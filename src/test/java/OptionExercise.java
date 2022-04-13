import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionExercise {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String optionText =driver.findElement(By.xpath("//div[@id='checkbox-example']/descendant::label[2]")).getText();
		System.out.println(optionText);
		
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText(optionText);
		
		driver.findElement(By.id("name")).sendKeys(optionText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		
		
		
		Assert.assertTrue(alertText.contains(optionText), optionText + "is not present in the alert box");
		driver.switchTo().alert().accept();

	}

}
