package in.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.app.dto.Student;
import in.app.service.IStudentService;
import in.app.servicefactory.StudentServiceFactory;

//controller layer
public  class TestApp {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
		System.out.println("1. CREATE");
		System.out.println("2. READ");
		System.out.println("3. UPDATE");
		System.out.println("4. DELETE");
		System.out.println("5. EXIT");
		
		System.out.println("ENTER YOUR CHOICE , PRESS[1/2/3/4/5] :: ");
		
		String option = br.readLine();
		
		switch (option) {
	
		case "1":
			
			insertOperation();
			
			break;
		
		case "2":
			
			selectOperation();
			
			break;
			
		case "3":
			
			updateRecord();
			
			break;

		case "4":
			
			deleteRecord();
			
			break;

		case "5":
			System.out.println("**************Thanks for using the application************");
			System.exit(0);
			
			break;

		default:
			System.out.println("Invalid option please try again  with valid optionsss......");
			break;
		}
		
		}
		
	}


	private static void updateRecord() throws IOException{
		
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));			
			System.out.print("Enter the Student ID to be updated :: ");
		
		 	String sid = br.readLine();
		 

			IStudentService studentService = StudentServiceFactory.getStudentService();
			
			Student student	=  studentService.searchStudent(Integer.parseInt(sid));
			
			if(student !=null) {
			
				Student newStudent = new Student();
				
			System.out.println("Student id is :: "+student.getSid());
			
			newStudent.setSid(student.getSid());
			
			System.out.print("Student oldName is :: "+student.getSname()+" Enter the newName :: ");
			String newName = br.readLine();
			
			if(newName.equals(" ")|| newName == "") {
				
				newStudent.setSname(student.getSname());
				
			}else {
				
				newStudent.setSname(newName);
				
			}
			
			System.out.print("Student oldAge is :: "+student.getSage()+" Enter the newAge :: ");
			String newAge = br.readLine();
			
           if(newAge.equals(" ")|| newAge == "") {
				
				newStudent.setSage(student.getSage());
				
			}else {
				
				newStudent.setSage(Integer.parseInt(newAge));
				
			}


			System.out.print("Student oldAddress is :: "+student.getSaddress()+" Enter the newAddress :: ");
			String newAddress = br.readLine();
			

			if(newAddress.equals(" ")|| newAddress == "") {
				
				newStudent.setSaddress(student.getSaddress());
				
			}else {
				
				newStudent.setSaddress(newAddress);
				
			}
			System.out.println("new Student data : "+newStudent);
			
			System.out.println();
			
			String status = studentService.updateStudent(newStudent);
			
			if (status.equalsIgnoreCase("success")) {
				
				System.out.println("Record UPDATED successfully....");
				
			}else {
				
				System.out.println("RECORD UPDATION FAILED...");
			
			}
			
			}else {
				
				System.out.println("Student record not available for the id ::"+sid+" for updation...");
			}
			
			
	}


	private static void deleteRecord() {
		
		@SuppressWarnings("resource")
		Scanner scanner  =  new Scanner(System.in);
		System.out.print("Enter the Student ID :: ");
		int sid = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		String msg	=  studentService.deleteStudent(sid);
		
		if (msg.equalsIgnoreCase("success")) {
			
			System.out.println("Record inserted successfully....");
			
		}else if(msg.equalsIgnoreCase("RECORD NOT FOUND")) {
			
			System.out.println("Record not available for the given id");
		
		}else {
			
			System.out.println("Record Deletion failed...");
		}
		


	}


	private static void selectOperation() {
		
		@SuppressWarnings("resource")
		Scanner scanner  =  new Scanner(System.in);
		
		System.out.print("Enter the Student ID :: ");
		int sid = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Student std = studentService.searchStudent(sid);
		
		if(std!=null) {
			
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
			
			
		}else {
			
			System.out.println("Record Not Found For The Given ID :(");
			
		}
		
		
	}


private static void insertOperation() {		
		
	IStudentService studentService   = 	StudentServiceFactory.getStudentService();
	
		@SuppressWarnings("resource")
		Scanner scanner  =  new Scanner(System.in);
	
		System.out.print("Enter the Student name :: ");
		String sname = scanner.next();
		
		System.out.print("Enter the Student Age :: ");
		int sage = scanner.nextInt();
		
		System.out.print("Enter the Student Addess :: ");
		String saddress = scanner.next();
		
		String msg	=  studentService.addStudent(sname, sage, saddress);
				
		if (msg.equalsIgnoreCase("success")) {
			
			System.out.println("Record inserted successfully....");
			
		}else {
			
			System.out.println("Record insertion failed...");
		}
		

}
}
