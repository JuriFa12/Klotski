package controller;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Piece;



public class SetConfigurationController
{	
	public void setConfiguration (Board game, Rectangle [] pieces, Group root, int config, Text moves)
	{
		game.reset();
		game.setConfiguration(config);
		game.setPieces();
		root.getChildren().remove(moves);
		moves.setText("Moves:" + game.getMoves());

		
		Piece [] puzzle = game.getPieces();
		
		for (int i = 0; i < 10; i++)
		{
			root.getChildren().remove(pieces[i]);
		}
		
		
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = puzzle[i].getDimensions();
			
			//pieces[i] = new Rectangle(dimensions[1]*100,dimensions[0]*100,dimensions[3]*100,dimensions[2]*100);
			pieces[i].setX(dimensions[1]*100);
			pieces[i].setY(dimensions[0]*100);
			pieces[i].setHeight(dimensions[2]*100);
			pieces[i].setWidth(dimensions[3]*100);
			pieces[i].setFill(Color.WHITE);
			pieces[i].setStrokeWidth(3);
			pieces[i].setStroke(Color.BLACK);
			
			root.getChildren().add(pieces[i]);
		}
		root.getChildren().add(moves);
		pieces[1].setFill(Color.DARKRED);
		
	}

}