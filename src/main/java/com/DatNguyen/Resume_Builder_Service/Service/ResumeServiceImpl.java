package com.DatNguyen.Resume_Builder_Service.Service;

import com.DatNguyen.Resume_Builder_Service.Entity.Resume;
import com.DatNguyen.Resume_Builder_Service.Repository.ResumeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Mono<Map<String, Object>> generateResumeResponse(String userResumeDescription) {
        return Mono.fromCallable(() -> loadPromptFromFile("resume_prompt.txt"))
                .map(promptString -> putValuesToTemplate(promptString, Map.of("userDescription", userResumeDescription)))
                .flatMap(promptContent -> Mono.fromCallable(() -> chatClient.call(promptContent)))
                .map(this::parseMultipleResponses)
                .flatMap(jsonResponse -> {
                    Map<String, Object> resumeData = (Map<String, Object>) jsonResponse.get("data");

                    if (resumeData != null) {
                        Map<String, Object> personalInfo = (Map<String, Object>) resumeData.get("personalInformation");
                        String email = (String) personalInfo.get("email");

                        if (email != null && !email.isEmpty()) {
                            Resume resume = new Resume();
                            resume.setEmail(email);
                            resume.setPersonalInformation(personalInfo);
                            resume.setSkills((List<Map<String, Object>>) resumeData.get("skills"));
                            resume.setExperience((List<Map<String, Object>>) resumeData.get("experience"));
                            resume.setEducation((List<Map<String, Object>>) resumeData.get("education"));
                            resume.setCertifications((List<Map<String, Object>>) resumeData.get("certifications"));
                            resume.setProjects(resumeData.get("projects"));
                            resume.setAchievements((List<Object>) resumeData.get("achievements"));
                            resume.setLanguages((List<Map<String, Object>>) resumeData.get("languages"));
                            resume.setInterests((List<Map<String, Object>>) resumeData.get("interests"));

                            return resumeRepository.save(resume).thenReturn(jsonResponse);

                        }
                    }
                    return Mono.just(jsonResponse);
                });
    }

    private String loadPromptFromFile(String filename) throws IOException {
        Path path = new ClassPathResource(filename).getFile().toPath();
        return Files.readString(path);
    }

    private String putValuesToTemplate(String template, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return template;
    }

    private Map<String, Object> parseMultipleResponses(String response) {
        Map<String, Object> jsonResponse = new HashMap<>();

        int jsonStart = response.indexOf("```json") + 7;
        int jsonEnd = response.lastIndexOf("```");

        if (jsonStart != -1 && jsonEnd != -1 && jsonStart < jsonEnd) {
            String jsonContent = response.substring(jsonStart, jsonEnd).trim();

            // Ensure that no control characters are included
            jsonContent = jsonContent.replaceAll("[\\x00-\\x1F]", "");

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> dataContent = objectMapper.readValue(jsonContent, Map.class);
                jsonResponse.put("data", dataContent);
            } catch (Exception e) {
                jsonResponse.put("data", null);
                System.err.println("Invalid JSON format: " + e.getMessage());
            }
        } else {
            jsonResponse.put("data", null);
        }

        return jsonResponse;
    }
}
