package com.inetbanking.testCases;

import java.io.IOException;


import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("providing login");
		lp.setPassword(password);
		logger.info("providing password");
		lp.clickButton();
		
		Thread.sleep(3000);
		
		AddCustomerPage acp = new AddCustomerPage(driver);
				
		acp.clickAddNewCustomer();		
		acp.custName("Kailash");		
		acp.custgender("mail");		
		acp.custdob("12","12","1985");
		Thread.sleep(3000);
		acp.custaddress("India");
		acp.custcity("kalaburagi");
		acp.custstate("karnataka");
		acp.custpinno("585105");
		acp.custtelephoneno("9445682999");
		String email=randomstring()+"@gmail.com";
		
		acp.custemailid(email);
		acp.custpassword("abcdef");
		acp.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			captureScreen(driver,"addnewcustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
	}
	

}
