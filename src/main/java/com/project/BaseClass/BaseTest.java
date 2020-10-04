package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.project.Utils.ExcelAPI;
import com.project.Driver.DriverScript;

public class BaseTest {
	
	
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties e1; 
	public static Properties evnprop; 
	public static ExcelAPI xls;
	public static String testName;
	public static DriverScript ds;
	
	@BeforeTest
	public void init() throws Exception 
	{
		System.out.println("Before Test");
		fis = new FileInputStream(projectPath + "//src//test//resource//Environment.properties");
		e1 = new Properties();
		e1.load(fis);
		System.out.println(e1.getProperty("env"));
		
		fis = new FileInputStream(projectPath + "//src//test//resource//"+e1.getProperty("env")+".properties");
		evnprop = new Properties();
		evnprop.load(fis);
		System.out.println(evnprop.getProperty("zohourl"));
		
		//inti testName
		testName = this.getClass().getSimpleName();
		System.out.println(testName);
		//How to know which suite is running
		String pack[]=this.getClass().getPackage().getName().split("\\.");
		String suiteName= pack[pack.length-1];
		System.out.println(suiteName);
		
		//Intializing the excel path
		xls= new ExcelAPI(evnprop.getProperty(suiteName+"_xls"));
		
		ds = new DriverScript();
		ds.setEvnprop(evnprop);
		ds.setE1(e1);
	}

	

}
