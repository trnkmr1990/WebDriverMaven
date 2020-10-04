package com.project.Driver;

import java.util.Hashtable;
import java.util.Properties;


import com.project.Utils.ExcelAPI;

public class DriverScript  {

	public static Properties e1; 
	public  static  Properties evnprop; 
	
	
	public  Properties getE1() {
		return e1;
	}

	public  void setE1(Properties e1) {
		this.e1 = e1;
	}

	public  Properties getEvnprop() {
		return evnprop;
	}

	public  void setEvnprop(Properties evnprop) {
		this.evnprop = evnprop;
	}

	public void executeKeywords(String testName, ExcelAPI xls, Hashtable<String, String>testData)
	{
		int rows=xls.getRowCount("Keywords");
		System.out.println("Rows:"+ rows);
		
		
		for(int rNum=1; rNum<=rows; rNum++)
		{
			
			String tcid=xls.getCellData("Keywords", "TCID", rNum);
			if(tcid.equals(testName))
			{
			String keyword=xls.getCellData("Keywords", "Keyword", rNum);
			String objectKey=xls.getCellData("Keywords", "Object", rNum);
			String dataKey=xls.getCellData("Keywords", "Data", rNum);
			String data = testData.get(dataKey);
			
			System.out.println(tcid + "----"+ keyword +"----"+ e1.getProperty(objectKey)+ "----"+ data );
			
			
			}
		}
	}
}
