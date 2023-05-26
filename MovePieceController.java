package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import model.Board;
import model.Piece;


public class MovePieceController
{
	
	public void move(Rectangle [] pieces, Board game,Group root, int directions)
	{
		//game.movePiece(directions);
		Piece [] blocks = game.getPieces();
		game.movePiece(directions);
		for(int i=0;i<10;i++) {
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			pieces[i].setFill(Color.WHITE);
		}
		
		
	}
}