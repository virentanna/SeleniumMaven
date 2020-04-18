package commUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Error while reading the Properties file : " + e.getMessage());
		} 
		
	}
	
	public String getConfigData(String xKey)
	{
		return pro.getProperty(xKey);
	}
}