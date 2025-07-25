package util;

import java.io.FileInputStream;

import java.util.Properties;

public class UtilsFactory
{
	static Properties p;
	public static Properties getProperties() throws Exception{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\config.Properties");
		Thread.sleep(2000);
		p=new Properties();
		p.load(file);
		Thread.sleep(1000);
		return p;
	}
}
