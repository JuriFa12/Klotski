package controller;

import model.Board;

public class SelectPieceController
{
	
	public void selectPiece (Board b,int index)
	{
		b.setSelected(index);
		return;
	}
}

	
	
	