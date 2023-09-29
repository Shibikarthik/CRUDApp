package in.inueron.daofactory;

import in.inueron.persistence.IStudentDao;
import in.inueron.persistence.StudentDaoImpl;

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
