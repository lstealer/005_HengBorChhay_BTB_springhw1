package com.hw1.springhw1.utitl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class MethodContainer {

    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    public Timestamp getTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
