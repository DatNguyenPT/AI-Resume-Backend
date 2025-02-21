//package com.DatNguyen.ImageGenerator.Controller;
//
//import com.DatNguyen.ImageGenerator.Service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/image")
//public class ImageController {
//
//    @Autowired
//    private ImageService imageService;
//
//    // Define WebP media type manually
//    private static final MediaType IMAGE_WEBP = MediaType.parseMediaType("image/webp");
//
//    @PostMapping("/generate")
//    public ResponseEntity<?> generate(@RequestParam String prompt) {
//        try {
//            byte[] imageBytes = imageService.generateImage(prompt);
//
//            if (imageBytes == null || imageBytes.length == 0) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Failed to generate image.");
//            }
//
//            // Set response headers for WebP image
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(IMAGE_WEBP);
//
//            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error generating image: " + e.getMessage());
//        }
//    }
//}
