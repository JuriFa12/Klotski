package view;

import java.util.Scanner;
import java.io.File;


public class a
{
	public static void main (String [] args)
	{
		File save = new File ("Save.txt");
		try
			{
			Scanner in = new Scanner (save);
		
			while (in.hasNext())
			{
				System.out.println(in.next());
			}
			in.close();
		
		}
		catch (Exception e)
		{
			
		}
	}
}