// 指定されたPCにアクセスし、メッセージを受け取って標準出力に出力する。
// 実験方法： java  Readnet 　PC名  ポート番号
// Readnet.java

import java.io.*;
import java.net.*;

public class Readnet
{
	public static void main(String[] args)
	{
		byte[]	buff	=	new	byte[1024];
		Socket	readsock	=	null;														// ソケットobj。入力用。
		InputStream	instr	=	null;														// 入力データストリーム。
		boolean	cont	=	true;

		try	{
			// 指定のポートに接続する。
			readsock	=	new	Socket(args[0],	Integer.parseInt(args[1]));	
			// ソケットobjから、入力データストリームを生成する。
			instr	=	readsock.getInputStream();											
		}												catch	(Exception	e)	{
			System.err.println("ネットワークエラーです。");
			System.exit(1);
		}


		// データ終了まで処理を繰り返す。
		while(cont)
		{
			try	{
				// 入力データストリームから読み込む。
				int	n	=	instr.read(buff);			

				// buff の内容を標準出力に出力。
				System.out.write(buff,	0,	n);							}																							// ※ファイルの処理と同じ！！
			catch	(Exception	e)	{
				cont	=	false;
			}
		}


		try	{
			instr.close();											// 接続を閉じる。
		}																								// ※これも、ファイルと同じ！！
		catch	(Exception	e)	{
			System.err.println("ネットワークのエラーです。");
			System.exit(1);
		}

	}
}
