import java.net.*;
import java.io.*;
public class ChatClient;
	public static void main(String[] args) {
		try{
			T1 t= new T1();
			t.openConnection(args[0],Integer.parseInt[1]);
			

		}catch(Exception e){
			e.printlnStrackTrace();
			System.exit(1);
		}
		
	}
}
class T1{
	public void openConnection(String namw,int  port){
		System.out.println("ip_addr：" + name);
		System.out.println("pore：" + port);
		try{
			sock = new Socket(name , port);
			System.out.println(" ネットワークをつなぎました。");

		}catch(Exception e )
		{
			System.err.println("error");
			e.printlnStackTrace();
			System.exit(1);
		}

}
class StreamConnector{

}