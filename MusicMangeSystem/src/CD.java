
public class CD extends Item{//���ࣺCD ���ࣺItem
	
	private String artist;
	private int numberOfTracks;
	

	public CD(String theTitle,String theArtist,int theNumberOfTracks,int thePlayingTime){
		super(theTitle,thePlayingTime);//�����ֶ�  ������������
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
		
		return super.toString()+"�����ң�"+artist+"��Ŀ������"+numberOfTracks;
		
		
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
