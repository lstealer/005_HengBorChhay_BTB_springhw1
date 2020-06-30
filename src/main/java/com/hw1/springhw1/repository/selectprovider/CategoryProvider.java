package com.hw1.springhw1.repository.selectprovider;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {

    public String getAllCategories(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_categories");
        }}.toString();
    }

    public String getCategoryById(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_categories");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String postCategory(){
        return new SQL(){{
            INSERT_INTO("school.tb_categories");
            VALUES("title","#{title}");
        }}.toString();
    }

    public String getCategoryIdByTitle(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_categories");
            WHERE("title=#{title}");
        }}.toString();
    }

    public String updateCategory(){
        return new SQL(){{
            UPDATE("school.tb_categories");
            SET("title=#{categoryDto.title}");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String deleteCategory(){
        return new SQL(){{
            DELETE_FROM("school.tb_categories");
            WHERE("id=#{id}");
        }}.toString();
    }

}
