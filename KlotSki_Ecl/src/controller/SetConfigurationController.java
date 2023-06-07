package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

//Classe utilizzata per modificare la configurazione presentata a schermata
public class SetConfigurationController
{	
	//Funzione che riceve come input la tavola di gioco, il numero della configurazione da settare, le scritte riguardante
	//mosse, configurazioni e vittoria, e i rettangoli presenti sulla scena a schermo
	public void setConfiguration (Board game, Rectangle [] pieces, Group root, int config, Text moves, Text win, Text configuration)
	{
		//Viene resettata la tavola e settati la configurazione e i pezzi in base alla nuova configurazione
		game.reset();
		game.setConfiguration(config);
		game.setPieces();
		//Vengono rimosse e risettate le scritte a schermo riguardanti la vecchia configurazione e le mosse
		root.getChildren().remove(moves);
		moves.setText("Moves:" + game.getMoves());
		root.getChildren().remove(configuration);
		configuration.setText("Configuration " + game.getConfiguration());

		Piece [] puzzle = game.getPieces();
		
		//Ciclo usato per rimuovere i vecchi rettangoli presenti a schermo
		for (int i = 0; i < 10; i++)
		{
			root.getChildren().remove(pieces[i]);
		}
		
		//Ciclo usato per riposizionare i nuovi rettangoli a schermo
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = puzzle[i].getDimensions();
			
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			pieces[i].setHeight(dimensions[2]*100);
			pieces[i].setWidth(dimensions[3]*100);
			pieces[i].setFill(Color.WHITE);
			pieces[i].setStrokeWidth(3);
			pieces[i].setStroke(Color.BLACK);	
			root.getChildren().add(pieces[i]);
		}
		
		//Vengono riaggiunte le scritte riguardanti mosse e configurazione
		//Eliminata invece la eventuale scritta riguardante la vittoria
		root.getChildren().add(moves);
		root.getChildren().add(configuration);
		pieces[1].setFill(Color.FIREBRICK);
		root.getChildren().remove(win);	
	}
}