package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		
		
		
		prop = new Properties();
		try {
			FileInputStream ip =  new FileInputStream("C:/Users/VIKAS KUMAR/eclipse-workspace/FreeCRM/src/main/java/com/crm/qa/"
					+ "config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public  void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "G:\\Testing\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("Mozilla")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
				 driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please select valid driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

		
		
	}
	

	

			
	
	
	
	
	
	
	
	
	
	
	
	
}
