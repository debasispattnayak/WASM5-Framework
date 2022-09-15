package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all java specific generic methods
 * @author DEV
 *
 */
public class JavaUtility {

	/**
	 * This method will return random number on every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int random = r.nextInt(1000);
		return random;
	}
	
	/**
	 * This method will generate system date and time, will return the value
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will generate current system date and time and will return the value
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] darr = d.toString().split(" ");
		String date = darr[2];
		String month = darr[1];
		String year = darr[5];
		String time = darr[3].replace(":", "-");
		String dateAndTime=date+" "+month+" "+year+" "+time;
		return dateAndTime;	
	}
		
}

