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
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import view.Form;
import view.Resources;

public class Super extends ActivatablePowerHero {
	public Super(Player player,Game game,String name) {
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
	case DOWNLEFT  : throw new UnallowedMovementException("This Hero can't perform this move",this,d);
	default:super.move(d);break;
	
	
}}
@Override
public void usePower(Direction d ,Piece target,Point newPos) throws PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException, InvalidPowerDirectionException {
	super.usePower(d, target, newPos);
	int PosI1 = this.getPosI();
	int PosJ1 = this.getPosJ();
	int PosI2 = this.getPosI();
	int PosJ2 = this.getPosJ();
	switch(d) {
		case UP:
			PosI1 -= 1;
			PosI2 -= 2;
			break;
		case DOWN:
			PosI1 += 1;
			PosI2 += 2;break;
		case RIGHT:
			PosJ1 += 1;
			PosJ2 += 2;break;
		case LEFT:
			PosJ1 -= 1;
			PosJ2 -= 2;break;
	default: throw new InvalidPowerDirectionException("Direction not allowed",this,d);
		
		}
	AttPos(PosI1,PosI2,PosJ1,PosJ2);
	this.setPowerUsed(true);
	this.getGame().switchTurns();
	
}
	

private void AttPos(int posI1, int posI2, int posJ1, int posJ2) {
	 {
		 
		 if(CellStat(posI1,posJ1)) {
			 Cell cell1 = this.getGame().getCellAt(posI1, posJ1);
			 this.attack(cell1.getPiece());
		 }
			if (CellStat(posI2,posJ2)) {
				Cell cell2 = this.getGame().getCellAt(posI2, posJ2);
				this.attack(cell2.getPiece());
		 }
		 
		
	}}
	 @Override
	public  void playChampSelect() {
			if(!(Form.fontp=="League"))
					return;
			try {		
				Clip clip = AudioSystem.getClip();
				if(this.getOwner().equals(this.getGame().getPlayer1()))
				clip.open(AudioSystem.getAudioInputStream(Resources.Khazix));
				else
					clip.open(AudioSystem.getAudioInputStream(Resources.Nasus));
					
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
				clip.open(AudioSystem.getAudioInputStream(Resources.Khazixp));
				else
					clip.open(AudioSystem.getAudioInputStream(Resources.Nasusp));
					
					
				clip.start();
				return;
			}
			catch(Exception e) {
				System.err.print(e.getMessage());
				
				
			}
		}
	
	
}




