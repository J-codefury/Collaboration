package com.coll.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.config.DBConfig;
import com.coll.dao.BlogDAO;
import com.coll.model.Blog;


public class BlogDAOTest
{
static	 BlogDAO blogDao;
	
	@BeforeClass
	public static  void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		context.scan("com.coll");
		//context.refresh();
		blogDao=(BlogDAO)context.getBean("blogDao");

	}
	
	
	
	@Ignore
	@Test
	public void addBlogtest()
	{
		Blog blog=new Blog();
		blog.setBlogname("EEE");
		blog.setBlogcontent("Electrical and Electronics Engineering");
		blog.setUsername("Kevi");
		blog.setCreateDate(new Date());
		blog.setLikes(2);
		blog.setDislikes(2);
		blog.setStatus("A");
		assertTrue(blogDao.addBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{ 
		Blog blog=blogDao.getBlog(7);
		assertTrue(blogDao.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDao.getBlog(10);
		blog.setBlogcontent("Mechanical Engineering");
		blog.setBlogname("ME");
		assertTrue(blogDao.updateBlog(blog));
		}
	
	@Ignore
	@Test
	public void listBlogTest()
	{
	List<Blog>blogList=blogDao.listblogs();
	assertTrue(blogList.size()>0);
	for(Blog blog:blogList)
	{
		System.out.print(blog.getBlogid()+":::");
		System.out.print(blog.getBlogname()+":::");
		System.out.print(blog.getBlogcontent()+":::");
		System.out.print(blog.getStatus()+":::");
	}
	}
	@Ignore
	@Test
	public void approveBlogTest()
	{
	Blog blog=blogDao.getBlog(5);
	assertTrue(blogDao.approveBlog(blog));
	}
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDao.getBlog(5);
		assertTrue(blogDao.rejectBlog(blog));
	}
	
	@Ignore
	@Test
	public void incrementLikesTest()
	{
		System.out.println("hi to increment");
		assertTrue(blogDao.incrementLikes(13));
		
	}
	
	//@Ignore
	@Test
	public void incrementDisLikesTest()
	{
		System.out.println("hi to decrement");
		assertTrue(blogDao.incrementdisLikes(13));
	}
	}