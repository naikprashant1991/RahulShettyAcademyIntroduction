import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//Launching on Chrome Browser
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launching on Firefox browser
		
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		//WebDriver driver1=new FirefoxDriver();
		
		//Launching on Edge browser
		
		System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver2 = new EdgeDriver();
		
		
		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();

	}

}
