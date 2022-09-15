package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ExecuteQueryDemo {

	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver(); //MY SQL DRIVER
		//STEP:1 : REGISTER THE DRIVER/DATABASE
		DriverManager.registerDriver(driver);
		
		//STEP2: GET THE CONNECTION (USE DATABASE NAME)

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//STEP3: ISSUE CREATE STATEMENT
			Statement state = con.createStatement();
		//STEP4: EXECUTE THE QUERY(USE TABLE NAME)
			ResultSet result = state.executeQuery("select * from customerinfo;");
			ResultSetMetaData metadata=result.getMetaData();
			int column=metadata.getColumnCount();
			
			while(result.next())
			{
				
				for(int i=1;i<=column;i++)
				System.out.print(result.getString(i));
				
					
			}
			
		//STEP5: CLOSE THE DATABASE
			con.close();

	}

}
