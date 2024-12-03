package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(Admin Admin){
        List<Admin> list= adminService.selectAll(Admin);
        return Result.success(list);
    }
    /**
     *查询单个的数据
     */
     @GetMapping("/selectById/{id}")
     public Result selectById(@PathVariable Integer id) {
         Admin admin = adminService.selectById(id);
         return Result.success(admin);
     }
    /**
     * 分页查询的数据
     * pageNum：当前页码
     * pageSize：每页的个数
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            Admin admin,
            @RequestParam(defaultValue ="1") Integer pageNum,
            @RequestParam(defaultValue ="10") Integer pageSize) {
        PageInfo<Admin> pageInfo = adminService.selectPage(admin,pageNum, pageSize);
        return Result.success(pageInfo);
    }
    /**
     *新增数据
     * @param admin
     * @return
     */
     @PostMapping("/add")
     public Result add(@RequestBody Admin admin) {
         adminService.add(admin);
         return Result.success();
     }
     /**
     *修改数据
     * @param Admin
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.success();
    }
    /**
     * 删除单个数据
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除数据
     */
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        adminService.deleteBatch(ids);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        Admin dbAdmin = adminService.login(admin);
        return Result.success(dbAdmin) ;
    }
}
