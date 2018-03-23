package chapter17;
import java.util.*;

import chapter15.Generator;

public class CollectionData<T> extends ArrayList<T>{

	public CollectionData(Generator<T> gen, int quantity) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<>(gen, quantity);
	}
}
