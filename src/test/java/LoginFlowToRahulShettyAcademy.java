import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginFlowToRahulShettyAcademy {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");;
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/");
		
		driver.findElement(By.linkText("LOGIN")).click();
		
		driver.findElement(By.id("email")).sendKeys("naik.prashant1991@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("Rahulshetty@123");
		
		driver.findElement(By.id("email")).submit();
		
		String actualTitle = driver.findElement(By.xpath("//span[contains(text(),'Prashant Madhusudan Naik')]")).getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Prashant Madhusudan Naik");
		
		driver.findElement(By.xpath("//span[contains(text(),'Prashant Madhusudan Naik')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
		driver.close();
		
	}

}
