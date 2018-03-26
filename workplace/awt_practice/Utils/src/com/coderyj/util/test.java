package com.coderyj.util;
import java.nio.*;
import java.io.*;
import java.nio.channels.*;

public class test {

	public test() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		FileChannel fc = new FileOutputStream("data.text").getChannel();
		try {
			fc.write(ByteBuffer.wrap("some text".getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
      