import java.io.*;

import javax.annotation.processing.Filer;

public class Example10_5 
{
//	public static void main(String[] args) 
//	{
//		int b;
//		byte buffer[] = new byte[100];
//		try 
//		{
//			System.out.println("输入一行文本，并存入磁盘");
//			b = System.in.read(buffer);
//			FileOutputStream writefile = new FileOutputStream("line.txt");
//			writefile.write(buffer, 0, b);
//			writefile.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
//	public static void main(String[] args)
//	{
//		char a[] = "今晚发起总攻".toCharArray();
//		int n = 0, m = 0;
//		try
//		{
//			File f = new File("secret.txt");
//			for(int i=0; i<a.length; i++)
//			{
//				a[i] = (char)(a[i]^'R');
//			}
//			FileWriter out = new FileWriter(f);
//			out.write(a,  0, a.length);
//			out.close();
//			FileReader in = new FileReader(f);
//			char tom[] = new char[10];
//			System.out.println("密文：");
//			while((n = in.read(tom, 0 ,10)) != -1)
//			{
//				String s = new String(tom , 0 ,n);
//				System.out.print(s);
//			}
//			in.close();
//			in = new FileReader(f);
//			System.out.println("");
//			System.out.println("明文");
//			while((n = in.read(tom, 0 ,10)) != -1)
//			{
//				for(int i = 0; i<n; i++)
//				{
//					tom[i] = (char)(tom[i] ^ 'R');
//				}
//				String s = new String(tom, 0 ,n);
//				System.out.print(s);
//			}
//			in.close();
//		}
//		catch(IOException e) 
//		{
//			System.out.println("File read Error");
//		}
//	}

}
