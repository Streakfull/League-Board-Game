package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import controller.ButtonControl;
import model.game.Game;
import model.game.Player;

public class Board extends Window  implements ActionListener {
	private Player player1;
	private Player player2;
	private Game game;
	public static JPanel cards;
	GraphicsDevice myDevice;
	private CardLayout cardLayout;
	public Board(String p1,String p2) throws IOException {
		super(0, 0, "SuperHeroChess", Color.WHITE);
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		this.add(cards);
		setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.player1 = new Player(p1);
		this.player2 = new Player(p2);
		this.game = new Game(player1,player2);
		BgPanel p = new BgPanel();
		p.setLayout(new BorderLayout());
		JPanel Cells = new Cells(this.game);
		CurrentPlayer Turn = new CurrentPlayer(game);
		p.add(Cells);
		p.add(Turn,BorderLayout.NORTH);
		PlayerBoard test = new PlayerBoard(game);
		p.add(test,BorderLayout.WEST);
		PlayerBoard test2 = new PlayerBoard(game,2);
		p.add(test2,BorderLayout.EAST);
		cards.add(p,"Board");
		CardLayout cardLayout = (CardLayout) cards.getLayout();
		cardLayout.show(cards,"Board");
		ButtonControl.b = this;
		//WinningScreen win = new WinningScreen(this);
		//cards.add(win,"win");
		//cardLayout.show(cards, "win");
		
	
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
	}

	

	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
