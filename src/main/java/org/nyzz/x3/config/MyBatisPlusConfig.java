package org.nyzz.x3.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.nyzz.x3.mapper")
public class MyBatisPlusConfig {
}
