import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

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
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase("India"))
			{
				list.get(i).click();
				break;
			}
		}
		
		
		
		  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); 
		  driver.findElement(By.xpath("//a[@value='BLR']")).click();
		  driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).click(); 
		  driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		  driver.close();
		  driver.switchTo().window(parentWindowHandle);
		  driver.close();
		 
	}

}
