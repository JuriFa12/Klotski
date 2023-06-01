package model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
	void testSetPiecesAndGetData()
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
	void testSetAndGetConfiguration()
	{
		Board testBoard = new Board();
		assertEquals(testBoard.getConfiguration(),1);
		testBoard.setConfiguration(3);
		assertEquals(testBoard.getConfiguration(),3);	
	}
	
	@Test 
	void testSetConfigurationException()
	{
		Board testBoard = new Board();
		Assertions.assertThrows(IllegalArgumentException.class, () -> testBoard.setConfiguration(4));
		Assertions.assertThrows(IllegalArgumentException.class, () -> testBoard.setConfiguration(-2));
		
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
		assertEquals(testBoard.checkWin(),false);
	}
	
	@Test
	void testGetPieces ()
	{
		Board testBoard = new Board();
		assertEquals(10,testBoard.getPieces().length);
	}
	
	@Test
	void testSetAndGetSelected()
	{
		Board testBoard = new Board();
		Piece testSelected = testBoard.getSelected();
		assertNull (testSelected);
		
		testBoard.setSelected(2);
		testSelected = testBoard.getSelected();
		int [] n = testSelected.getDimensions();
		assertEquals(n[0],1);
		assertEquals(n[1],4);
		assertEquals(n[2],1);
		assertEquals(n[3],1);
	}
	
	@Test
	void testReset()
	{
		Board testBoard = new Board();
		testBoard.selectPiece(5, 2);
		testBoard.movePiece(2);
		assertEquals(1,testBoard.getMoves());

		
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
	void testAvailable()
	{
		Board testBoard = new Board();
		assertTrue(testBoard.isAvaible(5, 1));
		
		testBoard.setSelected(9);
		testBoard.movePiece(2);
		assertFalse(testBoard.isAvaible(5, 1));
	}
	
	@Test
	void testOutOfBounds()
	{
		Board testBoard = new Board();
		assertTrue(testBoard.isOutOfBounds(6, 1, 1, 1));
		assertFalse(testBoard.isOutOfBounds(5, 1, 1, 1));
		assertTrue(testBoard.isOutOfBounds(5, 4, 2, 1));

	}
	
	@Test
	void testMovePieceAndGetMoves()
	{
		Board testBoard = new Board();
		assertFalse(testBoard.movePiece(0));
		
		testBoard.setSelected(9);
		assertTrue(testBoard.movePiece(2));
		assertEquals(1,testBoard.getMoves());
		assertEquals(1,testBoard.getUndoState());
		assertFalse(testBoard.movePiece(0));
		
		testBoard.setSelected(8);
		assertFalse(testBoard.movePiece(0));
		
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
	void testUndo()
	{
		Board testBoard = new Board();
		testBoard.setSelected(9);
		testBoard.movePiece(2);
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
        
        assertArrayEquals(testBoard.getPieces(),testPieces);
		
	}
	
	@Test
	void testLoadAndGetUndoState()
	{
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
        
        testBoard.load(testMoves, testPieces);
        assertEquals(testBoard.getMoves(),testMoves);
        assertEquals(testBoard.getUndoState(),0);
        assertArrayEquals(testPieces,testBoard.getPieces());
        
        
		
	}
	
	
	
	
	
	

}
