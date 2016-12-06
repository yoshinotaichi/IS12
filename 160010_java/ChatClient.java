import java.net.*;
import java.io.*;

public class ChatClient{
	public static void main(String[] args){
		try{
		sock = new Socket(name,port);
		System.out.println(ネットわっくにつなぎました);
		outSt = sock.getOutputStream();
		inBIS = new BufferedInputstream(sock.getOutputStream());
		System.out.println("stream をつくりました");
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
class T1{
	protected Socket sock = null;
	public OutputStream outSt;
	public BufferedInputstream inBIS;
	public void openConnection(String name, int port){
	System.out.println("ip_addr:"+name);
	System.out.println("port："+port);
	sock = new Socket(name, port);
   }catch(Exception e){
   	System.err.println("エラ-です。");
   	e.printStackTrace();
   	System.exit(1);
   }
 }
 public void mainProc(){
 	System.out.println("ALOHA!");
 	StreamConnector kbToSock = new StreamConnector();
StreamConnector sockToCmd = new StreamConnector(iBIS, System.out);

Thread inThread = new Thread(sockToCmd);
Thread outThred = new Thread(kbToSock);
inThread.start();
outThred.start();
System.out.println("Threadをstart しました。");
   }
 }
class StreamConnector implements Rundonable{
	InputStream src = null;
	OutputStream dist = null;
	public StreamConnector(InputStream in, OutputStream out){
		src= in;
		dist = out;
	}
	public void run(){
		try{
			byte[]buff =new byte[1024];
			while(true){
			int n = src.read(buff);
			if( n>0){
				dist.write(buff,0,n);
			}
		}
		}catch(Exception e){
			System.err.println("エラー");
			e.printStackTrace();
			System.exit(1);
		}
		}
	}

}

class