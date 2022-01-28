package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestLeafFrames {
	
public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
       
		List<WebElement> el = driver.findElements(By.tagName("iframe"));	
		int size1 = el.size();
		
		for (int i = 0; i < el.size(); i++) {
			
			driver.switchTo().frame(el.get(i));
			List<WebElement> el1 = driver.findElements(By.tagName("iframe"));
			size1 =  size1 + el1.size();
			driver.switchTo().defaultContent();
			
		}
		
		System.out.println("No. of frames present:" + size1);
		
	}

}
