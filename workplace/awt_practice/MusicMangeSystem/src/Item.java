
public class Item {
	private String title;
	private int playingTime;
	private boolean gotIt;
	private String comment;
	
	public Item(String thetitle,int time){
		title = thetitle;
		playingTime = time;
		gotIt = false;
		comment = "<no comment>";
	}
	public void setComment(String newcomment){
		comment = newcomment;
	}
	
	public String getComment(){
		return comment;
	}
	
	public void setOwn(boolean newgotit){
		gotIt = newgotit;
	}
	
	public String getOwn(){
		if(gotIt)
		return "ӵ��" ;
		return "��ӵ��" ;
	}
	
	public String getTitle(){
		return title;
	}
	public int getPlayingTime(){
		return playingTime;
	}
	
	public String toString()
	
	{
		String s;
		s ="���⣺"+title+ "����ʱ�䣺" +playingTime+"mins";
		if(gotIt){
			s=s+"ӵ��";
			
		}else{
			s=s+"��ӵ��";
		}
		s =s+"˵����"+comment;
		return s;
		
		
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
