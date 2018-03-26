package com.coderyj.util;
import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {

	// Read a file as a single string:
	public  static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
		
	}
	
	// Write s single string in one method call:
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Read a file, split by any regular expression:
	public TextFile(String fileName, String splitter) {
		// TODO Auto-generated constructor stub
		super(Arrays.asList(read(fileName).split(splitter)));
		// Regular expression split() often leaves an empty
		// String at the first position:
		if(get(0).equals("")) {
			remove(0);
		}
	}

	// Normally read by lines:
	public TextFile(String fileName) {
		this(fileName, "\n");
	}
	
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String item: this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	// Simple test:
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = read("E:\\Java\\Utils\\src\\com\\coderyj\\util\\TextFile.java");
		write("E:\\Java\\Utils\\src\\com\\coderyj\\util\\test.txt", file);
		TextFile text = new TextFile("E:\\Java\\Utils\\src\\com\\coderyj\\util\\test.txt");
		text.write("E:\\Java\\Utils\\src\\com\\coderyj\\util\\test2.txt");
		// Break into unique sorted list fo words:
		TreeSet<String> words = new TreeSet<String> (new TextFile("E:\\Java\\Utils\\src\\com\\coderyj\\util\\TextFile.java", "\\W+"));
		// Display the capitalized words:
		System.out.println(words.headSet("a"));
	}

}
