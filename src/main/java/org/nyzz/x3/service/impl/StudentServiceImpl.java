package org.nyzz.x3.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nyzz.x3.entity.Student;
import org.nyzz.x3.mapper.StudentMapper;
import org.nyzz.x3.service.StudentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Override
    @Cacheable(value = "users", key = "'custom'")
    public Student custom() {
        Student student = this.lambdaQuery().like(Student::getName, "辉").one();
        return student;
    }
}
