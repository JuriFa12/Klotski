package model;

import controller.*;

import javafx.scene.shape.*;
import javafx.scene.Group;


public class prova 
{
    public static void main(String[] args )
    {   
    	Rectangle [] r = new Rectangle [10];
    	Group root = new Group ();
        Board a = new Board();
        Piece [] pieces = a.getPieces();
		for (int i = 0; i < 10; i++)
		{
			int [] dimensions = pieces[i].getDimensions();
			r[i] = new Rectangle(dimensions[1]*100,dimensions[0]*100,dimensions[3]*100,dimensions[2]*100);

		}
		System.out.println(r[1].getY());
        ResetController d = new ResetController();
        d.reset (r,a,root);
        System.out.println(r[1].getY());

       
        
    }
    
}
