package com.ra.upload_cloudinary.models.services;

import com.ra.upload_cloudinary.models.entites.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService
{
    List<Image> findAll();

    Image findById(Long id);

    Image save(MultipartFile file) throws IOException;

    Image update(MultipartFile file,Long updateId) throws IOException;

    void deleteById(Long id);

}
