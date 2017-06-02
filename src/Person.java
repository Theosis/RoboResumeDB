import java.util.ArrayList;

public class Person {
	
	//Config parameters
	final int maxEdAch = 10;		//Educational Achievements
	final int maxWrkXp = 10;	//Work Experiences
	final int maxSkills = 20;		//
			
	String name;
	String email;
	ArrayList<String> edAch		= new ArrayList<String>(maxEdAch); 
	ArrayList<String> wrkXp 	= new ArrayList<String>(maxWrkXp);
	ArrayList<String> skills 			= new ArrayList<String>(maxSkills);
	ArrayList<String> skillLvl 	= new ArrayList<String>(maxSkills);
	
}