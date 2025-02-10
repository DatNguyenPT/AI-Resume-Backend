package com.DatNguyen.ImageGenerator.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${spring.ai.stabilityai.api-key}")
    private String apiKey;

    @Value("${spring.ai.stabilityai.base-url}")
    private String STABILITY_AI_URL;

    public byte[] generateImage(String prompt) {
        // Prepare request body (Form-Data)
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("prompt", prompt);
        body.add("output_format", "webp");

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Accept", "image/*");  // Expecting an image response
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        // Make API call
        ResponseEntity<byte[]> response = restTemplate.exchange(
                STABILITY_AI_URL, HttpMethod.POST, requestEntity, byte[].class
        );

        // Check response
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error generating image: " + response.getStatusCode());
        }
    }
}
