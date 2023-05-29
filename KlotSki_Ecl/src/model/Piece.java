package model;


public class Piece 
{
    //variabili di esemplare per le varie posizioni
    int coordinate_x;
    int coordinate_y;
    int width;
    int height;


    //costruttore 
    public Piece(int x, int y, int a, int l)
    {
        if (x <= 0 || y <= 0 || l < 1 || a < 1)
            throw new IllegalArgumentException("Values are not valid");

        this.coordinate_x = x;
        this.coordinate_y = y;
        this.height = a;
        this.width = l;
    }
    public Piece (Piece a)
    {
    	int [] dimensions = a.getDimensions();
    	this.coordinate_x = dimensions[0];
    	this.coordinate_y = dimensions[1];
    	this.height = dimensions[2];
    	this.width = dimensions[3];
    }
    //aggiorna la posizione del pezzo aggiornato
    public void move(int x, int y)
    {
        this.coordinate_x = x;
        this.coordinate_y = y;

    }

    public int[] getDimensions()
    {
      int[] dimensions = new int[] {coordinate_x, coordinate_y, height, width};
      return dimensions;
    }



    
    
}
