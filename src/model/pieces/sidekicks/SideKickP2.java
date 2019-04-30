package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

public class SideKickP2 extends SideKick{
	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(),game, name);
		
	}
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public void move(Direction d) throws WrongTurnException, UnallowedMovementException, OccupiedCellException
	{
		switch (d)
		{
		case UP     :  
		case UPRIGHT :   
		case UPLEFT  : throw new UnallowedMovementException("This hero can't perform this move",this,d);
		default:super.move(d);break;
		}
		
		
	}

	@Override
	public  void playChampSelect() {
		return;
	}
	@Override
	public void playSkill() {
		return;
			
		}

}
