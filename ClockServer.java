import java.io.*;
import java.net.*;
import java.util.*;

public class ClockServer{
	public static void main(String[] args) {
		ServerSocket servsock =null;
		Socket sock;
		OutputStream out;
		String outstr;
		int	i;
		Date	d;

		try{
			System.out.println("接続待ちです。");
			servsock = new ServerSocket(6000,300);

			while(true){
				sock = servsock.accept();
				System.out.println("接続されました。");
				d = new Date();
				outstr = "n" + "Hello, this is ClockServer by Nakae." + "\n" + d.toString() + "\n" + "Thank you." + "\n"+ "ありがとう." + "\n";
				out = sock.getOutputStream();

				for(i=0; i<outstr.length(); i++){
					out.write((int)outstr.charAt(i));
				}
				out.write('\n');
				System.out.println("メッセージを出力しました。");
				sock.close();
				System.out.println("Sreamを閉じました。");
			}
		}
		catch(IOException e){
			System.out.println("エラーです");
			System.exit(1);
		}
	}
}