package org.nyzz.x3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.nyzz.x3.entity.Student;

public interface StudentService extends IService<Student>{


    Student custom();
}
