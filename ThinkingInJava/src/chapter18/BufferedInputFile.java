package chapter18;
import java.io.*;

public class BufferedInputFile {

	public static String read(String fileName) throws IOException{
		// Reading input by line
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb =new StringBuilder();
		while((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println(read("E:\\Java\\ThinkingInJava\\src\\chapter18\\BufferedInputFile.java"));
	}

}
