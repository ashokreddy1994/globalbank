package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	Workbook wb;
	public ExcelFileUtil() throws Throwable{
		FileInputStream f=new FileInputStream("./TestInputs/inputData.xlsx");
          wb=WorkbookFactory.create(f);
	}
	public int rowCount(String sheetname){
		return wb.getSheet(sheetname).getLastRowNum();
	}
	public int colCount(String sheetname,int rowno){
		return wb.getSheet(sheetname).getRow(rowno).getLastCellNum();
	}
	public String getData(String sheetname,int rowno,int colno){
		String celldata="";
		if(wb.getSheet(sheetname).getRow(rowno).getCell(colno).getCellType()==Cell.CELL_TYPE_NUMERIC){
			int data=(int)wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue();
			celldata=String.valueOf(data);
		}
		else{
			celldata=wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		}
		return celldata;
		
	}
	
		
	
	

}
