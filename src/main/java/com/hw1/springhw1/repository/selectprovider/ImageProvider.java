package com.hw1.springhw1.repository.selectprovider;

import org.apache.ibatis.jdbc.SQL;

public class ImageProvider {
    public String getImageById(){
        return new SQL(){{
            SELECT("*");
            FROM("school.ImagePatch");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String postImage(){
        return new SQL(){{
            INSERT_INTO("school.imagepatch");
            VALUES("imgpath","#{imgpath}");
        }}.toString();
    }
}
