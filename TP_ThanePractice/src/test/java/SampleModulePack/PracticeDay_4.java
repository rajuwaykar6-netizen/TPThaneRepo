package SampleModulePack;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class PracticeDay_4 {
	
	@Test
	
	public void checkout() throws InterruptedException, Throwable {
		
		
		WebDriver driver = new ChromeDriver();
		
		Actions action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> companyName = driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		
		List<WebElement> price = driver.findElements(By.xpath("//table//tbody//tr//td/following-sibling::td[not(contains(.,'+'))]/preceding-sibling::td[last()-2]/following-sibling::td[not(contains(.,'+'))]"));
		
		FileInputStream fis = new  FileInputStream("./Resource/Guru99Data.xlsx");
        
        Workbook wb = WorkbookFactory.create(fis);
        
        Sheet sheet = wb.createSheet("Guru99");
        
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("Company Name");
        title.createCell(1).setCellValue("Current Price");
        title.createCell(2).setCellValue("Price Range");        
        
        for (int i = 0; i < companyName.size(); i++) {
            Row row = sheet.createRow(i + 1);
            
            String company = companyName.get(i).getText();
            String currentPrice = price.get(i).getText().replace(",", "").trim();
            
            row.createCell(0).setCellValue(company);
            row.createCell(1).setCellValue(currentPrice);
            
            double priceValue = Double.parseDouble(currentPrice);

            if (priceValue < 500) {
                row.createCell(2).setCellValue("Low");
            } else {
                row.createCell(2).setCellValue("High");
            }   
        }
         
        FileOutputStream fos = new FileOutputStream("./Resource/Guru99Data.xlsx");
        wb.write(fos);
        wb.close();
        fos.close();
        driver.quit();
	}

}
	
