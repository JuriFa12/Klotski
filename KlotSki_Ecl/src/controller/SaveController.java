package controller;

import java.io.File;
import java.io.FileWriter;

import model.*;
//Classe che rappresenta un controllore per salvare il gioco
public class SaveController 
{	//Vengono dati alla funzione il gioco attuale e un file dove salvare i dati del gioco attuale
	public void save (Board game,File save)
	{
		//Prende i pezzi dal gioco
		Piece [] a = game.getPieces();
		
		try 
		{
			//Crea un filewriter e scrive sul file save come prime due cose la configurazione usata
			//e il numero di mosse
			FileWriter myWriter = new FileWriter(save); 
			myWriter.write(game.getConfiguration()+ "\n");  
			myWriter.write(game.getMoves() + " \n");      
			
			//Ciclo che, per ogni pezzo del gioco, salva nel file le sue variabili d'esemplare
			for (int i = 0; i< 10; i++) 
			{
				int [] dimensions = a[i].getDimensions();
				myWriter.write(dimensions[0] +" "+ dimensions[1] + " "+ dimensions[2] + " " + dimensions[3] +"\n");
			} 
			
			//Chiude il writer
			myWriter.close();
		}
		catch (Exception e)
		{
		}				
	}
}