package com.hw1.springhw1.repository.selectprovider;

import org.apache.ibatis.jdbc.SQL;

public class BookProvider {

    public String getPagedBook(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
            LIMIT("#{limit}");
            OFFSET("#{offset}");

        }}.toString();
    }

    public String getCategoryTitleById(){
        return new SQL(){{
            SELECT("title");
            FROM("school.tb_categories");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String getCategoryById(){
        return new  SQL(){{
            SELECT("*");
            FROM("school.tb_categories");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String getAllBooks(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
        }}.toString();
    }

    public String getBookById(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String postBook(){
        return new SQL(){{
            INSERT_INTO("school.tb_books");
            VALUES("title","#{title}");
            VALUES("author","#{author}");
            VALUES("description","#{description}");
            VALUES("thumbnail","#{thumbnail}");
            VALUES("category_id","#{category.id}");
        }}.toString();
    }

    public String updateBook(){
        return new SQL(){{
            UPDATE("school.tb_books");
            SET("title=#{bookDto.title}");
            SET("author=#{bookDto.author}");
            SET("description=#{bookDto.description}");
            SET("thumbnail=#{bookDto.thumbnail}");
            SET("category_id=#{bookDto.category.id}");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String deleteBookById(){
        return new SQL(){{
            DELETE_FROM("school.tb_books");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String getBooksByCategoryId(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
            WHERE("category_id=#{id}");
        }}.toString();
    }

    public String getBookByTitle(){{
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
            WHERE("title LIKE '%'||#{filter.title}||'%'");
        }}.toString();
    }}

    public String getBookByCategoryIdAndTitle(){
        return new SQL(){{
            SELECT("*");
            FROM("school.tb_books");
            WHERE("category_id=#{id}");
            AND().
            WHERE("title LIKE '%'||#{title}||'%'");
        }}.toString();
    }

}
