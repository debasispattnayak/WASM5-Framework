package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all Excelfile specific generic methods
 * @author DEV
 *
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from excel sheet and return value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			String value = c.getStringCellValue();
			wb.close();
			return value;		
		}
		
		/**
		 * This method will return the last row in particular sheet
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			int lastrow = s.getLastRowNum();
			wb.close();
			return lastrow;
		}
		/**
		 * 
		 * @param sheet
		 * @param row
		 * @param cell
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public void writeDataIntoExcelSheet(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.createCell(cell);
			c.setCellValue(value);
			
			FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
			wb.write(fos);
			wb.close();
		}
		
		/**
		 * This method will read multiple data from excel sheet and return in Object[][]
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public Object[][] readMultipleDataFromExcel(String sheet) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			int lastrow = s.getLastRowNum();
			int lastcell = s.getRow(0).getLastCellNum();
			
			Object[][] data=new Object[lastrow][lastcell];
			
			for(int i=0;i<lastrow;i++)
			{
				for(int j=0;j<lastcell;j++)
				{
					data[i][j] = s.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;
			
		}
}
