
import	java.io.*;
import	java.net.*;
import	java.util.*;

public	class	ClockServer
{
	public static void	main(String[]	args)
	{
		ServerSocket	servsock	=	null;
		Socket	sock;						
		OutputStream	out;					
		String	outstr;
		int	i;
		try	{
			servsock	=	new	ServerSocket(6000,	300);
			while(true)
			{
				sock	=	servsock.accept();			
				outstr	=	"\n"
								+	"Hello, this is ClockServer by 160136"
								+	"\n"
								+	"Thank you."	+	"\n";

				out	=	sock.getOutputStream();
				for(i=0;	i<outstr.length();	i++)
				{
					out.write((int)	outstr.charAt(i));
				}
				out.write('\n');
				sock.close();
			}
		}
		catch	(IOException	e)	{
			System.exit(1);
		}
	}
}
