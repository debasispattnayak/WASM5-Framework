package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {

		//STEP1: LOAD THE FILE TO FILE INPUT STREAM
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commonData.properties");
		
		//STEP2: CREATE OBJECT OF PROPERTIES FROM JAVA
		Properties obj=new Properties();
		
		//STEP 3: LOAD THE FILE TO PROPERTIES OBJECT
		obj.load(fis);
		//STEP4: READ DATA THROUGH KEY
		String mybrowser=obj.getProperty("browser");
		System.out.println(mybrowser);
		
		String myurl=obj.getProperty("url");
		System.out.println(myurl);
	}

}
