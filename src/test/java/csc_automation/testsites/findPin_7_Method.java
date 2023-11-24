package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_7_Method extends BaseClass{


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_7, or.cscPassword_7);
		obj.rechargeCSC(or.loopNo_7, "CSC id- 7", or.endLoopNo_7);
	}
	
}
