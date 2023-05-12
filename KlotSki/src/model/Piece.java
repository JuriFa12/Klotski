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
    //aggiorna la posizione del pezzo aggiornato
    public void move(int x, int y)
    {
        this.coordinate_x = x;
        this.coordinate_y = y;

    }

    public int[] get_dimensions()
    {
      int[] dimensions = new int[] {coordinate_x, coordinate_y, height, width};
      return dimensions;
    }



    
    
}
