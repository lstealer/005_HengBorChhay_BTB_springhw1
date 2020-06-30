package com.hw1.springhw1.restcontroller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/BM/v1/")
public class FileController {

    @PostMapping("/upload")
    public String upLoadFile(@RequestParam("file") MultipartFile file) {
        File uploadedFile = new File("/home/bc/Image/" + file.getOriginalFilename());
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadedFile.getAbsolutePath();
//            return "null";
    }

}

