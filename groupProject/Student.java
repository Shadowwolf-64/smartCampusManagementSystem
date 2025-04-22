package groupProject;

import javax.swing.*;

public class Student {
	private JTextField name;
	private JTextField studentID;
	private JTextField degreePathway;
	private String[] enrolledModules;
	private JTextField grades;
	
	//getters and setters
	public JTextField getStudentName() {
		return name;
	}

	public void setStudentName(JTextField name) {
		this.name = name;
	}

	public JTextField getStudentID() {
		return studentID;
	}

	public void setStudentID(JTextField studentID) {
		this.studentID = studentID;
	}

	public JTextField getDegreePathway() {
		return degreePathway;
	}

	public void setDegreePathway(JTextField degreePathway) {
		this.degreePathway = degreePathway;
	}

	public String[] getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(String[] enrolledModules) {
		this.enrolledModules = enrolledModules;
	}

	public JTextField getGrades() {
		return grades;
	}

	public void setGrades(JTextField grades) {
		this.grades = grades;
	}

	public void setGrade(JTextField gradeInput) {
		this.grades = gradeInput;
	}
}
