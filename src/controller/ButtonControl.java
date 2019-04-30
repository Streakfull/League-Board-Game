package controller;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.pieces.Piece;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import view.Board;
import view.ButtonCells;
import view.Cells;
import view.CurrentPlayer;
import view.DeadCharacters;
import view.DeadCharactersP2;
import view.ExceptionWindow;
import view.Form;
import view.Player1Panel;
import view.Player2Panel;
import view.WinningScreen;

public class ButtonControl  implements ActionListener{ 
private static  ButtonCells CurrentCell;
private static DeadCharacters d1;
private static DeadCharactersP2 d2;
private Direction d = null;
private static boolean power = false;
private  ButtonCells revived; 
public static boolean tech = false;
private ButtonCells techs;
public static  boolean tp = false;
private ButtonCells techTp;
public Point Location = null;
public static Board b;


public static ButtonCells getCurrentCell() {
	return CurrentCell;
}

public void setTechTp(ButtonCells b) {
	this.techTp = b;
}

public ButtonControl() {
	super();
	
}
public static boolean getTech() {
	return tech;
}
public void setRevived(ButtonCells p) {
	this.revived = p;
}

 

public void setCurrentCell(ButtonCells b) {
	 this.CurrentCell = b;
 }
 public static void setd1(DeadCharacters d) {
	 d1 = d;
	 
 }
 public static void setd2(DeadCharactersP2 d) {
	 d2 = d;
	 
 }
 
 @Override
	public void actionPerformed(ActionEvent e) {
	 	
	 		String ev = e.getActionCommand();
	 		if(CurrentCell!=null) {
	 		if(CurrentCell.getPiece() instanceof Tech && ev.equals("usePower")) {
	 			techs = CurrentCell;
	 			tech = true;
	 			CurrentCell = null;
	 			return;
	 		}}
	 		
	 		switch(ev) {
	 		case "UP": 	d = Direction.UP;checkPower(d);break;
	 		case "UpLeft": d = Direction.UPLEFT;checkPower(d);break;
	 		case "UpRight" : d = Direction.UPRIGHT;checkPower(d);break;
	 		case "Left" : d = Direction.LEFT;checkPower(d);break;
	 		case "usePower": power = true;break;
	 		case "Right" : d = Direction.RIGHT;checkPower(d);break;
	 		case "DownLeft": d = Direction.DOWNLEFT;checkPower(d);break;
	 		case "Down" : d = Direction.DOWN;checkPower(d);break;
	 		case "DownRight" : d = Direction.DOWNRIGHT;checkPower(d);break;
	 		}
	 		
			
			
	}
 public void tele() {
	 Piece p2 = techs.getPiece();
	 try {
		((Tech) p2).usePower(null, techTp.getPiece(), Location);
		tp = false;
		techs = null;
		techTp=null;
		CurrentCell = null;
		Location = null;
		tech = false;
		p2.playSkill();
		updateAll();
	} catch (InvalidPowerTargetException | PowerAlreadyUsedException | InvalidPowerDirectionException
			| WrongTurnException e) {
		new ExceptionWindow(e.getMessage());
		tp = false;
		techs = null;
		techTp=null;
		CurrentCell = null;
		Location = null;
		tech = false;
	}
 }
  public void useTech() {
	  
		 if(CurrentCell==null||techs==null) {
			 new ExceptionWindow("Please select a target");
		 	  tech = false;
		 	  techs=null;
		 	  return;
		 	     }
		 Piece p2 = techs.getPiece();
			 try {
				 
				 ((Tech) p2).usePower(null, CurrentCell.getPiece(), null);
				 
				tech = false; 
				 techs= null;
				 CurrentCell = null;
				 p2.playSkill();
				 updateAll();
				 
			 
			} catch (InvalidPowerTargetException | PowerAlreadyUsedException | InvalidPowerDirectionException
					| WrongTurnException e) {
				new ExceptionWindow(e.getMessage());
				tech = false; 
				 techs= null;
				 CurrentCell = null;
				 
				
			}
	
	
}
public void checkPower(Direction d) {
  if(power) {
	  Power();
	  power = false;
	  updateAll();
	  checkEnd();
	  return;
	 
  }
  
  Move(d);checkEnd();}
 public void Power() {
	 if(CurrentCell==null) {
		 return;
	 }
	 Piece p = CurrentCell.getPiece();
	 if(p instanceof Super) {
		 try {
			((Super) p).usePower(d, null, null);
			CurrentCell = null;
			p.playSkill();
			return;
		} catch (PowerAlreadyUsedException | InvalidPowerTargetException | InvalidPowerDirectionException
				| WrongTurnException e) {
			new ExceptionWindow(e.getMessage());
			CurrentCell = null;
			//e.printStackTrace();
		}}
		 if(p instanceof Ranged) {
			 try {
					((Ranged) p).usePower(d, null, null);
					CurrentCell = null;
					p.playSkill();
					return;
				} catch (PowerAlreadyUsedException | InvalidPowerTargetException | InvalidPowerDirectionException
						| WrongTurnException e) {
					new ExceptionWindow(e.getMessage());
					CurrentCell = null;
				
				}
		 }
		 if(p instanceof Medic) {
			 if(revived==null) {
				 new ExceptionWindow("Please Choose a Piece to Be revived");
				 CurrentCell = null;
				 return;
				 
			 }
			
			 try {
					((Medic) p).usePower(d, revived.getPiece(), null);
						if(p.getOwner().equals(Cells.getGame().getPlayer1())) {
							d1.resetMedic();}
						else {
							d2.resetMedic();
						}
					CurrentCell = null;
					revived=null;
					p.playSkill();
					return;
				} catch (PowerAlreadyUsedException | InvalidPowerTargetException | InvalidPowerDirectionException
						| WrongTurnException e) {
					new ExceptionWindow(e.getMessage());
					CurrentCell = null;
					revived = null;
				
				}
			 }
			 
				 
			 
			 
			
			 
			 
		 }
		 
		 
	 
 
 
 
 
 
 

 public static void updateAll() {
	 DeadCharacters.setdeads(Cells.getGame().getPlayer1().getDeadCharacters());
		DeadCharactersP2.setdeads(Cells.getGame().getPlayer2().getDeadCharacters());
		d2.updateList();
		d1.updateList();
		CurrentPlayer.setPlayer(Cells.getGame().getCurrentPlayer().getName());	
		Player1Panel.setPayload(Cells.getGame().getPlayer1().getPayloadPos());
		Player2Panel.setPayload(Cells.getGame().getPlayer2().getPayloadPos());
		Cells.updatesButtons();
 }
 
 public void Move(Direction d) {

	 
	 if(!(CurrentCell==null)&&(d!=null)) {
			try {
				CurrentCell.getPiece().move(d);
				CurrentCell = null;
				updateAll();
				
				
			} catch (UnallowedMovementException | OccupiedCellException | WrongTurnException e1) {
				 
				new ExceptionWindow(e1.getMessage());
				CurrentCell = null;
				//e1.printStackTrace();
		}}}
 

public void checkEnd() {
	if(Cells.getGame().checkWinner()) {
		WinningScreen.winner = Cells.getGame().winner();
		WinningScreen tt  = new WinningScreen(b);
		CardLayout cardLayout = (CardLayout)Board.cards.getLayout();
		Board.cards.add(tt,"win");
		cardLayout.show(Board.cards, "win");
	}
}


} 
 
 





			
		
				
	

	
	


