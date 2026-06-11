package SampleModulePack;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Raju_Color_ValidationTest {

	public static void main(String[] args) {
		
		String expectedcolname = "BLACK/WHITE-ORANGE-CLEAR";

		WebDriver driver = new ChromeDriver();
		driver.get("	https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nike shoes");
		driver.findElement(By.id("nav-search-submit-button")).click();

		WebElement web = driver.findElement(By.xpath("//span[text()='Nike Womens Waffle Debut Running Shoes']"));
		web.click();

		Set<String> allid = driver.getWindowHandles();

		for (String id : allid) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains("Waffle")) {
				break;
			}
		}
		
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 650).perform();

		WebElement white = driver.findElement(By.xpath("//input[@aria-posinset='3' and @aria-setsize='4']"));
		act.moveToElement(white);
		white.click();

		String actualcolname = driver
				.findElement(By.xpath("//span[@id='inline-twister-expanded-dimension-text-color_name']")).getText();

		Assert.assertEquals(expectedcolname, actualcolname);
		System.out.println("Color is displayed: " + actualcolname);
	}	
}

