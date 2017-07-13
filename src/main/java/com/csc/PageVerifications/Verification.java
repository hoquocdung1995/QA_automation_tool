package com.csc.PageVerifications;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.csc.action.PageAction;
import com.csc.driverpool.DriverPool;

/**
 * class verification is web verification
 * @author Bui Duc Anh
 * @since 12/7/2017
 */

public class Verification {

	
	/**
	 * verifiElementText is method get the value in element.
	 * @param locator is get from read file properties
	 * @return elementText is value of attribute
	 */
	public static String verifyElementText(String locator) {
		WebDriver driver = DriverPool.getCurrentDriver();
		List<String> loca = PageAction.readLocator(locator);
		String type = loca.get(0);
		String elementText = "";
		try {
			if (type.equals("xpath")) {
				elementText = driver.findElement(By.xpath(loca.get(1))).getText();
			} else if (type.equals("id")) {
				elementText = driver.findElement(By.id(loca.get(1))).getText();
			} else if (type.equals("name")) {
				elementText = driver.findElement(By.name(loca.get(1))).getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			elementText = "Not found";
		}

		return elementText;

	}
	/**
	 * verifyDropDownList is get all element value in DropDownList.
	 * @param locator is get from read file properties
	 * @return elementText is value of attribute
	 */

	public static String verifyDropDownList(String locator) {
		WebDriver driver = DriverPool.getCurrentDriver();
		List<String> loca = PageAction.readLocator(locator);
		String type = loca.get(0);
		String elementText = "";
		try {
			if (type.equals("xpath")) {
				String dropdown = driver.findElement(By.xpath(loca.get(1))).getText();

				String[] str = dropdown.split("\\s");
				for (String s : str) {
					elementText = elementText + s;
				}

			} else if (type.equals("id")) {

				String dropdown = driver.findElement(By.id(loca.get(1))).getText();

				String[] str = dropdown.split("\\s");
				for (String s : str) {
					elementText = elementText + s;
				}

			} else if (type.equals("name")) {
				String dropdown = driver.findElement(By.name(loca.get(1))).getText();

				String[] str = dropdown.split("\\s");
				for (String s : str) {
					elementText = elementText + s;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			elementText = "Not found";
		}

		return elementText;

	}
	/**
	 * @author Vo trung tin
	 * @param locator
	 * @return list: a list of table element for verifyWebGrid
	 */
	public static List<List<List<String>>> verifyWebGrid(String locator) {
		WebDriver driver = DriverPool.getCurrentDriver();
		List<String> loca = PageAction.readLocator(locator);
		String type = loca.get(0);
		WebElement element = null;
		try {
			if (type.equals("xpath")) {
				element = driver.findElement(By.xpath(loca.get(1)));
			} else if (type.equals("id")) {
				element = driver.findElement(By.id(loca.get(1)));
			} else if (type.equals("name")) {
				element = driver.findElement(By.name(loca.get(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<List<String>> list = new ArrayList<>();
		list = readWebGrid(element);
		return getWebGrid(list);
	}
	
	/**
	 * Read grid table then save all cells' value of grid table into the list 
	 * @author Vo Duong Quang
	 * @param element of grid table
	 * @return list 
	 */
	private static List<List<String>> readWebGrid(WebElement element){
		//find tagName element of table
		WebElement webElement = element.findElement(By.tagName("tbody"));
		//find tagName element of row 
		List<WebElement> trList = webElement.findElements(By.tagName("tr"));
		//List to save all cells' value each row of the table 
		List<String> rowList=null;
		//list to save all rows' value of the table
		List<List<String>> list=new ArrayList<>();
		//add all cells' value of table into the list
		for(WebElement trElement:trList) {
			List<WebElement> tdList = trElement.findElements(By.xpath("*"));
			rowList=new ArrayList<>();
			for(WebElement tdElement:tdList) {
				//add cells' value into rowList
				rowList.add(tdElement.getText());
			}
			list.add(rowList);
			
		}
		return list;
	}
	
	/**
	 * Split the table in the format of the query table Fitnesse
	 * @author Vo Trung Tin
	 * @param list: a list of table element
	 * @return a list of table element for verifyWebGrid
	 */
	private static List<List<List<String>>> getWebGrid(List<List<String>> list) {
		// list last stored data
		List<List<List<String>>> finalList = new ArrayList<List<List<String>>>();
		// list of table row
		List<List<String>> currentList = null;
		// list of table column
		List<String> chilList = null;
		String th = null;
		String td = null;
		// Split the table in the format of the query table Fitnesse
		for (int i = 1; i < list.size(); i++) {
			currentList = new ArrayList<>();
			for (int j = 0; j < list.get(0).size(); j++) {
				chilList = new ArrayList<>();
				// get value of table head
				th = list.get(0).get(j);
				// get value of table cell
				td = list.get(i).get(j);
				chilList.add(th);
				chilList.add(td);
				currentList.add(chilList);
			}
			finalList.add(currentList);
		}
		return finalList;
	}

}
