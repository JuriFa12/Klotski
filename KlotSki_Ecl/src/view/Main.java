package view;

import javafx.application.Application;




import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import model.Board;
import model.Piece;
import controller.ResetController;
import controller.SetConfigurationController;
import controller.SelectPieceController;
import controller.MovePieceController;
import controller.UndoController;
import controller.SaveController;
import controller.LoadController;
import controller.NextBestMoveController;
import java.io.File;   


//Classe main, collega i controllori con il lato grafico del progetto
public class Main extends Application
{
	public static void main (String [] args)
	{
		launch(args);
	}

	@Override
	public void start (Stage stage) throws Exception
	{
		//crea un nuovo gioco
		Board game = new Board();
		Piece [] pieces = game.getPieces();
		int block = 100;
		
		//File usato per salvare i progressi
		File savings = new File ("Save.txt");
		


		//Creo i pulsanti 
		
		//Pulsante reset
		Button reset = new Button ();
		
		//Pulsanti per le tre diverse configurazioni possibili
		Button config1 = new Button ();
		Button config2 = new Button ();
		Button config3 = new Button ();
		
		//Pulsanti per muovere un pezzo
		Button up = new Button ();
		Button down = new Button ();
		Button left = new Button ();
		Button right = new Button ();
		
		//Pulsante per ripristinare la mossa precedente
		Button undo = new Button ();
		
		//Pulsante per salvare il gioco
		Button save = new Button ();
		
		//Pulsante per caricare il gioco salvato
		Button load = new Button ();
		
		//Pulsante per la risoluzione del gioco
		Button resolve = new Button ();
		
		//Posizione dei pulsanti nella scena
		undo.setText("Undo");
		undo.setTranslateX(450);
		undo.setTranslateY(700);
		
		resolve.setText("Best Move");
		resolve.setTranslateX(550);
		resolve.setTranslateY(500);
		
		save.setText("Save");
		save.setTranslateX(700);
		save.setTranslateY(150);
		
		load.setText("Load");
		load.setTranslateX(700);
		load.setTranslateY(200);
	
		right.setText("Right");
		right.setTranslateX(700);
		right.setTranslateY(700);
		
		left.setText("Left");
		left.setTranslateX(600);
		left.setTranslateY(700);
		
		up.setText("Up");
		up.setTranslateX(652);
		up.setTranslateY(667);
		
		down.setText("Down");
		down.setTranslateX(645);
		down.setTranslateY(700);
		
		
		reset.setText("Reset the game ");
		reset.setTranslateX(100);
	    reset.setTranslateY(700);
	    
	    config1.setText("Configuration 1 ");
		config1.setTranslateX(550);
	    config1.setTranslateY(150);
	    
	    config2.setText("Configuration 2 ");
		config2.setTranslateX(550);
	    config2.setTranslateY(250);
	    
	    config3.setText("Configuration 3 ");
		config3.setTranslateX(550);
	    config3.setTranslateY(350);
	    
	    //Crea la scena e seleziona lo sfondo
		Group root = new Group ();
		Scene scene = new Scene(root, Color.LIGHTCYAN);
		
		//Icona della finestra 
		Image icon = new Image ("Klotski.png");
		
		//Output del numero di mosse
		Text t = new Text (30, 20, "Moves: " + game.getMoves());
		t.setFont(new Font(20));
		t.setX(100);
		t.setY(650);//55
		
		//Potenziale output del segnale di vittoria
		Text win = new Text (300,650,"You won!");
		win.setFont(new Font(50));
		
		//Output della configurazione selezionata
		Text configuration = new Text (180,70, "Configuration " + game.getConfiguration());
		configuration.setFont(new Font(35));
	
		
		//Array che rappresenta i pezzi di gioco
		Rectangle [] a = new Rectangle [10];
		
		//Crea e Posiziona la tavola nella scena
		Rectangle border = new Rectangle(1*block,1*block,4*block,5*block);
		border.setStrokeWidth(10);
		border.setStroke(Color.ORANGE);
		border.setFill(Color.BISQUE);
		root.getChildren().add(border);
		
		//Ciclo che posiziona ogni pezzo nella scena
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = pieces[i].getDimensions();
			a[i] = new Rectangle(dimensions[1]*block,dimensions[0]*block,dimensions[3]*block,dimensions[2]*block);
	
			a[i].setFill(Color.WHITE);
			a[i].setStrokeWidth(3);
			a[i].setStroke(Color.BLACK);
			root.getChildren().add(a[i]);
		}
		a[1].setFill(Color.FIREBRICK);
		
		//Inserisce tutti i pulsanti nella scena
		root.getChildren().add(reset);
		root.getChildren().add(config1);
		root.getChildren().add(config2);
		root.getChildren().add(config3);
		root.getChildren().add(up);
		root.getChildren().add(down);
		root.getChildren().add(left);
		root.getChildren().add(right);
		root.getChildren().add(t);
		root.getChildren().add(undo);
		root.getChildren().add(save);
		root.getChildren().add(load);
		root.getChildren().add(resolve);
		root.getChildren().add(configuration);
		

