package model.game; 

import model.pieces.Piece;

public class Cell {
	
	private Piece piece ;
	
	public Cell ()
	{
		this.piece= null;
	}
	
	public Cell (Piece piece)
	{
		this.piece = piece ;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	@Override
	public String toString() {
		if(piece != null)
			return piece.toString();
		
		return "n";
	}
	
	public boolean isEmpty()
	{
		if (this.getPiece()==null)
			return true ; 
		else
			return false ;
			
	}

}
