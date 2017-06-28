package com.csc.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Properties {
	public static void setProperty(String fileName, String locator, String property) {
		try {
			String path = "FitNesseRoot/bin/" + fileName;
			String data = "";

			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			} else {
				data = "\r\n";
			}
			data = data + locator + "=" + property;

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(data);
			bw.close();
		} catch (Exception e) {

		}
	}

}
