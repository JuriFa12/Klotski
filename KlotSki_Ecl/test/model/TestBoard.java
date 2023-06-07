package model;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class TestBoard
{
	
	public TestBoard()
	{
		
	}
	@Test
	public void testBoard() 
	{
		//crea la tavola e controlla che i valori vengano impostati
		Board testBoard = new Board();

		assertEquals(1,testBoard.getConfiguration());
		assertEquals(0,testBoard.getMoves());
		assertFalse(testBoard.getWin());
		assertNull(testBoard.getSelected());
		assertEquals(10, testBoard.getPieces().length);
		assertNotNull(testBoard.getPieces());
	}
	
	@Test
	public void testSetPiecesAndGetData()
	{
		//Creazione della tavola e dei pezzi per il test
		Board testBoard = new Board();
		Piece [] testPieces = new Piece [10];
		Piece [][] testData = new Piece [1000][10];
        testPieces[0] = new Piece(1,1,2,1);
        testPieces[1] = new Piece(1,2,2,2);
        testPieces[2] = new Piece(1,4,1,1);
        testPieces[3] = new Piece(2,4,1,1);
        testPieces[4] = new Piece(3,1,2,1);
        testPieces[5] = new Piece(3,2,1,2);
        testPieces[6] = new Piece(3,4,2,1);
        testPieces[7] = new Piece(4,2,1,1);
        testPieces[8] = new Piece(4,3,2,1);
        testPieces[9] = new Piece(5,2,1,1);
        
        testData[0][0] = new Piece(1,1,2,1);
        testData[0][1] = new Piece(1,2,2,2);
        testData[0][2] = new Piece(1,4,1,1);
        testData[0][3] = new Piece(2,4,1,1);
        testData[0][4] = new Piece(3,1,2,1);
        testData[0][5] = new Piece(3,2,1,2);
        testData[0][6] = new Piece(3,4,2,1);
        testData[0][7] = new Piece(4,2,1,1);
        testData[0][8] = new Piece(4,3,2,1);
        testData[0][9] = new Piece(5,2,1,1);

        //Si controlla che i pezzi della tavola e quelli di test siano uguali
        assertArrayEquals(testPieces,testBoard.getPieces());
        assertArrayEquals(testData,testBoard.getData());
	}
	
	@Test
	public void testSetAndGetConfiguration()
	{
		
		Board testBoard = new Board();
		
		//Si controlla che il valore iniziale sia quello aspettato
		assertEquals(testBoard.getConfiguration(),1);
		
		//Valore cambiato e successivamente viene verificato questo cambiamento
		testBoard.setConfiguration(3);
		assertEquals(testBoard.getConfiguration(),3);	
	}
	
	@Test 
	public void testSetConfigurationException()
	{
		//Controlla gli errori in caso di configurazione non valida
		Board testBoard = new Board();
		Assertions.assertThrows(IllegalArgumentException.class, () -> testBoard.setConfiguration(4));
		Assertions.assertThrows(IllegalArgumentException.class, () -> testBoard.setConfiguration(-2));	
	}
	
	@Test
	public void testFindPieceIndex()
	{
		//Controllo dell'indice di pezzo trovato sia in caso positivo che negativo
		Board testBoard = new Board();
		assertEquals(testBoard.findPieceIndex(3, 2),5);
		assertEquals(testBoard.findPieceIndex(7, 4),-1);			
	}
	
	@Test 
	public void testcheckWin()
	{
		//Controllo del valore iniziale della variabile booleana per la vittoria
		Board testBoard = new Board();
		assertEquals(testBoard.checkWin(),false);
	}
	
	@Test
	public void testGetPieces ()
	{
		//controllo della lunghezza dell'array di pezzi ottenuto dalla funzione testata
		Board testBoard = new Board();
		assertEquals(10,testBoard.getPieces().length);
	}
	
	@Test
	public void testSetAndGetSelected()
	{
		//Controllo che il pezzo selezionato non equivalga a niente
		Board testBoard = new Board();
		Piece testSelected = testBoard.getSelected();
		assertNull (testSelected);
		
		//Viene selezionato un pezzo e verificato che il cambiamento sia avvenuto nella tavola di gioco
		testBoard.setSelected(2);
		testSelected = testBoard.getSelected();
		int [] n = testSelected.getDimensions();
		assertEquals(n[0],1);
		assertEquals(n[1],4);
		assertEquals(n[2],1);
		assertEquals(n[3],1);
	}
	
	@Test
	public void testReset()
	{
		//Si muove un pezzo per modificare la tavola e si verifica il cambiamento
		Board testBoard = new Board();
		testBoard.selectPiece(5, 2);
		testBoard.movePiece(2);
		assertEquals(1,testBoard.getMoves());

		//Tavola resettata e ci si assicura che siano state ripristinate tutte le variabili
		testBoard.reset();
		assertEquals(0,testBoard.getMoves());
		assertNull(testBoard.getSelected());
		assertFalse(testBoard.getWin());
		assertEquals(testBoard.getUndoState(),0);
		
		Piece [] testPieces = new Piece [10];
        testPieces[0] = new Piece(1,1,2,1);
        testPieces[1] = new Piece(1,2,2,2);
        testPieces[2] = new Piece(1,4,1,1);
        testPieces[3] = new Piece(2,4,1,1);
        testPieces[4] = new Piece(3,1,2,1);
        testPieces[5] = new Piece(3,2,1,2);
        testPieces[6] = new Piece(3,4,2,1);
        testPieces[7] = new Piece(4,2,1,1);
        testPieces[8] = new Piece(4,3,2,1);
        testPieces[9] = new Piece(5,2,1,1);       
        assertArrayEquals(testPieces,testBoard.getPieces());	
	}
	
	@Test
	public void testAvailable()
	{
		//Si controlla che una zona della tavola sia libera
		Board testBoard = new Board();
		assertTrue(testBoard.isAvaible(5, 1));
		
		//Si muove un pezzo nella zona precedentemente libera e si verifica ora la non disponibilità
		testBoard.setSelected(9);
		testBoard.movePiece(2);
		assertFalse(testBoard.isAvaible(5, 1));
	}
	
	@Test
	public void testOutOfBounds()
	{
		//Si verifica che il controllo sui limiti della tavola sia corretto
		Board testBoard = new Board();
		assertTrue(testBoard.isOutOfBounds(6, 1, 1, 1));
		assertFalse(testBoard.isOutOfBounds(5, 1, 1, 1));
		assertTrue(testBoard.isOutOfBounds(5, 4, 2, 1));
	}
	
	@Test
	public void testMovePieceAndGetMoves()
	{
		//Si muove un pezzo senza averne selezionato uno e si verifica che la azione non viene eseguita
		Board testBoard = new Board();
		assertFalse(testBoard.movePiece(0));
		
		//Si seleziona un pezzo e viene mosso
		testBoard.setSelected(9);
		assertTrue(testBoard.movePiece(2));
		assertEquals(1,testBoard.getMoves());
		assertEquals(1,testBoard.getUndoState());
		assertFalse(testBoard.movePiece(0));
		
		//Viene mosso un pezzo in una posizione non libera
		testBoard.setSelected(8);
		assertFalse(testBoard.movePiece(0));
		
		//Si muove un pezzo e si verifica che il numero di mosse sia aumentato
		testBoard.setSelected(6);
		assertTrue(testBoard.movePiece(1));
		assertEquals(2,testBoard.getMoves());
		assertEquals(2,testBoard.getUndoState());
		
		
		testBoard.setSelected(5);
		assertTrue(testBoard.movePiece(3));
		assertEquals(3,testBoard.getMoves());
		assertEquals(3,testBoard.getUndoState());
		assertFalse(testBoard.movePiece(3));
	}
	
	@Test
	public void testUndo()
	{
		//Viene creata una tavola e modificata
		Board testBoard = new Board();
		testBoard.setSelected(9);
		testBoard.movePiece(2);
		
		//Viene annullata la mossa precedente
		testBoard.undo();
		
		Piece [] testPieces = new Piece [10];
        testPieces[0] = new Piece(1,1,2,1);
        testPieces[1] = new Piece(1,2,2,2);
        testPieces[2] = new Piece(1,4,1,1);
        testPieces[3] = new Piece(2,4,1,1);
        testPieces[4] = new Piece(3,1,2,1);
        testPieces[5] = new Piece(3,2,1,2);
        testPieces[6] = new Piece(3,4,2,1);
        testPieces[7] = new Piece(4,2,1,1);
        testPieces[8] = new Piece(4,3,2,1);
        testPieces[9] = new Piece(5,2,1,1);
        
        //Si verifica che dopo l'undo la tavola rispecchi i valori aspettati
        assertArrayEquals(testBoard.getPieces(),testPieces);	
	}
	
	@Test
	public void testLoadAndGetUndoState()
	{
		//Si crea un'array di pezzi che corrispondono ad un "Salvataggio"
		Board testBoard = new Board();
		Piece [] testPieces = new Piece[10];
        testPieces[0] = new Piece(1,1,2,1);
        testPieces[1] = new Piece(1,2,2,2);
        testPieces[4] = new Piece(1,4,2,1);
        testPieces[6] = new Piece(3,1,2,1);
        testPieces[5] = new Piece(3,2,1,2);
        testPieces[2] = new Piece(4,2,1,1);
        testPieces[3] = new Piece(4,3,1,1);
        testPieces[8] = new Piece(3,4,2,1);
        testPieces[7] = new Piece(5,1,1,1);
        testPieces[9] = new Piece(5,4,1,1);
        int testMoves = 5;
        
        //Si carica il salvataggio e le mosse e si verifica che i valori siano quelli aspettati
        testBoard.load(testMoves, testPieces);
        assertEquals(testBoard.getMoves(),testMoves);
        assertEquals(testBoard.getUndoState(),0);
        assertArrayEquals(testPieces,testBoard.getPieces());    		
	}
}

