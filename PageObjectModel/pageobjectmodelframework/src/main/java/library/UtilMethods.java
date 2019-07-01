package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilMethods {
	
	Properties prop;
	FileInputStream fis;
	FileOutputStream fos;
	String path="Config/configuration.properties";
	
	/*public UtilMethods(String path)
	{
		this.path=path;
	}*/
	
	public String getValueOf(String key)
	{
		
		try
		{
			prop=new Properties();
			fis=new FileInputStream(path);
			
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
			fis=new FileInputStream(path);
			
			prop.load(fis);
			fis.close();
			
			fos=new FileOutputStream(path);
			
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
	
	public String getExcelData()
	{
		XSSFWorkbook workBook;
		XSSFSheet workSheet;
		XSSFCell Cell;
		XSSFRow Row;
		
		File file=new File("ExcelData/TestData.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			workBook=new XSSFWorkbook(fis);
			workSheet=workBook.getSheetAt(0);
			int lastRow=workSheet.getLastRowNum();
			return workSheet.getRow(lastRow).getCell(1).toString();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		 
	}
	
	public void setExcelData()
	{
		
	}

}
