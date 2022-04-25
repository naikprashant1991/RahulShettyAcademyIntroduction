import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingUsingJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement element = driver.findElement(By.xpath("//legend[text()='Web Table Fixed header']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("\r\n" + 
				"document.querySelector('.tableFixHead').scrollTop=5000");
		
		String actualCount = driver.findElement(By.cssSelector(".totalAmount")).getText();
		System.out.println(actualCount);
		String expectedCount = actualCount.split(":")[1].trim();
		
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum=0;
		for(int i=0;i<values.size();i++) {
			
			sum = sum + Integer.parseInt(values.get(i).getText());
			
		}
		
		Assert.assertEquals(sum, Integer.parseInt(expectedCount));
		

	}

}
