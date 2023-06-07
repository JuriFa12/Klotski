package model;

//Classe che rappresenta la tavola di gioco, alta 5 e larga 4
public class Board 
{   
    //Variabili di esemplare della tabella di gioco
    private Piece [] pieces;		//Array di pezzi posizionati sulla tabella
    private Piece selected;			//Rappresenta il pezzo selezionato
    private int configuration;		//Rappresenta la configurazione (3 possibili)
    private int moves;				//Indica il numero di mosse effettuate in una partita
    private boolean win;			//Variabili utile a capire quando si ha vinto o meno
    private int undoState = 0;		//Variabili utilizzata per la funzione "Undo"
    private Piece [][] data;		//Matrice che serve a salvare vecchi stati in cui si trova il gioco

    //Costruttore base
    public Board ()
    {
        this.pieces = new Piece [10];
        this.configuration = 1;
        this.moves = 0;
        this.win=false;
        data = new Piece [1000][10];
        this.setPieces();

    }
    
    //Setta le coordinate dei pezzi in base alla configurazione scelta
    public void setPieces()
    {
        if (configuration == 2)
        {
            pieces[0] = new Piece(1,1,2,1);
            pieces[1] = new Piece(1,2,2,2);
            pieces[4] = new Piece(1,4,2,1);
            pieces[6] = new Piece(3,1,2,1);
            pieces[5] = new Piece(3,2,1,2);
            pieces[2] = new Piece(4,2,1,1);
            pieces[3] = new Piece(4,3,1,1);
            pieces[8] = new Piece(3,4,2,1);
            pieces[7] = new Piece(5,1,1,1);
            pieces[9] = new Piece(5,4,1,1);
            
            for (int j = 0; j < 10; j++)						//questo ciclo viene usato per salvare il primo stato in assoluto del gioco
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
    
    //Setta la configurazione (tra 3 possibili)
    public void setConfiguration(int config)  
    {
    	if (config < 1 || config > 3)
    		throw new IllegalArgumentException();
        this.configuration=config;
    }
    
    //Trova il pezzo che occupa una coppia di numeri indicanti un punto della griglia 5x4
    //Restituisce "-1" se non viene trovato alcun pezzo
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
    
    //Funzione usata per controllare se si ha vinto o meno
    public boolean checkWin()
    {
        int [] dimensions = this.pieces[1].getDimensions();
        if ((dimensions[0] == 4) && (dimensions[1] == 2))
            return true;
        else return false;    
    }

    //Funzione usata per ottenere l'Array di Pezzi
    public Piece [] getPieces()
    {
        return this.pieces;
    }
    
    //Funzione usata per ottenere il pezzo attualmente selezionato
    public Piece getSelected()
    {
    	return this.selected;
    }
    
    //Setta il pezzo selezionato tramite l'indice del pezzo
    public void setSelected (int index)
    {
    	this.selected = this.pieces[index];
    }
    
    //Restituisce quale configurazione attualmente si sta usando
    public int getConfiguration()
    {
    	return this.configuration;
    }

    //Resetta la tavola di gioco e le variabili d'esemplare principali
    public void reset ()
    {
    	this.setPieces();
    	this.moves = 0;
    	this.selected = null;
    	this.win = false;
    	this.undoState = 0;
    }

    //Controlla che una posizione della tavola di gioco sia libera
    public boolean isAvaible(int x, int y) 
    {
    	if(findPieceIndex(x, y) == -1) 
    		return true;
        return false;
    }
    
    
    //Seleziona un pezzo grazie a due punti indicanti una coordinata
    public void selectPiece(int x, int y) 
    {
    	int i = findPieceIndex(x, y);
    	
    	if(i != -1)
    		selected = pieces[i];
    	else
    		selected = null;	
    }
    
    //Controlla che il punto in questione non si trovi all'esterno dei bordi della tavola 5x4
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
    
    //Funzione usata per muovere un pezzo, restituisce "True" se la mossa è effettuata, "False" altrimenti
    public boolean movePiece(int direction) 
    { 
    	if(selected == null)  //Se non vi è alcun pezzo selezionato, errore
    		{
    		return false;
    		}
    	
    	int directions[] = selected.getDimensions();
    	
    	if(direction == 0) //0 = Movimento verso l'alto
    	{
    		//Condizioni per il blocco 1x1
    		if (directions[2] == 1 && directions[3] == 1)
    		{
    		if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1])) 
    			return false;
    	    selected.move(directions[0]-1, directions[1]);
    
    		}
    		else
    		{ 	//Condizioni per il blocco alto 2
    			if (directions[2] == 2)
    			{
    				if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1])) 
    					return false;
    				selected.move(directions[0]-1, directions[1]);

    			
    			}
    			else
    			{ //Condizioni per il blocco largo 2
    				if (directions[3] == 2)
    				{
        				if(isOutOfBounds(directions[0]-1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]-1, directions[1]) || !isAvaible(directions[0]-1, directions[1]+1)) 
        					return false;
        				selected.move(directions[0]-1, directions[1]);
    				}
    			}		
    		}	    	
    	}
    	if(direction == 1) //1 = movimento verso il basso
    	{ 
    		//Condizioni per il blocco 1x1
    		if (directions[2] == 1 && directions[3] == 1)
    		{
    		if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+1, directions[1])) 
    			return false;
            selected.move(directions[0]+1, directions[1]);  
    		}
    		else
    		{
    			//Condizioni per il blocco alto 2
    			if (directions[2] == 2)
    			{
    				if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+2, directions[1])) 
    					return false;
    				selected.move(directions[0]+1, directions[1]);
    			}
    			else
    			{
    				//Condizioni per il blocco largo 2
    				if (directions[3] == 2)
    				{
        				if(isOutOfBounds(directions[0]+1, directions[1], directions[2], directions[3]) || !isAvaible(directions[0]+1, directions[1]) || !isAvaible(directions[0]+1, directions[1]+1)) 
        					return false;
        				selected.move(directions[0]+1, directions[1]);
    				}
    			}
    		}    
        }
    	
    	if(direction == 2) //2 = movimento verso sinistra
    	{ 
    		//Condizioni per blocco 1x1
    		if (directions[3] == 1 && directions [2] == 1)
    		{
    		if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1))
    			return false;
    		selected.move(directions[0], directions[1]-1);
    		}
    		else
    		{
    			//Condizioni per il blocco largo 2
    			if (directions[3] == 2)
    			{
    				if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1))
        				return false;
        			selected.move(directions[0], directions[1]-1);
    			}
    			else
    			{
    				//Condizioni per il blocco alto 2
    				if (directions[2] == 2)
    				{
    	   				if(isOutOfBounds(directions[0], directions[1]-1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]-1) || !isAvaible(directions[0]+1, directions[1]-1))
            				return false;
            			selected.move(directions[0], directions[1]-1);	
    				}
    			}
    		}
    	}
    	if(direction == 3) //3 = movimento verso destra
    	{
    		//Condizioni per il blocco 1x1
    		if (directions[3] == 1 && directions[2] == 1)
    		{
    		if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+1))
    			return false;
    		selected.move(directions[0], directions[1]+1);
    		}
    		else
    		{
    			//Condizioni per il blocco largo 2
    			if (directions[3] == 2)
    			{
    				if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+2))
    					return false;
    				selected.move(directions[0], directions[1]+1);		
    			}
    			else
    			{
    				//Condizioni per il blocco alto 2
    				if (directions[2] == 2)
    				{
    					if(isOutOfBounds(directions[0], directions[1]+1, directions[2], directions[3]) || !isAvaible(directions[0], directions[1]+1) || !isAvaible(directions[0]+1, directions[1]+1))
    						return false;
    					selected.move(directions[0], directions[1]+1);				
    				}
    			}
    		}
    	}
    	
    	//Dopo ogni movimento, si salva il nuovo stato corrente nell'Array data e si aumenta il numero di mosse
    	this.undoState++;											
    	for (int j = 0; j < 10; j++)
    	{
    		data[this.undoState][j] = new Piece(this.pieces[j]); 		
    	}
    	moves++;
    	
    	return true;
    }
    
    //Restituisce il numero di mosse attuali
    public int getMoves ()
    {
    	return this.moves;
    }
    
    //Ripristina lo stato precedente allo stato attuale, diminuendo anche il numero di mosse
    public void undo() 
    {
    	if (this.moves > 0) 
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

    //Carica una configurazione precedentemente salvata su File, ripristinando anche il numero di mosse
    public void load (int moves, Piece[] puzzle)
    {
    	this.moves = moves;
    	
    	for (int i = 0; i < 10; i++)
    	{
    		int[] dim = puzzle[i].getDimensions();
    		pieces[i].move(dim[0], dim[1]);			
    	}  
    	
    	this.undoState = 0;
    	
        for (int j = 0; j < 10; j++)
        {
        	data[this.undoState][j] = new Piece (pieces[j]);  	
        }	
    }
    
    //Restituisce la variabile booleana che indica la vittoria o meno
    public boolean getWin ()
    {
    	return this.win;
    }
    
    //Restituisce l'array che contiene gli stati precedenti
    public Piece[][] getData()
    {
    	return this.data;
    }
    
    //Restituisce l'indice raggiunto dall'array di dati precedenti
    public int getUndoState()
    {
    	return this.undoState;
    }    
}
