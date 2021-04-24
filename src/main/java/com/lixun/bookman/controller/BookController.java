package com.lixun.bookman.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixun.bookman.entity.Book;
import com.lixun.bookman.service.IBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixun
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @ApiOperation(value = "书籍列表")
    @RequestMapping("/list")
    //@ResponseBody // 返回数据给客户端
    public IPage<Book> list(
            @ApiParam(value = "搜索书籍名") @RequestParam(defaultValue = "", required = false) String name,
            @ApiParam(value = "搜索类型") @RequestParam(defaultValue = "-1", required = false) int tid,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1", required = false) int page,
            @ApiParam(value = "每页大小") @RequestParam(defaultValue = "2", required = false) int size) {
        // 告诉要看那一页以及查询提交
        IPage<Book> toWhichPage = new Page<Book>(page, size);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();// 构建查询条
        if (StringUtils.hasText(name)) {
            wrapper.like("name", name);
        }
        if (tid != -1) {
            wrapper.eq("tid", tid);
        }
        IPage<Book> resultPage = iBookService.page(toWhichPage, wrapper);
        return resultPage;
    }
    @RequestMapping("/del")
    //@ResponseBody
    public Map<String, Object> del(int id) {
        Map<String, Object> result = new HashMap<>();
        boolean ret = iBookService.removeById(id);
        if (ret) {
            result.put("msg", "删除成功");
            result.put("code", 1);
        } else {
            result.put("msg", "删除失败");
            result.put("code", -1);
        }
        return result;
    }
    @RequestMapping("/upload")
    //@ResponseBody
    public Map<String, Object> upload(MultipartFile photox) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 把 Book 保存到数据库
            if (!photox.isEmpty()) {
                String newFileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(photox.getOriginalFilename());
                photox.transferTo(new File(ResourceUtils.getFile("classpath:static/upload") + "/" + newFileName));
                result.put("newFileName", newFileName);
            }
            result.put("code", 0);
        } catch (Exception e) {
            result.put("code", -1);
            result.put("msg", "上传失败");
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/update")
    //@ResponseBody
    public Map<String, Object> update(Book book) {
        Map<String, Object> result = new HashMap<>();
        boolean ret=iBookService.saveOrUpdate(book);//根据 id 值进行判断
        if (ret) {
            result.put("code", 0);
            result.put("msg", "更新成功");
        } else {
            result.put("code", -1);
            result.put("msg", "更新失败");
        }
        return result;
    }
}