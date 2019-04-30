package model.pieces.heroes;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import view.Form;
import view.Resources;

public class Speedster extends NonActivatablePowerHero {
	
	

	public Speedster(Player player, Game game, String name) {
		super(player, game, name);
		
	}
	@Override
	public int[] moveDown() {
		int newPosI = this.getPosI()+2;
		int newPosJ = this.getPosJ();
		if(newPosI==7)
			newPosI = 0;
		if(newPosI==8)
			newPosI = 1;
		 int[] positions = {newPosI,newPosJ};
		 return positions;}
	
	@Override
	public int[] moveUp ()
	{
		int newPosI = this.getPosI() -2 ;
		int newPosJ = this.getPosJ() ;
		
		if (newPosI == -1 )
			newPosI = 6 ;
		if (newPosI == -2)
			newPosI = 5 ;
		int[] positions = {newPosI,newPosJ};
		 return positions;
		
	}
	
	@Override
	public int[] moveLeft ()
	{
		int newPosI = this.getPosI() ;
		int newPosJ = this.getPosJ() - 2 ;
		
		if (newPosJ == -1)
			newPosJ = 5 ;
		if (newPosJ == -2)
			newPosJ = 4 ;
		int[] positions = {newPosI,newPosJ};
		 return positions;
		
	}
	
	@Override
	public int[] moveRight ()
	{
		int newPosI = this.getPosI() ;
		int newPosJ = this.getPosJ() + 2 ;
		
		if (newPosJ == 6)
			newPosJ = 0 ;
		if (newPosJ == 7)
			newPosJ = 1 ;
		int[] positions = {newPosI,newPosJ};
		 return positions;
		
	}
	
	@Override
	public int[] moveDownLeft ()
	{
		int newPosI = this.getPosI() + 2;
		int newPosJ = this.getPosJ() - 2;
		
		if (newPosI == 8 && newPosJ == -2 ){
			newPosI = 1 ;
			newPosJ = 4 ;}
		if (newPosJ == -1)
			newPosJ = 5 ;
		if (newPosJ == -2)
			newPosJ = 4 ;
		if (newPosI == 7)
			newPosI = 0 ;
		if (newPosI == 8)
			newPosI = 1 ;
		int[] positions = {newPosI,newPosJ};
		 return positions ;
			
	}
	@Override
	public int[] moveDownRight ()
	{
		int newPosI = this.getPosI() + 2;
		int newPosJ = this.getPosJ() + 2;
		
		if (newPosI == 8 && newPosJ == 7){
			newPosI = 1 ;
			newPosJ = 1 ;}
		if (newPosJ == 6)
			newPosJ = 0 ;
		if (newPosJ == 7)
			newPosJ = 1 ;
		if (newPosI == 7)
			newPosI = 0 ;
		if (newPosI == 8)
			newPosI = 1 ;
		int[] positions = {newPosI,newPosJ};
		 return positions ;	
	}
	@Override
	public int[] moveUpLeft ()
	{
		int newPosI = this.getPosI() - 2;
		int newPosJ = this.getPosJ() - 2;
		
		if (newPosI == -2 && newPosJ == -2){
			newPosI = 5 ;
			newPosJ = 4 ;}
		if (newPosJ == -1)
			newPosJ = 5 ;
		if (newPosJ == -2)
			newPosJ = 4 ;
		if (newPosI == -1)
			newPosI = 6 ;
		if (newPosI == -2)
			newPosI = 5 ;
		int[] positions = {newPosI,newPosJ};
		 return positions ;
	}
	
	@Override
	public int[] moveUpRight ()
	{
		int newPosI = this.getPosI() - 2;
		int newPosJ = this.getPosJ() + 2;
		
		if (newPosI == -2 && newPosJ == 7){
			newPosI = 5 ;
			newPosJ = 1 ;}
		if (newPosI == -1)
			newPosI = 6 ;
		if (newPosI == -2)
			newPosI = 5 ; 
		if (newPosJ == 6)
			newPosJ = 0 ;
		if (newPosJ == 7)
			newPosJ = 1 ;
		int[] positions = {newPosI,newPosJ};
		 return positions ;
		
	}
		 
	
	@Override
	public void move (Direction d) throws WrongTurnException, UnallowedMovementException, OccupiedCellException
	{
		
		super.move(d);
		this.playSkill();
	}
	@Override
	public  void playChampSelect() {
		if(!(Form.fontp=="League"))
				return;
		try {		
			Clip clip = AudioSystem.getClip();
			if(this.getOwner().equals(this.getGame().getPlayer1()))
			clip.open(AudioSystem.getAudioInputStream(Resources.Lee_Sin));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.MasterYi));
				
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
			clip.open(AudioSystem.getAudioInputStream(Resources.Lee_Sinp));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.MasterYip));
				
			clip.start();
			return;
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
			
			
		}
	}

}
