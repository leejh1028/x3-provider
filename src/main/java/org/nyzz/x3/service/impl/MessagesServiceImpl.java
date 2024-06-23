package org.nyzz.x3.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nyzz.x3.entity.Messages;
import org.nyzz.x3.mapper.MessagesMapper;
import org.nyzz.x3.service.MessagesService;
import org.springframework.stereotype.Service;
@Service
@DS("slave_1")
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements MessagesService{

    @Override
    public Messages getMessages() {
        Messages one = this.lambdaQuery().eq(Messages::getId, 1).one();
        return one;
    }
}
