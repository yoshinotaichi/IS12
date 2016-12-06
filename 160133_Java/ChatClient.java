import java.net.*;
import java.io.*;

public class ChatClient {
	public static void main(String[] args){
		try {
			T1 t = new T1();
			t.openConnection(args[0], Integer.parseInt(args[1]));
			t.mainProc();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}	
	}
}


class T1 {
	protected Socket sock = null;
	public OutputStream outSt;
	public BufferedInputStream inBIS;
	public void openConnection(String name, int port){
		System.out.println("ip_addr:"+name);
		System.out.println("port:"+port);

		try {
			sock = new Socket(name,port);
			System.out.println("ネットワークをつなぎました。");
			outSt = sock.getOutputStream();
			inBIS = new BufferedInputStream(sock.getInputStream());
			System.out.println("streamをつくりました。");

			
		} catch(Exception e){
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);

		}
	}
	public void mainProc(){
		System.out.println("ALOHA!");
		try{
			StreamConnector kbToSocket = new StreamConnector(System.in, outSt);
			StreamConnector sockToCmd = new StreamConnector(inBIS, System.out);
			System.out.println("StreamConnectorを作りました。");

			Thread inThread = new Thread(sockToCmd);
			Thread outThread = new Thread(kbToSocket);
			System.out.println("Threadを作りました。");

			inThread.start();
			outThread.start();
			System.out.println("Threadをstartしました。");
		} catch(Exception e) {
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);

		}
	}
}


class StreamConnector implements Runnable {
	InputStream src = null;
	OutputStream dist = null;

	public StreamConnector(InputStream in, OutputStream out){
		src = in;
		dist = out;
	}

	public void run() {
		try {
			byte[] buff = new byte[1024];
			while(true){
				int n = src.read(buff);
				if(n>0){
					dist.write(buff,0,n);
				}
			}
		} catch(Exception e){
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);
		}
	}

}


