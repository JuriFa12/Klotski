package controller;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Scanner;
import model.*;


public class LoadController
{
	public void load (Board game, Text moves, Group root, Rectangle[] pieces,File save)
	{
		try 
		{
			Scanner reader = new Scanner(save);
			int config = reader.nextInt();
			
			if (game.getConfiguration() == config)
			{
				if(config==3&&game.getConfiguration()!=3) 
				{
					reader.close();
					return;
				}
				int move = reader.nextInt();
				Piece[] values = new Piece[10];
			
				int s=0;
				while(reader.hasNextInt())
				{
					int x=reader.nextInt();
					int y=reader.nextInt();
					int a=reader.nextInt();
					int l=reader.nextInt();
					values[s]= new Piece(x,y,a,l);
					s++;
				}
				
			
				game.load(move, values);
			
				reader.close();
				Piece [] blocks = game.getPieces();
			
				root.getChildren().remove(moves);
				moves.setText("Moves: " + game.getMoves());

			
			
				for (int i = 0; i < 10; i++)
				{
					int [] dimensions2 = blocks[i].getDimensions();
					pieces[i].setX(dimensions2[1]*100);
					pieces[i].setY(dimensions2[0]*100);
					pieces[i].setFill(Color.WHITE);

				}
			
				pieces[1].setFill(Color.DARKRED);
				root.getChildren().add(moves);

				}
				else
				{
					reader.close();
					return;
				}
			
		}

		catch (Exception e)
		{
		}

	}

	
}