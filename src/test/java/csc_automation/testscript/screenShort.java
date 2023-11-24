package csc_automation.testscript;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import csc_automation.webUtil.WebUtil;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class screenShort {
	WebDriver driver = null;

	public static void main(String[] args) {
		new screenShort().captchaCode();

	}

	public void captchaCode() {
		WebUtil util = new WebUtil();
		driver = util.driver;
		util.launchBrowser();
		util.openUrl("https://digitalseva.csc.gov.in/");
		util.click("//strong[text()=' Login']", "Login Button");
		util.mySendKeys("//input[@placeholder='Username or Email']", "User Name", "6876868678");
		util.mySendKeys("//input[@placeholder='Password']", "Password", "Raj@1234");

		WebElement findCap = util.myFindElement("//div[@id='captchaimgs']/img", "Captcha Code");
		File screenshot = findCap.getScreenshotAs(OutputType.FILE);
		File destines = new File("Screenshort\\fileName.png");

//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			// Save the screenshot to a file
			FileHandler.copy(screenshot, destines );

			// Perform OCR using Tesseract
			ITesseract tesseract = new Tesseract();
			tesseract.setDatapath("D:\\Frame Work OF Automation\\csc_automation\\datafile");
			String captchaText = null;
			try {
				captchaText = tesseract.doOCR(destines);
				
			} catch (TesseractException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.mySendKeys("//input[@placeholder='Enter Captcha Text']", captchaText, captchaText);
			// Extract the recognized text and use it as needed
			System.out.println("CAPTCHA Text: " + captchaText);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.close();

	}

}
