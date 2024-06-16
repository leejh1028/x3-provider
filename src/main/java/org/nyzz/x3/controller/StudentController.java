package org.nyzz.x3.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.nyzz.x3.entity.Student;
import org.nyzz.x3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "用户管理")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    @Operation(summary = "获取用户列表")
    public List<Student> list() {
        List<Student> students = studentService.list().stream().limit(10).toList();
        return students;
    }

    @PostMapping("/add")
    @Operation(summary = "添加用户")
    public boolean add(@RequestBody Student user) {
        return studentService.save(user);
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户信息")
    public boolean update(@RequestBody Student user) {
        return studentService.updateById(user);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除用户")
    public boolean delete(@PathVariable Long id) {
        return studentService.removeById(id);
    }

    @GetMapping("/custom")
    @Operation(summary = "自定义方法")
    public Student custom() {
        Student student = studentService.custom();
        return student;
    }
}
