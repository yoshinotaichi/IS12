// 繰り返し処理の練習プログラム その２。
// ※文字列を、１文字ずつ処理する。
// hello11.java

import	java.io.*;

public	class	hello11
{
	public	static	void	main(String[]	args)
	{
		String	kotoba	=	"Hello, world!";

		System.out.println("kotoba の最初の文字は、" + kotoba.charAt(0) + "です。");
		System.out.println("kotoba の文字数は、" + kotoba.length() + "です。");

		for(int  i = 0;	 i<kotoba.length();	 i++)									// i を使って繰り返しを数える。文字数の
		{																						// 分だけ繰り返し。
			System.out.println(kotoba.charAt(i));									// この書き方では、実は問題が、、、！
		}
	}
}
