package testCases;

import org.testng.annotations.Test;

import base.baseClass;

public class LoginTest extends baseClass {
	@Test(invocationCount = 1, priority = 1)
	public void FirstLoginTest() throws Exception {
		ApplicationNavigation();
	}
	
}
