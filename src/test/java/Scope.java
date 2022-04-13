import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Get the count of links on the page
		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksCount);
		
		//Get the count of links on the footer of the page
		int footerLinksCount = driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::li")).size();
		System.out.println(footerLinksCount);
		
		//Get the count of links for first section in the footer
		
		System.out.println("--------------links count on first section of the footer------------");
		List<WebElement> firstSectionLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::td[1]/ul/li/a"));
		System.out.println(firstSectionLinks.size());
		
		System.out.println("--------------links count on second section of the footer------------");
		List<WebElement> secondSectionLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::td[2]/ul/li"));
		
		for(WebElement e:secondSectionLinks ) {
			System.out.println(e.getText());
		}
		
		
		System.out.println("--------------links count on third section of the footer------------");
		List<WebElement> thirdSectionLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::td[3]/ul/li"));
		
		for(WebElement e:thirdSectionLinks ) {
			System.out.println(e.getText());
		}
		
		
		System.out.println("--------------links count on fourth section of the footer------------");
		List<WebElement> fourthSectionLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']/descendant::td[3]/ul/li"));
		
		for(WebElement e:fourthSectionLinks ) {
			System.out.println(e.getText());
		}

		  for(int i=0;i<firstSectionLinks.size();i++) 
		  {
		  System.out.println(firstSectionLinks.get(i).getText()); 
		  Thread.sleep(2000);
		  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		  firstSectionLinks.get(i).sendKeys(selectLinkOpeninNewTab);
		  }
		 
		  Set<String> windowHandles = driver.getWindowHandles();
		  Iterator<String> it = windowHandles.iterator();
		  
		  while(it.hasNext()) {
			  driver.switchTo().window(it.next());
			  System.out.println(driver.getTitle());
		  }
		  
		/*
		 * for(WebElement e:firstSectionLinks ) { System.out.println(e.getText());
		 * Thread.sleep(2000); String selectLinkOpeninNewTab
		 * =Keys.chord(Keys.CONTROL,Keys.RETURN); e.sendKeys(selectLinkOpeninNewTab); }
		 */
		 
		
					
	
	}

}
