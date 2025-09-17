package list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {

	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<>();
		
		//자료 추가
		myList.add("A");
		myList.add("B");
		myList.add("D");
		
		System.out.println(myList);
		
		//특정 위치에 자료 추가
		myList.add(2, "C");
		
		System.out.println(myList);
		
		//자료 삭제
		if(myList.contains("B")) {
			myList.remove("B");
		}
		
		System.out.println(myList);
		
		//전체 요소 출력
		for(String list : myList)
			System.out.println(list);

	}

}
