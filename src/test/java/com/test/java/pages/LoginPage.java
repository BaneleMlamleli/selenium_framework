package com.test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.*;
import com.test.driver.*;

public class LoginPage extends BasePage{
	
	
	@FindBy(name = "username")
	private WebElement userNameTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTExtBox;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement loginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriverFactoryInstance().getDriver(), this);
	}

	public void loginToApplication(String userNameValue, String passwordValue) {
		super.sendKeys(userNameTextBox, "user name text box", userNameValue);
		super.sendKeys(passwordTExtBox, "Password text box", passwordValue);
		super.click(loginBtn, "Login btn");
	}
}
