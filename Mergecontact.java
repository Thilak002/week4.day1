package week4.day1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontact {

	public static void main(String[] args)throws InterruptedException  {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver(); 
			driver.get("http://leaftaps.com/opentaps/");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys( "DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			driver.findElement(By.id("ComboBox_partyIdFrom")).sendKeys("raj");
			driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys("thilak");
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			Thread.sleep(5000);
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        String title = driver.getTitle();
	        System.out.println(title);
		}



	}


