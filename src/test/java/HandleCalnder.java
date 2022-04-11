import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalnder {

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
		
		 driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); 
		  driver.findElement(By.xpath("//a[@value='BLR']")).click();
		  driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).click(); 
		  driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		  driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		  //System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		
		  System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		  
		  if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			  System.out.println("Return Date is enabled");
		  }
		  else
		  {
			  System.out.println("Return date is disabled");
		  }
		
		/*
		 * driver.findElement(By.xpath(
		 * "//div[@class='picker-first2']/descendant::button[@class='ui-datepicker-trigger']"
		 * )).click();
		 * 
		 * List<WebElement> dateRange =
		 * driver.findElements(By.xpath("//td//a[@class='ui-state-default']"));
		 * 
		 * for(WebElement e:dateRange) { if(e.getText().equalsIgnoreCase("11")) {
		 * e.click(); break; } }
		 */
		

		
	}

}
