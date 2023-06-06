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

public class MovePieceControllerTest {

    private MovePieceController movePieceController;
    private Rectangle[] pieces;
    private Board game;
    private Group root;
    private Text move;
    private Text win;

    @Before
    public void setUp() {
        movePieceController = new MovePieceController();
        pieces = new Rectangle[10];
        game = new Board();
        root = new Group();
        move = new Text();
        win = new Text();
    }

    @Test
    public void testMove() {
        // Simulazione di un caso di test

        // Verifica dello stato iniziale prima della mossa
        assertEquals(0, game.getMoves());
        assertNull(game.getSelected());
        assertFalse(root.getChildren().contains(move));
        assertFalse(root.getChildren().contains(win));

        // Esegui la mossa
        movePieceController.move(pieces, game, root, 1, move, win);

        // Verifica dello stato dopo la mossa
        assertEquals(1, game.getMoves());
        assertNotNull(game.getSelected());
        assertTrue(root.getChildren().contains(move));
        assertFalse(root.getChildren().contains(win));

        // ... continuare con ulteriori verifiche
    }
}