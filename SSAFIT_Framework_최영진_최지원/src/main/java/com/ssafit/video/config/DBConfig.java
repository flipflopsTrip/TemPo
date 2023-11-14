package com.ssafit.video.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafit.video.model.dao")
public class DBConfig {
	
}
