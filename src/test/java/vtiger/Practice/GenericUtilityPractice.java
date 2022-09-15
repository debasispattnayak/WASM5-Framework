package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		JavaUtility jlib=new JavaUtility();
		System.out.println(jlib.getRandomNumber());
		System.out.println(jlib.getSystemDate());
		System.out.println(jlib.getSystemDateInFormat());
		
		PropertyFileUtility plib=new PropertyFileUtility();
		System.out.println(plib.readDataFromPropertyFile("browser"));
		System.out.println(plib.readDataFromPropertyFile("url"));
		
		ExcelFileUtility elib=new ExcelFileUtility();
		System.out.println(elib.getRowCount("Organization"));
	}

}
