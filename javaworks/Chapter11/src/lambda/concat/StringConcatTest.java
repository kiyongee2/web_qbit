package lambda.concat;

public class StringConcatTest {
	public static void main(String[] args) {
		String str1 = "Hill";
		String str2 = "State";
		
		StringConcat concat;
		
		concat = (s1, s2) -> System.out.println(s1 + ", " + s2);
		concat.makeString(str1, str2);
	}
}
