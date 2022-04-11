import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EFlightApplicationFlow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
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
		  driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		  driver.findElement(By.xpath("(//a[@value='IXJ'])[2]")).click();
		  
		  driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		  
		  if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			  System.out.println("Return Date is enabled");
		  }
		  else
		  {
			  System.out.println("Return date is disabled");
		  }
		  
			System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
			driver.findElement(By.id("divpaxinfo")).click();
			
			
			for(int i=0;i<5;i++) {
				driver.findElement(By.xpath("//span[text()='+']")).click();
			
			}
			System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		  
		  Select selectDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			selectDropdown.selectByVisibleText("AED");
			
			Thread.sleep(1000);
			
			System.out.println(driver.findElements(By.xpath("//div[@id='discount-checkbox']/descendant::label")).size());
			List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@id='discount-checkbox']/descendant::label"));
			
			for(int i=0;i<checkboxList.size();i++) {
				System.out.println(checkboxList.get(i).getText());
				if(checkboxList.get(i).getText().equalsIgnoreCase("Student")) {
					checkboxList.get(i).click();
					break;
				}
			}
			
			driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

	}

}
