package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.Board;
import model.Piece;

public class LoadControllerTest 
{
	public LoadControllerTest()
	{
		
	}

    @Test
    public void testLoad() {
        // Creazione degli oggetti necessari per il test
        Board game = new Board();
        Text moves = new Text();
        Group root = new Group();
        Rectangle[] pieces = new Rectangle[10];
        File save = new File("Test.txt");
        LoadController controller = new LoadController();

        // Simulazione del file di salvataggio con dati di esempio
        String fileContent = "1\n"
        		+ "5\n"
        		+ "2 1 2 1\n"
        		+ "1 2 2 2\n"
        		+ "1 4 1 1\n"
        		+ "2 4 1 1\n"
        		+ "4 1 2 1\n"
        		+ "3 2 1 2\n"
        		+ "4 4 2 1\n"
        		+ "4 2 1 1\n"
        		+ "4 3 2 1\n"
        		+ "5 2 1 1\n";
        //Array di pezzi da confrontare per confermare che lo stato della tavola di gioco sia esatto
        Piece [] testPiece = new Piece [10];
        testPiece[0] = new Piece (2,1,2,1);
        testPiece[1] = new Piece (1,2,2,2);
        testPiece[2] = new Piece (1,4,1,1);
        testPiece[3] = new Piece (2,4,1,1);
        testPiece[4] = new Piece (4,1,2,1);
        testPiece[5] = new Piece (3,2,1,2);
        testPiece[6] = new Piece (4,4,2,1);
        testPiece[7] = new Piece (4,2,1,1);
        testPiece[8] = new Piece (4,3,2,1);
        testPiece[9] = new Piece (5,2,1,1);
        // Salvataggio dei dati nel file
        try {
            FileWriter fileWriter = new FileWriter(save);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Chiamata al metodo da testare
        controller.load(game, moves, root, pieces, save);

        // Verifica che il gioco sia stato caricato correttamente
        assertEquals(5, game.getMoves());
        assertEquals(1,game.getConfiguration());
        assertArrayEquals(testPiece, game.getPieces());
        
        // Rimozione del file di salvataggio dopo il test
        save.delete();
    }
}