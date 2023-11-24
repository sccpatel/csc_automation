package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_17_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test);
		obj.openCSCIDAndLogin(or.CSCid_17, or.cscPassword_17);
		obj.rechargeCSC(or.loopNo_17, "CSC id- 17", or.endLoopNo_17);
	}
	
}
