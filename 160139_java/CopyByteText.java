import java.io.*;
public class CopyByteText{
	public static void main(String[]args){
FileInputStream inFile = null;
FileOutputStream outFile = null;

try{
	inFile = new FileInputStream("TXXXT.txt");
	outFile = new FileOutputStream("result.txt");
	System.out.println("Streamを作りました。");
	//int data = inFile.read();
	int data;
	while((data = inFile.read())!=-1){
	outFile.write((char)data);
	System.out.println("テキストファイルをコピーしています。");
	}
	inFile.close();
	System.out.println("コピー終わりました。");
	outFile.close();
}catch(IOException e){
	System.err.println("エラーです");
	System.exit(1);
		}
}
}
