
package controller;


import model.Board;

//Classe che rappresenta un controllore che setta il pezzo selezionato sulla tavola
public class SelectPieceController
{
	//Funzione che prende un indice,rappresentante il pezzo su cui si è cliccato col cursore,
	//e la tavola di gioco e setta il pezzo selezionato
	public void selectPiece (Board b,int index)
	{
		b.setSelected(index);
		return;
	}
}

	
	
	