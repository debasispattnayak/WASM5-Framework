package debugging;

import org.testng.annotations.Test;

public class DebugPractice {
	
	@Test
	public void test01()
	{
		System.out.println("Hi");
		int c = divide(20,0);
		System.out.println(c);
		
	}
	public static int divide(int a,int b)
	{
		
		return a/b;
	}
}
