package com.csc.PaseVerifications;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Verification {
	WebDriver driver = new FirefoxDriver();
	public String verifyGithub() {
		
		driver.get("https://github.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String element = driver.findElement(By.xpath("//div[4]/div[1]/div/div[1]/h1")).getText();
		return element;
	}

	public String veryfiGmail() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String element = driver.findElement(By.xpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/div[2]/span")).getText();
		return element;
	}
	
	
	public String verifyElementText(String id, String url) {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id(id));
		String elementval = element.getAttribute("value");
		System.out.println(elementval);
		driver.close();
		return elementval;

	}

	public String verifyElementIsPresent(String text) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String pageSource = driver.getPageSource();
		if (pageSource.contains(text)) {
			System.out.println("2) Expected text '" + text + "' present in the web page.");
			return text + "is not present in the web page.";
		}
		driver.close();
		return text + "Expected text";
	}

	public void verifyDropDownList(String id) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dropdown = driver.findElement(By.id(id));
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			System.out.println(we.getText());
		}
	}

	public void verifyWebGrid(String url, String id) {

		driver = new FirefoxDriver();
		driver.get(url);

		WebElement table_element = driver.findElement(By.id(id));

		List<WebElement> tr_collection = table_element.findElements(By.xpath("id(" + id + ")/tbody/tr"));

		System.out.println("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
		int row_num, col_num;
		row_num = 1;
		for (WebElement trElement : tr_collection) {
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			System.out.println("NUMBER OF COLUMNS=" + td_collection.size());
			col_num = 1;
			for (WebElement tdElement : td_collection) {
				System.out.println("row # " + row_num + ", col # " + col_num + "text=" + tdElement.getText());
				col_num++;
			}
			row_num++;
		}

	}
	
	

}
