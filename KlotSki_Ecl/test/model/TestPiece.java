package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;


public class TestPiece {
	
	public TestPiece()
	{		
	}
    
	@Test
	public void testPiece() 
	{
		//Vengono creati due pezzi
		new Piece (0,1,2,2);
		new Piece (1,2,2,2);
	}
	
	@Test
	public void testPiece2()
	{
		//Viene creato un pezzo tramite un altro pezzo
		Piece a = new Piece (1,1,2,2);
		Piece testPiece = new Piece (a);
		int [] dimensions = testPiece.getDimensions();
		
		//Si verificano che le dimensioni siano le stesse
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],1);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],2);
		
	}
	
	@Test
	public void testMove()
	{
		//Viene creato un pezzo e mosso
		Piece testPiece = new Piece(1,1,2,2);
		testPiece.move(1, 2);
		
		int [] dimensions = testPiece.getDimensions();
		
		//Si verifica che le coordinate del pezzo siano aggiornate
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],2);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],2);
		
	}
	
	@Test
	public void testGetDimensions()
	{
		//Viene creato un pezzo
		Piece testPiece = new Piece (1,1,2,1);
		int [] dimensions = testPiece.getDimensions();
		
		//Si verifica che la funzione restituisce i valori aspettati correttamente
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],1);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],1);
	}

}