		//Gestisce la selezione del primo pezzo da parte dell'utente
	       a[0].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t)
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	
	            	}
	                a[0].setFill(Color.LIGHTGREY);
	                
	                //Crea e chiama il controllore per la selezione del pezzo
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 0);
	            }
	        });
	       
	     //Gestisce la selezione del secondo pezzo da parte dell'utente
	       a[1].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		
	            	}
	            	a[1].setFill(Color.DARKRED);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 1);
	            }
	        });
	       
	     //Gestisce la selezione del terzo pezzo da parte dell'utente
	       a[2].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	         
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[2].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 2);
	            }
	        });
	       
	     //Gestisce la selezione del quarto pezzo da parte dell'utente
	       a[3].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[3].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 3);
	            }
	        });
	       
	     //Gestisce la selezione del quinto pezzo da parte dell'utente
	       a[4].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[4].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 4);
	            }
	        });
	       
	     //Gestisce la selezione del sesto pezzo da parte dell'utente
	       a[5].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[5].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 5);
	            }
	        });
	       
	     //Gestisce la selezione del settimo pezzo da parte dell'utente
	       a[6].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[6].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 6);
	            }
	        });
	       
	     //Gestisce la selezione dell'ottavo pezzo da parte dell'utente
	       a[7].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[7].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 7);
	            }
	        });
	       
	     //Gestisce la selezione del nono pezzo da parte dell'utente
	       a[8].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[8].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 8);
	            }
	        });
	       
	     //Gestisce la selezione del decimo pezzo da parte dell'utente
	       a[9].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) 
	            {
	            	for (int i = 0; i < 10; i++)
	            	{
	            		if (i != 1)
	            		a[i].setFill(Color.WHITE);
	            		else
	            			a[i].setFill(Color.FIREBRICK);
	            	}
	            	
	                a[9].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 9);
	            }
	        });

	    //Gestisce il funzionamento del pulsante reset
	    reset.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il reset controller
	        	 ResetController c = new ResetController();
	        	 c.reset(a, game, root,t,win);
	         }
	         
  
	       });
	    
	    //Gestisce il funzionamento del pulsante per la prima configurazione
	    config1.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il SetConfiguration controller
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,1,t,win,configuration);

	          }
	       });
	    
	  //Gestisce il funzionamento del pulsante per la seconda configurazione
	    config2.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il SetConfiguration controller
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,2,t,win,configuration);

	          }
	       });
	    
	    //Gestisce il funzionamento del pulsante per la terza configurazione
	    config3.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il SetConfiguration controller
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game, a, root, 3, t, win, configuration);

	          }
	       });
	    
	    //Gestisce il funzionamento del pulsante per muovere a sinistra il pezzo selezionato
	    left.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il MovePiece controller
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,2,t,win); //2 è il numero per la direzione a sinistra

	         }
	         
  
	       });
	    
	    //Gestisce il funzionamento del pulsante per muovere a destra il pezzo selezionato
	    right.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il MovePiece Controller
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,3,t,win); //3 è il numero per la direzione a destra
	         }
	         
  
	       });
	    //Gestisce il funzionamento del pulsante per muovere in alto il pezzo selezionato
	    up.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il MovePiece Controller
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,0,t,win); //0 è il numero per la direzione in alto
	         }
	         
  
	      });
	    //Gestisce il funzionamento del pulsante per muovere in basso il pezzo selezionato
	    down.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il MovePiece controller
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root, 1, t, win); //1 numero per sotto
	         }
	         
	    });
	    
	    //Gestisce il funzionamento del pulsante per ripristinare alla mossa precedente
	    undo.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama l'Undo controller
	        	 UndoController c = new UndoController();
	        	 c.undo(a, game, root, t,win); 
	         }
	         
	    });
	    
	    //Gestisce il funzionamento del pulsante per salvare la partita
	    save.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il Save Controller
	        	 SaveController c = new SaveController ();
	        	 c.save(game,savings);
	         }
	         
  
	      });
	    //Gestisce il funzionamento del pulsante per caricare una partita precedentemente salvata
	    load.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il Load controller
	        	 LoadController c = new LoadController ();
	        	 c.load(game,t,root,a,savings);
	         }
	         
	         
  
	      });
	    //Gestisce il funzionamento del pulsante risolvere il gioco
	    resolve.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 //Crea e chiama il NextBestMove controller
	        	 NextBestMoveController c = new NextBestMoveController ();
	        	 c.resolve(game, root, t, a,win);
	         }
	         
  
	      });
	    
	         
  

		
		
		//Modifica lo stage aggiungendo l'icona, il titolo e le dimensioni
		stage.getIcons().add(icon);
		stage.setTitle("Klotski");
		stage.setHeight(4*200);
		stage.setWidth(4*200);
		stage.setResizable(false);
		
		//Mostro lo stage		
		stage.setScene(scene);
		stage.show();
	}

}