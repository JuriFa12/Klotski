package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.junit.Test;

import model.Board;

public class SaveControllerTest 
{
	public SaveControllerTest()
	{
		
	}
	
	@Test
	public void testSave(){
		// Creazione della board di test e del file di destinazione
		Board testBoard = new Board();
		File Test = new File("test.txt");
		
		// Creazione del controller e salvataggio della board nel file
		SaveController controller = new SaveController();
		controller.save(testBoard, Test);
		
		try {
			// Stringa di confronto per il contenuto atteso del file
			String notController = "1\n"
					+ "0 \n"
					+ "1 1 2 1\n"
					+ "1 2 2 2\n"
					+ "1 4 1 1\n"
					+ "2 4 1 1\n"
					+ "3 1 2 1\n"
					+ "3 2 1 2\n"
					+ "3 4 2 1\n"
					+ "4 2 1 1\n"
					+ "4 3 2 1\n"
					+ "5 2 1 1\n";
			
			// Leggi il contenuto del file generato dal controller
			byte[] fileBytes = Files.readAllBytes(Test.toPath());
            String fromController = new String(fileBytes, StandardCharsets.UTF_8);
            
            // Confronta la stringa di confronto con il contenuto del file
            assertEquals(notController, fromController);
            
		} catch (IOException e) {
		}
	}
}
