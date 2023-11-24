package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_14_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test);
		obj.openCSCIDAndLogin(or.CSCid_14, or.cscPassword_14);
		obj.rechargeCSC(or.loopNo_14, "CSC id- 14", or.endLoopNo_14);
	}
	
}
