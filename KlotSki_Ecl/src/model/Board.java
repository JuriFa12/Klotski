package model;

public class Board 
{
    

    
    //variabili di esemplare
    Piece [] pieces;
    Piece selected;
    int height;
    int width;
    int configuration;
    int moves;
    boolean win;

    //costruttore iniziale
    public Board ()
    {
        this.pieces = new Piece [10];
        this.height = 5;
        this.width = 4;
        this.configuration = 1;
        this.moves = 0;
        this.win=false;
        this.setPieces();

    }
    //setta le coordinate dei pezzi una volta scelta la configurazione
    public void setPieces()
    {
        if (configuration == 1)
        {
            pieces[0] = new Piece(1,1,2,1);
            pieces[1] = new Piece(1,2,2,2);
            pieces[2] = new Piece(1,4,2,1);
            pieces[3] = new Piece(3,1,2,1);
            pieces[4] = new Piece(3,2,1,2);
            pieces[5] = new Piece(4,2,1,1);
            pieces[6] = new Piece(4,3,1,1);
            pieces[7] = new Piece(3,4,2,1);
            pieces[8] = new Piece(5,1,1,1);
            pieces[9] = new Piece(5,4,1,1);
            return;
        }
        else 
        {
            if (configuration == 2)
            {
                pieces[0] = new Piece(1,1,2,1);
                pieces[1] = new Piece(1,2,2,2);
                pieces[2] = new Piece(1,4,1,1);
                pieces[3] = new Piece(2,4,1,1);
                pieces[4] = new Piece(3,1,2,1);
                pieces[5] = new Piece(3,2,1,2);
                pieces[6] = new Piece(3,4,2,1);
                pieces[7] = new Piece(4,2,1,1);
                pieces[8] = new Piece(4,3,2,1);
                pieces[9] = new Piece(5,2,1,1);
                return;
            }
            else
            {
                if (configuration == 3)
                {
                    pieces[0] = new Piece(1,1,1,1);
                    pieces[1] = new Piece(1,2,2,2);
                    pieces[2] = new Piece(1,4,1,1);
                    pieces[3] = new Piece(2,1,2,1);
                    pieces[4] = new Piece(2,4,2,1);
                    pieces[5] = new Piece(3,2,2,1);
                    pieces[6] = new Piece(4,1,1,1);
                    pieces[7] = new Piece(4,4,1,1);
                    pieces[8] = new Piece(5,1,1,2);
                    pieces[9] = new Piece(5,3,1,2);
                    return;
                }
            }
        }
        
    }
    //setta la configurazione 
    public void setConfiguration(int config)
    {
        this.configuration=config;
    }
    //trova il pezzo una volta dato un punto
    public int findPieceIndex(int x,int y)
    {
        for(int i = 0; i < 10; i++)
        {
            int [] dimensions=this.pieces[i].getDimensions();

            if ((dimensions[0] == x) && (dimensions[1] == y))
            return i;
            else
            {
                if (dimensions[2] == 2 && dimensions[3] != 2)
                {
                    if (dimensions[0] == x-1 && dimensions[1] == y)
                    return i;
                }
                else
                {
                    if (dimensions[3] == 2 && dimensions [2] != 2)
                    {
                        if (dimensions[0] == x && dimensions[1] == y-1)
                        return i;
                    }
                    else
                        if (dimensions[2] == 2 && dimensions[3] == 2)
                        {
                            if ((dimensions[0] == x-1 && dimensions[1] == y-1) ||(dimensions[0] == x-1 && dimensions[1] == y) || (dimensions[0] == x && dimensions[1] == y-1) )
                                return i;
                        }
                }   
            }
        }
        return -1;
    }
    //funzione usata per controllare se si ha vinto o meno
    public boolean checkWin()
    {
        int i = 0;
        int [] dimensions = this.pieces[i].getDimensions();
        boolean found = false;

        while(!found)
        {
            dimensions = this.pieces[i].getDimensions();
            if ((dimensions[2] == 2) && (dimensions[3] == 2))
                found = true;
            i++;    
        }

        if ( (dimensions[0] == 5) && (dimensions[1] == 2))
            return true;
        else return false;    
    }

    public Piece [] getPieces()
    {
        return this.pieces;
    }

    public Piece getSelected(int index)
    {
        return this.pieces[index];
    }
    
    public void setSelected (int index)
    {
    	this.selected = this.pieces[index];
    }
    
    
    //muove un pezzo se la posizione voluta è libera
    public boolean movePiece (int x, int y, int piece)
    {
    	int index = findPieceIndex(x,y);
    	//int [] dimensions = pieces[piece].getDimensions();
    	
    	if (index == -1)
    	{
    		pieces[piece].move(x,y);
    		return true;
    	}
    	else return false;
    }
    
    
    public void reset ()
    {
    	this.setPieces();
    	this.moves = 0;
    	this.selected = null;
    	this.win = false;
    }
    

    



    
}
