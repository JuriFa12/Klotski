package controller;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovePieceControllerTest 
{
	public MovePieceControllerTest()
	{
		
	}

    private MovePieceController movePieceController;
    private Rectangle[] pieces;
    private Board game;
    private Group root;
    private Text move;
    private Text win;
    private Piece [] testPiece;

    @Before
    public void setUp() 
    {
        movePieceController = new MovePieceController();
        pieces = new Rectangle[10];
        game = new Board();
        root = new Group();
        move = new Text();
        win = new Text();
        testPiece = game.getPieces();
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = testPiece[i].getDimensions();
			pieces[i] = new Rectangle(dimensions[1]*100,dimensions[0]*100,dimensions[3]*100,dimensions[2]*100);
	
			pieces[i].setFill(Color.WHITE);
			pieces[i].setStrokeWidth(3);
			pieces[i].setStroke(Color.BLACK);
			root.getChildren().add(pieces[i]);
		}
    }

    @Test
    public void testMove() {
        // Simulazione di un caso di test

        // Verifica dello stato iniziale prima della mossa
        assertEquals(0, game.getMoves());
        assertNull(game.getSelected());
        assertFalse(root.getChildren().contains(move));
        assertFalse(root.getChildren().contains(win));
        game.setSelected(4);

        // Esegui la mossa
        movePieceController.move(pieces, game, root, 1, move, win);

        // Verifica dello stato dopo la mossa
        assertEquals(1, game.getMoves());
        assertNull(game.getSelected());
        assertTrue(root.getChildren().contains(move));
        assertFalse(root.getChildren().contains(win));

        // ... continuare con ulteriori verifiche
    }
}