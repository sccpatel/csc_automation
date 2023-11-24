package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_5_Method extends BaseClass{


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_5, or.cscPassword_5);
		obj.rechargeCSC(or.loopNo_5, "CSC id- 5", or.endLoopNo_5);
	}
	
}
