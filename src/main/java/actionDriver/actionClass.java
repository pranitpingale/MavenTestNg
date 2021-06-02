package actionDriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.baseClass;
import utilities.Log;

public class actionClass extends baseClass {


 /*
  *Function-Type Text
  *Author- Priyanka
 ***/
 public boolean type(WebElement ele, String text, String log) {
  boolean flag = false;
  try {
  flag = ele.isDisplayed();
  ele.clear();
  ele.sendKeys(text);
  flag = true;
  } catch (Exception e) {
   Log.info(log +" Location not found");
  flag = false;
  } finally {
  if (flag) {
   Log.info(log +" Is Entered Successfully..");
  } else {
   Log.info("Unable To Enter " + log);
  }

  }
  return flag;
  }

 /*
  *Function-Click
  *Author- Priyanka
 ***/
 public boolean click(WebElement ele, String log) {
   boolean flag = false;
   try {
   ele.click();
   flag = true;
   return true;
   } catch (Exception e) {
   return false;
   } finally {
   if (flag) {
    Log.info("Able to click on '"+ log +"'");
   } else {
    Log.info("Click Unable to click on '"+ log +"'");
   }
   }
       }


 /*
  *Function-ScrollByVisibilityOfElement
  *Author- Priyanka
 ***/
 public void scrollByVisibilityOfElement(WebElement ele) {
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].scrollIntoView();", ele);
 }


 /*
  *Function-FindElement
  *Author- Priyanka
 ***/
 public boolean findElement(WebElement ele, String log) {
   boolean flag = false;
   try {
   ele.isDisplayed();
   flag = true;
   } catch (Exception e) {
   flag = false;
   } finally {
   if (flag) {
    Log.info("Successfully Found '" + log + "' element");

   } else {
    Log.info("Unable to locate '" + log + "' element");
   }
   }
   return flag;

 }



 /*
  *Function-IsDisplayed
  *Author- Priyanka
 ***/
 public boolean isDisplayed(WebElement ele, String log) {
   boolean flag = false;
   flag = ele.isDisplayed();
   if (flag) {
    Log.info("The webelement '" + log + "' is Displayed");
   } else {
    Log.info("The webelement '" + log + "'  is not Displayed");
   }
   return flag;
 }



 /*
  *Function-IsSelected
  *Author- Priyanka
 ***/
 public boolean isSelected(WebElement ele, String log) {
   boolean flag = false;
   flag = ele.isSelected();
   if (flag) {
    Log.info("The webelement '" + log + "' is Selected");
   } else {
    Log.info("The webelement '" + log + "' is not Selected");
   }
   return flag;
   }


 /*
  *Function-Is Enabled
  *Author- Priyanka
 ***/
 public boolean isEnabled(WebElement ele,String log) {
   boolean flag = false;
   flag = ele.isEnabled();
   if (flag) {
    Log.info("The webelement '" + log + "' is Enabled");
   } else {
    Log.info("The webelement '" + log + "' is not Enabled");
   }
   return flag;
   }


 /*
  *Function-SelectByIndex
  *Author- Priyanka
 ***/
 public boolean selectByIndex(WebElement element, int index,String log) {
   boolean flag = false;
   try {
   Select s = new Select(element);
   s.selectByIndex(index);
   flag = true;
   return true;
   } catch (Exception e) {
   return false;
   } finally {
   if (flag) {
    Log.info(log + " Option selected by Index");
   } else {
    Log.info(log + " Option not selected by Index");
   }
   }
   }


 /*
  *Function-moveToElement
  *Author- Priyanka
 ***/
 public void moveToElement(WebElement ele,String log) {

   Actions act = new Actions(driver);
   act.moveToElement(ele).clickAndHold().build().perform();
   Log.info(log + " Is Clicked");
   }


 /*
  *Function-slider
  *Author- Priyanka
 ***/

 public boolean slider(WebElement ele, int x, int y) {
   boolean flag = false;
   try {
   new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
   Thread.sleep(5000);
   flag = true;
   return true;
   } catch (Exception e) {

   return false;
   } finally {
   if (flag) {
    Log.info("Slider Action is performed");
   } else {
    Log.info("Slider Action is not performed");
   }
   }
   }



 /*
  *Function-RadioButton
  *Author- Priyanka
 ***/
 public boolean RadioButton(WebElement ele, String log) {
   boolean flag = false;
   try {
   ele.click();
   flag = true;
   return true;
   } catch (Exception e) {
   return false;
   } finally {
   if (flag) {
    Log.info("Able to select RadioButton '"+ log +"'");
   } else {
    Log.info("Click Unable to select RadioButton '"+ log +"'");
   }
   }

   }




 /*
  * Function-Decoding String
  * Author- Priyanka
  */

  public String decodeString(String value) {
  byte[] decodedString = Base64.decodeBase64(value);
  return(new String(decodedString));
  }




 /*
  * Function-Encoding
  * Author- Priyanka
  */

  public String encodeString(String value) {
  byte[] encodededString = Base64.encodeBase64(value.getBytes());
  return(new String(encodededString));
  }

}