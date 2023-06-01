package model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBoard {

	@Test
	void testBoard() 
	{
		Board testBoard = new Board();

		assertEquals(1,testBoard.getConfiguration());
		assertEquals(0,testBoard.getMoves());
		assertFalse(testBoard.getWin());
		assertNull(testBoard.getSelected());
		assertEquals(10, testBoard.getPieces().length);
		assertNotNull(testBoard.getPieces());
	}
	
	@Test
	void testSetPieces()
	{
		Board testBoard = new Board();
		Piece [] testPieces = new Piece [10];
		Piece [][] testData = new Piece [800][10];
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

        assertArrayEquals(testPieces,testBoard.getPieces());
        assertArrayEquals(testData,testBoard.getData());
	}
	
	@Test
	void testSetConfiguration()
	{
		Board testBoard = new Board();
		testBoard.setConfiguration(3);
		assertEquals(testBoard.getConfiguration(),3);	
	}
	
	@Test
	void testFindPieceIndex()
	{
		Board testBoard = new Board();
		assertEquals(testBoard.findPieceIndex(3, 2),5);
		assertEquals(testBoard.findPieceIndex(7, 4),-1);
		
		
	}
	
	@Test
	void testcheckWin()
	{
		Board testBoard = new Board();
		assertEquals(testBoard.getWin(),false);
	}
	

}
