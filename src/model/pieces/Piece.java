package model.pieces;



import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

abstract public class Piece implements Movable {
	private String name;
	private Player owner;
	private Game game;
	private int  posI;
	private int posJ;
	public Piece(Player owner, Game game, String name) {
		this.owner = owner;
		this.game = game;
		this.name = name;
	}
	public abstract void playChampSelect();
	public abstract  void playSkill();
		
	
	public String getName() {
		return name;
	}
	public Player getOwner() {
		return owner;
	}
	public Game getGame() {
		return game;
	}
	public int getPosI() {
		return posI;
	}
	public int getPosJ() {
		return posJ;
	}
	public void setPosI(int posI) {
		this.posI = posI;
	}
	public void setPosJ(int posJ) {
		this.posJ = posJ;
	}
	public void superSet(int posI,int posJ) {
		setPosI( posI);
		setPosJ(posJ);
		
	}
	@Override
	public String toString() {
		return this.getName();
	}
	
	private Piece eliminate(Piece target) {
		int posI = target.getPosI();
		int posJ = target.getPosJ();
		Cell targetCell = target.game.getCellAt(posI, posJ);
		Piece dead = targetCell.getPiece();
		targetCell.setPiece(null);
		return dead;
		
		
	}
	private void setPayLoads(Piece target) {
		int initialSideKill = this.owner.getSideKilled();
		int initialPayLoad = this.owner.getPayloadPos();
		if(target instanceof Armored && ((Armored)target).isArmorUp()==true ){
			target.playSkill();
			return;}	
	 	if(target instanceof SideKickP1 ||target instanceof SideKickP2) {
			 this.owner.setSideKilled(initialSideKill+1);
			 if(this.owner.getSideKilled()==2) {
				 this.owner.setPayloadPos(initialPayLoad+1);
				 this.owner.setSideKilled(0);
				 } 
			 }
	 	else {
			 this.owner.setPayloadPos(initialPayLoad+1);}}
		
	
	
	public void attack(Piece target) {
		setPayLoads(target);
		if(target instanceof Armored && ((Armored)target).isArmorUp()==true ){
			((Armored)target).setArmorUp(false) ;
			return;}
	 	target.owner.addDeadCharacter(this.eliminate(target));
	 	this.getGame().checkWinner();} 
		 
private void AttackMove(int [] pos,Direction d) throws OccupiedCellException {
	int oldI = this.getPosI();
	int oldJ = this.getPosJ();
	int posI = pos[0];
	int posJ = pos[1];
	Cell fee = this.getGame().getCellAt(posI, posJ);
	if(fee.isEmpty()) {
		fee.setPiece(this);
		this.getGame().getCellAt(oldI, oldJ).setPiece(null);
		fee.getPiece().superSet(posI, posJ);
		this.getGame().switchTurns();
		return;}
	if(fee.getPiece().getOwner().equals(this.owner))
		throw new OccupiedCellException("This cell is already occupied",this,d);
	this.attack(fee.getPiece());
	if(fee.isEmpty()) {
		fee.setPiece(this.getGame().getCellAt(oldI, oldJ).getPiece());
		this.getGame().getCellAt(oldI, oldJ).setPiece(null);
		fee.getPiece().superSet(posI, posJ);
			
	}

		this.getGame().switchTurns();
	}

public int[] moveDown() {
	int newPosI = this.getPosI()+1;
	int newPosJ = this.getPosJ();
	if(newPosI>6)
		newPosI = 0;
	 int[] positions = {newPosI,newPosJ};
	 return positions;}
	 

public int[] moveUp() {
	int newPosI = this.getPosI()-1;
	int newPosJ = this.getPosJ();
	if(newPosI<0)
		newPosI = 6;
	int[] positions = {newPosI,newPosJ};
	 return positions;
}
public int[] moveLeft() {
	int newPosI = this.getPosI();
	int newPosJ = this.getPosJ()-1;
	if(newPosJ<0)
		newPosJ = 5;
	int[] positions = {newPosI,newPosJ};
	 return positions;
}
public int[] moveRight() {
	int newPosI = this.getPosI();
	int newPosJ = this.getPosJ()+1;
	if(newPosJ>5)
		newPosJ = 0;
	int[] positions = {newPosI,newPosJ};
	 return positions;
}

public int[] moveDownLeft()
{
	int newPosI = this.getPosI()+1 ;
	int newPosJ = this.getPosJ()-1;
	if(newPosI>6)
		newPosI = 0;
	if(newPosI<0)
		newPosI = 6;
	if(newPosJ>5)
		newPosJ = 0;
	if(newPosJ<0)
		newPosJ = 5;
	int[] positions = {newPosI,newPosJ};

	
	 return positions; }

public int[] moveDownRight()
{
	int newPosI = this.getPosI()+1 ;
	int newPosJ = this.getPosJ()+1;
	if(newPosI>6)
		newPosI = 0;
	if(newPosI<0)
		newPosI = 6;
	if(newPosJ>5)
		newPosJ = 0;
	if(newPosJ<0)
		newPosJ = 5;
int[] positions = {newPosI,newPosJ};
	return positions ;}

	


public int[]  moveUpLeft()
{
	int newPosI = this.getPosI()-1 ;
	int newPosJ = this.getPosJ()-1;
	if(newPosI>6)
		newPosI = 0;
	if(newPosI<0)
		newPosI = 6;
	if(newPosJ>5)
		newPosJ = 0;
	if(newPosJ<0)
		newPosJ = 5;
	int[] positions = {newPosI,newPosJ};
	
	 return positions; }


public int[] moveUpRight() 
{
	int newPosI = this.getPosI()-1 ;
	int newPosJ = this.getPosJ()+1;
	if(newPosI>6)
		newPosI = 0;
	if(newPosI<0)
		newPosI = 6;
	if(newPosJ>5)
		newPosJ = 0;
	if(newPosJ<0)
		newPosJ = 5;
	int[] positions = {newPosI,newPosJ};

	
	 return positions;
}

	@Override
	public void move (Direction d) throws WrongTurnException,UnallowedMovementException, OccupiedCellException
	{	if(!this.getOwner().equals(this.getGame().getCurrentPlayer()))
			throw new WrongTurnException("Wrong Turn",this);
		
		switch(d)
		{
		case UP : AttackMove(moveUp(),Direction.UP) ;break;
		case DOWN : AttackMove(moveDown(),Direction.DOWN) ;break ;
		case RIGHT : AttackMove(moveRight(),Direction.RIGHT) ; break ;
		case LEFT : AttackMove(moveLeft(),Direction.LEFT) ; break ;
		case UPRIGHT : AttackMove(moveUpRight(),Direction.UPRIGHT) ; break ;
		case DOWNRIGHT : AttackMove(moveDownRight(),Direction.DOWNRIGHT) ; break ;
		case UPLEFT : AttackMove(moveUpLeft(),Direction.UPLEFT) ; break ;
		case DOWNLEFT : AttackMove(moveDownLeft(),Direction.DOWNLEFT) ; break ;
		}
		
		
	}
	
		

	



	
	
	
	
}
	
