public class Echo {
	public static void main (String[] args) {
	// 0. 変数・データをつくる
	String name;

	// 1. "名前を入力してください >"と表示する
	System.out.println("名前を入力してください >");

	// 2. 名前を変数に入れる
	name = new java.util.Scanner(System.in).nextLine();

	// 3. 名前を表示する
	System.out.println(name);
	}
}