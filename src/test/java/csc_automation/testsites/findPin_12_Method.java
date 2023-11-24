package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_12_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_12, or.cscPassword_12);
		obj.rechargeCSC(or.loopNo_12, "CSC id- 12", or.endLoopNo_12);
	}
	
}
