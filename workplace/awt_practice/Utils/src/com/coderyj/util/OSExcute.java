package com.coderyj.util;
import java.io.*;

public class OSExcute {

	public static void command(String command) {
		boolean err =false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();  //通过命令行开启一个其他程序的新进程
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream())); // 将其他程序的输出结果读取出来
			String s;
			while((s = results.readLine()) != null) {
				System.out.println(s);		// 将其他程序的输出结果输出到本程序的标准输出中
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
