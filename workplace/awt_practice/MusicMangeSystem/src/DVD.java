
public class DVD extends Item{
	
	private String director;
	
	public DVD(String theTitle,String theDirector,int thePlayingTime){
		super(theTitle,thePlayingTime);
		
		director = theDirector;
		
	}

	public String getDirector(){
		return director;
	}
	public String toString(){
		
		return super.toString()+"“’ ıº“£∫"+director;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
