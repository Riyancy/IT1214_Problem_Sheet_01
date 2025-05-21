class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	Student(String name,int exam1,int exam2,int exam3){
		validateMarks(exam1);
		validateMarks(exam2);
		validateMarks(exam3);
		this.name=name;
		this.exam1=exam1;
		this.exam2=exam2;
		this.exam3=exam3;
	}
	
	void validateMarks(int score){
		if(score>0 && score<100){
			calculateAverage();
		}
		else{
			throw new IllegalArgumentException("Ivalid Marks");
				
		}
	}
	
	public String getName(){
		return name;
	}
	public int getExam1(){
		return exam1;
	}
	public int getExam2(){
		return exam2;
	}
	public int getExam3(){
		return exam3;
	}
	
	public double calculateAverage(){
		return (exam1+exam2+exam3)/3;
	}
	
}

class Main{
	public static void main(String[] args){
		try{
		Student st=new Student("John",75,110,90);
		System.out.println("Student name is "+st.getName());
		System.out.println("Average is "+st.calculateAverage());
		}catch(IllegalArgumentException e){
			System.out.println("Excepection "+e.getMessage());
		}
	}
}