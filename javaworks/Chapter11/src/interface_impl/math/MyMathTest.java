package interface_impl.math;

public class MyMathTest {

	public static void main(String[] args) {
		
		MyMathImpl math = new MyMathImpl();
		System.out.println("절대값: " + math.myAbs(-4));
	}

}
