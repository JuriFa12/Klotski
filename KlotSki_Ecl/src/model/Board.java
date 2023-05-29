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
    int savedMoves = 0;
    int undoState = 0;
    Piece [][] data;
    Piece [ ]save;

    //costruttore iniziale
    public Board ()
    {
        this.pieces = new Piece [10];
        this.save = new Piece [10];
        this.height = 5;
        this.width = 4;
        this.configuration = 1;
        this.moves = 0;
        this.win=false;
        data = new Piece [500][10];
        this.setPieces();

        
        for (int j = 0; j < 10; j++)
        {
        	data[this.undoState][j] = new Piece (pieces[j]);  	
        }


    }
    //setta le coordinate dei pezzi una volta scelta la configurazione
    public void setPieces()
    {
        if (configuration == 2)
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
            
            for (int j = 0; j < 10; j++)
            {
            	this.data[0][j] = new Piece(this.pieces[j]);
            }
            return;
        }
        else 
        {
            if (configuration == 1)
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
                
                for (int j = 0; j < 10; j++)
                {
                	this.data[0][j] = new Piece(this.pieces[j]);
                }
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
                    
                    for (int j = 0; j < 10; j++)
                    {
                    	this.data[0][j] = new Piece(this.pieces[j]);
                    }
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

        if ( (dimensions[0] == 4) && (dimensions[1] == 2))
            return true;
        else return false;    
    }

    public Piece [] getPieces()
    {
        return this.pieces;
    }
/*
    public Piece getSelected(int index)
    {
        return this.pieces[index];
    }
    */
    public Piece getSelected()
    {
    	return this.selected;
    }
    
    public void setSelected (int index)
    {
    	this.selected = this.pieces[index];
    }
    
    public int getConfiguration()
    {
    	return this.configuration;
    }
    
    
    //muove un pezzo se la posizione voluta è libera
    /*
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
    */
    
    
    public void reset ()
    {
    	this.setPieces();
    	this.moves = 0;
    	this.selected = null;
    	this.win = false;
    }
    
   //Tommaso
    

    public boolean isAvaible(int x, int y) 
    {
    	if(findPieceIndex(x, y) == -1) 
    		return true;
        return false;
    }
    
    public void selectPiece(int x, int y) 
    {
    	int i = findPieceIndex(x, y);
    	
    	if(i != -1)
    		selected = pieces[i];
    	else
    		selected = null;
    	
    }
    
    public boolean isOutOfBounds(int x, int y, int a, int l) 
    {
    	if(x > 5 || x < 1 || y > 4 || y < 1)
    		return true;
    	if(a == 1 && l == 1)
    		return false;
    	if(l == 2) 
    	{
    		if(y == 4)
    			return true;
        }
    	if(a == 2) 
    	{
    		if(x == 5)
    			return true;
    	}
    	return false;
    }
    
    public boolean movePiece(int direction) 
    { //ritorna true se la mossa è stata effettuata
    	
    	if(selected == null) 
    		{
    		return false;
    		}//Errore
    	
    	int directions[] = selected.getDimensions();
    	
    	if(direction == 0) 
    	{// verso l'alto
    		//blocco 1x1
    		if (directions[2] == 1 && directions[3] == 1)
    		{
    		if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1])) 
    			return false;
    	    selected.move(directions[0]-1, directions[1]);
    
    		}
    		else
    		{ //cubetto alto 2
    			if (directions[2] == 2)
    			{
    				if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1])) 
    					return false;
    				selected.move(directions[0]-1, directions[1]);

    			
    			}
    			else
    			{ //cubetto largo 2
    				if (directions[3] == 2)
    				{
        				if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1]) || !isAvaible(directions[0]-1, directions[1]+1)) 
        					return false;
        				selected.move(directions[0]-1, directions[1]);
        				
    					
    				}
    			}
    			
    		}
    	    	
    	}
    	if(direction == 1) 
    	{ //verso il basso
    		//blocco 1x1
    		if (directions[2] == 1 && directions[3] == 1)
    		{
    		if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+1, directions[1])) 
    			return false;
            selected.move(directions[0]+1, directions[1]);
     
    		}
    		else
    		{
    			//cubetto 2X1
    			if (directions[2] == 2)
    			{
    				if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+2, directions[1])) 
    					return false;
    				selected.move(directions[0]+1, directions[1]);
    			
    			}
    			else
    			{
    				if (directions[3] == 2)
    				{
        				if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+1, directions[1]) || !isAvaible(directions[0]+1, directions[1]+1)) 
        					return false;
        				selected.move(directions[0]+1, directions[1]);
        			
    					
    				}
    			}
    		}
            
        }
    	
    	if(direction == 2)
    	{ //verso sinistra
    		if (directions[3] == 1 && directions [2] == 1)
    		{
    		if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1))
    			return false;
    		selected.move(directions[0], directions[1]-1);
    	
    		}
    		else
    		{
    			if (directions[3] == 2)
    			{
    				if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1))
        				return false;
        			selected.move(directions[0], directions[1]-1);
        		
    			}
    			else
    			{
    				if (directions[2] == 2)
    				{
    	   				if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1) || !isAvaible(directions[0]+1, directions[1]-1))
            				return false;
            			selected.move(directions[0], directions[1]-1);
            			
    				}
    			}
    		}
    		
    	}
    	if(direction == 3) 
    	{ //verso destra
    		if (directions[3] == 1 && directions[2] == 1)
    		{
    		if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+1))
    			return false;
    		selected.move(directions[0], directions[1]+1);
    		
    		}
    		else
    		{
    			if (directions[3] == 2)
    			{
    				if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+2))
    					return false;
    				selected.move(directions[0], directions[1]+1);
    				
    			}
    			else
    			{
    				if (directions[2] == 2)
    				{
    					if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+1) || !isAvaible(directions[0]+1, directions[1]+1))
    						return false;
    					selected.move(directions[0], directions[1]+1);
    				
    				}
    			}
    		}
    	}
    	this.undoState++;
    	
    
    	for (int j = 0; j < 10; j++)
    	{
    		data[this.undoState][j] = new Piece(this.pieces[j]); 		
    	}	
    	moves++;
    	
    	return true;
    }
    
    public int getMoves ()
    {
    	return this.moves;
    }
    
    public void undo() 
    {
    	if (moves > 0) 
    	{
    		int resume = this.undoState-1;
    		
    		for (int i = 0; i < 10; i++)
    		{
    			this.pieces[i] = new Piece(this.data[resume][i]);
    		}
    		moves--;	
    		this.undoState--;
    	}
    	else return;

    }
    
    public void save()
    {
    	//save.push(this.getPieces());
    	for (int i = 0; i < 10; i++)
    	{
    		save[i] = new Piece (pieces [i]);
    	}
    	this.savedMoves = this.moves;
    	
    }
    
    public void load ()
    {
    	if (save[1] !=  null)
    	{
       	for (int i = 0; i < 10; i++)
    	{
    		this.pieces[i] = new Piece (this.save [i]);
    	}
    	this.moves = this.savedMoves;
    	}
    	else
    		return;
    
    }

    
}
