import java.io.*;
import java.net.*;
public class Readnet{
	public static void main(String[] args) {
		
		String host;
		int port;
		Socket sock=null;
		InputStream inStr=null;
		byte[]buff = new byte[1024];
		boolean flag = true;


		 host = args[0];
		 port =Integer.parseInt( args[1]);
		 System.out.println("host:"+host);
		  System.out.println("port:"+port);

		  try{
		  	sock = new Socket(host,port);
		  	inStr = sock.getInputStream();
		  	System.out.println("ネットワークつながる");
		  }catch (Exception e){
		  	System.err.println("エラーです。");
		  	System.exit(1);
		  }
		  while(flag){
		  	try{
		  		int n = inStr.read(buff);
		  		System.out.write(buff,0,n);

		  	}catch(Exception e){
		  		flag=false;
		  	}
		  }
		  try{
		  	inStr.close();
		  }catch(Exception e){
		  	System.err.println("エラーです");
		  	System.exit(1);
		  }
	}
}