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
			Piece [] puzzle = new Piece[10];
			Scanner reader = new Scanner(save);
			int [] dimensions = new int[4];
			int j = 0;
			int move = reader.nextInt();
				
			while (reader.hasNextLine())
			{
				String line = reader.nextLine();
				Scanner in = new Scanner (line);
				for (int i = 0; i < 4; i++)
				{	
					int a = in.nextInt();
					dimensions[i] = a;
				}
				puzzle[j] = new Piece(dimensions[0],dimensions[1],dimensions[2],dimensions[3]);	
				in.close();
			}
			
			reader.close();
			
			
			game.load(move,puzzle);
			
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
			//root.getChildren().remove(win);
			
		}

		catch (Exception e)
		{
		}

	}

	
}