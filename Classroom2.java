package week4.day1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2 {
	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
			Set<String> childwindow = driver.getWindowHandles();
			List<String> windowHandles = new ArrayList<String>(childwindow);
			driver.switchTo().window(windowHandles.get(1));
			String title = driver.getTitle();
			System.out.println(title);
			
			driver.switchTo().window(windowHandles.get(0));
			driver.close();
			
		}

	}

