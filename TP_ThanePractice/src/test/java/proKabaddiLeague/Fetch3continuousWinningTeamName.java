package proKabaddiLeague;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Fetch3continuousWinningTeamName {
	@Test
	public void Fetch3continuousWinningTeamName() throws Throwable {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.prokabaddi.com/");

		driver.findElement(By.xpath("//a[@href='https://www.prokabaddi.com/standings']")).click();

		List<WebElement> teamName = driver.findElements(By.xpath(
				"//ul[@class='form-listing' and contains(.,'WWW')]//ancestor::div[@class='table-row-wrap' and contains(.,'P')]//p[@class='name']"));
		for(WebElement team : teamName)
		System.out.println(team.getText());
		
		System.out.println(";;;;;;;;;;");
		System.out.println("++++++++++++++");
		System.out.println("=-=-=-=-==-=");
	}
}