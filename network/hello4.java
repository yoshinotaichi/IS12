// キーボード（標準入力）から読みこんで、画面（標準出力）に表示（出力する）。
// ☆クラスにご注目！！
// hello4.java

import	java.io.*;

public	class	hello4
{
	public	static	void	main(String[]	args)
	{
		ReadWrite	rw	=	new	ReadWrite();					// ReadWriteクラスのインスタンスを、rw という名前で
																			// 新規作成する。
		rw.yomikaki();													// rw の機能である、yomikaki()メソッドを呼び出す
	}																		// （実行させる）。
}




class	ReadWrite
{
	public	static	void	yomikaki()
	{
		byte[]	buff	=	new	byte[1024];
		int	n;

		try	{
			n	=	System.in.read(buff);								// 標準入力から読み込んだデータを buff に格納し、
																				// バイト数を返す。
			System.out.write(buff,  0,  n);							// buff から nバイトのデータを標準出力に出力する。
		} catch (IOException e) {
			System.err.println("エラーが発生しました！");
			System.exit(1);
		}
	}
}