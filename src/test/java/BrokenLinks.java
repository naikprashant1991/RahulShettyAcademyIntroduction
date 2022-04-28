import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));WebDriverManager.chromedriver().setup();
		
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for(WebElement e:links) {
			String url = e.getAttribute("href");
			HttpURLConnection connect = (HttpURLConnection)new URL(url).openConnection();
			connect.connect();
			System.out.println(connect.getResponseCode());
			a.assertTrue(connect.getResponseCode()<400, "The link with text " +e.getText()+ " is broken with code " +connect.getResponseCode());
			
		}
		a.assertAll();
		

	}

}
