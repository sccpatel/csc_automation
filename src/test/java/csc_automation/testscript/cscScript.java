package csc_automation.testscript;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import csc_automation.webUtil.WebUtil;

public class cscScript {

	String cscID = "";

	private WebUtil util;
	private ExtentTest test;
	private ExtentReports extent;
	public cscScript(WebUtil util, ExtentTest test, ExtentReports extent) {
		this.util = util;
		this.test = test;
		this.extent = extent;
	}


	public void openCSCIDAndLogin(String cscIDName, String cscPassword) {
		cscID = cscIDName;
//		util.launchBrowser();
//		util.openUrl("https://digitalseva.csc.gov.in/");
		util.click("//strong[text()=' Login']", "Login Button");
		util.mySendKeys("//input[@placeholder='Username or Email']", "User Name", cscID);
		util.mySendKeys("//input[@placeholder='Password']", "Password", cscPassword);
	}

	public void rechargeCSC(int loopStartingSize, String cscNumber, int loopSize) {
		List<Integer> pinList = new ArrayList<Integer>();
		List<Integer> lowBalance = new ArrayList<Integer>();
		List<Integer> anyError = new ArrayList<Integer>();
		int[] arrPin = ageArr();
		try {
//			util.webWait("(//button[text()='Close'])[2]", 900);
//			util.click("(//button[text()='Close'])[2]", "Clic Telecom");
			util.webWait("//a[@title='TELECOM']/..", 900);
			util.click("//a[@title='TELECOM']/..", "Clic Telecom");
			util.webWait("//*[@id='1005']");
			util.click("//*[@id='1005']", "Clic Mobile Priped");
		} catch (Exception e) {
			System.out.println("Click on Mobile Priped ");
		}

		try {
			util.webWait("//h4[text()='BSNL']//..", 300);
			util.click("//h4[text()='BSNL']//..", "BSNL");

			util.webWait("//input[@name='mobile']", 60);
			util.mySendKeys("//input[@name='mobile']", "mobile", "9450362909");
			util.webWait("//*[contains(text(),'TOPUP')]/..");
			util.click("//*[contains(text(),'TOPUP')]/..", "Clic On TopUP ");
			util.myThread(500);
			util.webWait("//div[@id='category_topup']//button");
			util.click("//div[@id='category_topup']//button", "Select");
		} catch (Exception e) {
			System.out.println("Mobile No Not Select");
		}
		int loopNum = loopStartingSize;
		for (int i = loopNum; i <= loopSize; i++) {
//			int num = arrPin[i];
			int num = i;
			String strI = String.valueOf(num);
			if (strI.length() == 6 && strI.charAt(0) == strI.charAt(1)) {
				continue;
			}
			try {
				util.webWait("//input[@type='password']");
				util.mySendKeys("//input[@type='password']", "Pin", num);
				util.myThread(100);
				util.webWait("//button[contains(text(),'Pay')]");
				util.click("//button[contains(text(),'Pay')]", "Recharge");
				util.webWait("//p[@class='alert alert-danger panel-mn-show']", 60);
				String innerValue = util
						.myInnerText("//p[@class='alert alert-danger panel-mn-show']", cscNumber, num, test)
						.toUpperCase();
//				test.log(Status.PASS, num+" "+innerValue);
				if (innerValue.contains("Insufficient Wallet Balance".toUpperCase())) {
					lowBalance.add(num);
					test.log(Status.FAIL,
							"Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + lowBalance);
					System.err.println("Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + lowBalance);
				} else if (innerValue.contains("Incorrect Wallet PIN".toUpperCase())) {

				} else {
					anyError.add(num);
					test.log(Status.FAIL, "Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + anyError);
					System.err.println("Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + anyError);
				}

			} catch (Exception e) {
				pinList.add(num);
				test.log(Status.FAIL, "Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + pinList);
				System.err.println("Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + pinList);
				if (lowBalance.size() > 0) {
					test.log(Status.FAIL, "Insufficient Wallet Balance:   " + lowBalance);
					System.err.println("Insufficient Wallet Balance:   " + lowBalance);
				}
			}
			extent.flush();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		test.log(Status.INFO, "Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + pinList);
		System.err.println("Your CSC ID " + cscID + " " + cscNumber + "  and  Pin is:- \n  " + pinList);
		test.log(Status.FAIL, "Other Type Error   " + anyError);
		System.err.println("Other Type Error   " + anyError);
		test.log(Status.INFO, "Insufficient Wallet Balance:   " + lowBalance);
		System.err.println("Insufficient Wallet Balance:   " + lowBalance);
		test.log(Status.FAIL, loopStartingSize + " Loop Starting SIze>>>>>>>>>>  END  <<<<< LoopLastSize " + loopSize);
		System.out.println(loopStartingSize	+ " Loop Starting SIze>>>>>>>>>>>>>>>>  END  <<<<<<<<<<<<<< LoopLastSize " + loopSize);
		getCSCBalance();
	}

	public void getCSCBalance() {
		util.webWait("//i[text()='menu']/..");
		util.click("//i[text()='menu']/..", "Menu");

		util.webWait("//span[text()='WALLET']//parent::a/..");
		util.click("//span[text()='WALLET']//parent::a/..", "Wallet");
		util.myThread(1000);
		util.webWait("//a[contains(text(),'')]SUMMARY/..");
		util.click("//a[contains(text(),'SUMMARY')]/..", "Show Balance");
		util.myThread(5000);
		util.webWait("//h2[@id='owner-balance']/parent::div");
		util.myInnerText("//h2[@id='owner-balance']/parent::div", cscID, 0, test);
	}

	public int[] ageArr() {
		int[] pinNumber = { 19, 19, 19, 18, 19, 19 };
		return pinNumber;
	}

}
