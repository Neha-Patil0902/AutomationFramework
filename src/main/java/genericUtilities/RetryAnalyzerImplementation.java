package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	int count = 0;
	int retrycount = 3;  //Manual Analysis
	
/**
 * This class provides implementation to IRetryAnalyzer Interface of TestNG
 * 	@author yashp
 */
	public boolean retry(ITestResult result) {

		//0<3 1<3 2<3 3<3No
		while(count<retrycount)
		{
			count++;   //1 2 3
			return true;  //retry retry retry
		}
		
		return false;	//stop retry
	}
}
