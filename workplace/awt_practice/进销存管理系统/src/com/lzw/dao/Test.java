package com.lzw.dao;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.lzw.Item;
import com.lzw.dao.model.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item = new Item();
		item.setId("kh1001");
		TbKhinfo khInfo = new TbKhinfo();
//		khInfo.setId("kh001");
		Dao.addKeHu(khInfo);
		khInfo = Dao.getKhInfo(item);
		System.out.println(Dao.getKhInfo(item).getKhname());
	}

}
