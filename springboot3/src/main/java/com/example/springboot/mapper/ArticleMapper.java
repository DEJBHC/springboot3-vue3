package com.example.springboot.mapper;

import com.example.springboot.entity.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    List<Article> selectAll(Article article);
    @Select("SELECT * FROM `article` WHERE id=#{id}")
    Article selectById(Integer id);

    void insert(Article article);

    void updateById(Article article);
    @Delete("DELETE FROM `article` WHERE id=#{id}")
    void deleteById(Integer id);
    @Select("SELECT COUNT(*) from article where time like '%${date}%'")
    Integer selectCountByDate(String date);
}
