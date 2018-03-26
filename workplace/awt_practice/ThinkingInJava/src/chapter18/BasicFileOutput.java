package chapter18;
import java.io.*;

public class BasicFileOutput {

	static String file = "E:\\Java\\ThinkingInJava\\src\\chapter18\\BasicFileOutput.out";
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("E:\\Java\\ThinkingInJava\\src\\chapter18\\BasicFileOutput.java")));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount++ + ":" + s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
		
		RandomAccessFile rf = new RandomAccessFile("retest.dat","rw");
//		rf.seek(5);
	}
}
