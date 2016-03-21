package com.projet.test.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testJpa {

	@Test
	public void test() {
		try{
			ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[] {"datasource-config.xml"});
			
			assertTrue(true);
			} catch(Exception e) {
			assertTrue(e.getMessage(),false);
			}

	}

}
