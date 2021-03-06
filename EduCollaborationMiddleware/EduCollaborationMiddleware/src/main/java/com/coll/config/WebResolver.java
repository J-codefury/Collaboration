package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebResolver
{
	
	//========================================INTERNAL RESOLVER VIEW RESOLVER====================================================================
	
	@Bean
 public InternalResourceViewResolver getViewResolver() 
 {
	 InternalResourceViewResolver iResolver=new InternalResourceViewResolver();
	 iResolver.setPrefix("/WEB-INF/jsp");
	 iResolver.setSuffix(".jsp");
	 return iResolver;
 }
}
