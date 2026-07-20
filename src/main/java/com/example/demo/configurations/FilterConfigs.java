package com.example.demo.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.jwt.JwtFilters;


@Configuration
public class FilterConfigs {
	
	@Bean
	public FilterRegistrationBean<JwtFilters> jwtFilter(){
		FilterRegistrationBean<JwtFilters> bean = new FilterRegistrationBean<>();
		
		bean.setFilter(new JwtFilters());
		
		bean.addUrlPatterns("/users/*");
		
		return bean; 
	}
}
