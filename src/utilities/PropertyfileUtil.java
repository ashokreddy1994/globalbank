package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyfileUtil {
	public static String getPropertyValueForKey(String Key) throws Throwable{
		Properties configproperties=new Properties();
		configproperties.load(new FileInputStream(new File("./propertiesfile/environment.properties")));
		
		return configproperties.getProperty(Key);
		
	}

}
