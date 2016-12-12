public class Aloha{
	public static void main(String[] args) {
		String name;
		
		while(true){		
		System.out.println("名前を入力してください>");
		name=new java.util.Scanner(System.in).nextLine();
		System.out.println(name);
		if(name.equals("Aoki")){
			break;
		}

		
	}
}
}