package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.game.Game;

public class Player2Panel  extends JPanel{
	private Game game;
	private static JLabel payLoad;
	public Player2Panel(Game g) {
		super();
		this.game = g;
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		Color x = Color.BLACK;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		JLabel playerName = new JLabel(g.getPlayer2().getName());
		if(Form.fontp=="League") {
			playerName.setFont(Theme.f);
			x = Resources.league;
		}else
			playerName.setFont(Form.font);
		
		playerName.setForeground(x);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,50,5,50),BorderFactory.createMatteBorder(0,0,5,0,x));
		playerName.setBorder(border);
		JPanel st = new JPanel();
		st.setOpaque(false);
		st.setLayout(new FlowLayout());
		JLabel Score = new JLabel("SCORE: ");
		Score.setForeground(x);
		if(Form.fontp=="League") {
			Score.setFont(Theme.f);
		}else
			Score.setFont(Form.font);
		Border borderS = BorderFactory.createEmptyBorder(0,50,5,0);
		Score.setBorder(borderS);
		payLoad = new JLabel("0/6 ");
		payLoad.setForeground(x);
		if(Form.fontp=="League") {
			payLoad.setFont(Theme.f);
		}else
			payLoad.setFont(Form.font);
		
		st.add(Score);
		st.add(payLoad);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weighty = 0;
		add(playerName,c);
		c.gridy+=50;
		add(st,c);
	    c.gridy+=50;
	    DeadCharactersP2 dead = new DeadCharactersP2(game);
	    add(dead,c);
	   
	    
}
public static void	setPayload(int n) {
	payLoad.setText(""+n+"/6");
}

}
