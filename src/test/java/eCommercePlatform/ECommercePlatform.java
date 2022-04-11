package eCommercePlatform;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommercePlatform {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String itemsNeeded[] = {"Cucumber","Brocolli"};
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) 
		{
			String productName = products.get(i).getText();
			List<String> itemsNeededList= Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(productName))
			{
				
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
			}
		}

	}

}
