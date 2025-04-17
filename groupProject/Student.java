package groupProject;

public class Student {
	String name;
	int studentID;
	String degreePathway;
	String[] enrolledModules;
	int[] grades;
	
	//getters and setters
	public String getStudentName() {
		return name;
	}

	public void setStudentName() {
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getDegreePathway(String degreePathway) {
		return degreePathway;
	}

	public void setDegreePathway() {
		this.degreePathway = degreePathway;
	}

	public String[] getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(String[] enrolledModules) {
		this.enrolledModules = enrolledModules;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int grades) {
		this.grades = new int[]{grades};
	}
}
