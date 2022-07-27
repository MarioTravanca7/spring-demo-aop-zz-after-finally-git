package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get membership bean from spring container
		MemberShipDAO theMembershipDAO = 
				context.getBean("memberShipDAO", MemberShipDAO.class);
		
		//call the businesss method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinium");
		
		theAccountDAO.addAccount(myAccount, true);		
		theAccountDAO.doWork();
		
		//call the accountDAO getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
				
		// call the membership business method
		theMembershipDAO.addSillyMember();	
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
