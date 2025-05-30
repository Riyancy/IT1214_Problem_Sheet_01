import java.util.*;

class Student{
	private int studentId;
	private String name;
	private int daysAttended;
	
	Student(int studentId,String name,int daysAttended){
		this.studentId=studentId;
		this.name=name;
		this.daysAttended=daysAttended;
	}
	
	int getStudentId(){
		return studentId;
	}
	void setStudentId(int studentId){
		this.studentId=studentId;
	}
	
	String getName(){
		return name;
	}
	void setName(String name){
		this.name=name;
	}
	
	int getDaysAttended(){
		return daysAttended;
	}
	void setDaysAttended(int daysAttended){
		this.daysAttended=daysAttended;
	}
	

	
	class Classroom{
		Student[] students=new Student[10];
		int count=0;
		
		
		void addStudent(Student s){
			if(count<students.length){
				students[count++]=s;
			}else{
				System.out.println("Classroom is full.Can not add more students.");
			}
		}
		
		void updateAttendence(int studentId,int newDays){
			boolean found=false;
			for(int i=0; i<count; i++){
				if(students[i].getStudentId()==studentId){
					students[i].setDaysAttended(newDays);
					found=true;
					break;
				}
			}
			if{
					System.out.println("Student ID "+studentId+" not found");
			}
			
			}
			
		
		
		public void displayStudents(){
			for(int i=0; i<count; i++){
				System.out.println("StudentID id "+students[i].getStudentId());
				System.out.println("Student Name "+students[i].getName());
				System.out.println("Update DayAttended is "+students[i].getDaysAttended());
			}
		}
	}
}
	

class Main{
	public static void main(String[] args){
		Classroom cr=new Classroom();
		cr.addStudent(new Student(101,"Alice Smith",12));
		cr.addStudent(new Student(102,"Bob Jones",15));
		cr.addStudent(new Student(103,"Carol Lee",10));
		
		cr.updateAttendence(102,16);
		cr.updateAttendence(104,5);
		
		cr.displayStudents();
		
		
	}
}
