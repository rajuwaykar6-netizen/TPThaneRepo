package SampleModulePack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class raju_new_pro_kabaddi {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.xpath("//a[contains(@href,'stand')]")).click();

		List<WebElement> names = driver.findElements(By.xpath(
				"//ul[@class=\"form-listing\" and contains(.,'WWW')]/ancestor::div[@class='row-head']/descendant::div[@class='team-name']"));

		for (WebElement name : names) {
			System.out.println(name.getText());
		}
		
		System.out.println("Task Completed");
		
	}

}
