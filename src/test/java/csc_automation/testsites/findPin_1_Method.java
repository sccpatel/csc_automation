package csc_automation.testsites;

import org.testng.annotations.Test;

import csc_automation.testscript.BaseClass;
import csc_automation.testscript.cscScript;

public class findPin_1_Method extends BaseClass {

	@Test
	public void check() {
		findPinMethodOR or=	new findPinMethodOR();
		cscScript obj=	new cscScript(util,test, extent);
		obj.openCSCIDAndLogin(or.CSCid_1, or.cscPassword_1);
		obj.rechargeCSC(or.loopNo_1, "CSC id- 1", or.endLoopNo_1);
		
	}



//public static void main(String[] args) {
//	
//	cscScript obj=	new cscScript();
//	obj.openCSCIDAndLogin("277634560012", "Shanti@531");
//	obj.rechargeCSC(283570, "CSC id- 1", 283575);
//	
//	
//}

}
