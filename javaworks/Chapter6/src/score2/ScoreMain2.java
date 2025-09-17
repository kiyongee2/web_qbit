package score2;

import score3.Student;

public class ScoreMain2 {

	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		
		//학생 인스턴스 생성
		Student st1 = new Student(1001, "이정후");
		Student st2 = new Student(1002, "신유빈");
		Student st3 = new Student(1003, "우상혁");
		
		//배열에 저장
		students[0] = st1;
		students[1] = st2;
		students[2] = st3;
		
		//과목 입력
		st1.addSubject("국어", 90);
		st1.addSubject("수학", 85);
		st2.addSubject("국어", 70);
		st2.addSubject("수학", 80);
		st3.addSubject("국어", 90);
		st3.addSubject("수학", 100);
		
		for(Student student : students)
			student.displayInfo();
		
		/*for(int i = 0; i < students.length; i++) {
			students[i].displayInfo();
		}*/
		
		
	}
}
