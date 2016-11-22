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
		
		/*----------------------- 
			public class ShutdownHookDemo {
			    public void start() {
			        System.out.println("Demo");
			        ShutdownHook shutdownHook = new ShutdownHook();
			        Runtime.getRuntime().addShutdownHook(shutdownHook);
			    }
			
			    public static void main(String[] args) {
			        ShutdownHookDemo demo = new ShutdownHookDemo();
			        demo.start();
			        try {
			            System.in.read();
			        }
			        catch(Exception e) {
			        }
			    }
			}
			
			class ShutdownHook extends Thread {
			    public void run() {
			        System.out.println("Shutting down");
			    }
			}
		--------------------------- */
		
		boolean flag = false;
		String hello = "Hello World!";
		String userInput[] = new String[4];
		Scanner scan = new Scanner(System.in);
		CallBackImpl callBack = new CallBackImpl();
		
		System.out.println("Podaj nazwe pliku");
		userInput[1] = scan.nextLine();
		System.out.println("Podaj str1");
		userInput[2] = scan.nextLine();
		System.out.println("Podaj str2");
		userInput[3] = scan.nextLine();
				
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
		
		if(flag)
		{
			final boolean flagg = flag;
		    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() 
		    {
		        public void run() 
		        {
		    		callBack.methodToCallBack(flagg);
		        }
		    }, "Shutdown-thread"));
		}
	}
}
