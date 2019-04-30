package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import model.game.Game;

public class PlayerBoard extends JPanel {
	private Game game;
	public PlayerBoard(Game g) {
		super();
		this.game = g;
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		Player1Panel panel = new Player1Panel(g);
		PlayerControl c = new PlayerControl();
		this.add(panel,BorderLayout.PAGE_START);
		this.add(c,BorderLayout.PAGE_END);
		
		
	}
	
	public PlayerBoard(Game g,int x) {
		super();
		this.game = g;
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		Player2Panel panel = new Player2Panel(g);
		PlayerControl2 c  = new PlayerControl2();
		this.add(panel,BorderLayout.PAGE_START);
		this.add(c,BorderLayout.PAGE_END);
	}

}
