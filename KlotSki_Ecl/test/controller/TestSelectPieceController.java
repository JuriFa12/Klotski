package controller;


import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSelectPieceController {

	@Test
	void testSelectPieceController() 
	{
		Board testBoard = new Board();
		SelectPieceController testController = new SelectPieceController();
		assertNull(testBoard.getSelected());
		
		testController.selectPiece(testBoard, 6);
		Piece testSelected = testBoard.getSelected();
		
		int [] n = testSelected.getDimensions();
		assertEquals(n[0],3);
		assertEquals(n[1],4);
		assertEquals(n[2],2);
		assertEquals(n[3],1);

	}

}
