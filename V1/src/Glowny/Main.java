package Glowny;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		CallBackImpl callBack = new CallBackImpl();
		FileOperations fOp = new FileOperations();
		String str[] = new String[3];
		
		Scanner scan = new Scanner(System.in);
		String answer = "";
		
		boolean flag = false;
		
		while(true)
		{
			System.out.println("Co chcesz zrobiæ?\n1-Podaj dane\n2-Zapisz plik\n3-Wyjdz");
			answer = scan.nextLine();
			switch(answer)
			{
				case "1" :	System.out.println("Wybrales opcje 1");
							str = GetData();
							flag = false;
							break;
							
				case "2" :	System.out.println("Wybrales opcje 2");
							if(str.equals(null) || str.equals(""))
							{
								System.out.println("Najpierw musisz podaæ dane");
								flag = false;
							}
							else
							{
								fOp.SaveFile(str, callBack);
								flag = true;
							}
							break;
							
				case "3" :	System.out.println("Wybrales opcje 3");
							callBack.methodToCallBack(flag);
							System.exit(1);
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
				System.out.println("Podaj œcie¿kê do pliku o rozszerzeniu '.txt'");
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
