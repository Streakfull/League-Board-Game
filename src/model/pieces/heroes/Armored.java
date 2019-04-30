package model.pieces.heroes;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import model.game.Game;
import model.game.Player;
import view.Form;
import view.Resources;

  public class Armored extends  NonActivatablePowerHero {
	
	private boolean armorUp ;
	
	
	
		
	

	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		armorUp =  true ;
	}






	public boolean isArmorUp() {
		return armorUp;
	}






	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
	@Override
	public void playChampSelect() {
		if(!(Form.fontp=="League"))
				return;
		try {		
			Clip clip = AudioSystem.getClip();
			if(this.getOwner().equals(this.getGame().getPlayer1()))
			clip.open(AudioSystem.getAudioInputStream(Resources.Blitz));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.Jax));
				
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
			clip.open(AudioSystem.getAudioInputStream(Resources.Blitzp));
			else
				clip.open(AudioSystem.getAudioInputStream(Resources.Jaxp));
				
			clip.start();
			return;
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
			
			
		}
	}
	
	

}
