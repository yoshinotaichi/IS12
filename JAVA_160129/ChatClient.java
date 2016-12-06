import java.net.*;
import java.io.*;


public class ChatClient  {
	public static void main(String[] args) {
		try	{
			T1	t	=	null;
			t	=	new	T1();
			t.openConnection(args[0],  Integer.parseInt(args[1]));
			t.main_proc();
		}	catch(Exception	e)	{
			e.printStackTrace();
			System.exit(1);
		}
	} 
} 



	class  T1 {
		protected	Socket	sock;
		public	OutputStream	outST;
	    public	BufferedInputStream	inBIS;

		public void 	openConnection(String	name,  int	port){
			System.out.println("ip_address:"+name);
			System.out.println("port:"+ port);
          try{


			sock	=	new	Socket(name, port);
			System.out.println("NETWORK CONNECTED");
			
		    outST = sock.getOutputStream();
		    inBIS = new BufferedInputStream(sock.getInputStream());
		}catch(Exception e){
			System.err.println("ERRORS");
			e.printStackTrace();
			System.exit(1);

		}

    }
    public	void	main_proc()	throws	IOException{
	
		try{
			StreamConnector	kbToSock = new	StreamConnector(System.in,  outST);
			StreamConnector sockToCmd = new	StreamConnector(inBIS, System.out);
			System.out.println("Thread を start しました");

			Thread inthread = new Thread(sockToCmd);
			Thread outthread = new Thread(kbToSock);

		}catch(Exception e)	{
			System.err.print(e);
			System.exit(1);

		
	}

	class StreamConnector implements Runnable{

		InputSream src = null;
		OutputStream dist = null;

		public StreamConnector(InputSream in, OutputStream out){

			src = in;
			dist = out;

		}

		public void run(){

			try{
				byte[] buff = new byte[1024];
				int n = src.read(buff);
				if(n>0){
					dist.write(buff,0,n);

						
					
				}


			}catch(Exception e){
			    System.err.println("ERRORS");
			    e.printStackTrace();
			    System.exit(1);
			}
		}
	}
}
}




	


	
