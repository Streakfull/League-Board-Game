package model.pieces.heroes;

import java.awt.Point;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import view.Form;
import view.Resources;

public class Medic  extends ActivatablePowerHero{
	public Medic(Player player,Game game,String name) {
		super(player,game,name);
	}

	
	@Override
	public void move (Direction d) throws WrongTurnException, UnallowedMovementException, OccupiedCellException
	{
		switch (d)
		{
		case UPRIGHT   :     
		case UPLEFT    : 	    
		case DOWNRIGHT : 		  
		case DOWNLEFT  : throw new UnallowedMovementException("This hero can't perform this move",this,d);
		default :super.move(d);break;
		}
		
	}
	@Override
	public void usePower(Direction d, Piece target, Point newPos) throws PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException, InvalidPowerDirectionException{
		super.usePower(d, target, newPos);
		if(checkTarget(target)) {
		int posI = this.getPosI();
		int posJ = this.getPosJ();
		switch(d) {
		case LEFT: posJ--;break;
		case RIGHT: posJ++;break;
		case UP: posI --;break;
		case DOWN:posI++;break;
		case UPRIGHT:posI--;posJ++;break;
		case UPLEFT: posI--;posJ--;break;
		case DOWNRIGHT:posI++;posJ++;break;
		case DOWNLEFT:posI++;posJ--;break;
		default:return;	}
		if(posI>6)
			posI = 0;
		if(posI<0)
			posI = 6;
		if(posJ>5)
			posJ = 0;
		if(posJ<0)
			posJ = 5;
		if(checkCell(posI,posJ,target)) {
			this.getOwner().getDeadCharacters().remove(target);
			this.getGame().getCellAt(posI, posJ).setPiece(target);
			target.superSet(posI, posJ);
			if(target instanceof ActivatablePowerHero )
				((ActivatablePowerHero) target).setPowerUsed(false);
			if(target instanceof Armored)
				((Armored) target).setArmorUp(true);
			this.setPowerUsed(true);
			this.getGame().switchTurns();	}
		
		}
		
		}
	 
	public boolean checkTarget(Piece target) throws InvalidPowerTargetException{
		if(!(this.getOwner().equals(target.getOwner()))) { 
			throw new InvalidPowerTargetException("Target belongs to enemy",this,target);}
		if(!this.getOwner().getDeadCharacters().contains(target)) 
			throw new InvalidPowerTargetException("Target is alive",this,target);

		return true;	
			
		
	}
	@Override
	public  void playChampSelect() {
		if(!(Form.fontp=="League"))
				return;
		try {		
			Clip clip = AudioSystem.getClip();
			if(this.getOwner().equals(this.getGame().getPlayer1()))
			clip.open(AudioSystem.getAudioInputStream(Resources.Lulu));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.Sona));
				
			clip.start();
			return;
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
			
			
		}
	}
	@Override
	public void playSkill() {
		if(!(Form.fontp=="League"))
				return;
		try {		
			Clip clip = AudioSystem.getClip();
			if(this.getOwner().equals(this.getGame().getPlayer1()))
			clip.open(AudioSystem.getAudioInputStream(Resources.Lulup));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.Sonap));
				
			clip.start();
			return;
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
			
			
		}
	}
	


}
