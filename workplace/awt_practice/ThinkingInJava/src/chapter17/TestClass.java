package chapter17;
import java.util.*;

public class TestClass {

	static void test(String msg, List<String> list) {
		List<String> lst = list;
		list.addAll(list);
		for(String st: msg.split(" ")) {
//			lst.add(st);
		}
		
		Collection<String> c =list;
		Collection<String> subList = list.subList(1, 8);
		Collection<String> c2 = new ArrayList<String>(subList);
		try {
			c.retainAll(c2);
		}catch (Exception e) {
			System.out.println("c.retainAll: " + e);
		}
	}
	
	public static void  main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
		test("A B C D E F G H I J K L", new ArrayList<String>(list));
		}

}
