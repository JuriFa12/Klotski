package model;

//Classe che rappresenta i pezzi posizionati sopra la tabella di gioco
public class Piece 
{
    //variabili di esemplare
	//Le prime due coordinate si riferiscono al punto in alto a sinistra del pezzo, le altre due si riferiscono a larghezza ed altezza
    int coordinate_x;
    int coordinate_y;
    int width;
    int height;
    
    //Costruttore che riceve 4 valori interi 
    public Piece(int x, int y, int a, int l)
    {
        this.coordinate_x = x;
        this.coordinate_y = y;
        this.height = a;//altezza
        this.width = l;//lunghezza
    }
    
    //Costruttore che riceve un altro elemento delle stessa classe
    public Piece (Piece a)
    {
    	int [] dimensions = a.getDimensions();
    	this.coordinate_x = dimensions[0];
    	this.coordinate_y = dimensions[1];
    	this.height = dimensions[2];
    	this.width = dimensions[3];
    }
    
    //Aggiorna la posizione del pezzo mosso
    public void move(int x, int y)
    {
        this.coordinate_x = x;
        this.coordinate_y = y;
    }
    
    //Ritorna un Array contenenti le variabili di esemplare del Pezzo
    public int[] getDimensions()
    {
      int[] dimensions = new int[] {coordinate_x, coordinate_y, height, width};
      return dimensions;
    }
    
    @Override
    //Override del metodo "==" per oggetti di tipo "Piece"
    public boolean equals(Object o) 
    {
        if (!(o instanceof Piece))
        {
            return false;
        }
        else
        {
        	Piece a = (Piece) o;
        	int [] n = a.getDimensions();
        	if (this.coordinate_x == n[0] && this.coordinate_y == n[1] && this.height == n[2] && this.width == n[3])
        		return true;
        	else return false;
        }	
    }    
}
