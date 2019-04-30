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

public class Tech extends ActivatablePowerHero {
	public Tech(Player player,Game game,String name) {
		super(player, game, name);}
	
	
	@Override
	public void move (Direction d) throws WrongTurnException, UnallowedMovementException, OccupiedCellException
	{
		switch (d)
		{
		case UP   :    
		case LEFT  :    
		case RIGHT :    
		case DOWN  : throw new UnallowedMovementException("This hero can't perform this move",this,d); 
		default:super.move(d);break;
		}
		
		
	}
	 @Override
	public void usePower(Direction d, Piece target, Point newPos) throws InvalidPowerTargetException, PowerAlreadyUsedException, InvalidPowerDirectionException, WrongTurnException {
		 super.usePower(d, target, newPos);
		 if(newPos!=null) {
		 	teleport(target,newPos); this.setPowerUsed(true);return;}
		 if(!target.getOwner().equals(this.getOwner())) {
			 hack(target); this.setPowerUsed(true);return;}
		 if(target.getOwner().equals(this.getOwner())) {
			 restore(target); this.setPowerUsed(true);return;}
			 
		 }
		 
			 
				 
				 
			 
		 
	 private void teleport(Piece target,Point newPos) throws InvalidPowerTargetException {
		 if(target==null) {
			 return;}
		 int i = (int) newPos.getX();
		 int j = (int) newPos.getY();
		 if(checkCell(i,j,target)) {
			 if(this.getGame().getCurrentPlayer().getDeadCharacters().contains(target))
				 throw new InvalidPowerTargetException("This Target is dead",this,target);
			 if(!this.getOwner().equals(target.getOwner())) {
				throw new InvalidPowerTargetException("Target belongs to enemy",this,target);}
			 this.getGame().getCellAt(i, j).setPiece(target);
			  this.getGame().getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
			  target.superSet(i, j);
	 }}
	 
	 public void hack(Piece target) throws InvalidPowerTargetException {
		 if(target instanceof ActivatablePowerHero) {
			 if(((ActivatablePowerHero) target).isPowerUsed())
				 throw new InvalidPowerTargetException("Target already used its power",this,target);
		 ((ActivatablePowerHero) target).setPowerUsed(true);return;			}
		if(target instanceof Armored) {
			if(!((Armored) target).isArmorUp())
				 throw new InvalidPowerTargetException("Armor is already Down",this,target);
		((Armored) target).setArmorUp(false);	
		}
		
	 

}
public void restore( Piece target) throws InvalidPowerTargetException {
	 if(target instanceof ActivatablePowerHero) {
		 if(!((ActivatablePowerHero) target).isPowerUsed())
			 throw new InvalidPowerTargetException("Target did not use ability yet",this,target);
	 ((ActivatablePowerHero) target).setPowerUsed(false);return;			}
	if(target instanceof Armored) {
		if(((Armored) target).isArmorUp())
			throw new InvalidPowerTargetException("Armor is still up",this,target);
	((Armored) target).setArmorUp(true);	
	}
	
		
 
 
 
 }


@Override
public  void playChampSelect() {
	if(!(Form.fontp=="League"))
			return;
	try {		
		Clip clip = AudioSystem.getClip();
		if(this.getOwner().equals(this.getGame().getPlayer1()))
		clip.open(AudioSystem.getAudioInputStream(Resources.Ekko));
		else
			clip.open(AudioSystem.getAudioInputStream(Resources.Orianna));
			
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
		clip.open(AudioSystem.getAudioInputStream(Resources.Ekkop));
		else
			clip.open(AudioSystem.getAudioInputStream(Resources.Oriannap));
			
		clip.start();
		return;
	}
	catch(Exception e) {
		System.err.print(e.getMessage());
		
		
	}
}

}
	 
	 
	 
	 
	 
	


