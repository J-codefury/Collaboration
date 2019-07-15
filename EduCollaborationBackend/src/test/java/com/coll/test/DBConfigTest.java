package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.config.DBConfig;

public class DBConfigTest
{
	
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	context.scan("com");
	context.refresh();
	
}
	@Test
	public void test() {
	 System.out.println("test");
	}

}