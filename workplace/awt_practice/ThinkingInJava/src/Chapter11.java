import java.util.*;
public class Chapter11 {

//	public Chapter11() {
//		// TODO Auto-generated constructor stub
//	}
	
	static <T> void test(Iterable<T> ib) {
		for (T t: ib) {
			System.out.print(t + " ");
		}
	}
	
	public static void main(String args[]) {
//		for (Map.Entry entry: System.getenv().entrySet()) {
//			System.out.println(entry.getKey() + " : " + entry.getValue());
//		}
		
		test(Arrays.asList(1, 2, 3));
		String[] strings = {"A", "B", "C"};
		test(Arrays.asList(strings));
	}

}
