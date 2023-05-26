package controller;

import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Piece;



public class ResetController
{
	
	public void reset (Rectangle [] pieces,Board game,Group root)
	{
		game.reset();
		/*
		for (int i = 0; i < 10; i++)
		{
        FillTransition ft = new FillTransition(Duration.millis(5), pieces[i], Color.RED, Color.WHITE);
        ft.setAutoReverse(false);
        ft.play();
		}
		*/
		
		
		
		
		Piece [] blocks = game.getPieces();
		/*
		for (int i = 0; i < 10; i++)
		{
			root.getChildren().remove(pieces[i]);
		}
		*/
		
		
		for (int i = 0; i < 10; i++)
		{
			//root.getChildren().remove(pieces[i]);
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			//pieces[i] = new Rectangle(dimensions[1]*100,dimensions[0]*100,dimensions[3]*100,dimensions[2]*100);
	
			pieces[i].setFill(Color.WHITE);
			//pieces[i].setStrokeWidth(3);
			//pieces[i].setStroke(Color.BLACK);
			
			//root.getChildren().add(pieces[i]);
		}
		
		
		
	}
		
}