package controller;

import java.io.File;
import java.io.FileWriter;

import model.*;


public class SaveController 
{
	
	public void save (Board game,File save)
	{
		//game.save();
		Piece [] a = game.getPieces();
		
		try 
		{
			FileWriter myWriter = new FileWriter(save);
			myWriter.write(game.getMoves() + " \n");
			for (int i = 0; i< 10; i++)
			{
				int [] dimensions = a[i].getDimensions();
				//myWriter.write(dimensions[0] +" "+ dimensions[1] + "\n");
				myWriter.write(dimensions[0] +" "+ dimensions[1] + " "+ dimensions[2] + " " + dimensions[3] +"\n");
			}
			myWriter.close();
		}
		catch (Exception e)
		{	  	  
		}
		
		
	}
}