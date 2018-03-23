package chapter14;

public class Holder3<U> {

	private U a;
	
	public Holder3(U a) {
		// TODO Auto-generated constructor stub
		this.a = a;
	}
	
	public void set(U a) {
		this.a = a;
	}
	
	public U get() {
		return a;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder3<AutoMobile> h3 = new Holder3<AutoMobile>(new AutoMobile());
		AutoMobile a = h3.get();
		System.out.println("Success!");
	}

}
