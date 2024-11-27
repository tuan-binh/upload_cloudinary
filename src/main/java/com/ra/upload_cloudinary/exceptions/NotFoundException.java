package com.ra.upload_cloudinary.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String message)
    {
        super(message);
    }
}
