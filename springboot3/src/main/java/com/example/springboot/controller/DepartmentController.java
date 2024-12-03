package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Department;
import com.example.springboot.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(Department department){
        List<Department> list= departmentService.selectAll(department);
        return Result.success(list);
    }
    /**
     *查询单个的数据
     */
     @GetMapping("/selectById/{id}")
     public Result selectById(@PathVariable Integer id) {
         Department department = departmentService.selectById(id);
         return Result.success(department);
     }
    /**
     * 分页查询的数据
     * pageNum：当前页码
     * pageSize：每页的个数
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            Department department,
            @RequestParam(defaultValue ="1") Integer pageNum,
            @RequestParam(defaultValue ="10") Integer pageSize) {
        PageInfo<Department> pageInfo = departmentService.selectPage(department,pageNum, pageSize);
        return Result.success(pageInfo);
    }
    /**
     *新增数据
     * @param department
     * @return
     */
     @PostMapping("/add")
     public Result add(@RequestBody Department department) {
         departmentService.add(department);
         return Result.success();
     }
     /**
     *修改数据
     * @param department
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Department department) {
        departmentService.updateById(department);
        return Result.success();
    }
    /**
     * 删除单个数据
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除数据
     */
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        departmentService.deleteBatch(ids);
        return Result.success();
    }

}
