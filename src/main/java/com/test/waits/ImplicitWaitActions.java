package com.test.waits;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.constants.Constants;
import com.test.driver.DriverFactory;

public class ImplicitWaitActions {

	private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);

	public void setImplicitWait() {

		try {
			DriverFactory.getDriverFactoryInstance().getDriver().manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
			logger.info("Implicit wait time is set to "+Constants.IMPLICIT_WAIT_TIME);
		}
		catch (Exception e) {
			logger.error("Error occured while setting the implicit wait "+e.getMessage());
		}
	}

}
