// サーバにメッセージを送信し、返信を受け取って標準出力に出力する。
// 実験方法： java  Writenet   サーバアドレス   ポート番号
//					↑webサーバにアクセスして、データを受信してみよう！
// Writenet.java

import java.io.*;
import java.net.*;

public class Writenet
{
	public static void main(String[] args)
	{
		byte[] buff = new byte[1024];
		Socket	sock	=	null;
		InputStream	instr	=	null;
		OutputStream	outstr	=	null;
		boolean	cont	=	true;

		// サーバへの接続
		try	{
			int	portNum	=	Integer.parseInt(args[1]);					// 引数は文字なので、ポート番号だけ
			sock	=	new Socket(args[0], portNum);							// 数値に変換する。
			instr	=	sock.getInputStream();
			outstr	=	sock.getOutputStream();
		}	catch	(Exception	e)	{
			System.err.println("ネットワークエラー");
			System.exit(1);
		}

		// 入力を送信する。
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


		// サーバからの返信を出力する。
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


		// 接続を閉じる。
		try	{
			instr.close();
		}	catch	(Exception	e){
			System.err.println("ネットワークエラー");
			System.exit(1);
		}

	} // main()メソッドの終わり。
} // Writenetクラスの終わり。
