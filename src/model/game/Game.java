package model.game;
import java.util.*;

import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Game {
	
	private  final int payloadPosTarget =6 ;
	private final int boardWidth =6;
	private final int boardHeight =7;
	private Player player1 ;
	private Player player2;
	private Player currentPlayer ;
	private Cell[][] board ;
	
	public Game(Player player1, Player player2)
	{
		board = new Cell[boardHeight][boardWidth];
		currentPlayer = player1;
		this.player1 = player1;
		this.player2 = player2;
		this.setEmptyCells();
		this.assemblePieces();
			
		}
									
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	
	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}
	public int getBoardWidth() {
		return boardWidth;
	}
	public int getBoardHeight() {
		return boardHeight;
	}
	@Override
	public String toString() {
		String s = "";
		System.out.println("      " + getPlayer2().getName());
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null)
					System.out.print("n ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		System.out.println("    " + getPlayer1().getName());
		return s;
	}
	private void setEmptyCells() {
		for(int i=0;i<7;i++) {
			for(int j =0;j<6;j++) {
				this.board[i][j] = new Cell();
			}}}

	private SideKickP1[] sp1() {
		
		SideKickP1 tink1 = new SideKickP1(this,"TinkerBell");
		SideKickP1 tink2 = new SideKickP1(this,"TinkerBell");
		SideKickP1 tink3 = new SideKickP1(this,"TinkerBell");
		SideKickP1 tink4 = new SideKickP1(this,"TinkerBell");
		SideKickP1 tink5 = new SideKickP1(this,"TinkerBell");
		SideKickP1 tink6 = new SideKickP1(this,"TinkerBell");
		SideKickP1[] sideKick1 = {tink1,tink2,tink3,tink4,tink5,tink6};
		return sideKick1;
		
		
	}
	private SideKickP2[] sp2() {
		SideKickP2 olaf1   =new SideKickP2(this,"olaf");
		SideKickP2 olaf2  =new SideKickP2(this,"olaf");
		SideKickP2 olaf3   =new SideKickP2(this,"olaf");
		SideKickP2 olaf4   =new SideKickP2(this,"olaf");
		SideKickP2 olaf5   =new SideKickP2(this,"olaf");
		SideKickP2 olaf6   =new SideKickP2(this,"olaf");
		SideKickP2[] sideKick2 = {olaf1,olaf2,olaf3,olaf4,olaf5,olaf6};
		return sideKick2;
	
	
}
	private Hero[] heroesP1() {
		Armored pooh = new Armored(this.player1,this,"Whinnie The Pooh");
		Medic	mulan	 = new Medic(this.player1,this,"Mulan");
		Ranged	buzz	 = new Ranged(this.player1,this,"Buzz Lightyear");	
		Speedster dash   = new Speedster(this.player1,this,"Dash");
		Super   nadine   = new Super(this.player1,this,"nadine");
		Tech	nael	 = new Tech(this.player1,this,"nael");
		Hero[] heroesP1 = {pooh,mulan,buzz,dash,nadine,nael};
		return heroesP1;
		
	}
	private Hero[] heroesP2() {
		Armored a = new Armored(this.player2,this,"Whinnie The Pooh");
		Medic	b	 = new Medic(this.player2,this,"Mulan");
		Ranged	c	 = new Ranged(this.player2,this,"Buzz Lightyear");	
		Speedster d   = new Speedster(this.player2,this,"Dash");
		Super   n   = new Super(this.player2,this,"nadine");
		Tech	na	 = new Tech(this.player2,this,"nael");
		Hero[] heroesP2 = {a,b,c,d,n,na};
		return heroesP2;
		
	}
	private void shuffle(Hero[] original) {
		Random randGen = new Random();
		for(int i =0;i<12;i++) {
			int z = randGen.nextInt(6);
			int j = randGen.nextInt(6);
			Hero temp = original[z];
			original[z] = original[j];
			original[j] = temp;} 
		
			}
	private void setOnBoard(Hero[] p1,Hero[]p2,SideKickP1[] s1,SideKickP2[] s2) {
		for(int i=0;i<6;i++) {
			this.board[2][i].setPiece(s2[i]);
			s2[i].superSet(2, i);
			this.board[4][i].setPiece(s1[i]);
			s1[i].superSet(4,i);
			this.board[1][i].setPiece(p2[i]);
			p2[i].superSet(1,i);
			this.board[5][i].setPiece(p1[i]);
			p1[i].superSet(5,i);}
		}
		public void assemblePieces(){
		  Hero[] heroP1 =  heroesP1();
		  shuffle(heroP1);
		  Hero[] heroP2 = heroesP2();
		  shuffle(heroP2);
		  setOnBoard(heroP1,heroP2,sp1(),sp2());}
		 
	 
	 public  Cell getCellAt(int i, int j) 
	 {
		 return board[i][j] ;
	 }
	
	 public void switchTurns() 
	 {
		if (getCurrentPlayer().equals(player1))
			setCurrentPlayer(player2) ;
		else 
			setCurrentPlayer(player1) ;
	 }
	 
	 public boolean checkWinner()
	 {
		 return (player1.getPayloadPos()==6||player2.getPayloadPos()==6);
	 }
	 public String winner() {
		 if(player1.getPayloadPos()==6)
			 return player1.getName();
		 return player2.getName();
			 
		 
	 }
	
		 
	 }
	 
	 
	 
	
		
	

	
	
	

