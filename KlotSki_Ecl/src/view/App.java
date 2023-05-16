package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import model.Board;
import model.Piece;



public class App extends Application
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
		Group root = new Group ();
		Scene scene = new Scene(root, Color.SIENNA);
		Image icon = new Image ("Klotski.png");
		
		Text text = new Text();
		text.setText("Klotski");
		text.setX(50);
		text.setY(50);
		text.setFont(Font.font("Aerial",50));
		text.setFill(Color.ANTIQUEWHITE);
		
		
		/*
		Line line = new Line();
		line.setStartX(200);
		line.setStartY(200);
		line.setEndX(0);
		line.setEndY(200);
		line.setStrokeWidth(5);
		*/
		
		root.getChildren().add(text);
		//larghezza ed altezza di un blocco
		int block = 100;
		//root.getChildren().add(line);
		
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
		
		
		
		
		stage.getIcons().add(icon);
		stage.setTitle("Klotski");
		stage.setHeight(4*200);
		stage.setWidth(4*150);
		stage.setResizable(false);
		//stage.setFullScreen(true);
		
		
		stage.setScene(scene);
		stage.show();
	}

}