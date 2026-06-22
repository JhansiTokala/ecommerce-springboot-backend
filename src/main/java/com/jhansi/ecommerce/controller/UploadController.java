package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.service.ImageUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final ImageUploadService imageUploadService;

    public UploadController(
            ImageUploadService imageUploadService) {

        this.imageUploadService =
                imageUploadService;
    }

    @PostMapping
    public String uploadImage(
            @RequestParam("file")
            MultipartFile file)
            throws Exception {

        return imageUploadService
                .uploadImage(file);
    }
}