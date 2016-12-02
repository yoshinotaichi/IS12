import java.io.*;
import java.net.*;

public class Writenet{
	public static void main(String[] args)
	{
		byte[] buff = new byte[1024];
		Socket	sock	=	null;
		InputStream	instr	=	null;
		OutputStream	outstr	=	null;
		boolean	cont	=	true;
		try	{
			int	portNum	=	Integer.parseInt(args[1]);
			sock	=	new Socket(args[0], portNum);
			instr	=	sock.getInputStream();
			outstr	=	sock.getOutputStream();
		}	catch	(Exception	e)	{
			System.err.println("111");
			System.exit(1);
		}
		while	(cont)
		{
			try	{
				int	n	=	System.in.read(buff);
				if	(buff[0]	== '.')
				{
					cont	=	false;
				}
				else
				{
					outstr.write(buff, 0, n);
				}
			} catch( Exception	e)	{
				System.exit(1);
			}
		}


		cont	=	true;
		while	(cont)
		{
			try	{
				int	n	=	instr.read(buff);
				System.out.write(buff, 0, n);
			}	catch	(Exception	e)	{
				cont	=	false;
			}
		}


		try	{
			instr.close();
		}	catch	(Exception	e){
			System.err.println("111");
			System.exit(1);
		}

	}
} 
