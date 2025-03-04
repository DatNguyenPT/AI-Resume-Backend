package com.DatNguyen.Resume_Builder_Service.Service;

import com.DatNguyen.Resume_Builder_Service.Entity.Resume;
import com.DatNguyen.Resume_Builder_Service.Repository.ResumeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

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
    public Map<String, Object> generateResumeResponse(String userResumeDescription) throws IOException {
        // Generate response
        String promptString = this.loadPromptFromFile("resume_prompt.txt");
        String promptContent = this.putValuesToTemplate(promptString, Map.of(
                "userDescription", userResumeDescription
        ));
        String response = chatClient.call(promptContent);

        // Extract data section
        Map<String, Object> jsonResponse = parseMultipleResponses(response);
        Map<String, Object> resumeData = (Map<String, Object>) jsonResponse.get("data");

        if (resumeData != null) {
            Map<String, Object> personalInfo = (Map<String, Object>) resumeData.get("personalInformation");
            String email = (String) personalInfo.get("email");

            // Ensure email is not null (to avoid saving invalid data)
            if (email != null && !email.isEmpty()) {
                Resume resume = new Resume();
                resume.setEmail(email); // Use email as ID
                resume.setPersonalInformation(personalInfo);
                resume.setSkills((List<Map<String, Object>>) resumeData.get("skills"));
                resume.setExperience((List<Map<String, Object>>) resumeData.get("experience"));
                resume.setEducation((List<Map<String, Object>>) resumeData.get("education"));
                resume.setCertifications((List<Map<String, Object>>) resumeData.get("certifications"));
                resume.setProjects(resumeData.get("projects"));
                resume.setAchievements((List<Object>) resumeData.get("achievements"));
                resume.setLanguages((List<Map<String, Object>>) resumeData.get("languages"));
                resume.setInterests((List<Map<String, Object>>) resumeData.get("interests"));

                resumeRepository.save(resume); // Save to MongoDB with email as _id
            }
        }

        return jsonResponse; // Return response for debugging
    }



    String loadPromptFromFile(String filename) throws IOException {
        Path path = new ClassPathResource(filename).getFile().toPath();
        return Files.readString(path);
    }

    String putValuesToTemplate(String template, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {

            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());

        }
        return template;
    }


    public static Map<String, Object> parseMultipleResponses(String response) {
        Map<String, Object> jsonResponse = new HashMap<>();

        // Extract content inside <think> tags
        int thinkStart = response.indexOf("<think>") + 7;
        int thinkEnd = response.indexOf("</think>");
        if (thinkStart != -1 && thinkEnd != -1) {
            String thinkContent = response.substring(thinkStart, thinkEnd).trim();
            jsonResponse.put("think", thinkContent);
        } else {
            jsonResponse.put("think", null); // Handle missing <think> tags
        }

        // Extract content that is in JSON format
        int jsonStart = response.indexOf("```json") + 7; // Start after ```json
        int jsonEnd = response.lastIndexOf("```");       // End before ```
        if (jsonStart != -1 && jsonEnd != -1 && jsonStart < jsonEnd) {
            String jsonContent = response.substring(jsonStart, jsonEnd).trim();
            try {
                // Convert JSON string to Map using Jackson ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> dataContent = objectMapper.readValue(jsonContent, Map.class);
                jsonResponse.put("data", dataContent);
            } catch (Exception e) {
                jsonResponse.put("data", null); // Handle invalid JSON
                System.err.println("Invalid JSON format in the response: " + e.getMessage());
            }
        } else {
            jsonResponse.put("data", null); // Handle missing JSON
        }

        return jsonResponse;
    }
}

