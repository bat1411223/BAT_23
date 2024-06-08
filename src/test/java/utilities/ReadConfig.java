package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path="config.properties";
	
	public ReadConfig() throws Exception {
		
		properties=new Properties();
		FileInputStream fix=new FileInputStream(path);
		properties.load(fix);
	}
	
	//User Defined Method
	
	public String getBrowser() {  //firefox
		
		String value=properties.getProperty("browser");//firefox
		
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Browser is not found in config file");
		}
		
	}
}
