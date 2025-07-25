package setup;

import java.util.Properties;

import util.UtilsFactory;

public class PropertiesProvider {
	static Properties p;
	public static String getKey(String key) throws Exception {
		p=UtilsFactory.getProperties();
		String valueString= p.getProperty(key);
		System.out.println(valueString);
		return valueString;
		
	}
//	public static void main(String[]args) throws Exception {
//		System.out.println( PropertiesProvider.getKey("appUrl"));
//		System.out.println( PropertiesProvider.getKey("browser"));
//		
//	}
	

}
