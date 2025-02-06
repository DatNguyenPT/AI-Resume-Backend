package com.DatNguyen.ImageGenerator.Service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String generateImage(String prompt, MultipartFile imageFile) {
        String url = "http://localhost:8000/generate/?prompt=" + prompt;

        File tempFile = convertMultipartFileToFile(imageFile);

        if (tempFile == null) {
            return "Error: Failed to process image file";
        }

        FileSystemResource fileResource = new FileSystemResource(tempFile);

        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("image", fileResource);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        tempFile.delete();

        return response.getBody();
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) {
        try {
            File tempFile = File.createTempFile("upload_", multipartFile.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(multipartFile.getBytes());
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
