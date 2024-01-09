package com.test.java.test;

import org.testng.annotations.Test;

import com.test.base.BaseTest;
import com.test.java.pages.LoginPage;
import com.test.properties.TestDataLoader;

public class LoginTest extends BaseTest {

	@Test
	public void loginWithValidUserNameAndValidPassword() {

		LoginPage loginPage = new LoginPage();

		loginPage.loginToApplication(TestDataLoader.getInstance().getUserName(),
				TestDataLoader.getInstance().getPassword());

	}

}
