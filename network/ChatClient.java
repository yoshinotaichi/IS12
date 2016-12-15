// ŠÈˆÕ’ÊMƒvƒƒOƒ‰ƒ€BƒXƒgƒŠ[ƒ€‚Ì“Ç‚Ý‘‚«‚ðŒJ‚è•Ô‚·B
// ŽÀŒ±•û–@F java  client  ƒzƒXƒg–¼  ƒ|[ƒg”Ô†
// T1.java

import	java.net.*;
import	java.io.*;

public	class	 ChatClient
{
	// main()ƒƒ\ƒbƒh
	public	static	void	main(String[]	args)
	{
		try	{
			T1	t	=	null;
			t	=	new	T1();
			t.openConnection(args[0],  Integer.parseInt(args[1]));
			t.main_proc();
		}	catch(Exception	e)	{
			e.printStackTrace();
			System.exit(1);
		}
	} // main()ƒƒ\ƒbƒh‚ÌI‚í‚èB
} // ChatClientƒNƒ‰ƒX‚ÌI‚í‚èB



class	T1
{
	protected	Socket	sock;
	public	OutputStream	outST;
	public	BufferedInputStream	inBIS;


	// openConnection()ƒƒ\ƒbƒh
	public	void	openConnection(String	host,  int	port)	throws IOException, UnknownHostException
	{
		sock	=	new	Socket(host, port);
		outST = sock.getOutputStream();
		inBIS = new BufferedInputStream(sock.getInputStream());
	} // openConnection()ƒƒ\ƒbƒh‚ÌI‚í‚èB


	// main_proc()ƒƒ\ƒbƒh
	public	void	main_proc()	throws	IOException
	{
		try	{
			StreamConnector	stdin_to_socket = new	StreamConnector(System.in,  outST);
			StreamConnector socket_to_stdout = new	StreamConnector(inBIS, System.out);

			Thread	input_thread = new Thread(stdin_to_socket);
			Thread	output_thread = new Thread(socket_to_stdout);

			inthread.start();
			outthread.start();
		}	catch(Exception	e)	{
			System.err.print(e);
			System.exit(1);
		}
	} // main_proc()ƒƒ\ƒbƒh‚ÌI‚í‚èB
} // T1ƒNƒ‰ƒX‚ÌI‚í‚èB













// StreamConnectorƒNƒ‰ƒX
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
} // StreamConnectorƒNƒ‰ƒX‚ÌI‚í‚èB
