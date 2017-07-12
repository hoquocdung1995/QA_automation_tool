package com.csc.storage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.csc.driverpool.DriverPool;

/**
 * 
 * @author Nguyen Huu Phuoc
 *
 */
public class Screenshot {
	// constant url of screenshots folder 
	private static final String URL_BASE = "localhost/files/screenshots/";
	
	/**
	 * @author Nguyen huu phuoc, Vo Duong Quang
	 * @return URL file screenshot
	 */
	public static String screenshot() {
		try {
			File scrFile = ((TakesScreenshot) DriverPool.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
			String fileName = Screenshot.date() + ".jpg";
			String path = getPathScreenShot() + fileName;
			FileUtils.copyFile(scrFile, new File(path));
			return (URL_BASE + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String date() {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
		String now = ft.format(date);
		return now;
	}
	/**
	 * @author Vo Duong Quang
	 * @return path image screenshot 
	 */
	private static String getPathScreenShot() {
		return new File(getFitNesseFilesSectionDir(), "screenshots").getPath() + "/";
	}
	/**
	 * @author Vo Duong Quang
	 * @return path folder files of system 
	 */
	private static String getFitNesseFilesSectionDir() {
		return new File("FitNesseRoot", "files").getAbsolutePath();
	}
}
