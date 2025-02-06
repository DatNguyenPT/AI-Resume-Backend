package com.DatNguyen.ImageGenerator.Controller;

import com.DatNguyen.ImageGenerator.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping("/generate")
    public String generate(@RequestParam String prompt, @RequestParam MultipartFile imageFile) {
        return imageService.generateImage(prompt, imageFile);
    }
}
