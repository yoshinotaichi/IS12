import java.net.*;
import java.io.*;
public class ChatClient{
public static void main(String[] args) {
	 try{
	    T1 t = null;
	    t	=	new	T1();
	    t.openConnection(args[0],Integer.parseInt(args[1]));
	    t.mainProc();
	    }catch(Exception e){
	 	e.printStackTrace();
	 	System.exit(1);
	 }
	}
}
class T1{
	protected Socket sock=null;
	public	OutputStream	outST;
	public	BufferedInputStream	inBIS;
public void openConnection(String name,int port){
	System.out.println("ip_addr："+name);
	System.out.println("port"+port);
	try{
		sock=new Socket(name,port);
		System.out.println("ネットワクをつなぎました");
		outSt=sock.getOutputStream();
		inBIS=new BufferedInputStream(sock.getInputStream());
	}catch (Exception e) {
		System.err.println("エラーです");
		e.printStackTrace();
		System.exit(1);

	}
	
	//int age2017=age+1;
	//System.out.println("来年："+age2017);
	//int age2027=age+11;
	//System.out.println("2027年"+age2027);
}
}
class StreamConnector{

}