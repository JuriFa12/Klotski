package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPiece {

	@Test
	public void testPiece() 
	{
		new Piece (0,1,2,2);
		new Piece (1,2,2,2);
	}
	
	@Test
	public void testPiece2()
	{
		Piece a = new Piece (1,1,2,2);
		int [] n = a.getDimensions();
		
		Piece testPiece = new Piece (n[0],n[1],n[2],n[3]);
		int [] dimensions = testPiece.getDimensions();
		
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],1);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],2);
		
	}
	
	@Test
	public void testMove()
	{
		Piece testPiece = new Piece(1,1,2,2);
		testPiece.move(1, 2);
		
		int [] dimensions = testPiece.getDimensions();
		
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],2);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],2);
		
	}
	
	@Test
	public void testGetDimensions()
	{
		Piece testPiece = new Piece (1,1,2,1);
		int [] dimensions = testPiece.getDimensions();
		
		assertEquals(dimensions[0],1);
		assertEquals(dimensions[1],1);
		assertEquals(dimensions[2],2);
		assertEquals(dimensions[3],1);
	}

}
