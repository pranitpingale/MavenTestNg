package base;

import com.google.common.collect.ImmutableMap;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.HashMap;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

//import pages.LoginPageObjects;
import utilities.Log;
import utilities.excelUtil;
import utilities.extentReport;
import utilities.screenshotsUtil;
import com.aventstack.extentreports.Status;

public class baseClass {

 public static Properties prop;
 public static WebDriver driver;
 public static extentReport extentReport;


   @AfterSuite
   public void tearDown() throws Exception {
	   driver.quit();
	   extentReport.endReport();
   }


   @BeforeSuite
   public void beforSuite() throws Exception, Exception {
     DOMConfigurator.configure("log4j.xml");
     Log.info("Log4j Is Configured");
     loadConfig();
  extentReport = new extentReport();
  extentReport.setExtent();

        allureEnvironmentWriter(
        ImmutableMap.<String, String>builder()
        .put("Browser", prop.getProperty("browser"))
        .put("Browser.Version", prop.getProperty("browser_version"))
        .put("Env", prop.getProperty("Environment"))
        .put("URL", prop.getProperty("Login_url"))
        .build(), System.getProperty("user.dir")+"/allure-results/");

   }


   @AfterMethod
   public void reporting(ITestResult result) throws Exception {
//  extentReport.status(result);

   }

   @BeforeClass
   public void setup() throws Exception, IOException {
      launchDriver();
   }

//   @AfterClass
//   public void driverQuit() throws Exception, IOException {
//    driver.quit();
//   }



 //Load Properties data
    public void loadConfig() throws IOException {
   Object[][] data = excelUtil.getTestData("TestEnv") ;
   switch(data[0][0].toString()) {
  case "qa":
      try {
    prop = new Properties();
    FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/configuration/qa_config.properties");
    prop.load(ip);
   }
   catch(FileNotFoundException e ) {
    e.printStackTrace();
   }
   catch (IOException e) {
       e.printStackTrace();
      }
      break;
     case "dev":
   try {
    prop = new Properties();
    FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\dev_config.properties<file://\\configuration\\dev_config.properties>");
    prop.load(ip);
   }
   catch(FileNotFoundException e ) {
    e.printStackTrace();
   }
   catch (IOException e) {
       e.printStackTrace();
      }
       break;
  case "uat":
   try {
    prop = new Properties();
    FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\uat_config.properties<file://\\configuration\\uat_config.properties>");
    prop.load(ip);
   }
   catch(FileNotFoundException e ) {
    e.printStackTrace();
   }
   catch (IOException e) {
   e.printStackTrace();
      }
      break;
    }
    }

 //Launch Driver

 public void launchDriver() throws Exception, TimeoutException {
  String browserName = prop.getProperty("browser");
  if(browserName.contains("Chrome")) {
        //String chromeDriverLoc = System.getProperty("user.dir")+prop.getProperty("chromeDriverLoc"); //Temp disable user dir+driver location

         String chromeDriverLoc = prop.getProperty("chromeDriverLoc");

         System.setProperty("webdriver.chrome.driver",chromeDriverLoc);

         HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

         chromePrefs.put("profile.default_content_settings.popups", 0);

         chromePrefs.put("download.default_directory",

         System.getProperty("user.dir") + File.separator + "testData" + File.separator + "downloads");

         ChromeOptions options = new ChromeOptions();

         options.setExperimentalOption("prefs", chromePrefs);

         options.addArguments("--disable-notifications");

//        options.addArguments("--headless");


        driver = new ChromeDriver(options);

  }else if (browserName.contains("Firefox")) {
   driver = new FirefoxDriver();
  }
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     Log.info("Driver Started..");
   }



 public void ApplicationNavigation() throws Exception {
  try {
    driver.get(prop.getProperty("Login_url"));
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    String ActualUrl = driver.getCurrentUrl();

    String ExpectedUrl =prop.getProperty("Login_url");
    Assert.assertEquals(ExpectedUrl,ActualUrl);
//    extentReport.test.log(Status.PASS, "Navigated To DataVerify Application");
    Log.info("Navigated To DataVerify Application");

  }
  catch(TimeoutException e) {
   screenshotsUtil.saveFailureScreenshot();
    Log.warn("Page-'"+ prop.getProperty("Login_url") + "' didnot load within 20 seconds");
    e.printStackTrace();
    Assert.assertTrue(false, "Page-'"+ prop.getProperty("Login_url") + "' didnot load within 20 seconds");
     }
    }


