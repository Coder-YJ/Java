import java.io.*;
public class Student implements Serializable{  /**  需再了解一下Serializable 类
	 * 
	 */
	private static final long serialVersionUID = 771652260758459933L;

	String number, name, discipling, grade, borth, sex;
	File imagePic;
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDisciping(String discipling) {
		this.discipling = discipling;
	}
	
	public String getDiscipling() {
		return discipling;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setBorth(String borth) {
		this.borth = borth;
	}
	
	public String getBorth() {
		// TODO Auto-generated method stub
		return borth;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setImagePic(File imagePic) {
		this.imagePic = imagePic;
	}
	
	public File getImagePic() {
		return imagePic;
	}

}
