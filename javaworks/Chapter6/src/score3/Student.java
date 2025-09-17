package score3;

import java.util.ArrayList;

import score.Subject;

public class Student {
	private int studentId;      //학번
	private String studentName; //이름
	private ArrayList<Subject> subjects; //과목
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		subjects = new ArrayList<>();
	}
	
	//과목 추가
	public void addSubject(String name, int score) {
		Subject subject = new Subject(); //과목 객체 1개 생성
		subject.setSubjectName(name);
		subject.setScorePoint(score);
		
		//생성된 과목 객체를 리스트에 저장
		subjects.add(subject);
	}
	
	//학생의 정보와 평균 계산
	public void displayInfo() {
		int total = 0;  //총점
		double avg;     //평균
		
		System.out.println(   //학생 정보 출력
			     "학번: " + studentId +
				 "\n이름: " + studentName);
		
		for(int i = 0; i < subjects.size(); i++) {
			Subject subject = subjects.get(i);
			total += subject.getScorePoint();
			
			System.out.println(subject.getSubjectName() + 
					"점수: " + subject.getScorePoint());
		}
		
		//평균 계산
		avg = (double)total / subjects.size();
		System.out.printf("평균 점수: %.1f점", avg);
		System.out.println("\n========================");
	}
}

