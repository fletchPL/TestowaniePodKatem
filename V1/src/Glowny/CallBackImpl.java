package Glowny;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CallBackImpl implements CallBack
{
	
	private static String y = "y";
	static String hello = "hello World";
	public void SaveFile(Path path)
	{
		try
		{
			File filee = new File(path + "\\file.txt");
			
			FileWriter fw = new FileWriter(filee);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(hello);
			bw.close();
		}catch(IOException e)
		{
			System.out.println("zapisywanie nie powiodlo sie callback");
		}
	}
	@Override
	public String methodToCallBack(boolean wynik) 
	{
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		if(wynik)
		{
			System.out.println("wanna change your path Y/N?");
			userInput = scan.nextLine().toLowerCase();
			if(userInput.equals(y.toLowerCase()))
			{
				System.out.println("Write a new Path");
				userInput = scan.nextLine();
				Path path = Paths.get(userInput);
				if(Files.exists(path))
				{
					System.out.println("Path exist");
					System.out.println(path);
					SaveFile(path);
					
				}else {
					System.out.println("wrong path");
				}
			}
			else 
			{
				System.out.println("nie wybrales opcji zmiany sciezki");
			}
		}
		else if(!wynik)
		{
			System.out.println("plik nie zostal zapisany");
		}
		scan.close();//add
		return userInput;
	}
}
