package test;

public class CheckBranch {
	public boolean k = false;
	public boolean verifyBranch(String branch) {
		switch(branch) {
		case "ECE": k = true;
			break;
		case "EEE": k = true;
			break;
		case "CSE": k = true;
			break;
		}//end of Switch
		return k;
	}
	
}
