package com.hw1.springhw1.service;

import com.hw1.springhw1.repository.dto.ImageDto;

public interface ImageService {
    ImageDto getImageById(int id);
    ImageDto postImage(ImageDto image);
}
