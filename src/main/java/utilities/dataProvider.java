package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

  public class dataProvider {

   @DataProvider(name = "testData")
   public Object[][] getData() throws IOException
   {
   Object[][] data = excelUtil.getTestData("searchLoan") ;
   return data;
   }}