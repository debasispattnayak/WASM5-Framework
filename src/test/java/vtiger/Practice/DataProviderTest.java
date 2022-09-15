package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "cartlist") //HERE WE CAN TAKE METHOD NAME ALSO
	public void addToCart(String name,int price)
	{
		System.out.println(name+"= "+price);
	}

	@DataProvider(name="cartlist")
	public Object[][] getData()
	{
		Object[][] d=new Object[3][2];
		
		d[0][0]="samsung";
		d[0][1]=15000;
		
		d[1][0]="vivo";
		d[1][1]=20000;
		
		d[2][0]="realme";
		d[2][1]=25000;
		
		return d;		
	}
}
