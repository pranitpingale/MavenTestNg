package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import base.baseClass;

public class excelUtil extends baseClass {

   public static long PAGE_LOAD_TIMEOUT = 20;
   public static long IMPLICIT_WAIT = 20;
   public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/testData/DV_TestData.xlsx";
   static Workbook book;
   static Sheet sheet;


   public void switchToFrame() {
    driver.switchTo().frame("mainpanel");
   }


   public static Object[][] getTestData(String sheetName) throws IOException {
    FileInputStream file = null;
    try {
     file = new FileInputStream(TESTDATA_SHEET_PATH);
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }
    try {
     book = WorkbookFactory.create(file);
    } catch (IOException e) {
     e.printStackTrace();
    }
    sheet = book.getSheet(sheetName);
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for (int i = 0; i < sheet.getLastRowNum(); i++) {
     for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
      data[i][k] =sheet.getRow(i + 1).getCell(k).toString();
//      if (sheetName.equalsIgnoreCase("InputNewLoan")) {
//       Cell cell= sheet.getRow(i + 1).getCell(k);
//       cell.setCellValue("LORRY");
//       file.close();

//       FileOutputStream outputStream = new FileOutputStream(TESTDATA_SHEET_PATH);

//      }
     }
    }

    return data;

   }


  }