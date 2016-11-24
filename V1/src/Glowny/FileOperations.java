package Glowny;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations 
{
	public void SaveFile(String[] str, CallBackImpl callBack)
	{
		boolean flag = false;
		String hello = "Hello World!";

		int iterator = 0;
		do
		{
			try
			{
				File filee = new File(str[0]);
				FileWriter fw = new FileWriter(filee);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(hello);
				bw.close();
				flag = true;
				
				System.out.println("result : " + str[1]);
				iterator++;
			}
			catch(IOException e)
			{
				System.out.println("result : " +str[2]);
				flag = false;
				e.printStackTrace();
			}		
			if(iterator == 2)
			{
				break;
			}
		}
		while(!(str[0] = callBack.methodToCallBack(flag)).equals("") && iterator <= 1);
	}
}
