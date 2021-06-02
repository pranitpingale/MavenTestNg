package pages;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import actionDriver.actionClass;
import base.baseClass;

import utilities.Log;

public class ReportsPageObjects extends baseClass {
 private static final int BUFFER_SIZE = 4096;
 actionClass action= new actionClass();
// PageObjects

@CacheLookup
 @FindBy(how = How.XPATH, using = "//*[@id=\"_ctl0_MPContent_txtUsername\"]")
 WebElement usrName;

@CacheLookup
 @FindBy(how = How.XPATH, using = "//*[@id=\"_ctl0_MPContent_txtPassword\"]")
 WebElement pwd;

@CacheLookup
 @FindBy(how = How.XPATH, using = "//*[@id=\"_ctl0_MPContent_btnLogin\"]")
 WebElement submit;

@CacheLookup
 @FindBy(how = How.XPATH, using = "//*[@id=\"_ctl0_TopRightNav_lnkLogout\"]")
 WebElement Logout;



// Page Functions
 public void userName(String username) {
  usrName.sendKeys(action.decodeString(username));
 }

public void passWord(String password) throws IOException {
  pwd.sendKeys(action.decodeString(password));
 }

public void submit() throws IOException {
  submit.click();
 }

 public void ForYesterdayBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

 Thread.sleep(3000);

 driver.get(prop.getProperty("WatchlistMatchReport_url"));

 Thread.sleep(3000);
  WebElement yesterdayBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateYesterday"));
  Actions action = new Actions(driver);
  action.moveToElement(yesterdayBtn).click().build().perform();

 WebElement RunReportBtn = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));
  action.moveToElement(RunReportBtn).click().build().perform();
  Thread.sleep(4000);


    String folderName = System.getProperty("user.dir") + "/testData/downloads/";


 File[] listFiles = new File(folderName).listFiles();
  for (int i = 0; i < listFiles.length; i++) {
   if (listFiles[i].isFile()) {
    String fileName = listFiles[i].getName();

    if (fileName.contains("WatchlistMatchReport")) {
     System.out.println("File is verified successfully & the file name is : " + fileName);
    }

  }
  }
 }

public void ForTodayBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

 Thread.sleep(3000);

 driver.get(prop.getProperty("WatchlistMatchReport_url"));

 Thread.sleep(3000);
  Actions action = new Actions(driver);

 WebElement todayBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateToday"));
  action.moveToElement(todayBtn).click().build().perform();
  Thread.sleep(4000);

 WebElement RunReportBtn2 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

 action.moveToElement(RunReportBtn2).click().build().perform();
  Thread.sleep(4000);
  String folderName = System.getProperty("user.dir") + "/testData/downloads/";

 File[] listFiles = new File(folderName).listFiles();
  for (int i = 0; i < listFiles.length; i++) {
   if (listFiles[i].isFile()) {
    String fileName = listFiles[i].getName();

    if (fileName.contains("WatchlistMatchReport")) {
     System.out.println("File is verified successfully & the file name is : " + fileName);
    }

  }
  }
 }

public void ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

 Thread.sleep(3000);

 driver.get(prop.getProperty("WatchlistMatchReport_url"));

 Thread.sleep(3000);
  Actions action = new Actions(driver);
  WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
  action.moveToElement(currentMonthBtn).click().build().perform();
  Thread.sleep(4000);
  WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

 action.moveToElement(RunReportBtn3).click().build().perform();
  Thread.sleep(4000);

  String folderName = System.getProperty("user.dir") + "/testData/downloads/";

 File[] listFiles = new File(folderName).listFiles();
  for (int i = 0; i < listFiles.length; i++) {
   if (listFiles[i].isFile()) {
    String fileName = listFiles[i].getName();

    if (fileName.contains("WatchlistMatchReport")) {
     System.out.println("File is verified successfully & the file name is : " + fileName);
    }

  }
  }
 }

public void  LoanConditionDetail_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

  Thread.sleep(3000);

  driver.get(prop.getProperty("LoanConditionDetails_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("LoanConditionDetailReport")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
  }


public void  ComparableSales_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

  Thread.sleep(3000);

  driver.get(prop.getProperty("ComparableSales_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("MarketComparable")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
  }

public void  ConditionResolution_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

  Thread.sleep(3000);

  driver.get(prop.getProperty("ConditionResolution_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("ScoringCondition")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
  }


public void  ConditionStatus_ForTodayBtn_downloadExcelForloanScoringResultReport() throws IOException, Exception {

  Thread.sleep(3000);

  driver.get(prop.getProperty("ConditionStatus_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateToday"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("ConditionStatus")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
  }

public void PropertyVerify_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws InterruptedException {
  Thread.sleep(3000);

  driver.get(prop.getProperty("PropertyVerify_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("PropertyVerify")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
}



public void LoanParticipants_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws InterruptedException {
  Thread.sleep(3000);

  driver.get(prop.getProperty("LoanParticipants_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("LoanParticipant")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
}


public void TransactionHistoryReport_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport() throws InterruptedException {
  Thread.sleep(3000);

  driver.get(prop.getProperty("TransactionHistoryReport_url"));

  Thread.sleep(3000);
   Actions action = new Actions(driver);
   WebElement currentMonthBtn = driver.findElement(By.id("_ctl0_MPContent_btnDateCurrentMonth"));
   action.moveToElement(currentMonthBtn).click().build().perform();
   Thread.sleep(4000);
   WebElement RunReportBtn3 = driver.findElement(By.id("_ctl0_MPContent_btnRunReport"));

  action.moveToElement(RunReportBtn3).click().build().perform();
   Thread.sleep(4000);

   String folderName = System.getProperty("user.dir") + "/testData/downloads/";

  File[] listFiles = new File(folderName).listFiles();
   for (int i = 0; i < listFiles.length; i++) {
    if (listFiles[i].isFile()) {
     String fileName = listFiles[i].getName();

     if (fileName.contains("TransactionHistory")) {
      System.out.println("File is verified successfully & the file name is : " + fileName);
     }

   }
   }
}

//TransactionHistoryReport_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport
public void logout() throws IOException {
  Logout.click();
  Log.info("Clicked on Logout button");
  Log.info("User Is Able To LogOut From Application");
 }

}
