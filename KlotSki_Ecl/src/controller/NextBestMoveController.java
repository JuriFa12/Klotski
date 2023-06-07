package controller;

import javafx.scene.Group;


import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
//Classe che rappresenta un controllore per la sequenza di risoluzione del gioco
public class NextBestMoveController
{
	public void resolve (Board game, Group root, Text moves, Rectangle [] a,Text win)
	{
	//Opzione di risoluzione per la configurazione 1
	if( game.getConfiguration() == 1)
	{
		if(game.getMoves()!= 0) {
			return;
		}
		//Nuovo controllore per selezionare un particolare pezzo
		SelectPieceController b = new SelectPieceController(); 
		//Nuovo controllore per muovere il pezzo selezionato
		MovePieceController c = new MovePieceController();
		
		
		//Sequenza di mosse per completare il gioco
		Timeline resolve = new Timeline(
			    new KeyFrame(Duration.millis(000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,2,moves,win);
			    }),
			    new KeyFrame(Duration.millis(1000), event -> 
			    {
					b.selectPiece(game, 7);
					c.move(a,game,root,1,moves,win);
			    }),
			    new KeyFrame(Duration.millis(2000), event -> 
			    {
					b.selectPiece(game, 6);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(3000), event -> 
			    {
					b.selectPiece(game, 5);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(4000), event -> 
			    {
					b.selectPiece(game, 4);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(5000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(6000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(7000), event -> 
			    {
					b.selectPiece(game, 1);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(8000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(9000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(10000), event -> 
			    {
					b.selectPiece(game, 5);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(11000), event -> 
			    {
					b.selectPiece(game, 8);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(12000), event -> 
			    {
					b.selectPiece(game, 6);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(13000), event -> 
			    {
					b.selectPiece(game, 7);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(14000), event -> 
			    {
					b.selectPiece(game, 7);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(15000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(16000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(17000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(18000), event -> 
			    {
					b.selectPiece(game, 4);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(19000), event -> 
			    {
					b.selectPiece(game, 1);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(20000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(21000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(22000), event -> 
			    {
					b.selectPiece(game, 2);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(23000), event -> 
			    {
					b.selectPiece(game, 2);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(24000), event -> 
			    {
					b.selectPiece(game, 5);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(25000), event -> 
			    {
					b.selectPiece(game, 8);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(26000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(27000), event -> 
			    {
					b.selectPiece(game, 7);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(28000), event -> 
			    {
					b.selectPiece(game, 6);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(29000), event -> 
			    {
					b.selectPiece(game, 8);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(30000), event -> 
			    {
					b.selectPiece(game, 1);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(31000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(32000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(33000), event -> 
			    {
					b.selectPiece(game, 4);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(34000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(35000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(36000), event -> 
			    {
					b.selectPiece(game, 1);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(37000), event -> 
			    {
					b.selectPiece(game, 2);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(38000), event -> 
			    {
					b.selectPiece(game, 2);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(39000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(40000), event -> 
			    {
					b.selectPiece(game, 3);
					c.move(a,game,root,1,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(41000), event -> 
			    {
					b.selectPiece(game, 0);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(42000), event -> 
			    {
					b.selectPiece(game, 4);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(43000), event -> 
			    {
					b.selectPiece(game, 9);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(44000), event -> 
			    {
					b.selectPiece(game, 5);
					c.move(a,game,root,2,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(45000), event -> 
			    {
					b.selectPiece(game, 8);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(46000), event -> 
			    {
					b.selectPiece(game, 6);
					c.move(a,game,root,0,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(47000), event -> 
			    {
					b.selectPiece(game, 7);
					c.move(a,game,root,3,moves,win);
			    }),
			    
			    new KeyFrame(Duration.millis(48000), event -> 
			    {
					b.selectPiece(game, 1);
					c.move(a,game,root,1,moves,win);
			    })			    
			);		
		resolve.play(); //Esegue le mosse
	}
	else return;		
	}
}