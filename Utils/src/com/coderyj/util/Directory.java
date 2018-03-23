package com.coderyj.util;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public final class Directory {
	public static File[] local (File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local (String path, final String regex) {
		return local(new File(path), regex);
	}
	
	// A two-tuple for returning a pair of objects:
	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		// the default iterable element is the file list:
		@Override
		public Iterator<File> iterator() {
			// TODO Auto-generated method stub
			return files.iterator();
		}
		
		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString() {
			return "dirs:" + PPrint.pformat(dirs) + "\n\nfiles:" + PPrint.pformat(files);
		}
	}
	
	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		for (File item: startDir.listFiles()) {
			if(item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else {  // regular file
				if(item.getName().matches(regex)) {
					result.files.add(item);
				}
			}
			
		}
		return result;
		
	}
	
	public static TreeInfo walk(String start, String regex) {  // Begin recursion
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(File start, String regex) { // overload	
		return recurseDirs(start, regex);
	}
	
	public static TreeInfo walk(File start) { // everything	
		return recurseDirs(start, ".*");
	}
	
	public static TreeInfo walk(String start) { // everything	
		return recurseDirs(new File(start), ".*");
	}
	// simple validation test:
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println(walk("."));
		} else {
			for(String arg: args) {
				System.out.println(walk(arg));
			}
		}
	}
}
