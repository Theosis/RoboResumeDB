import java.util.Scanner;

public class RoboResume {
	
		public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		//fVariables are for form-filling:
		String fName, fEmail, fEdAch, fEdAchOrg, fEdAchYr, fWrkXp, fSkill, fSkillLvl;
		boolean done;
		int numItems;
		Person fPerson;

		println("RESUME ENTRY FORM\n");
		
		fPerson = new Person();
		
		do {
			print("Name? ");
			fName = kb.nextLine();
			fPerson.name = fName;
		} while (fName.equals(""));	//No null entries allowed.
		
		do {//TODO: validate as email using one of the candidates in Class Email.
			print("Email? ");
			fEmail = kb.nextLine();
			fPerson.email = fEmail;
		} while (fEmail.equals(""));		//No null entries allowed.
		
		println("\nEnter one to ten educational achievements (\"DONE\" to exit this section)");
		done = false;
		numItems = 0;
		do {
			do {
				print("Educational Achievement #"+ (numItems+1) +" (or done): ");
				fEdAch = kb.nextLine();
			} while (fEdAch.equals(""));	//No null entries allowed.
			done = fEdAch.toUpperCase().equals("DONE");
			if (!done) {
				do {  //skip entering Educ. Achiev. Org. and Year if Educ. Achiev. is "DONE"
					print("Organization of Educational Achievement #"+ (numItems+1) +": ");
					fEdAchOrg = kb.nextLine();
				} while (fEdAchOrg.equals(""));	//No null entries allowed.
				do {  //TODO: use integer for year, validate as year.					
					print("Year of Educational Achievement #"+ (numItems+1) +": ");
					fEdAchYr = kb.nextLine();
				} while (fEdAchYr.equals(""));	//No null entries allowed.
				fPerson.edAch.add(fEdAch + ", \n" + fEdAchOrg + ", " + fEdAchYr);
			}
			numItems = fPerson.edAch.size();
		} while ( !(  (done && (numItems >= 1)) || (numItems > 9)  ) );
		
		println("\nEnter up to ten work experiences (\"DONE\" to exit this section)");
		done = false;
		numItems = 0;
		do {
			do {
				print("Work Experience #"+ (numItems+1) +" (or done): ");
				fWrkXp = kb.nextLine();
			} while (fWrkXp.equals(""));	//No null entries allowed.
			done = fWrkXp.toUpperCase().equals("DONE");
			if (!done) {fPerson.wrkXp.add(fWrkXp);}
			numItems = fPerson.wrkXp.size();
		} while ( !(done  || (numItems > 9)) );
		
		println("\nEnter one to twenty skills (\"DONE\" to exit this section)");
		done = false;
		numItems = 0;
		do {
			do {
				print("Skill #"+ (numItems+1) +" (or done): ");
				fSkill = kb.nextLine();
			} while (fSkill.equals(""));	//No null entries allowed.
			done = fSkill.toUpperCase().equals("DONE");
			if (!done) {		
				do {  //skip entering Skill Level if Skill is "DONE"
					print("Level of Skill #"+ (numItems+1) +": ");
					fSkillLvl = kb.nextLine();
				} while (fSkillLvl.equals(""));	//No null entries allowed.
				fPerson.skills.add(fSkill + ", " +fSkillLvl);
			}
			numItems = fPerson.skills.size();
		} while ( !(  (done && (numItems >= 1)) || (numItems > 19)  ) );
		
		
		println("\n=============================================================");
		println(fPerson.name);
		println(fPerson.email);
		
		println("\nEducation");
		for (String item : fPerson.edAch) {
			println(item);
			println(" ");
		}
		println("Experience");
		for (String item : fPerson.wrkXp) {
			println(item);
			println(" ");
		}
		println("\nSkills");
		for (String item : fPerson.skills) {
			println(item);
		}		
		kb.close();
		}

	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void print(String msg) {
		System.out.println(msg);
	}
}
