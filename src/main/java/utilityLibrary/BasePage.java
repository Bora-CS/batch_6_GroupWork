package utilityLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	static WebDriver driver;
	private String url1 = "https://www.totalwine.com/";
	private String url2 = "https://www.amazon.com/";
	private String url3 = "https://www.walmart.com/";
	private String url4 = "https://www.homedepot.com/";



	
	
	
	
	
	private void closeDriver() {
		driver.close();
		driver.quit();
	}

	private void setUpDriver() {
		String os = System.getProperty("os.name");
		String driverPath = "";
		if (os.toLowerCase().startsWith("mac")) {
			driverPath = "src/main/resources/chromedriver91";
		} else if (os.toLowerCase().startsWith("windows")) {
			driverPath = "src/main/resources/chromedriver91.exe";
		}

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
	}


}
