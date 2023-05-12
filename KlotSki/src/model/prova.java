package model;


public class prova 
{
    public static void main(String[] args )
    {    
        Board a = new Board();
        a.set_pieces(1);
        //int [] b= a.pieces[6].get_dimensions();
        //System.out.println(b[1]);
        int search= a.find_piece_index(2,3);
        System.out.println(search);
    }
    
}
