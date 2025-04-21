package groupProject;

import javax.swing.*;

public class Student {
	JTextField name;
	int studentID;
	JTextField degreePathway;
	String[] enrolledModules;
	JTextField grade;
	
	//getters and setters
	public JTextField getStudentName() {
		return name;
	}

	public void setStudentName(JTextField studentName) {
		this.name = studentName;
    }

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public JTextField getDegreePathway() {
		return degreePathway;
	}

	public void setDegreePathway(JTextField degreePath) {
		this.degreePathway = degreePath;
    }

	public String[] getEnrolledModules() {
		return enrolledModules;
	}

	public void setEnrolledModules(String[] enrolledModules) {
		this.enrolledModules = enrolledModules;
	}

	public JTextField getGrade() {
		return grade;
	}

	public void setGrade(JTextField grade) {
		this.grade = grade;
	}
}
