package org.nyzz.x3.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nyzz.x3.entity.Users;
import org.nyzz.x3.mapper.UsersMapper;
import org.nyzz.x3.service.UsersService;
@Service
@DS("slave_1")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService{

}
