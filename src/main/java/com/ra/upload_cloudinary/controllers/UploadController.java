package com.ra.upload_cloudinary.controllers;

import com.ra.upload_cloudinary.services.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UploadController
{
    private final UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> handleUpload(@RequestParam MultipartFile file) throws IOException
    {
        return ResponseEntity.created(URI.create("api/v1/auth/upload")).body(
                uploadService.uploadFile(file)
        );
    }
}
