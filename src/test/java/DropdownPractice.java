import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {

	public static void main(String[] args) throws InterruptedException {
		
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
		Select selectDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		selectDropdown.selectByIndex(3);
		Thread.sleep(1000);
		System.out.println(selectDropdown.getFirstSelectedOption().getText());
		selectDropdown.selectByVisibleText("AED");
		Thread.sleep(1000);
		System.out.println(selectDropdown.getFirstSelectedOption().getText());
		selectDropdown.selectByValue("INR");
		Thread.sleep(1000);
		System.out.println(selectDropdown.getFirstSelectedOption().getText());
		driver.close();
		driver.switchTo().window(parentWindowHandle);
		driver.close();
		


	}

}
