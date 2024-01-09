package com.test.base;

import org.openqa.selenium.WebElement;

import com.test.alert.AlertActions;
import com.test.constants.ExtentFactory;
import com.test.iframe.IframeActions;
import com.test.javascript.JavaScriptActions;
import com.test.waits.ExplicitWaitActions;

public class BasePage {
	
	protected AlertActions alertActions;	
	protected IframeActions iframeActions;	
	protected JavaScriptActions javaScriptActions;	
	protected ExplicitWaitActions explicitWaitActions;	
	
	protected BasePage() {
		alertActions = new AlertActions();
		iframeActions = new IframeActions();
		javaScriptActions = new JavaScriptActions();
		explicitWaitActions = new ExplicitWaitActions();
	}
	
	public void click(WebElement element, String elementName) {		
		explicitWaitActions.waitForElementToBeClickable(element, elementName);		
		element.click();
		ExtentFactory.getInstance().passTest(elementName+" is clicked.");		
	}
	
	
	public void sendKeys(WebElement element, String elementName, String value) {
		explicitWaitActions.waitForElementToBePresent(element, elementName);		
		element.clear();		
		element.sendKeys(value);		
		ExtentFactory.getInstance().passTest(value+ " is entered in "+elementName);
	}	
	
	public boolean isElementSelected(WebElement element, String elementName) {		
		explicitWaitActions.waitForElementToBePresent(element, elementName);
		return	element.isSelected();		
	}	
	
	public void selectCheckBox(WebElement element, String elementName) {		
		if(this.isElementSelected(element, elementName) == false) {
			this.click(element, elementName);
		} else {
			ExtentFactory.getInstance().failTest(elementName+ " is already selected");
		}		
	}
	
	
	
	
	
	
	

}
