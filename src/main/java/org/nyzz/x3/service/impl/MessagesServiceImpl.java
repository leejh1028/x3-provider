package org.nyzz.x3.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nyzz.x3.mapper.MessagesMapper;
import org.nyzz.x3.entity.Messages;
import org.nyzz.x3.service.MessagesService;
@Service
@DS("slave_1")
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements MessagesService{

}
