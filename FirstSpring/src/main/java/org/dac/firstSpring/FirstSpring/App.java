package org.dac.firstSpring.FirstSpring;

import org.dac.spring.firstspringapp.beans.Cards;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	try(ClassPathXmlApplicationContext context = 
    			new ClassPathXmlApplicationContext("confg.xml");)
    	{
    		Cards objCards = (Cards)context.getBean("objCards");
//    		Cards secondCards = (Cards)context.getBean("objCards");
    		System.out.println(objCards);
//    		System.out.println(secondCards);
    	}
    }
}
