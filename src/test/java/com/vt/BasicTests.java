package com.vt;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/*
 * @author Javid Akhter
 * javid.akhter@gmail.com
 * 
 */
public class BasicTests {

	private static Logger log = Logger.getLogger("devpinoyLogger");
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.valtech.com/");
		WebElement cookiesAlert = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept"));
		cookiesAlert.click();

	}

	//Question - 1
	@Test
	public void checkLatestNewsElementIsPresent() throws Exception {

		WebElement newsTitle = driver.findElement(By.xpath("//div/header/h2"));
		Assert.assertTrue(VerificationHelper.verifyElementPresent(newsTitle));
		Assert.assertTrue(VerificationHelper.verifyTextEquals(newsTitle, "LATEST NEWS"));
	}
	//Question - 2
	@Test
	public void checkAboutTabIsPresentAndDisplaysCorrectText() throws Exception {

		WebElement aboutTabLink = driver.findElement(By.xpath("//li/a/span"));
		Assert.assertTrue(VerificationHelper.verifyElementPresent(aboutTabLink));
		Assert.assertTrue(VerificationHelper.verifyTextEquals(aboutTabLink, "ABOUT"));
	}

	@Test
	public void checkServicesTabIsPresentAndDisplaysCorrectText() throws Exception {

		WebElement servicesTabLink = driver.findElement(By.xpath("//li[3]/a/span"));
		Assert.assertTrue(VerificationHelper.verifyElementPresent(servicesTabLink));
		Assert.assertTrue(VerificationHelper.verifyTextEquals(servicesTabLink, "SERVICES"));
	}

	@Test
	public void checkWorkTabIsPresentAndDisplaysCorrectText() throws Exception {

		WebElement workTabLink = driver.findElement(By.xpath("//li[2]/a/span"));
		Assert.assertTrue(VerificationHelper.verifyElementPresent(workTabLink));
		Assert.assertTrue(VerificationHelper.verifyTextEquals(workTabLink, "WORK"));
	}

	//Question - 3
	@Test
	public void checkOfficeNamessAreDisplayedInContactUsArea() throws Exception {

		String officeNames = driver.findElement(By.cssSelector("p.foot__offices")).getText();
		String [] arrOfStr =  officeNames.split(":", -1);

		for (String a : arrOfStr)
			log.info(a);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Exception {
		if (driver != null)
			driver.quit();
	}

}
