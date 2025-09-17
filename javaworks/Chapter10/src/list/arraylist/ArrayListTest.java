package list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList 사용 - 부모 타입으로 생성
		//List - 인터페이스, ArrayList - 구현 클래스
		List<String> vegeList = new ArrayList<>();
		
		//요소 추가 - add()
		vegeList.add("양파");
		vegeList.add("마늘");
		vegeList.add("콩나물");
		
		System.out.println(vegeList);  //[양파, 마늘, 콩나물]
		
		//요소의 개수 - size()
		System.out.println("요소의 개수: " + vegeList.size());
		
		//특정 요소 검색 - get()
		System.out.println(vegeList.get(1)); //마늘
		System.out.println();
		
		//전체 출력
		for(int i = 0; i < vegeList.size(); i++) {
			String vegetable = vegeList.get(i);
			System.out.println(vegetable);
		}
		System.out.println("=========");
		
		//향상 for문
		for(String vegetable : vegeList)
			System.out.println(vegetable);
	}
}
