package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;


public class MovePieceController
{
	
	public void move(Rectangle [] pieces, Board game,Group root, int directions,Text move,Text win)
	{
		//game.movePiece(directions);

		root.getChildren().remove(move);
		Piece [] blocks = game.getPieces();
		game.movePiece(directions);
		move.setText("Moves:" + game.getMoves());
		Piece selected = game.getSelected();
		if (selected == null)
		{
			root.getChildren().add(move);
			return;
		}
		boolean checkWin = false;
		int [] check = selected.getDimensions();

		
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
		if (check[2] == 2 && check[3] == 2)
			checkWin = game.checkWin();
		
		
		game.selectPiece(-1,-1);
		root.getChildren().add(move);
		
		if (checkWin)
			root.getChildren().add(win);

		
		
		
	}
}