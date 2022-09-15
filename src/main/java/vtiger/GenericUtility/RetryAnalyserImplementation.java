package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will re try the failed test scripts due to synchronization or network issue/
 * @author DEV
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count=0;
	int retryCount=4; //MANUALLY TRY THEN SPECIFY THE RETRY COUNT
	public boolean retry(ITestResult result) {
		
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
