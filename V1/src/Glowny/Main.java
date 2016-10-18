package Glowny;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args)
	{
		boolean flag = false;
		String hello = "Hello World!";
		String userInput[] = new String[3];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Podaj nazwe pliku");
		userInput[0] = scan.nextLine();
		System.out.println("Podaj str1");
		userInput[1] = scan.nextLine();
		System.out.println("Podaj str2");
		userInput[2] = scan.nextLine();
		
		try
		{
			File file = new File(userInput[1]);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(hello);
			bw.close();
			
			flag = true;
			
			System.out.println("result : " + userInput[2]);
			
		}
		catch(IOException e)
		{
			System.out.println("result : " +userInput[3]);
			flag = false;
			e.printStackTrace();
		}	
		
		//callBack.methodToCallBack(flag);
	}
}
