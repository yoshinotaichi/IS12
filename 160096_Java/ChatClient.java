import java.net.*;
import java.io.*;
public class ChatClient{
	public static void main(String[]args){
		try{
			T1 t = new T1();
			t.openConnection(args[0],Integer.parseInt(args[1]));
			t.mainProc();


		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
class T1 {
	protected	Socket	sock;
	public	OutputStream	outST;
	public	BufferedInputStream	inBIS;

	public void openConnection(String name, int port){
		System.out.println("IP_address："+name);
		System.out.println("Port："+ port);
		
		try{
		sock = new Socket(name, port);
		System.out.println("ネットワークをつなぎました。");

		outST = sock.getOutputStream();
		inBIS = new BufferedInputStream(sock.getInputStream());
		System.out.println("Stream を作りました");

	}catch(Exception e){
		System.err.println("エラーです。");
		e.printStackTrace();
		System.exit(1);
	}
	}
	public void mainProc(){
		System.out.println("Aloha!");
		try {
		StreamConnector kbToSock = new StreamConnector(System.in, outST);
		StreamConnector sockToCmd = new StreamConnector(inBIS, System.out);
		Thread inThread = new Thread(sockToCmd);
		Thread outThread = new Thread(kbToSock);
		System.out.println("thread を　作りました");
		inThread.start();
		outThread.start();
		System.out.println("thread を　start しました。");
	} catch (Exception e){
		System.err.println("エラーです。");
		e.printStackTrace();
		System.exit(1);

	}
	}
}
class StreamConnector implements Runnable{
	InputStream	src	=	null;
	OutputStream	dist	=	null;
	public StreamConnector(InputStream in, OutputStream out){
		src = in;
		dist = out;
	}
	public void run(){
		byte[]	buff	=	new	byte[1024];

		while(true){
		try {
			int	n	=	src.read(buff);
				if( n>0 )
				{
					dist.write(buff, 0, n);
				}
		}catch(Exception e){
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);
		}
	}
	}
}