package in.app.servicefactory;

import in.app.service.IStudentService;
import in.app.service.StudentServiceImpl;

//Abstraction logic of implementation
public class StudentServiceFactory {
	
	//make constructor private to avoid object creation
	private StudentServiceFactory() {
		
		
	}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {

		//singleton pattern code
		if (studentService ==null) {
			
			studentService = new StudentServiceImpl();
		}
		
		return studentService;		
		
	}

}
