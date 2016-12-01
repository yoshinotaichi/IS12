// ファイルから読み込み、標準出力に出力する。
// 実験方法： java  hello8  入力ファイル名

import	java.io.*;

public	class	hello8
{
	public	static	void	main(String[]	args)
	{
		byte[]	buff	=	new	byte[1024];
		boolean	cont	=	true;
		FileInputStream	infile	=	null;

		// 入力用ファイルを開く（＝ファイルをハンドルするオブジェクトを生成する）。
		try	{
			infile	=	new	FileInputStream(args[0]);
		} catch (FileNotFoundException	e) {
			System.err.println("ファイルがありません。");
			System.exit(1);
		}


		// 無限ループでファイルの内容を１行ずつ出力する。
		while (cont)
		{
			try	{
				int	n	=	infile.read(buff);
				System.out.write(buff,  0,  n);
			} catch (Exception	e) {
				cont	=	false;										// ファイルの終わりになると、読み込みに失敗するため
			}															// エラーとなる。それを利用して読み込みを終了する。
		}


		// 入力ファイルを閉じる。
		try	{
			infile.close();
		} catch (IOException	e) {
			System.err.println("ファイルエラー");
			System.exit(1);
		}
	} // mainメソッドの終わり。
} // hello8クラスの終わり。
