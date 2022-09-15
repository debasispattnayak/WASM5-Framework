package readdatafromparameter;

	import org.testng.annotations.Test;

	public class ReadDataFromCmdTest {
		@Test
		public void getData()
		{
			String URL = System.getProperty("url");
			String BROWSER = System.getProperty("browser");
			String USERNAME = System.getProperty("username");
			String PASSWORD = System.getProperty("password");
			
			System.out.println(URL);
			System.out.println(BROWSER);
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
		}

	}



