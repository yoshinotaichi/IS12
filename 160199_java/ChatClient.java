import java.net.*;
import java.io.*;

public class ChatClient{
	public static void main(String[] args) {
		try{
			T1 t=new T1();
			t.openConnection(args[0],Integer.parseInt(args[1]));
			t.main_Proc();

			

		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
class T1{
	protected Socket sock=null;
	public OutputStream outSt;
	public BufferedInputStream inBIS;
	public void openConnection(String name, int port){
		System.out.println("ip_addr:" +name);
		System.out.println("port:" +port);
		try{
			sock=new Socket(name,port);
			System.out.println("ネットﾜｰｸをつなぎました!")；
			outst=sock.getOutputStream();
			inBIS=new BufferedInputStream(sock.getInputStream());
			System.out.println("streamをつくりました!");

		}catch(Exception e){
			System.err.println("エーラです。");
			e.printStackTrace();
			System.exit(1);
		}
		public void mainProc(){
			System.out.println("ALOHA!");
			StreamConnector kbToSocket=new StreamConnector();
			StreamConnector SocketToCmd=new StreamConnector();
			inThread.start();
			outThread.start();
			System.out.println("Thread Starts");
		}
	}
}
class StreamConnector implements Runnable{

	public StreamConnector(InputStream in,OutputStream out){
		public void Run(){
			try{
				byte[ ] buff=new byte[1024];
				while(true){
					int n=s{rc.read(buff);
				if(n>0){
					dist.write(buff,0,n);
				}

				}
			}catch(Exception e){
			System.err.println("エーラです。");
			e.printStackTrace();
			System.exit(1);
			}
		}
	}
}