package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_18_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test);
		obj.openCSCIDAndLogin(or.CSCid_18, or.cscPassword_18);
		obj.rechargeCSC(or.loopNo_18, "CSC id- 18", or.endLoopNo_18);
	}
	
}
