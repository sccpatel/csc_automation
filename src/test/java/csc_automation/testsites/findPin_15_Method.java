package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_15_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test);
		obj.openCSCIDAndLogin(or.CSCid_15, or.cscPassword_15);
		obj.rechargeCSC(or.loopNo_15, "CSC id- 15", or.endLoopNo_15);
	}
	
}
