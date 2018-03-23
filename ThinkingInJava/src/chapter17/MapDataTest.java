package chapter17;
import java.util.*;

import chapter15.Generator;

class Letters implements Generator<Pair<Integer, String>> , Iterable<Integer>{

	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer, String>(number++, "" + letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

public class MapDataTest {

	public static void main(String[] args) {
		// pair Generator 
		System.out.println(MapData.map(new Letters(),11));
		System.out.println(MapData.map(new Letters(), "Pop"));
	}

}
