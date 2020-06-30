package com.hw1.springhw1.service.impl;

import com.hw1.springhw1.repository.CategoryRepository;
import com.hw1.springhw1.repository.IImageRepository;
import com.hw1.springhw1.repository.dto.CategoryDto;
import com.hw1.springhw1.repository.dto.ImageDto;
import com.hw1.springhw1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageServiceImplement implements ImageService {

    IImageRepository imageRepository;

    @Autowired
    public void setCategoryRepository(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageDto getImageById(int id) {
        return imageRepository.getImageById(id);
    }

    @Override
    public ImageDto postImage(ImageDto image) {
        if (imageRepository.postImage(image)){
//            int id = Integer.parseInt(imageRepository.getImageById(image.getImgpath()));
//            image.setId(id);
            return image;
        }else {
            return null;
        }
    }
}
