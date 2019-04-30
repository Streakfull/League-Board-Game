package model.pieces.heroes;

import java.awt.Point;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import view.Form;
import view.Resources;

public class Ranged extends ActivatablePowerHero {
	public Ranged(Player player,Game game,String name) {
		super(player,game,name);
}
	
@Override
public void usePower(Direction d ,Piece target,Point newPos) throws PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException, InvalidPowerDirectionException  {
	super.usePower(d, target, newPos);
	int PosI1 = this.getPosI();
	int PosJ1 = this.getPosJ();
	int newI =this.getPosI();
	int newJ = this.getPosJ();
	switch(d) {
		case UP:
			newI -=1;
			while (CellStatR(newI,PosJ1)) {
				newI -= 1;
			}
			/*if(this.CellStat(newI,PosJ1))
					this.attack(this.getGame().getCellAt(newI,PosJ1).getPiece());*/
			break;		
		case DOWN:
			newI +=1;
			while (CellStatR(newI,PosJ1)) {
				newI += 1;
			}
			
			/*if(this.CellStat(newI,PosJ1))
				this.attack(this.getGame().getCellAt(newI,PosJ1).getPiece());*/
			break;
		case RIGHT:
				newJ +=1;
				while (CellStatR(PosI1, newJ)) {
					newJ += 1;
			}
			
			/*if(this.CellStat(PosI1,newJ))
				this.attack(this.getGame().getCellAt(PosI1,newJ).getPiece());*/	
			break;
		case LEFT:
				newJ-=1;
				while (CellStatR(PosI1, newJ)) {	
					newJ -= 1;
			}
				
			break;
	default:throw new InvalidPowerDirectionException("Direction not allowed",this,d);
	}if(this.CellStatRA(newI,newJ,d)) {
		this.attack(this.getGame().getCellAt(newI,newJ).getPiece());
		this.setPowerUsed(true);
		this.getGame().switchTurns();}}

private boolean CellStatR(int i,int j) {
if(i>6||j>5||i<0||j<0)
	return false;
if(this.getGame().getCellAt(i, j).isEmpty())
	return true;
if(!(this.getGame().getCellAt(i, j).getPiece().getOwner().equals(this.getOwner())))
	return false;
return false;
	
}
public boolean CellStatRA(int i,int j,Direction d) throws InvalidPowerDirectionException {
	 if(i>6||j>5||i<0||j<0)
			throw new InvalidPowerDirectionException("No enemies Hit",this,d);
		if(this.getGame().getCellAt(i, j).isEmpty())
			throw new InvalidPowerDirectionException("No enemies Hit",this,d);
		if(this.getGame().getCellAt(i, j).getPiece().getOwner().equals(this.getOwner()))
			throw new InvalidPowerDirectionException("Friendly piece Hit",this,d);
		return true;
			
			
		
	
	}
@Override
public  void playChampSelect() {
	if(!(Form.fontp=="League"))
			return;
	try {		
		Clip clip = AudioSystem.getClip();
		if(this.getOwner().equals(this.getGame().getPlayer1()))
		clip.open(AudioSystem.getAudioInputStream(Resources.Ashe));
		else
			clip.open(AudioSystem.getAudioInputStream(Resources.Tristana));
			
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
		clip.open(AudioSystem.getAudioInputStream(Resources.Ashep));
		else
			clip.open(AudioSystem.getAudioInputStream(Resources.Tristanap));
			
		clip.start();
		return;
	}
	catch(Exception e) {
		System.err.print(e.getMessage());
		
		
	}
}



	
	
	
}





