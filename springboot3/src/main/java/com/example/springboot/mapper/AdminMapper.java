package com.example.springboot.mapper;

import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    List<Admin> selectAll(Admin admin);
    @Select("SELECT * FROM `admin` WHERE id=#{id}")
    Admin selectById(Integer id);

    void insert(Admin admin);

    void updateById(Admin admin);
    @Delete("DELETE FROM `admin` WHERE id=#{id}")
    void deleteById(Integer id);
    @Select("SELECT * FROM `admin` WHERE username=#{username}")
    Admin selectByUsername(String username);
}
