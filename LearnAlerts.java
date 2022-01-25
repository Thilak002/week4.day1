package week4.day1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        Thread.sleep(5000);
        Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        Thread.sleep(5000);
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("ABCDE");
        alert3.accept();
        driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        driver.close();
        
		
		
		
	}

}

	
