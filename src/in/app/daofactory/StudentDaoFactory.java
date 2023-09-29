package in.app.daofactory;

import in.app.persistence.IStudentDao;
import in.app.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {
		
		
	}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getIStudentDao() {
		
		if(studentDao == null) {
			
			studentDao = new StudentDaoImpl();			
		}
		
		return studentDao;
		
	}
	
}
