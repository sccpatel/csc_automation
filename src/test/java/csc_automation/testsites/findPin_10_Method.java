package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_10_Method extends BaseClass {


	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test,extent);		
		obj.openCSCIDAndLogin(or.CSCid_10, or.cscPassword_10);
		obj.rechargeCSC(or.loopNo_10, "CSC id- 10", or.endLoopNo_10);
	}
	
}
