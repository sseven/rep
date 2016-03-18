package com.ms.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.dao.SysUserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/applicationContext.xml"})
public class SpringTest {

	@Resource
	private SysUserDao userDao;
	
	@Test
	public void connectionTest() {
		for (int i = 120; i >= 0; i--) {
			System.out.println(userDao.get("4028816b4f3e91c7014f3e9567820003").getNickname() + i);
		}
	}
	
}



