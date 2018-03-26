package chapter17;
import java.util.*;

import chapter15.Generator;

class Government implements Generator<String> {

	String[] foundation = ("strange women lying in ponds distributing swords in no basis for a system of government").split(" ");
	private int index;
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundation[index++];
	}
	
}

public class CollectionDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));
		System.out.println(set);
		set.addAll(CollectionData.list(new Government() 
		, 15));
		System.out.println(set);
	}
}
