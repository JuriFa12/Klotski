package controller;

import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;


//Classe che controlla e resetta la tavola di gioco,le scritte a schermo e la posizione dei rettangoli a schermo
public class ResetController
{
	//Funzione che prende la tavola di gioco, i rettangoli visualizzati a schermo,
	//le scritte riguardanti le mosse e la vittoria e il root a cui si aggiungono i pezzi
	//e resetta tutto
	public void reset (Rectangle [] pieces, Board game, Group root, Text moves,Text win)
	{
		
		game.reset();									//viene resettato il gioco
		Piece [] blocks = game.getPieces();				
		root.getChildren().remove(moves);				//Vengono rimosse e reimpostate le vecchie scritte sulla scena
		moves.setText("Moves:" + game.getMoves());
		
		//Ciclo usato per riposizionare i rettangoli nella scena
		for (int i = 0; i < 10; i++)					
		{
			int [] dimensions = blocks[i].getDimensions();
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			pieces[i].setFill(Color.WHITE);

		}
	
		pieces[1].setFill(Color.FIREBRICK);
		//Aggiunge le mosse e rimuovo l'eventuale scritta riguardante la vittoria
		root.getChildren().add(moves);
		root.getChildren().remove(win);	
	}		
}