package SampleModulePack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Aditya_task {
	@Test
	public void  main1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		
		driver.get("https://www.prokabaddi.com/standings");
		Thread.sleep(2000);
		List<WebElement> we1= driver.findElements(By.xpath("//div[@class='row-head' and contains(.,'WWW')]//p[@class='name']"));
		
		for(WebElement x:we1 )
		System.out.println(x.getText());
		System.out.println("new commit");
		System.out.println("new commit 8-6-26");
		System.out.println("new commit 8-6-26 by command");
		



	
		
		

	}

}
