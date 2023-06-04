package controller;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Scanner;
import model.*;

//Classe utilizzata per modificare la configurazione presentata a schermata
public class LoadController
{
	//Funzione che riceve come input la tavola di gioco e il File dove è stata salvato il gioco e lo carica nella finestra corrente
	public void load (Board game, Text moves, Group root, Rectangle[] pieces,File save)
	{
		try 
		{
			//Scanner per leggere i contenuti del file
			Scanner reader = new Scanner(save);
			//Il primo dato contenuto nel file è il tipo di configurazione
			int config = reader.nextInt(); 
			
			//Controlla che la configurazione messa nel file sia uguale a quella selezionata
			if (game.getConfiguration() == config)
			{
				if(config==3&&game.getConfiguration()!=3) //Problema, la configurazione del file non è compatibile con quella selezionata
				{
					reader.close();
					return;
				}
				//Il secondo dato contenuto del file è il numero di mosse effettuate
				int move = reader.nextInt(); 
				
				Piece[] values = new Piece[10];
			
				//Ciclo che inserisce i dati dei pezzi in un array
				int s=0;
				while(reader.hasNextInt())
				{
					int x=reader.nextInt();
					int y=reader.nextInt();
					int a=reader.nextInt();
					int l=reader.nextInt();
					values[s]= new Piece(x,y,a,l);
					s++;
				}
				
				//Richiama il load di Board
				game.load(move, values); 
				
				//Richiama il load di Board e prende i nuovi pezzi
				reader.close(); 
				Piece [] blocks = game.getPieces();
				
				 //Aggiona a schermo il nuovo numero di mosse
				root.getChildren().remove(moves);
				moves.setText("Moves: " + game.getMoves());
				
				//Ciclo usato per riposizionare i nuovi rettangoli a schermo
				for (int i = 0; i < 10; i++) 
				{
					int [] dimensions2 = blocks[i].getDimensions();
					pieces[i].setX(dimensions2[1]*100);
					pieces[i].setY(dimensions2[0]*100);
					pieces[i].setFill(Color.WHITE);
				}
			
				 //Il blocco 2x2 ha un colore diverso, per questo viene aggiornato a parte
				pieces[1].setFill(Color.FIREBRICK);
				root.getChildren().add(moves);
				}
				else //Caso dove il tipo di configurazione salvata nel file non sia uguale a quella attuale
				{
					reader.close();
					return;
				}	
		}
		catch (Exception e)
		{
		}
	}
}