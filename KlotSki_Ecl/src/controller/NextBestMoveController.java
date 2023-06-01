package controller;

import javafx.scene.Group;


import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.*;







public class NextBestMoveController
{
	public void resolve (Board game, Group root, Text moves, Rectangle [] a,Text win,int index)
	{
	if( game.getConfiguration() == 1)
	{
		SelectPieceController b = new SelectPieceController();
		MovePieceController c = new MovePieceController();

		
		b.selectPiece(game, 9);
		c.move(a,game,root,2,moves,win);
		
		
	

		b.selectPiece(game, 7);
		c.move(a,game,root,1,moves,win);


		b.selectPiece(game, 6);
		c.move(a,game,root,1,moves,win);

		b.selectPiece(game, 5);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 4);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,1,moves,win);

		b.selectPiece(game, 1);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,0,moves,win);
	
		
		b.selectPiece(game, 5);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 8);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 6);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 7);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 7);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 4);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 1);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 2);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 2);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 5);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 8);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 7);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 6);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 8);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 1);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 4);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 1);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 2);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 2);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,3,moves,win);
		
		b.selectPiece(game, 3);
		c.move(a,game,root,1,moves,win);
		
		b.selectPiece(game, 0);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 4);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 9);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 5);
		c.move(a,game,root,2,moves,win);
		
		b.selectPiece(game, 8);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 6);
		c.move(a,game,root,0,moves,win);
		
		b.selectPiece(game, 7);
		c.move(a,game,root,3,moves,win);

		b.selectPiece(game, 1);
		c.move(a,game,root,1,moves,win);
	}
	else return;
		
		
		
	}
}