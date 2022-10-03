package test;
import java.util.Scanner;
public class Read {
	public void read(Scanner sc, Student st) {
		System.out.println("Enter Student Name:");
		st.name = sc.nextLine();
		System.out.println("Enter Branch");
		st.branch = sc.nextLine().toUpperCase();
		boolean branchStatus = st.cb.verifyBranch(st.branch);
		
		if(branchStatus) {
			System.out.println("Enter Student Roll No:");
			st.rollNo = sc.nextLine();
			if(st.rollNo.length() == 10) {
				//Address
				System.out.println("Enter House No:");
				st.ad.hNo = sc.nextLine();
				System.out.println("Enter Street Name:");
				st.ad.sName = sc.nextLine();
				System.out.println("Enter City Name:");
				st.ad.city = sc.nextLine();
				System.out.println("Enter Pin Code:");
				st.ad.pinCode = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Student Mail Id:");
				st.mailId = sc.nextLine();
				System.out.println("Enter Student Phone No:");
				st.phNo = Long.parseLong(sc.nextLine());
				
				//Enter Subject Marks
				System.out.println("Enter 6 Subject Marks:");
				int i = 1, p = 0;
				st.sr.totalMarks = 0;
				while(i<7) {
					System.out.println("Enter marks for Subject"+i+":");
					int marks = sc.nextInt();
					i++;
					if(marks<0 || marks>100) {
						System.out.println("Entered Invalid Marks...");
						i--;
						continue;//skip below lines from execution
					}
					if(marks>0 && marks<34) {
						p =1;
					}
					st.sr.totalMarks = st.sr.totalMarks+marks;
				}// end of while loop
				st.sr.calculate(st.sr.totalMarks, p);
			} // End of if 
			else {
				System.out.println("Invalid Roll No");
				System.exit(0);
			}
		}  // End of if
		else {
			System.out.println("Invalid Branch...");
			System.exit(0);
		}
	}
}
