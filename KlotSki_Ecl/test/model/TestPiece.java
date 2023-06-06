package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPiece {

	@Test
	// Test del costruttore di Piece
	public void testPiece() {
		// Crea due istanze di Piece
		new Piece(0, 1, 2, 2);
		new Piece(1, 2, 2, 2);
	}

	@Test
	// Test del costruttore di Piece e del metodo getDimensions
	public void testPiece2() {
		// Crea un'istanza di Piece
		Piece a = new Piece(1, 1, 2, 2);
		int[] n = a.getDimensions();
		
		// Crea un'altra istanza di Piece utilizzando i valori restituiti da getDimensions
		Piece testPiece = new Piece(n[0], n[1], n[2], n[3]);
		int[] dimensions = testPiece.getDimensions();
		
		// Verifica che le dimensioni siano corrette
		assertEquals(dimensions[0], 1);
		assertEquals(dimensions[1], 1);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 2);
	}

	@Test
	// Test del metodo move
	public void testMove() {
		// Crea un'istanza di Piece
		Piece testPiece = new Piece(1, 1, 2, 2);
		testPiece.move(1, 2);
		
		// Ottiene le dimensioni dopo lo spostamento
		int[] dimensions = testPiece.getDimensions();
		
		// Verifica che le dimensioni siano corrette dopo lo spostamento
		assertEquals(dimensions[0], 1);
		assertEquals(dimensions[1], 2);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 2);
	}

	@Test
	// Test del metodo getDimensions
	public void testGetDimensions() {
		// Crea un'istanza di Piece
		Piece testPiece = new Piece(1, 1, 2, 1);
		int[] dimensions = testPiece.getDimensions();
		
		// Verifica che le dimensioni siano corrette
		assertEquals(dimensions[0], 1);
		assertEquals(dimensions[1], 1);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 1);
	}

}
