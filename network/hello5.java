// キーボード（標準入力）から読みこんで、画面（標準出力）に表示（出力する）。
// ☆無限ループ
// hello5.java

import	java.io.*;

public	class	hello5
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

		while (true)															// ()の中が「１」になれば、繰り返し処理続行。
		{																			// 他の表現もある。
			try	{
				n	=	System.in.read(buff);								// 標準入力から読み込んだデータを buff に格納し
																					// バイト数を返す。
				System.out.write(buff,  0,  n);							// buff から nバイトのデータを標準出力に出力する。
			} catch (IOException e) {
				System.err.println("エラーが発生しました！");
				System.exit(1);
			}
		}
	}
}