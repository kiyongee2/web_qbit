package score2;

import score.Subject;
public class Student {
	private int studentId;      //학번
	private String studentName; //이름
	private Subject[] subjects; //과목 
	private int subjectCount;   //현재 과목수
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		subjects = new Subject[10];
		this.subjectCount = 0;
	}
	
	//과목 추가
	public void addSubject(String name, int score) {
		Subject subject = new Subject(); //과목 객체 1개 생성
		subject.setSubjectName(name);
		subject.setScorePoint(score);
		
		//생성된 과목 객체를 배열에 저장
		subjects[subjectCount] = subject;
		subjectCount++;
	}
	
	//학생의 정보와 평균 계산
	public void displayInfo() {
		int total = 0;  //총점
		double avg;     //평균
		
		System.out.println(   //학생 정보 출력
			     "학번: " + studentId +
				 "\n이름: " + studentName);

		for(int i = 0; i < subjectCount; i++) {
			total += subjects[i].getScorePoint(); //점수 더하기
			
			System.out.println(   //과목 점수 출력
					 subjects[i].getSubjectName() + 
					 "점수: " + subjects[i].getScorePoint());
		}
		
		//평균 계산
		avg = (double)total / subjectCount;
		System.out.printf("평균 점수: %.1f점", avg);
		System.out.println("\n========================");
	}
}



