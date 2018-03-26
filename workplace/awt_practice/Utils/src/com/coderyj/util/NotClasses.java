package com.coderyj.util;
import java.util.*;
// Test File 
enum LikeClasses{
	WINKEN{void behavior(){System.out.println("Behavior1");}},
	BLIKEN{void behavior(){System.out.println("Behavior2");}},
	NOD{void behavior(){System.out.println("Behavior3");}};
	abstract void behavior();
}

public class NotClasses {
//	void f1(LikeClasses.WINKEN instance) {}
}
