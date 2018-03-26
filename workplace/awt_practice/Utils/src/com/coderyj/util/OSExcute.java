package com.coderyj.util;
import java.io.*;

public class OSExcute {

	public static void command(String command) {
		boolean err =false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();  //ͨ�������п���һ������������½���
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream())); // �������������������ȡ����
			String s;
			while((s = results.readLine()) != null) {
				System.out.println(s);		// ����������������������������ı�׼�����
			}
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			// Report errors and return nonzero value to calling process if there are problems:
			while((s = errors.readLine()) != null) {
				System.err.println(s);
				err =true;
			}
		} catch (Exception e) {
			// compensate for windows 2000, which throws an exception for the default command line:
			if(!command.startsWith("CMD /C")) {
				command("CMD /C" + command);
			} else {
				throw new RuntimeException();
			}
		}
		
		if(err) {
			throw new OSExcuteException("Errors excuting" + command);
		}
	}

}
