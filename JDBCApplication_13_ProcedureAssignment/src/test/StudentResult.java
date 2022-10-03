package test;

public class StudentResult {
	public int totalMarks;
	public float per;
	public String result;
	
	public void calculate(int totMarks, int p) {
		totalMarks = totMarks;
		per = (float) totalMarks/6;
		
		if (p == 1) {
			result = "Fail";
		} else if (per >= 70 && per <= 100) {
			result = "Distinction";
		} else if (per >= 60 && per < 70) {
			result = "First Class";
		} else if (per >= 50 && per < 60) {
			result = "Second Class";
		} else if (per >= 35 && per < 50) {
			result = "Second Class";
		} else {
			result = "Fail";
		}
	}
}
