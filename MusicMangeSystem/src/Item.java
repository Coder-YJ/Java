
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
		return "拥有" ;
		return "不拥有" ;
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
		s ="标题："+title+ "播放时间：" +playingTime+"mins";
		if(gotIt){
			s=s+"拥有";
			
		}else{
			s=s+"不拥有";
		}
		s =s+"说明："+comment;
		return s;
		
		
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
