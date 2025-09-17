package score3;

import java.util.ArrayList;

public class ScoreMain {
	public static void main(String[] args) {
		
		ArrayList<Student> students = new ArrayList<>();
		
		//학생 인스턴스 추가
		Student st1 = new Student(1001, "이정후");
		Student st2 = new Student(1002, "신유빈");
		Student st3 = new Student(1003, "우상혁");
		
		students.add(st1);
		students.add(st2);
		students.add(st3);
		
		//과목 입력
		st1.addSubject("국어", 90);
		st1.addSubject("수학", 85);
		st2.addSubject("국어", 70);
		st2.addSubject("수학", 80);
		st3.addSubject("국어", 90);
		st3.addSubject("수학", 100);
		
		//학생 출력
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			student.displayInfo();
		}
	}
}
