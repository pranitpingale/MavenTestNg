package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport extends baseClass{

 public ExtentHtmlReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest test;
 WebDriver driver;

 public void setExtent() {

  String dateName = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
 // specify location of the report
  htmlReporter = new ExtentHtmlReporter("./test-output/reports/Automation_Execution_Report_" + dateName + ".html");
     htmlReporter.config().setEncoding("utf-8");
//  htmlReporter.config().setDocumentTitle("Automation Execution Report"); // Tile of report
  htmlReporter.config().setReportName("Automation Execution Report "); // Name of the report
  htmlReporter.config().setTheme(Theme.DARK);

  extent = new ExtentReports();

  extent.attachReporter(htmlReporter);


 // Passing General information
  extent.setSystemInfo("Host name", prop.getProperty("hostname"));
  extent.setSystemInfo("Environment", prop.getProperty("Environment"));
  extent.setSystemInfo("user", prop.getProperty("User"));
 }


 public void testName(String name) {
  test = extent.createTest(name);
 }


 public void status(ITestResult result) throws Exception {

  if (result.getStatus() == ITestResult.FAILURE) {
  test.log(Status.FAIL,"TESTCASE:- "+ result.getName() + " FAILED"); // to add name in extent report
  test.log(Status.FAIL,"TESTCASE:- "+ result.getThrowable() + " FAILED"); // to add error/exception in extent report

  String screenshotPath = screenshotsUtil.getScreenshot(result.getName());
  test.addScreenCaptureFromPath(screenshotPath);


     } else if (result.getStatus() == ITestResult.SKIP) {
  test.log(Status.SKIP,"TESTCASE:- "+ result.getName() + " SKIPPED");
  }
  else if (result.getStatus() == ITestResult.SUCCESS) {
  test.log(Status.PASS,"TESTCASE:- "+ result.getName() + " PASSED");
//  String methodName = result.getMethod().getMethodName();
//  String logText = "<b>" + methodName.toUpperCase()+ "is PASSED"+ "</b>";
//  Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//  test.pass(m);
  }
 }



 public void endReport() {
 extent.flush();
 }



}
