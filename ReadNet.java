import java.io.*;
import java.net.*;

public class ReadNet  {
	public static void main(String[] args) {
		//1. remove region data
		String host;    // name pc
		int port;    // port number
		Socket sock = null;
		InputStream inStr = null;
		byte[] buff = new byte[1024];
		boolean flag = true;

		//2. args[] data
		host = args[0];
		port = Integer.parseInt(args[1]);



		// also data
		System.out.println("host:" + host);
		System.out.println("port:" + port);
		
		try{
			sock = new Socket(host, port);
			inStr = sock.getInputStream();
			System.out.println("netword connect.");


		}catch (Exception e){
			System.out.println("errors");
			System.exit(1);
		}

		//5 also data
		while(flag){
			try{
				// also data
			int n = inStr.read(buff);


				//output data
			System.out.write(buff,0,n);


			}catch (Exception e){
				flag = false;
			}

		}



		//6 netword cut
		try{
			inStr.close();

		}catch(Exception e){
			System.out.println("errors!");
			System.exit(1);
		}
	}
	
}