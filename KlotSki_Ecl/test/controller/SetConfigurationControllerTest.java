package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;

public class SetConfigurationControllerTest 
{
	public SetConfigurationControllerTest()
	{
		
	}

    @Test
    public void test() {
        // Creazione degli oggetti necessari per il test
        Rectangle[] testRectangle = new Rectangle[10];
        Group testRoot = new Group();
        Board testBoard = new Board();
        Piece[] testPieces = new Piece[10];
        Text testWin = new Text();
        Text testMoves = new Text();
        SetConfigurationController testConfig = new SetConfigurationController();
        Text testConfiguration = new Text();

        // Configurazione dei pezzi di test
        testPieces[0] = new Piece(1, 1, 2, 1);
        testPieces[1] = new Piece(1, 2, 2, 2);
        testPieces[2] = new Piece(1, 4, 1, 1);
        testPieces[3] = new Piece(2, 4, 1, 1);
        testPieces[4] = new Piece(3, 1, 2, 1);
        testPieces[5] = new Piece(3, 2, 1, 2);
        testPieces[6] = new Piece(3, 4, 2, 1);
        testPieces[7] = new Piece(4, 2, 1, 1);
        testPieces[8] = new Piece(4, 3, 2, 1);
        testPieces[9] = new Piece(5, 2, 1, 1);

        // Creazione dei rettangoli di test
        for (int i = 0; i < 10; i++) {
            int[] dimensions = testPieces[i].getDimensions();
            testRectangle[i] = new Rectangle(dimensions[1] * 100, dimensions[0] * 100, dimensions[3] * 100,
                    dimensions[2] * 100);
            testRectangle[i].setFill(Color.WHITE);
            testRectangle[i].setStrokeWidth(3);
            testRectangle[i].setStroke(Color.BLACK);
            testRoot.getChildren().add(testRectangle[i]);
        }

        // Esecuzione del metodo da testare
        testConfig.setConfiguration(testBoard, testRectangle, testRoot, 1, testMoves, testWin, testConfiguration);

        // Verifica degli stati attesi
        assertEquals(0, testBoard.getMoves());
        assertArrayEquals(testBoard.getPieces(), testPieces);
        assertFalse(testBoard.checkWin());
    }
}