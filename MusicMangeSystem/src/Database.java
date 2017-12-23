
import java.util.ArrayList;
import java.util.Iterator;

public class Database {
	private ArrayList<Item> items;
	public Database(){
		items =new ArrayList<Item>();
	}
	public void addItem(Item theItem){
		items.add(theItem);
	}
	
	public void list(){
		for(Item item:items)
		{
			item.toString();
		}
	}
	public String getTitle(){
		return getTitle();
	}
	public int number(){
		return items.size();
	}
	//查询  按什么查询
	 
		 public DVD searchDVD(String t)
		    {
			 for(Item i: items){
			 		System.out.println("Get in search");
			 		if(i.getTitle().equals(t) && i instanceof DVD){
			 			return (DVD)i;
			 		}
			 		
			 	}
			 	return null;
		           
		    }
		//删除
		 public void deleteCD(String title){
			 for(int i=0;i<items.size();i++){
				 Item item = items.get(i);
				 if(item instanceof CD && item.getTitle().equals(title)){
					 items.remove(i);i--;
				 }
			 }
		 }
		 
		//修改
		 public void updateCD(Item element){
			 for(int index=0;index<items.size();index++){
				 Item i = items.get(index);
				 if(i instanceof CD && i.getTitle().equals(element.getTitle())){
					 items.set(index,element);
					 break;
					 
				 }
			 }
		 }
		 
		 public CD searchCD(String t)
		    {
			 	for(Item i: items){
			 		System.out.println("Get in search: " + i);
			 		
			 		if(i.getTitle().equals(t) && i instanceof CD){
			 			return (CD)i;
			 			
			 		}
			 		
			 	}
			 	return null;
		           
		    }
	
		//删除
		 public void deleteDVD(String title){
			 for(int i=0;i<items.size();i++){
				 Item item = items.get(i);
				 if(item instanceof DVD && item.getTitle().equals(title)){
					 items.remove(i);i--;
				 }
			 }
		 }
		 
		//修改
		 public void updateDVD(Item element){
			 for(int index=0;index<items.size();index++){
				 Item i = items.get(index);
				 if(i instanceof DVD && i.getTitle().equals(element.getTitle())){
					 items.set(index,element);
					 break;
					 
				 }
			 }
		 }
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}

}
