import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExercise {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int rowCount = driver.findElements(By.xpath("//div[@class='left-align']//table[@id='product']/tbody/tr")).size();
		System.out.println("Number of rows are " +rowCount);
		int columnCount = driver.findElements(By.xpath("//div[@class='left-align']//table[@id='product']/tbody/tr/th")).size();
		System.out.println("Number of columns are "+columnCount);
		
		List<WebElement> rowText = driver.findElements(By.xpath("//div[@class='left-align']//table[@id='product']/tbody/tr[2]/child::*"));
		for(WebElement e:rowText) {
			System.out.print(e.getText() + " ");
		}

	}

}
