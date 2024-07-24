package Qualityqa.QA;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args) throws Exception{
		
		 	
		    	try {
					FileInputStream fis = new FileInputStream("C:\\Users\\sanika.patil\\Documents\\AmazonLogin.xlsx");
		    		@SuppressWarnings("resource")
					XSSFWorkbook wk =  new XSSFWorkbook(fis);
					XSSFSheet sh = wk.getSheetAt(0);
					
					for (int i = 1; i <= sh.getLastRowNum(); i++) {
						XSSFRow row = sh.getRow(i);
						String cell1 = row.getCell(1).getRawValue();
						XSSFCell cell2 = row.getCell(2);
						System.out.println(cell1);
						System.out.println(cell2);
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
		    } 
	}


