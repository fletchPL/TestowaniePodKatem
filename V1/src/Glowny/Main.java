package Glowny;

import java.util.Scanner;

public class Main 
{
	static class CallCallBack extends Thread 
	{
	   public void run() 
	   {
		   CallBackTwoImpl callBackTwo = new CallBackTwoImpl();
		   callBackTwo.CallBackToCallBack(cStr);
	   }
	}
	public static final String[] cStr = new String[3]; 
	
	public static void main(String[] args)
	{
		CallBackImpl callBack = new CallBackImpl();
		FileOperations fOp = new FileOperations();
		
		String str[] = new String[3];
		
		Scanner scan = new Scanner(System.in);
		String answer = "";
		
		boolean flag = true;
		
		Runtime.getRuntime().addShutdownHook(new CallCallBack());
		
		while(flag)
		{
			System.out.println("Co chcesz zrobi�?\n1-Podaj dane\n2-Zapisz plik\n3-Wyjdz");
			answer = scan.nextLine();
			switch(answer)
			{
				case "1" :	System.out.println("Wybrales opcje 1");
							str = GetData();
							cStr[0] = str[0];
							cStr[1] = str[1];
							cStr[2] = str[2];
							break;
							
				case "2" :	System.out.println("Wybrales opcje 2");
				
							if(str[0] == null || str[0].equals(""))
							{
								System.out.println("Najpierw musisz poda� dane");
							}
							else
							{							
								fOp.SaveFile(str, callBack);
							}
							break;
							
				case "3" :	System.out.println("Wybrales opcje 3");
							flag = false;
							break;
					
				default  : 	break;
			}
		}
	}

	public static String[] GetData()
	{
		String userData[] = new String[3];
		
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Podaj nazwe pliku");
			userData[0] = scan.nextLine();
			if(userData[0].endsWith(".txt"))
			{
				break;
			}
			else
			{
				System.out.println("Podaj �cie�k� do pliku o rozszerzeniu '.txt'");
			}
		}

		System.out.println("Podaj 'poprawny' ciag znakow");
		userData[1] = scan.nextLine();
		
		System.out.println("Podaj 'niepoprawny' ciag znakow");
		userData[2] = scan.nextLine();
		

		if(!scan.hasNextLine())
		{
			scan.close();
		}
		return userData;
	}
}
