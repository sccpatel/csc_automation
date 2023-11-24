package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_2_Method extends BaseClass{

	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_2, or.cscPassword_2);
		obj.rechargeCSC(or.loopNo_2, "CSC id- 2", or.endLoopNo_2);
	}
}
