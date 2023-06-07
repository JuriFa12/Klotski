package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

//Classe usata per ripristinare lo stato della tavola immediatamente precedente all'attuale
public class UndoController {
	
	public void undo(Rectangle [] pieces, Board game,Group root, Text move, Text win)
	{
		
		//Viene annullata l'ultimo mossa
		game.undo();
		Piece[] blocks = game.getPieces();
		//Viene eliminata e risettata la scritta riguardante le mosse
		root.getChildren().remove(move);
		move.setText("Moves:" + game.getMoves());
		
		//Vengono risettati i rettangoli a schermo
		for(int i = 0; i < 10; i++) 
		{
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			if (i != 1)
			{
				pieces[i].setFill(Color.WHITE);
			}
		}

		//Viene riaggiunta la scritta riguardante le mosse e rimossa quella riguardo la eventuale vittoria
		game.selectPiece(-1,-1);
		root.getChildren().add(move);
		root.getChildren().remove(win);		
	}
}
