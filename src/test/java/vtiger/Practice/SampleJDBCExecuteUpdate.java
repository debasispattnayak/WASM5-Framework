package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		Connection con=null;
		try
		{
		DriverManager.registerDriver(driver);
		con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		Statement state = con.createStatement();
		String query="insert into customerinfo values('devil',33,'balasore')";
		int result=state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data inserted successfully");
		}
		else
		{
			System.out.println("data not inserted: please check query");
		}
		}
		catch(Exception e)
		{
			//handled code
		}
		finally 
		{
		con.close();
		System.out.println("database closed");
		}
	}

}
