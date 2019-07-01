package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	Properties prop;
	FileInputStream fis;
	FileOutputStream fos;
	
	public String getValueOf(String key)
	{
		
		try
		{
			prop=new Properties();
			fis=new FileInputStream("Config/configuration.properties");
			
			prop.load(fis);
			return prop.getProperty(key);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return "";
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			return "";
		}
	}
	
	public void setValueOf(String key, String value)
	{
		
		try
		{
			prop=new Properties();
			fis=new FileInputStream("Config/configuration.properties");
			
			prop.load(fis);
			fis.close();
			
			fos=new FileOutputStream("Config/configuration.properties");
			
			prop.setProperty(key, value);
			prop.store(fos, null);
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
