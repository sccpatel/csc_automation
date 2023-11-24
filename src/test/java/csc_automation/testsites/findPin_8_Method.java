package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_8_Method extends BaseClass{


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_8, or.cscPassword_8);
		obj.rechargeCSC(or.loopNo_8, "CSC id- 8", or.endLoopNo_8);
	}
	
}
