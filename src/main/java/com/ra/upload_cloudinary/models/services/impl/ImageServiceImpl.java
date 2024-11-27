package com.ra.upload_cloudinary.models.services.impl;

import com.ra.upload_cloudinary.exceptions.NotFoundException;
import com.ra.upload_cloudinary.models.entites.Image;
import com.ra.upload_cloudinary.models.repositories.IImageRepository;
import com.ra.upload_cloudinary.models.services.IImageService;
import com.ra.upload_cloudinary.services.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService
{
    private final IImageRepository imageRepository;
    private final UploadService uploadService;

    @Override
    public List<Image> findAll()
    {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(Long id)
    {
        return imageRepository.findById(id).orElseThrow(() -> new NotFoundException("Image not found"));
    }

    @Override
    public Image save(MultipartFile file) throws IOException
    {
        return imageRepository.save(Image.builder()
                .url(uploadService.uploadFile(file))
                .build());
    }

    @Override
    public Image update(MultipartFile file, Long updateId) throws IOException
    {
        Image image = findById(updateId);
        image.setUrl(file != null && file.getSize() > 0 ? file.getOriginalFilename() : image.getUrl());
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id)
    {
        imageRepository.deleteById(id);
    }
}
