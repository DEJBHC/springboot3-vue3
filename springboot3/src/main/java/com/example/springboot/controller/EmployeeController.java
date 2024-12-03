package com.example.springboot.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(Employee employee){
        List<Employee> list= employeeService.selectAll(employee);
        return Result.success(list);
    }
    /**
     *查询单个的数据
     */
     @GetMapping("/selectById/{id}")
     public Result selectById(@PathVariable Integer id) {
         Employee employee = employeeService.selectById(id);
         return Result.success(employee);
     }
    /**
     * 分页查询的数据
     * pageNum：当前页码
     * pageSize：每页的个数
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            Employee employee,
            @RequestParam(defaultValue ="1") Integer pageNum,
            @RequestParam(defaultValue ="10") Integer pageSize) {
        PageInfo<Employee> pageInfo = employeeService.selectPage(employee,pageNum, pageSize);
        return Result.success(pageInfo);
    }
    /**
     *新增数据
     * @param employee
     * @return
     */
     @PostMapping("/add")
     public Result add(@RequestBody Employee employee) {
         employeeService.add(employee);
         return Result.success();
     }
     /**
     *修改数据
     * @param employee
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Employee employee) {
        employeeService.updateById(employee);
        return Result.success();
    }
    /**
     * 删除单个数据
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return Result.success();
    }

    /**
     *导出excel
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        //1．拿到所有的员工数据
        List<Employee> employeeList = employeeService.selectAll(null);
        //2.构建 ExceLWriter
        //在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //13.设置中文表头
        writer.addHeaderAlias("username","账号");
        writer.addHeaderAlias("name","名称");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("no","工号");
        writer.addHeaderAlias("age","年龄");
        writer.addHeaderAlias("description","个人介绍");
        writer.addHeaderAlias("departmentName","部门");
        //默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除
        writer.setOnlyAlias(true);
        //4.写出数据到writer
        writer.write(employeeList, true);
        //5。设置输出的文件的名称以及输出流的头信息
        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("员工信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        //6.写出到输出流,并关闭writer
        ServletOutputStream os = response.getOutputStream();
        writer.flush(os);
        writer.close();
    }
    /**
     *excel导入
     */
    @PostMapping("/import")
    public Result importData(MultipartFile file) throws Exception {
        ///1.拿到输入流构建reader
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        reader.addHeaderAlias("账号","username");
        reader.addHeaderAlias("名称","name");
        reader.addHeaderAlias("性别","sex");
        reader.addHeaderAlias("工号","no");
        reader.addHeaderAlias("年龄","age");
        reader.addHeaderAlias("个人介绍","description");
        reader.addHeaderAlias("部门","departmentName");
        //2.读取excel里面的数据
        List<Employee> employeeList = reader.readAll(Employee.class);
        //3.写入list数据到数据库
        for (Employee employee : employeeList) {
            employeeService.add(employee);
        }
        return Result.success();
    }
    /**
     * 批量删除数据
     */
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        employeeService.deleteBatch(ids);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.login(employee);
        return Result.success(dbEmployee) ;
    }
    @PostMapping("/register")
    public Result register(@RequestBody Employee employee) {
        employeeService.register(employee);
        return Result.success() ;
    }
}
