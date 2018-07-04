package com.vt;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/*
 * /*
 * @author Javid Akhter
 * javid.akhter@gmail.com
 */
 
public class VerificationHelper {

	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static synchronized boolean verifyElementPresent( WebElement element) {
		boolean isDispalyed = false;
		try {
			 isDispalyed= element.isDisplayed();
			 log.info(element.getText()+" is displayed");
		}
		catch(Exception ex) {
			log.error("Element not found " + ex);
		}
		
		return isDispalyed;
	}
	
	public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
		try {
			String actualText=element.getText();
			if(actualText.equals(expectedText)) {
				log.info("actualText is :"+actualText+" expected text is: "+expectedText);
				return true;
			}
			else {
				log.info("Text not Matching ---actualText is :"+actualText+" expected text is: "+expectedText);
				return false;
			}
		}
		catch(Exception ex) {
			log.error("Text not Matching ---actualText is :"+element.getText()+" expected text is: "+expectedText);
			log.info("text not matching" + ex);
			return false;
		}
	}
	
}