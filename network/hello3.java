// 「オブジェクトとクラス」の例題。文字列型（String型）の機能　その２。
// hello3.java

import	java.io.*;

public	class	hello3
{
	public	static	void	main(String[]	args)
	{
		String kotoba;
		int	n;

		kotoba	=	"Hello, world!";
		System.out.println("Hello, world!");

		n = kotoba.length();
		System.out.println(kotoba + "の長さは、" + n + "文字です。");


		// 似たような、もうひとつの例。こんな書き方もできる。
		System.out.println("はろーわーるど！");

		n = "はろーわーるど！".length();
		System.out.println("はろーわーるど！の長さは、" + n + "文字です。");
	}
}
