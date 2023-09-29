package in.inueron.service;

import in.inueron.daofactory.StudentDaoFactory;
import in.inueron.dto.Student;
import in.inueron.persistence.IStudentDao;

//SERVICE LAYER
public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		stdDao = StudentDaoFactory.getIStudentDao();
		
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		
		stdDao = StudentDaoFactory.getIStudentDao();
		
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {

		stdDao = StudentDaoFactory.getIStudentDao();
		
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {

		stdDao = StudentDaoFactory.getIStudentDao();
		
		return stdDao.deleteStudent(sid);
		
	}

}
