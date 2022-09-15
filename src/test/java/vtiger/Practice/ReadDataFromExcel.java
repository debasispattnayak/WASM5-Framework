package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//STEP1: LOAD FILE INTO FILEINPUT STREAM
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
	
		//STEP2: CREATE WORKBOOK USING WORKBOOK FACTORY(COMES FROM APACHE POI AND APACHE POI-OOXML)
		Workbook wb = WorkbookFactory.create(fis);
		
		//STEP3: NAVIGATE TO SHEET
		Sheet sheet = wb.getSheet("Organization");
		
		//STEP4: NAVIGATE TO ROW
		Row row = sheet.getRow(1);
		
		//STEP5: NAVIGATE TO CELL
		Cell cell = row.getCell(2);
		
		//GET THE RESPECTIVE CELL VALUE BY THE BELOW METHOD
		String	Org_Name=cell.getStringCellValue();
		System.out.println(Org_Name);
		

	}

}
