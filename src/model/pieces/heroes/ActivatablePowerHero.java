package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

abstract public class ActivatablePowerHero extends Hero {
	private boolean powerUsed;

	public ActivatablePowerHero(Player player,Game game,String name) {
		super(player,game,name);
		powerUsed = false;
	}
	public boolean isPowerUsed() {
		return powerUsed;
	}


	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}
	 public void usePower(Direction d, Piece target, Point newPos) throws PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException, InvalidPowerDirectionException  {
		 if(!this.getOwner().equals(this.getGame().getCurrentPlayer()))
				throw new WrongTurnException("Wrong Turn",this);
		 
		 if(this.isPowerUsed()) {
			throw new PowerAlreadyUsedException("This Power is Already Used",this);}
		 

	 }
	 
	 public boolean CellStat(int i,int j) {
		 if(i>6||j>5||i<0||j<0)
				return false;
			if(this.getGame().getCellAt(i, j).isEmpty())
				return false;
			if(this.getGame().getCellAt(i, j).getPiece().getOwner().equals(this.getOwner()))
				return false;
			return true;
				
				
			
		
		}
	 public boolean checkCell(int i ,int j,Piece target) throws InvalidPowerTargetException {
			if(i>6||j>5||i<0||j<0)
				return false;
			
			if(this.getGame().getCellAt(i, j).isEmpty())
				return true;
			throw new InvalidPowerTargetException("This cell is already occupied",this,target);
			
		}
		

	


}
