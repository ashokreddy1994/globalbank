package driverFactory;

import org.openqa.selenium.WebDriver;

import commonFunctionLibrary.FunctionLibrary;
import utilities.ExcelFileUtil;

public class DriverScript {
	WebDriver driver;
	public void start() throws Throwable{
		ExcelFileUtil excel=new ExcelFileUtil();
		for(int i=1;i<=excel.rowCount("MasterTestCases");i++){
			if(excel.getData("MasterTestCases",i, 2).equalsIgnoreCase("Y")){
				String TCModule=excel.getData("MasterTestCases",i,1);
				int rowcount=excel.rowCount(TCModule);
				for(int j=1;j<=rowcount;j++){
					String Description=excel.getData(TCModule, j, 0);
					String Object_Type=excel.getData(TCModule, j, 1);
					String Locator_Type=excel.getData(TCModule, j, 2);
					String Locator_Value=excel.getData(TCModule, j, 3);
					String Test_Data=excel.getData(TCModule, j, 4);
					if(Object_Type.equalsIgnoreCase("openBrowser")){
						driver=FunctionLibrary.openBrowser(driver);
					}
					if(Object_Type.equalsIgnoreCase("startApplication")){
						FunctionLibrary.startApplication(driver);
					}
					if(Object_Type.equalsIgnoreCase("waitAction")){
						FunctionLibrary.waitAction(driver, Locator_Type, Locator_Value, Test_Data);
					}
					if(Object_Type.equalsIgnoreCase("typeAction")){
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
					}
					if(Object_Type.equalsIgnoreCase("clickAction")){
						FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
					}
					if(Object_Type.equalsIgnoreCase("closeBrowser")){
						FunctionLibrary.closeBrowser(driver);
					}
				}
			}
		}
	}

}
