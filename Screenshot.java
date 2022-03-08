package week4.day1;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");	   
		driver.manage().window().maximize();
	   Thread.sleep(3000);
	   driver.switchTo().frame(0);
	  WebElement ele = driver.findElement(By.xpath("//button[text()='Click Me']"));
	  
	
	File src = ele.getScreenshotAs(OutputType.FILE);
	File des = new File("./images/button.png");
     FileUtils.copyFile(src, des);
     driver.switchTo().defaultContent();
     


	
	
	}

}
