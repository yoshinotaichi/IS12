// 「オブジェクトとクラス」の例題。文字列型（String型）の機能　その１。
// hello2.java

import	java.io.*;

public	class	hello2
{
	public	static	void	main(String[]	args)
	{
		String kotoba;											// 文字列クラス（Stringクラス）のインスタンスを、kotobaという
																		// 名前で生成する。
		int	n;														// 整数クラス（intクラス）のインスタンスを、nという名前で生成
																		// する。

		kotoba	=	"Hello, world!";							// kotobaに文字列を代入する。
		System.out.println("Hello, world!");

		n = kotoba.length();										// kotobaの機能「length()」を呼び出して、文字列に
																		// それ自身の長さを計算させる。
		System.out.println(kotoba + "の長さは、" + n + "文字です。");			// 文字列の連結。
	}
}
