package com.csc.PaseVerifications;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Verification {

	public String verifyGithub() {
		WebDriver driver = new FirefoxDriver();
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

}
