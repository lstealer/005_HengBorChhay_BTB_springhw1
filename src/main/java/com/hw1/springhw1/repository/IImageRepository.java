package com.hw1.springhw1.repository;

import com.hw1.springhw1.repository.dto.CategoryDto;
import com.hw1.springhw1.repository.dto.ImageDto;
import com.hw1.springhw1.repository.selectprovider.CategoryProvider;
import com.hw1.springhw1.repository.selectprovider.ImageProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository {
    @InsertProvider(value = ImageProvider.class, method = "postImage")
    Boolean postImage(ImageDto category);
    @SelectProvider(value = ImageProvider.class, method = "getImageById")
    ImageDto getImageById(int id);
}
