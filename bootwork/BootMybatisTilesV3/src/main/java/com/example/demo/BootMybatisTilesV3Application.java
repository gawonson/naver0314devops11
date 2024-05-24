package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"*.member","data.*","tiles.config","com.example.demo","controller.*"})
@MapperScan("data.mapper")
@SpringBootApplication
public class BootMybatisTilesV3Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisTilesV3Application.class, args);
	}

}
