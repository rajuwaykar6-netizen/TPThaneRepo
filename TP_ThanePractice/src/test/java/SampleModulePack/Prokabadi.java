package SampleModulePack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Prokabadi {

	@Test

	public void win() {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.prokabaddi.com/");

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@title='Standings']")).click();
		
		List<WebElement> wins = driver.findElements(By.xpath("//ul[@class='form-listing' and contains(.,'WWW')]/ancestor::div[@class='row-head']//p[@class='name']"));
////ul[@class='form-listing' and contains(.,'WWW')]/ancestor::div[@class='row-head' and contains(.,'P')]//p[@class='name']
		
		for (WebElement win : wins) {
			System.out.println(win.getText());	
			
		}
		
		System.out.println("Task Completed!!!@#");
		
		System.out.println("Task Completed");
		}
		
		
	}
