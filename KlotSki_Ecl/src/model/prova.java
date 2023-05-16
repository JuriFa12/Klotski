package model;


public class prova 
{
    public static void main(String[] args )
    {    
        Board a = new Board();
        //int [] b= a.pieces[6].get_dimensions();
        //System.out.println(b[1]);
        Piece [] b = a.getPieces();
        
        for (int i = 0; i < 10; i++)
        {
        	int [] c = b[i].getDimensions();
        	System.out.print(c[0]+" "+c[1]+" "+c[2]+" "+c[3]+"\n");
        }
        
    }
    
}
