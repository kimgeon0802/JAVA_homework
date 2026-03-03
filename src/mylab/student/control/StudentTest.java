package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudentId("A1100");
		student.setName("±è¹Î¼ö");
		student.setMajor("ÄÄÇ»ÅÍ°øÇĞ");
		try {
			student.setGrade(3);
			System.out.println(student.getName()+" / "+student.getMajor()+" / " +student.getGrade()+"ÇĞ³â");
		} catch(InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}
}
