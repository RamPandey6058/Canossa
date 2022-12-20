package com.hms.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary{
	 private FileInputStream fis;
   private	Workbook workbook;
   /**  
    * This method is used to fetch data from excel using row and cell index 
    * @param excelpath
    * @param sheet name
    * @param row Number
    * @param cell number
    * @return
    * @return EncryptedDocumentexception
    * @throws ioexception
    */

   
	public  String getExcelData(String path,String sheet,int row, int cellIndex) {


		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Cell cell = workbook.getSheet(sheet).getRow(row).getCell(cellIndex);
		 DataFormatter df = new DataFormatter();
			String data=df.formatCellValue(cell);
			return data;
			
	}
	
	
	/**This method is used to close the Excel
	 * @throws IOException 
	 * @throws ioexception
	 */
	public void closeExcel() throws IOException {
	workbook.close();
	fis.close();
}
}

