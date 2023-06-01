package controller;

import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;



public class ResetController
{
	
	public void reset (Rectangle [] pieces, Board game, Group root, Text moves,Text win)
	{
		game.reset();		
		Piece [] blocks = game.getPieces();
		root.getChildren().remove(moves);
		moves.setText("Moves:" + game.getMoves());
		
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			pieces[i].setFill(Color.WHITE);

		}
		
		pieces[1].setFill(Color.DARKRED);
		root.getChildren().add(moves);
		root.getChildren().remove(win);
		
		
		
	}
		
}