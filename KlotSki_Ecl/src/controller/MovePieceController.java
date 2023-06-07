package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

//Controllore che permette il movimento del pezzo selezionato sulla tavola
public class MovePieceController
{	
	public void move(Rectangle [] pieces, Board game,Group root, int directions,Text move,Text win)
	{
		//Prende i pezzi, effettua la mossa su Board e aggiorna il numero di mosse
		root.getChildren().remove(move);
		Piece [] blocks = game.getPieces();
		game.movePiece(directions);
		move.setText("Moves:" + game.getMoves());
		Piece selected = game.getSelected();
		
		//Caso in cui non sia stato selezionato nessun pezzo
		if (selected == null)
		{
			//Posiziona il numero di mosse nella tavola
			root.getChildren().add(move);
			return;
		}
		
		boolean checkWin = false;
		int [] check = selected.getDimensions();

		//Ciclo per riposizionare i rettangoli nella tavola
		for(int i=0;i<10;i++) 
		{
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			
			if (i != 1)
				pieces[i].setFill(Color.WHITE);
			else
				pieces[i].setFill(Color.FIREBRICK);	//Colore del blocco 2x2
		}
		
		//Controlla che non sia finito il gioco
		if (check[2] == 2 && check[3] == 2)
			checkWin = game.checkWin();
		
		//Rimuove la selezione del pezzo
		game.selectPiece(-1,-1);
		
		//Posiziona il numero di mosse nella tavola
		root.getChildren().add(move);
		
		//Se il gioco è finito aggiunge un segnale di vittoria
		if (checkWin)
			root.getChildren().add(win);		
	}
}