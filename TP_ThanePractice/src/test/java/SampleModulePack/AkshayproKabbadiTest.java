package SampleModulePack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AkshayproKabbadiTest {
@Test
public void proKabaddiTest() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.prokabaddi.com/standings");
	
	List<WebElement> teams = driver.findElements(By.xpath("//ul[@class=\"form-listing\" and contains(.,'WWW')]/ancestor::div[@class=\"row-head\"]/descendant::div[@class=\"team-name\"]"));
	for (WebElement webElement : teams) {
		System.out.println(webElement.getText());
	}
	
	System.out.println("=============================================");
	
	
	List<WebElement> tnQ=driver.findElements(By.xpath("//ul[@class=\"form-listing\" and contains(.,'WWW')]/ancestor::div[@class=\"row-head\"]//p[@class=\"position\" and contains(text(),'P')]/ancestor::div[@class=\"row-head\"]//div[@class=\"team-name\"]"));
	for (WebElement webElement2 : tnQ) {
		System.out.println(webElement2.getText());
	}
}
}
