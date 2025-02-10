package com.DatNguyen.ImageGenerator.Service;

import com.cloudinary.Cloudinary;
import jakarta.mail.Multipart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Cloudinary cloudinary;
    public ImageService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

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
            byte[] image = response.getBody();
            MultipartFile multipartFile = convertImageToMultipart(image);

            try{
                upload(multipartFile);
            }catch (Exception e){
                e.printStackTrace();
            }

            return response.getBody();
        } else {
            throw new RuntimeException("Error generating image: " + response.getStatusCode());
        }
    }

    public MultipartFile convertImageToMultipart(byte[] image) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<byte[]> requestEntity = new HttpEntity<>(image, headers);
        ResponseEntity<Multipart> response = restTemplate.exchange(
                STABILITY_AI_URL, HttpMethod.POST, requestEntity, Multipart.class
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            return (MultipartFile) response.getBody();
        }
        throw new RuntimeException("Error converting image: " + response.getStatusCode());
    }

    public Map upload(MultipartFile file)  {
        try{
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
            return data;
        }catch (IOException io){
            throw new RuntimeException("Image upload fail");
        }
    }

}
