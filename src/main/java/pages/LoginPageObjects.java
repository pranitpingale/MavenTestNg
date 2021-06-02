package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects {

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
	  usrName.sendKeys(username);
	 }

	public void passWord(String password) throws IOException {
	  pwd.sendKeys(password);
	 }

	public void submit() throws IOException {
	  submit.click();
	 }


}
