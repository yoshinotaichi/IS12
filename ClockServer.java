// ポート6000でアクセスを待ち、時刻を返すサーバ。
// ※ServerSocket登場。
// ※for文による「繰り返し処理」登場。
// ※Dateオブジェクト登場。
// ClockServer.java

import	java.io.*;
import	java.net.*;
import	java.util.*;

public	class	ClockServer
{
	public static void	main(String[]	args)
	{
		// 宣言。
		ServerSocket	servsock	=	null;	// サーバ用ソケット。
		Socket	sock;					// 読み書き用ソケット。
		OutputStream	out;				// 出力ストリーム。
		String	outstr;
		int	i;
		//Msg	m;					// 日付をハンドルするオブジェクト。

		// サーバ動作。
		try	{
			// サーバソケットを作成する。
			servsock	=	new	ServerSocket(6000,	300);

			// 接続の待ち受けと処理の繰り返し。
			while(true)
			{
				sock	=	servsock.accept();		// 接続受付。

				// 出力用データを生成する。
				//m	=	new	Msg();
				outstr	=	"\n"
						+	"Hello, everybody GOOD MORNING !!"
						+	"\n"	
						//+	m.toString()	+	"\n"
						+   "It's great to see the 21st Century Cures Act --"
						 + "which will put billions of dollars towards scientific research and fighting diseases -- pass through the US House of Representatives today."
+ "I think it is possible to cure all diseases in our children's lifetime" 
+ "but we need to invest much more to get there. The US government currently spends 50x more treating people who are sick than finding cures so people do not get sick in the first place." 
+ "Today is an important step towards changing that, and I hope the Senate follows the House is lead."
						+ 	"\n";
						+   "Mark Juk"

				// データを出力する。
				out	=	sock.getOutputStream();
				for(i=0;	i<outstr.length();	i++)
				{
					out.write((int)	outstr.charAt(i));
				}
				out.write('\n');

				// ストリームを閉じる。
				sock.close();
			}
		}
		catch	(IOException	e)	{
			System.exit(1);
		}
	}
}
