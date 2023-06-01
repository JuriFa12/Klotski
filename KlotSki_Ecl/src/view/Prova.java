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



public class Prova extends Application
{
	public static void main (String [] args)
	{
		launch(args);
	}



	@Override

	public void start (Stage stage) throws Exception
	{
		Board game = new Board();
		Piece [] pieces = game.getPieces();
		int block = 100;
		
		File savings = new File ("Save.txt");
		


		//Creo lo stage e tutto il resto
		Button reset = new Button ();
		Button config1 = new Button ();
		Button config2 = new Button ();
		Button config3 = new Button ();
		Button up = new Button ();
		Button down = new Button ();
		Button left = new Button ();
		Button right = new Button ();
		Button undo = new Button ();
		Button save = new Button ();
		Button load = new Button ();
		Button resolve = new Button ();
		
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
	    
	    
		Group root = new Group ();
		Scene scene = new Scene(root, Color.LIGHTCYAN);
		Image icon = new Image ("Klotski.png");
		
		Text t = new Text (30, 20, "Moves: " + game.getMoves());
		t.setFont(new Font(20));
		t.setX(100);
		t.setY(650);//55
		
		Text win = new Text (300,650,"You won!");
		win.setFont(new Font(50));
		
		Text configuration = new Text (180,70, "Configuration " + game.getConfiguration());
		configuration.setFont(new Font(35));
	
		
		//Array che rappresenta i pezzi
		Rectangle [] a = new Rectangle [10];
		//Setta il contorno dei pezzi
		Rectangle border = new Rectangle(1*block,1*block,4*block,5*block);
		border.setStrokeWidth(10);
		border.setStroke(Color.ORANGE);
		border.setFill(Color.BISQUE);
		root.getChildren().add(border);
		
		//Crea i rettangoli e li inserisce nella scena
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = pieces[i].getDimensions();
			a[i] = new Rectangle(dimensions[1]*block,dimensions[0]*block,dimensions[3]*block,dimensions[2]*block);
	
			a[i].setFill(Color.WHITE);
			a[i].setStrokeWidth(3);
			a[i].setStroke(Color.BLACK);
			root.getChildren().add(a[i]);
		}
		a[1].setFill(Color.DARKRED);
		//Inserisce i bottoni nella scena
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
	            			a[i].setFill(Color.DARKRED);
	            	
	            	}
	                a[0].setFill(Color.LIGHTGREY);
	                
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 0);
	            }
	        });
	       
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
	            	a[1].setFill(Color.FIREBRICK);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 1);
	            }
	        });
	       
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[2].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 2);
	            }
	        });
	       
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[3].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 3);
	            }
	        });
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[4].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 4);
	            }
	        });
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[5].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 5);
	            }
	        });
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[6].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 6);
	            }
	        });
	       
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[7].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 7);
	            }
	        });
	       
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[8].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 8);
	            }
	        });
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
	            			a[i].setFill(Color.DARKRED);
	            	}
	            	
	                a[9].setFill(Color.LIGHTGREY);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 9);
	            }
	        });

	       
	    reset.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 ResetController c = new ResetController();
	        	 c.reset(a, game, root,t,win);
	         }
	         
  
	       });
	    
	    config1.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,1,t,win,configuration);

	          }
	       });
	    
	    config2.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,2,t,win,configuration);

	          }
	       });
	    
	    
	    config3.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game, a, root, 3, t, win, configuration);

	          }
	       });
	    
	    left.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,2,t,win); //2 numero per sinistra

	         }
	         
  
	       });
	    right.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,3,t,win); //3 numero per destra
	         }
	         
  
	       });
	    
	    up.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root,0,t,win); //0 numero per sopra
	         }
	         
  
	      });
	    
	    down.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 MovePieceController c = new MovePieceController();
	        	 c.move(a, game, root, 1, t, win); //1 numero per sotto
	         }
	         
	    });
	    
	    undo.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 UndoController c = new UndoController();
	        	 c.undo(a, game, root, t,win); 
	         }
	         
	    });
	    
	    save.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SaveController c = new SaveController ();
	        	 c.save(game,savings);
	         }
	         
  
	      });
	    
	    load.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 LoadController c = new LoadController ();
	        	 c.load(game,t,root,a,savings);
	         }
	         
	         
  
	      });
	    
	    resolve.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 NextBestMoveController c = new NextBestMoveController ();
	        	 c.resolve(game, root, t, a,win, 1);
	         }
	         
  
	      });
	    
	         
  

		
		
		//modifico lo stage
		stage.getIcons().add(icon);
		stage.setTitle("Klotski");
		stage.setHeight(4*200);
		stage.setWidth(4*200);
		stage.setResizable(false);
		//stage.setFullScreen(true);
		
		//mostro lo stage		
		stage.setScene(scene);
		stage.show();
	}

}