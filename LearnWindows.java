package week4.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.id("home")).click();
	    String parentwindow = driver.getWindowHandle();
	    Set<String> childwindow = driver.getWindowHandles();
	    List<String>windowhandles = new ArrayList<String>(childwindow);
		driver.switchTo().window(windowhandles.get(0));
        String title = driver.getTitle();
		System.out.println(title);
		driver.close();
			
	    driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
	    Set<String> childwindow1 = driver.getWindowHandles();
	    List<String>windowhandles1 = new ArrayList<String>(childwindow1);
		driver.switchTo().window(windowhandles1.get(1));
		driver.switchTo().window(windowhandles1.get(2));
	    int size = driver.getWindowHandles().size();
        System.out.println(size);
        driver.close();
            
        driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
        Set<String> childwindow2 = driver.getWindowHandles();    
        List<String>windowhandles2 = new ArrayList<String>(childwindow2);
        driver.switchTo().window(windowhandles2.get(1));
        driver.switchTo().window(windowhandles2.get(0));
        driver.close();
        
        driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<String> childwindow3 = driver.getWindowHandles();
        System.out.println(childwindow3);    
        List<String>windowhandles3 =new ArrayList<String>(childwindow3);
        driver.switchTo().window(windowhandles3.get(1));
        driver.close();
            
            
            
            
            
            
            
            
            
            
            
            
	}

}
