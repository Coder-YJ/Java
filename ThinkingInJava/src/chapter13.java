import java.util.regex.*;

public class chapter13 {

	
	public chapter13() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "Java now has regular expressions";
		Pattern p1 = Pattern.compile("^Java");
		Matcher m1 = p1.matcher(expression);
		while (m1.find()) {
			System.out.println("^Java: " + m1.group());
		}
		
		p1 = Pattern.compile("\\Breg.*");
		m1 = p1.matcher(expression);
		while (m1.find()) {
			System.out.println("\\Breg.*: " + m1.group());
		}
		
		p1 = Pattern.compile("n.w\\s+h(a|i)s");
		m1 = p1.matcher(expression);
		while (m1.find()) {
			System.out.println("n.w\\s+h(a|i)s: " + m1.group());
		}
		
		p1 = Pattern.compile("s{1,3}");
		m1 = p1.matcher(expression);
		while (m1.find()) {
			System.out.println("s?: " + m1.group());
		}
		
	}

}
