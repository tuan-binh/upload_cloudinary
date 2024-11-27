package com.ra.upload_cloudinary.advice;

import com.ra.upload_cloudinary.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleUpload(NotFoundException e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
