package queue;

import java.util.Queue;
import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
    	//은행 대기줄 구현
        Queue<String> queue = new LinkedList<>();

        queue.offer("고객A");
        queue.offer("고객B");
        queue.offer("고객C");

        //System.out.println(queue.peek()); //고객A
        //queue.poll(); //요소 삭제
        
        //System.out.println(queue.peek()); //고객B
        
        while(!queue.isEmpty()) {
        	System.out.println(queue.peek() + "님 업무 처리중...");
        	queue.poll();
        }
        System.out.println("모든 고객의 업무가 완료되었습니다.");   
     }
}

