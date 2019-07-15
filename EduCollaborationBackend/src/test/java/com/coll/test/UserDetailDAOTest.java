package com.coll.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.config.DBConfig;
import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;


public class UserDetailDAOTest
{
static	UserDetailDAO userDao;
	
	@BeforeClass
	public static  void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		context.scan("com.coll");
		userDao=(UserDetailDAO)context.getBean("userDao");
	}
	//@Ignore
	@Test
	public void registeruserTest()
	{
		UserDetail user=new UserDetail();
		user.setEmailid("kevin@gmail.com");
		user.setIsonline("Y");
		user.setMemberName("Kevin");
		user.setPassword("user123");
		user.setRole("User");
		user.setStatus("NA");
		user.setUsername("Kevi");
		assertTrue(userDao.registeruser(user));	
	}
	@Ignore
	@Test
	public void updateUsertest()
	{
		UserDetail user=userDao.getUser("Ini");
		user.setEmailid("ini@gmail.com");
		user.setMemberName("Inian");
		assertTrue(userDao.updateUser(user));
	}
	
	@Ignore
	@Test
	public void checkUsertest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("Ini");
		user.setPassword("user123");
		UserDetail user1=userDao.checkuser(user);
		assertNotNull("problem in login credential",user1);
		System.out.println("name:" +user1.getMemberName());
		System.out.println(user1.getRole());
		
		}
}
