package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

public class UndoController {
	
	public void undo(Rectangle [] pieces, Board game,Group root, Text move)
	{
		

		root.getChildren().remove(move);
		game.undo();
		Piece[] blocks = game.getPieces();
		move.setText("Moves:" + game.getMoves());

		
		for(int i=0;i<10;i++) 
		{
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			if (i != 1)
			{
			pieces[i].setFill(Color.WHITE);
			}
		}
		
		game.selectPiece(-1,-1);
		root.getChildren().add(move);
		
		
		
	}

}
