import java.net.*;
import java.io.*;
public class ChatClient{
	public static void main(String[] args) {
		try{
		System.out.println("Aloha!");
		T1	t	=	null;
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
	protected	Socket	sock;
	public	OutputStream	outST;
	public	BufferedInputStream	inBIS;

	public void openConnection(String name, int port){
		
		System.out.println("ip_addr："+ name);
		System.out.println("port："+port);
		try{
			sock = new Socket(name,port);
			System.out.println("ネットワークをつなぎました");
					outST = sock.getOutputStream();
		inBIS = new BufferedInputStream(sock.getInputStream());

			System.out.println("streamを作りました。");
		}catch(Exception e){
			System.err.println("エラーです。");
			e.printStackTrace();
			System.exit(1);	
		}
		
	}
	public void mainProc()	throws	IOException{
		System.out.println("mainProc");
				try	{
			StreamConnector	kbToSock = new	StreamConnector(System.in,  outST);
			StreamConnector sockToCmd = new	StreamConnector(inBIS, System.out);
			System.out.println("StreamConnectorを作りました。");

			Thread	inThread = new Thread(kbToSock);
			Thread	outThread = new Thread(sockToCmd);
			System.out.println("Threadを作りました。");

			inThread.start();
			outThread.start();
			System.out.println("Threadを開始しました。");
		}	catch(Exception	e)	{
			System.err.println("mainProc:エラーです。");
			System.err.print(e);
			System.exit(1);
		}
	}

}
class	StreamConnector	implements	Runnable
{
	InputStream	src	=	null;
	OutputStream	dist	=	null;

	// ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	public	StreamConnector(InputStream	in,		OutputStream	out)
	{
		src	=	in;
		dist	=	out;
	}


	// ƒXƒŒƒbƒhˆ—‚Ì–{‘Ì
	public	void	run()
	{
		byte[]	buff	=	new	byte[1024];

		while(true)
		{
			try	{
				int	n	=	src.read(buff);
				if( n>0 )
				{
					dist.write(buff, 0, n);
				}
			}	catch(Exception	e)	{
				e.printStackTrace();
				System.err.print(e);
				System.exit(1);
			}
		}
	}
}
