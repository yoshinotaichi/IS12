// ChatClient.java

import java.net.*;
import java.io.*;

public class ChatClient {
	public  static void main(String[] args) {
		try {
			T1 t = new T1();

			// ↓ネットワークをつなぐ
			t.openConnection(args[0], Integer.parseInt(args[1]));	// T1に、args[0]とargs[1]をわたす

			// ↓データを送ったり、もらったりする
			t.mainProc();

		} catch(Exception e) {
			e.printStackTrace(); // エラー表示
			System.exit(1);		 // システム終了
		}
	}
}

class T1 {
	// 変数・データを準備する
	protected Socket sock = null;
	public	OutputStream	outSt;		// データを送る
	public	BufferedInputStream	inBIS;	// データをもらう


	// メソッド
	public void openConnection(String name, int port){

		System.out.println("ip_addr: "+name);
		System.out.println("port: "+port);

		// Socketを new する。（ネットワークをつなぐ）
		// streamをつくる
		try {
			sock = new Socket(name, port);
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

	// mainProcメソッド
	public void mainProc() {
		System.out.println("ALOHA!");

		try {
			// StreamConnectorをつくる(２つ)
			StreamConnector kbToSock = new StreamConnector(System.in, outSt);
			StreamConnector sockToCmd = new StreamConnector(inBIS, System.out);
			System.out.println("StreamConnectorをつくりました。");

			// Threadをつくる(２つ)
			Thread inThread = new Thread(sockToCmd);
			Thread outThread = new Thread(kbToSock);
			System.out.println("Threadをつくりました。");

			// Threadをスタートする(２つ)
			inThread.start();
			outThread.start();
			System.out.println("Threadを start しました。");

		} catch(Exception e) {
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);
		}
	}
}

class StreamConnector implements Runnable {
	// 変数・データ
	InputStream	src	= null;
	OutputStream dist = null;

	// メソッド
	public StreamConnector(InputStream	in,	OutputStream out) {
		src	= in;
		dist = out;
	}

	public void run(){
		// データを読んで、書く。
		try {
			byte[] buff = new byte[1024];  // データ保存場所

			// ずっと、仕事する。くり返し、くり返し、、、
			while(true){
				int	n = src.read(buff);		// データを読む（もらう）
				if( n>0 ){
					dist.write(buff, 0, n); // データを次に送る
				}
			}

		} catch(Exception e) {
			System.err.println("エラー");
			e.printStackTrace();
			System.exit(1);
		}
	}
}






