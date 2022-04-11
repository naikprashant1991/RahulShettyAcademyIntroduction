import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.xpath("//a[text()='Flight Booking']")).click();
		String parentWindowHandle = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while(it.hasNext()) {
			String childWindow = it.next();
			if(childWindow!=parentWindowHandle) {
				driver.switchTo().window(childWindow);
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		
		
		for(int i=0;i<5;i++) {
			driver.findElement(By.xpath("//span[text()='+']")).click();
		
		}

		driver.findElement(By.xpath("//input[@class='buttonN']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "6 Adult");
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
	}

}
