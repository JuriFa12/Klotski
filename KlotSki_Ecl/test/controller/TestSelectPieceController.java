package controller;


import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class TestSelectPieceController
{
	public TestSelectPieceController()
	{
		
	}

	@Test
	public void testSelectPieceController() 
	{
		//Creazione della tavola e del controllore
		Board testBoard = new Board();
		SelectPieceController testController = new SelectPieceController();
		
		//Controllo del valore iniziale
		assertNull(testBoard.getSelected());
		
		//Viene selezionato un pezzo
		testController.selectPiece(testBoard, 6);
		Piece testSelected = testBoard.getSelected();
		
		//Controlla che la selezione sia andata a buon fine
		int [] n = testSelected.getDimensions();
		assertEquals(n[0],3);
		assertEquals(n[1],4);
		assertEquals(n[2],2);
		assertEquals(n[3],1);

	}

}
