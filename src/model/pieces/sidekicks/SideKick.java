package model.pieces.sidekicks;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

abstract public class SideKick extends Piece {
	public SideKick(Player player, Game game, String name) {
		super(player,game,name);
	}
	
	public void rep(Piece target) {
		int posI = this.getPosI();
		int posJ = this.getPosJ();
				if(target instanceof Speedster)	
				this.getGame().getCellAt(posI, posJ).setPiece(new Speedster(this.getOwner(),this.getGame(),target.getName()));
					
				if(target instanceof Armored)
					this.getGame().getCellAt(posI, posJ).setPiece(new Armored(this.getOwner(),this.getGame(),target.getName()));
				if(target instanceof Medic)
					this.getGame().getCellAt(posI, posJ).setPiece(new Medic(this.getOwner(),this.getGame(),target.getName()));
				if(target instanceof Ranged)
					this.getGame().getCellAt(posI, posJ).setPiece(new Ranged(this.getOwner(),this.getGame(),target.getName()));
				if(target instanceof Tech)
					this.getGame().getCellAt(posI, posJ).setPiece(new Tech(this.getOwner(),this.getGame(),target.getName()));
				if(target instanceof Super)
					this.getGame().getCellAt(posI, posJ).setPiece(new Super(this.getOwner(),this.getGame(),target.getName()));
			
	}
		
		
		
	
	
	
	
	@Override
	public void attack(Piece target) {
		if(target instanceof Armored) {
			if(((Armored) target).isArmorUp()) {
				super.attack(target);
				return;}}
		super.attack(target);
		this.rep(target);
	}
		
	}

