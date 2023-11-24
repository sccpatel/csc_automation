package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_13_Method  extends BaseClass{


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test);
		obj.openCSCIDAndLogin(or.CSCid_13, or.cscPassword_13);
		obj.rechargeCSC(or.loopNo_13, "CSC id- 13", or.endLoopNo_13);
	}
	
}
