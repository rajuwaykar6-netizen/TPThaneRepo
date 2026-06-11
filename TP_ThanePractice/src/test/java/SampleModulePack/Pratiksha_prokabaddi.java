package SampleModulePack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pratiksha_prokabaddi {
	
	public static void main(String[] args) {
		
		
		  WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.prokabaddi.com");
	        
	       driver.findElement(By.xpath("//span[text()='Standings']")).click();
	       
	       List<WebElement> wins =driver.findElements(By.xpath("//ul[@class=\"form-listing\" and contains(.,'WWW')]/parent::div[@class=\"table-data form\"]/preceding-sibling::div[@class='table-data team']"));
	     
	       for(WebElement row : wins) {
	    	   String s=row.getText();
	    	   System.out.println(s);
	    	   
	    	   
	    	   System.out.println("prokabaddi1");
	    	   System.out.println("prokabaddi2");
	    	   
	       }
	       System.out.println("prokabaddi  is application");
	       
	       
	}

}



