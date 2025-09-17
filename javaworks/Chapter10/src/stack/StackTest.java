package stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> stk = new Stack<>();
		
		//요소 추가
		stk.push(10);
		stk.push(20);
		stk.push(30);
		
		//맨 위 요소 보기
		//System.out.println(stk.peek());
		
		//직접 접근 조회
		//stk[1];
		
		//요소 꺼내기
		/*stk.pop();
		System.out.println(stk.peek());
		stk.pop();
		System.out.println(stk.peek());*/
		//stk.pop();  //예외 발생
		
		//안전한 삭제 및 출력
		while(!stk.isEmpty()) {
			System.out.println(stk.peek());
			stk.pop();
		}
	}
}

