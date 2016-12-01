// 標準入力から読みこんで、ファイルに出力する。
// クラスを分けるほどの内容ではないので、hello7クラスの mainメソッド の中で全てを実行する。
// 実験方法：  java  hello7  出力ファイル名
// hello7.java

import	java.io.*;

public	class	hello7
{
	public	static	void	main(String[]	args)
	{
		byte[]	buff	=	new	byte[1024];
		boolean	cont	=	true;
		FileOutputStream	outfile	=	null;

		// 出力用のファイルを生成する。
		try	{
			outfile	=	new	FileOutputStream(args[0]);
		} catch (FileNotFoundException	e) {
			System.err.println("ファイルがみつかりません。");
			System.exit(1);
		}

		// 無限ループ
		while (cont)
		{
			try	{
				int	n	=	System.in.read(buff);
				System.out.write(buff,  0,  n);

				// もし、入力行の初めが「．」だったらループ終了
				if (buff[0]	==	'.')
				{
					cont	=	false;
				}
				else
				{
					outfile.write(buff,  0,  n);
				}
			} catch (Exception  e) {
				System.exit(1);
			}
		} // while の終わり。


		// 出力用ファイルを閉じる。
		try	{
			outfile.close();
		} catch (IOException  e) {
			System.err.println("ファイルエラー");
			System.exit(1);
		}
	} // mainメソッドの終わり。
} // hello7クラスの終わり。