 public void searchLoan() throws IOException {
  try {
       driver.get(prop.getProperty("SearchLoan_url"));
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  catch(TimeoutException e) {
    Log.warn("Page-'"+ prop.getProperty("SearchLoan_url") + "' didnot load within 20 seconds");
    e.printStackTrace();
   screenshotsUtil.saveFailureScreenshot();
   Assert.assertTrue(false, "Page-'"+ prop.getProperty("SearchLoan_url") + "' didnot load within 20 seconds");
     }
    }


 public void advancedSearch() throws IOException {
    try {
         driver.get(prop.getProperty("AdvanceSearch_url"));
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Log.info("To Verify Load Saved Search Is Selected");

     extentReport.test.log(Status.PASS, "Navigated To DataVerify Application");
     Log.info("Navigated To DataVerify Application");
  }
  catch(TimeoutException e) {
   Log.warn("Page-'"+ prop.getProperty("AdvanceSearch_url") + "' didnot load within 20 seconds");
   e.printStackTrace();
   screenshotsUtil.saveFailureScreenshot();
   Assert.assertTrue(false, "Page-'"+ prop.getProperty("AdvanceSearch_url") + "' didnot load within 20 seconds");

     }
    }


    public void inputNewLoan() throws IOException {
     try {
        WebElement ele=driver.findElement(By.xpath("//*[@id=\"el0\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(ele).clickAndHold().build().perform();
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.TAB);
        act.sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get(prop.getProperty("InputNewLoan_url"));
   }catch(TimeoutException e ) {
    Log.warn("Page-Input New Loan didnot load within 20 seconds");
    e.printStackTrace();
    screenshotsUtil.saveFailureScreenshot();
    Assert.assertTrue(false, "Page-Input New Loan didnot load within 20 seconds");
      }
    }


 public void batchLosUpload() throws IOException {
  try {
        driver.get(prop.getProperty("BatchLOSUpload_url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  catch(TimeoutException e) {
     Log.warn("Page-'"+ prop.getProperty("BatchLOSUpload_url") + "' didnot load within 20 seconds");
     e.printStackTrace();
   screenshotsUtil.saveFailureScreenshot();
   Assert.assertTrue(false, "Page-'"+ prop.getProperty("BatchLOSUpload_url") + "' didnot load within 20 seconds");
     }
    }


 public void importFromDU() throws IOException {
  try {
        driver.get(prop.getProperty("ImportFromDU_url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  catch(TimeoutException e) {
     Log.warn("Page-'"+ prop.getProperty("ImportFromDU_url") + "' didnot load within 20 seconds");
     e.printStackTrace();
   screenshotsUtil.saveFailureScreenshot();
   Assert.assertTrue(false, "Page-'"+ prop.getProperty("ImportFromDU_url") + "' didnot load within 20 seconds");
     }
    }

  public void Loan_DropDown() throws IOException {
   try {
     WebElement ele=driver.findElement(By.xpath("//*[@id=\"el0\"]"));
     Actions act = new Actions(driver);
     act.moveToElement(ele).clickAndHold().build().perform();
     act.sendKeys(Keys.TAB);
     act.sendKeys(Keys.ENTER).build().perform();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }catch(TimeoutException e ) {
     Log.warn("Page-Input New Loan didnot load within 20 seconds");
     e.printStackTrace();
   screenshotsUtil.saveFailureScreenshot();
   Assert.assertTrue(false, "Page-Input New Loan didnot load within 20 seconds");
      }
  }

  public void systemMessage() {
   try {
         driver.get(prop.getProperty("SystemMessage_url"));
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }
   catch(TimeoutException e) {
      Log.warn("Page-'"+ prop.getProperty("SystemMessage_url") + "' didnot load within 20 seconds");
      e.printStackTrace();
      }
     }
 public void CompanyMessageOption() {
  try {
   driver.get(prop.getProperty("CompanyMessage_url"));
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  } catch (TimeoutException e) {
   Log.warn("Page-'" + prop.getProperty("CompanyMessage_url") + "' didnot load within 20 seconds");
   e.printStackTrace();
  }
 }
  public void NavigateToHomepageFromCompanyMessagePage() {
  try {
   driver.get(prop.getProperty("Expected_Login_url"));
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  } catch (TimeoutException e) {
   Log.warn("Page-'" + prop.getProperty("Expected_Login_url") + "' didnot load within 20 seconds");
   e.printStackTrace();
  }
 }

   public void UserManagerFromSuperUser() {
  try {
   driver.get(prop.getProperty("Admin_UserManager_url"));
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  } catch (TimeoutException e) {
   Log.warn("Page-'" + prop.getProperty("Admin_UserManager_url") + "' didnot load within 20 seconds");
   e.printStackTrace();
  }
 }

}
