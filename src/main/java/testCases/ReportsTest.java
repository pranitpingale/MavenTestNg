package testCases;

import java.io.File;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import base.baseClass;

import pages.ReportsPageObjects;
import utilities.Log;
import utilities.excelUtil;

import com.aventstack.extentreports.Status;

import io.qameta.allure.Allure;
import io.qameta.allure.Story;

public class ReportsTest extends baseClass {
 @Story("Report Module: Watchlist Match")
 @Test(invocationCount = 1, priority = 1, description="Report Module: Test case 1: Watchlist Match - Top verify it gives the waitlist match report")

 public void reportTestFirst() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Watchlist Match - LoanScoringReport :TestCase 1- To check excel report for yesterday filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);
   Log.info("Report Module: Watchlist Match - To verify it gives the waitlist match report");
   Allure.step("Report Module: Watchlist Match - To verify it gives the waitlist match report");
   // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.ForYesterdayBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Excel report for yesterday filter is working properly and the report file is downloaded properly in destination folder");

   page.ForTodayBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Excel report for today filter is working properly and the report file is downloaded properly in destination folder");

   page.ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Excel report for current month filter is working properly and the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

//
// @Story("Report Module: Loan scoring result")
// @Test(invocationCount = 1, priority = 2, description="Report Module: Loan scoring result -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")
//
// public void reportTestSecond() throws Exception {
//  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");
//
//  File fList[] = folder.listFiles();
//
//  for (File f : fList) {
//
//   if (f.getName().endsWith(".xls")) {
//
//    f.delete();
//   }
//  }
//
//  ApplicationNavigation();
//
//  extentReport.testName(
//    "Loan Scoring Results - LoanScoringReport :TestCase 2- To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
//  extentReport.test.assignCategory("REPORT MODULE");
//
//  Object[][] data = excelUtil.getTestData("Report");
//
//  int k = data[0].length;
//
//  for (int i = 0; i < data.length; i++) {
//
//   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);
//
//   Log.info("Report Module: Loan scoring result -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
//   Allure.step("Report Module: Loan scoring result -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username
//
//   page.userName(data[i][k - 2].toString());
//
//   // Password
//
//   page.passWord(data[i][k - 1].toString());
//
//   page.submit();
//
//   extentReport.test.log(Status.PASS, "Logged in successfully");
//
//   page.LoanScoringResult_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();
//
//   extentReport.test.log(Status.PASS,
//     "Excel report for current month filter is working properly and the report file is downloaded properly in destination folder");
//
//   page.logout();
//  }
// }
//
//
 @Story("Report Module: Loan Condition Detail")
 @Test(invocationCount = 1, priority = 2, description="Report Module: Loan scoring result -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestSecond() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Loan Condition Detail - LoanScoringReport :TestCase 2- To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Loan Condition Detail -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Loan Condition Detail -  TestCase 2 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.LoanConditionDetail_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Loan Condition Detail - Excel report for current month filter is working properly and the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

 @Story("Report Module: Comparable sales")
 @Test(invocationCount = 1, priority = 3, description="Report Module: Comparable sales - TestCase 3 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestThird() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Comparable sales -  TestCase 3 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Comparable sales -  TestCase 3 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Comparable sales -  TestCase 3 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.ComparableSales_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Comparable sales -  TestCase 3 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

 @Story("Report Module: Condition Resolution")
 @Test(invocationCount = 1, priority = 4, description="Report Module: Condition Resolution -  TestCase 4 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestFourth() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Condition Resolution -  TestCase 4 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Condition Resolution -  TestCase 4 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Condition Resolution -  TestCase 4 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.ConditionResolution_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Condition Resolution -  TestCase 4 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

   @Story("Report Module: Condition Status")
 @Test(invocationCount = 1, priority = 5, description="Report Module: Condition Status -  TestCase 5 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestFifth() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Condition Status -  TestCase 5 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Condition Status -  TestCase 5 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Condition Status -  TestCase 5 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.ConditionStatus_ForTodayBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Condition Status -  TestCase 5 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

 @Story("Report Module: Property Verify")
 @Test(invocationCount = 1, priority = 6, description="Report Module: Property Verify -  TestCase 6 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestSixth() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Property Verify -  TestCase 6 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Property Verify -  TestCase 6 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Property Verify -  TestCase 6 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.PropertyVerify_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Property Verify -  TestCase 6 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

 @Story("Report Module: Loan Participants")
 @Test(invocationCount = 1, priority = 7, description="Report Module: Loan Participants -  TestCase 7 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestSeventh() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Loan Participants -  TestCase 7 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Loan Participants -  TestCase 7 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Loan Participants -  TestCase 7 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.LoanParticipants_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Loan Participants -  TestCase 7 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }

 @Story("Report Module: Transaction History Report")
 @Test(invocationCount = 1, priority = 8, description="Report Module: Transaction History Report -  TestCase 8 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder")

 public void reportTestEigth() throws Exception {
  File folder = new File(System.getProperty("user.dir") + "/testData/downloads/");

  File fList[] = folder.listFiles();

  for (File f : fList) {

   if (f.getName().endsWith(".xls")) {

    f.delete();
   }
  }

  ApplicationNavigation();

  extentReport.testName(
    "Report Module: Transaction History Report -  TestCase 8 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
  extentReport.test.assignCategory("REPORT MODULE");

  Object[][] data = excelUtil.getTestData("Report");

  int k = data[0].length;

  for (int i = 0; i < data.length; i++) {

   ReportsPageObjects page = PageFactory.initElements(driver, ReportsPageObjects.class);

   Log.info("Report Module: Transaction History Report -  TestCase 8 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");
   Allure.step("Report Module: Transaction History Report -  TestCase 8 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder"); // Username

   page.userName(data[i][k - 2].toString());

   // Password

   page.passWord(data[i][k - 1].toString());

   page.submit();

   extentReport.test.log(Status.PASS, "Logged in successfully");

   page.TransactionHistoryReport_ForCurrentMonthBtn_downloadExcelForloanScoringResultReport();

   extentReport.test.log(Status.PASS,
     "Report Module: Transaction History Report -  TestCase 8 - To check excel report for current month filter is working properly and to verify the report file is downloaded properly in destination folder");

   page.logout();
  }
 }
}