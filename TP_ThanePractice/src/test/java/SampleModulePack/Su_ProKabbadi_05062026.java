package SampleModulePack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Su_ProKabbadi_05062026 {

	@Test
	public void proKabbadiStandingTest() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// navigate to url
		driver.get("https://www.prokabaddi.com/");

		// click on standings link
		driver.findElement(By.xpath("//span[text()='Standings']")).click();

		// get list of teams with 3 consecutive wins

		List<WebElement> form = driver.findElements(By.xpath(
				"//ul[@class='form-listing'and contains(.,'WWW')]/ancestor::div[@class='row-head']/descendant::p[@class='name']"));
		for (WebElement status : form) {
			String teamname = status.getText();

			System.out.println(teamname);

		}

//		}

	}

}
