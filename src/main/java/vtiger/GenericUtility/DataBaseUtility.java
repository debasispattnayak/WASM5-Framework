package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all generic methods related to database
 * @author DEV
 *
 */
public class DataBaseUtility {
	
	Driver driverRef;
	Connection con=null;
	/**
	 * This method will establish connection with DB
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantsUtility.DBurl, ConstantsUtility.DBusername, ConstantsUtility.DBpassword);
	} 
	/**
	 * This method will close DB connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	/**
	 * This method will execute a query and check for the expected data 
	 * if expected data is found ,it will return the data 
	 * else it will return null
	 * data validation with respect to database
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQuesryAndGetData(String query,int colIndex,String expData) throws SQLException
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colIndex);
			if(actData.equals(expData))
			{
				flag=true; //Flag Raising
				break;
			}
			
		}
		if(flag)
		{
			System.out.println("data present "+expData);
			return expData;
		}
		else
		{
			System.out.println("data not present");
			return " ";
		}
		
	}
	
	

	

}
