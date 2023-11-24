package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_9_Method extends BaseClass{


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_9, or.cscPassword_9);
		obj.rechargeCSC(or.loopNo_9, "CSC id- 9", or.endLoopNo_9);
	}
	
}
