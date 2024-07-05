package com.tynu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * DATE: 2022/11/17
 * Author: 李毫
 * Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 设置允许跨域的路径
		registry.addMapping("/**")
				// 设置允许跨域请求的域名
				.allowedOrigins("*")
				// 是否允许cookie
				.allowCredentials(true)
				// 设置允许的请求方式
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				// 设置允许的header属性
				.allowedHeaders("*")
				// 跨域允许时间
				.maxAge(3600);
	}

	@Bean
	public CharacterEncodingFilter characterEncodingFilter(){
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
