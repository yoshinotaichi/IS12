import java.io.*;
public class CopyByteImage{
	public static void main(String[] args) {
		FileInputStream inFile=null;			

		try{
		inFile = new FileInputStream("3.jpg");
		//int data=inFile.read();
		int n=0;
		int data;

		while((data=inFile.read())!=-1){
		System.out.println("n:"+n+"3");
		n++;
	}
		inFile.close();

	}catch (IOException e){
		System.err.println("エラーです。");
		System.exit(1);
		}
		
	}
}