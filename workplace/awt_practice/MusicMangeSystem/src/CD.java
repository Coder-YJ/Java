
public class CD extends Item{//子类：CD 父类：Item
	
	private String artist;
	private int numberOfTracks;
	

	public CD(String theTitle,String theArtist,int theNumberOfTracks,int thePlayingTime){
		super(theTitle,thePlayingTime);//共有字段  个数：看父类
		artist = theArtist;
		numberOfTracks = theNumberOfTracks;
	}
	
	public String getArtist(){
		return artist;
	}
	public int getNumberOfTracks(){
		return numberOfTracks;
	}
	
	public String toString(){
		
		return super.toString()+"艺术家："+artist+"曲目数量："+numberOfTracks;
		
		
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
