package com.project.SuiteA;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;

import com.project.Utils.DataUtils;

public class LoginTest extends BaseTest
{
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,  String> data)
	{
		if(data.get("Runmode").equals("N"))
			throw new SkipException("Runmde is set to No");
		System.out.println("I am Login Test....");
		//ds = new DriverScript();
		ds.executeKeywords(testName, xls, data);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		System.out.println("Data Provider");
		String testName="LoginTest"; 
		String sheetName="Data";
		return DataUtils.getTestData(sheetName,testName, xls);
		
	}
}
