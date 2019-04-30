package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;


public class SideKickP1  extends SideKick{
public SideKickP1(Game game,String name) {
	super(game.getPlayer1(),game, name);
	}

@Override
public void move(Direction d) throws WrongTurnException, UnallowedMovementException, OccupiedCellException
{
	switch (d)
	{
	case DOWN      :
	case DOWNRIGHT :
	case DOWNLEFT  : throw new UnallowedMovementException("This hero can't perform this move",this,d);
	default:super.move(d);break;
	}
	
	
}
@Override
public  void playChampSelect() {
	return;}
@Override
public void playSkill() {
	return;
		
	}
}
	
		
		
		
	


