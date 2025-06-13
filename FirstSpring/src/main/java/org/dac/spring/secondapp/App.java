package org.dac.spring.secondapp;

import org.dac.spring.secondapp.beans.Cards;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext context = 
    			new ClassPathXmlApplicationContext("secondapp.xml");)
		{
		
		Cards objcards = (Cards)context.getBean("objCards");
    	System.out.println(objcards);
	}
}
}


