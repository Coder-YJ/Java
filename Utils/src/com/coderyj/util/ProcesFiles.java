package com.coderyj.util;
import java.io.*;

public class ProcesFiles {

	public interface Strategy {
		void process(File file);
	}
	
	private Strategy strategy;
	private String ext;
	
	public ProcesFiles(Strategy strategy, String ext) {
		// TODO Auto-generated constructor stub
		this.strategy = strategy;
		this.ext = ext;
	}
	
	public void start(String[] args) {
		try {
			if(args.length == 0) {
				processDirectoryTree(new File("."));
			} else {
				for(String arg: args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					} else {
						// Allow user to leave off Extension
						if(!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for(File file: Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			System.out.println(file.getCanonicalFile());  // test
			strategy.process(file.getCanonicalFile());
		}
	}
	
	// Demonstration of how to use it:
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProcesFiles(new Strategy() {
			
			@Override
			public void process(File file) {
				// TODO Auto-generated method stub
				System.out.println(file);
			}
		}, "java").start(args);
	}

}
