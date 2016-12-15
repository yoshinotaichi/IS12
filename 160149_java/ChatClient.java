import java.net.*;
 import java.io.*;
public class ChatClient{
	public static void main(String[] args) {
     try	{
         T1 t = new T1();
         t.aloha();
         String s=args[0];
         System.out.println(args[0]+args[1]);
         int age = Integer.parseInt(args[1]);
         int answer = age+1;
         System.out.println(answer+"(2017)");

     }catch(Exception e){
		e.printStackTrace();
		System.exit(1);
      }
  }
}
class T1{
  public void aloha(string name, int age){
  	System.out.println("名前:"+ name);
  	System.out.println("年齢:"+ age);
  	int age2017 =age+1;
  	System.out.println("来年:"+age2017);
  }
}
class StreamConnector{

 }