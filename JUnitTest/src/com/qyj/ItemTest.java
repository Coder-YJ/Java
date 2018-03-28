package com.qyj;

import internalFrame.guanli.Item;
import junit.framework.TestCase;

public class ItemTest extends TestCase {
	private Item item;
	protected void setUp() throws Exception {
		item = new Item();
		item.setId("007");
		item.setName("JAVA测试");
	}
	
	public void testID() {
		assertEquals(item.getId(), "007");
	}
	
	public void testName() {
		assertEquals(item.getName(), "JAVA测试");
	}
	
	public void testEquals() {
		Item newItem = new Item();
		newItem.setId("007");
		newItem.setName("JAVA测试");
//		assertEquals(item, newItem);
	}

}
