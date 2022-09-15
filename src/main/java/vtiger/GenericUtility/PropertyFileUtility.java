package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all propertyfile specific generic methods
 * @author DEV
 *
 */
public class PropertyFileUtility {

		/**
		 * This method will read the specific key value from property file
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public String readDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fis=new FileInputStream(ConstantsUtility.propertyFilePath);
			Properties obj=new Properties();
			obj.load(fis);
			String value = obj.getProperty(key);
			return value;
		}
		
}
