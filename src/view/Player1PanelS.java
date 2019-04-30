package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import model.game.Game;

public class Player1PanelS extends JLabel{
	
	public Player1PanelS(Game g) {
		super();
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		Player1Panel p = new Player1Panel(g);
		PlayerControl c = new PlayerControl();
		this.add(p,BorderLayout.PAGE_START);
		this.add(c, BorderLayout.PAGE_END);
	}
	
	
	

}
