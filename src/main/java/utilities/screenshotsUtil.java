package utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.baseClass;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class screenshotsUtil extends baseClass {

// static WebDriver driver;

 public static String getScreenshot(String screenshotName) throws Exception {

    String dateName = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

       TakesScreenshot ts = (TakesScreenshot)driver;

    File source = ts.getScreenshotAs(OutputType.FILE);

    String destination = System.getProperty("user.dir") + "\\test-output\\screenshots\\"+screenshotName+dateName+".png<file://\\test-output\\screenshots\\"+screenshotName+dateName+".png>";

    File finalDestination = new File(destination);

       FileUtils.copyFile(source, finalDestination);

    return destination;

 }



 public static void saveFailureScreenshot() throws IOException {


  File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

  Allure.addAttachment("FailureScreenshot", FileUtils.openInputStream(screenshotAs));

 }


}