package com.csc.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.csc.fixture.SetUpConfiguration;

public class Properties {
	public static void setProperty(String fileName, String value, String property) {
		try {
			String path = SetUpConfiguration.configuration.getUrl() + "/" + fileName;
			String data = "";

			File file = new File(path);
			if (!file.exists()) {				file.createNewFile();
			} else {
				data = "\r\n";
			}
			data = data + value + "=" + property;

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(data);
			bw.close();
		} catch (Exception e) {

		}
	}
	
}
