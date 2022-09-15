package retryfailedtestscript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryPractice {
	
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void retry()
	{
		System.out.println("hello");
		Assert.fail();
	}

}
