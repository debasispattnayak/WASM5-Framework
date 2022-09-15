package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test
	public void testScript01()
	{
		System.out.println("test 01");
	}
	@Test(priority = -1)
	public void testScript02()
	{
		Assert.fail();
		System.out.println("test 02");
	}
	@Test(enabled = false)
	public void testScript03()
	{
		System.out.println("test 03");
	}
	@Test(dependsOnMethods = {"testScript01","testScript02"})
	public void testScript04()
	{
		System.out.println("test 04");
	}
}
