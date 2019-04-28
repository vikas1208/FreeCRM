package com.vikas.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

 static	WebDriver driver;
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "G:\\Testing\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.get("https://www.toolsqa.com/automation-practice-table/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
		int rowlength=	driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr")).size();
		int columnlength= driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td")).size();
		for(int i=1;i<=rowlength;i++) {
			for(int j=1;j<=columnlength;j++) {
		WebElement data=	driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr["+i+"]/td["+j+"]"));
			System.out.print(data.getText()+" ");
			}
			System.out.println();
		}
		
	}

}
