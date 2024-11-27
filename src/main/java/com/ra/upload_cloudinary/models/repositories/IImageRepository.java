package com.ra.upload_cloudinary.models.repositories;

import com.ra.upload_cloudinary.models.entites.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IImageRepository extends JpaRepository<Image,Long>
{
}
