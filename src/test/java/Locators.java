import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/");
		
		driver.findElement(By.linkText("LOGIN")).click();
		
		driver.findElement(By.id("email")).sendKeys("naik.prashant1991@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		driver.findElement(By.id("email")).submit();
		
		Thread.sleep(3000);
		
		String text = driver.findElement(By.cssSelector("div.bodySmall")).getText();
		System.out.println(text);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("naik.prashant1991@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("naik.prashant1991@yahoo.com");
		
	}

}
