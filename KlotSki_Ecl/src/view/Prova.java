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
import model.Board;
import model.Piece;
import controller.ResetController;
import controller.SetConfigurationController;
import controller.SelectPieceController;



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

		//Creo lo stage e tutto il resto
		Button reset = new Button ();
		Button config1 = new Button ();
		Button config2 = new Button ();
		Button config3 = new Button ();
		
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
		Scene scene = new Scene(root, Color.SIENNA);
		Image icon = new Image ("Klotski.png");
		
		
		
		/*funziona
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = pieces[i].getDimensions();
			Rectangle a = new Rectangle();
			a.setX(dimensions[1]*block);
			a.setY(dimensions[0]*block);
			a.setHeight(dimensions[2]*block);
			a.setWidth(dimensions[3]*block);
			
			
			a.setFill(Color.WHITE);
			a.setStrokeWidth(3);
			a.setStroke(Color.BLACK);
			
			root.getChildren().add(a);
		}
		*/
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
		//Inserisce i bottoni nella scena
		root.getChildren().add(reset);
		root.getChildren().add(config1);
		root.getChildren().add(config2);
		root.getChildren().add(config3);
		

		
	       a[0].setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t)
	            {
	            	for (int i = 0; i < 10; i++)
	            		a[i].setFill(Color.WHITE);
	            	
	                a[0].setFill(Color.RED);
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
	            		a[i].setFill(Color.WHITE);
	            	
	                a[1].setFill(Color.RED);
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
	            		a[i].setFill(Color.WHITE);
	            	
	                a[2].setFill(Color.RED);
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
	            		a[i].setFill(Color.WHITE);
	            	
	                a[3].setFill(Color.RED);
	                SelectPieceController c = new SelectPieceController();
	                c.selectPiece(game, 3);
	            }
	        });

	       
	    reset.setOnAction(new EventHandler<ActionEvent>() 
	    {
	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 ResetController c = new ResetController();
	        	 c.reset(a, game, root);
	         }
	         
  
	       });
	    
	    config1.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,1);

	          }
	       });
	    
	    config2.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,2);

	          }
	       });
	    
	    
	    config3.setOnAction(new EventHandler<ActionEvent>() {

	         @Override
	           
	         public void handle(ActionEvent event)
	         {
	        	 SetConfigurationController c = new SetConfigurationController();
	        	 c.setConfiguration(game,a,root,3);

	          }
	       });
	    
	    a[9].setOnMouseDragged(e -> {
	        if (a[9].contains(e.getX(), e.getY())) 
	        {
	        	boolean flag=false;
	        	for (int i = 0; i < 10 && i != 9; i++)
	        	{
	        		if (a[i].contains(e.getX(),e.getY()))
	        				flag=true;
	        		
	        	}
	        	if (flag == false)
	        	{
	        		a[9].setX(e.getX() -50/2 );
	        		a[9].setY(e.getY() -60/2);
	        	}
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