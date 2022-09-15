package assertionPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPracticeTest {
	
	@Test
	public void test01()
	{
		System.out.println("step 01");
		System.out.println("step 02");
		Assert.assertTrue(false);
		System.out.println("step 03");
		System.out.println("step 04");
		System.out.println("step 05");
		
	}
	
	@Test
	public void test02()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("=====1 line===");
		System.out.println("=====2 line===");
		sa.assertEquals(1, 2);
		System.out.println("=====3 line===");
		sa.assertTrue(false);
		System.out.println("=====4 line===");
		sa.assertAll();   //MANDATORY TO USE AT LAST FOR SOFT ASSERTION
	}

}
