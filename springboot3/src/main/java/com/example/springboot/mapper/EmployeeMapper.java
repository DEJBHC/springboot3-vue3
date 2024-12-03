package com.example.springboot.mapper;

import com.example.springboot.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll(Employee employee);
    @Select("SELECT * FROM `employee` WHERE id=#{id}")
    Employee selectById(Integer id);

    void insert(Employee employee);

    void updateById(Employee employee);
    @Delete("DELETE FROM `employee` WHERE id=#{id}")
    void deleteById(Integer id);
    @Select("SELECT * FROM `employee` WHERE username=#{username}")
    Employee selectByUsername(String username);
    @Select("SELECT * FROM `employee` WHERE no=#{no}")
    Employee selectByNo(String no);
}
