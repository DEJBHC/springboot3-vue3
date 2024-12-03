package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Article;
import com.example.springboot.service.ArticleService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(Article Article){
        List<Article> list= articleService.selectAll(Article);
        return Result.success(list);
    }
    /**
     *查询单个的数据
     */
     @GetMapping("/selectById/{id}")
     public Result selectById(@PathVariable Integer id) {
         Article article = articleService.selectById(id);
         return Result.success(article);
     }
    /**
     * 分页查询的数据
     * pageNum：当前页码
     * pageSize：每页的个数
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            Article article,
            @RequestParam(defaultValue ="1") Integer pageNum,
            @RequestParam(defaultValue ="10") Integer pageSize) {
        PageInfo<Article> pageInfo = articleService.selectPage(article,pageNum, pageSize);
        return Result.success(pageInfo);
    }
    /**
     *新增数据
     * @param article
     * @return
     */
     @PostMapping("/add")
     public Result add(@RequestBody Article article) {
         System.err.println(article);
         articleService.add(article);
         return Result.success();
     }
     /**
     *修改数据
     * @param Article
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Article article) {
        articleService.updateById(article);
        return Result.success();
    }
    /**
     * 删除单个数据
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        articleService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除数据
     */
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        articleService.deleteBatch(ids);
        return Result.success();
    }

}
