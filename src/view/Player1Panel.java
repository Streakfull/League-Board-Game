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

public class Player1Panel  extends JPanel{
	private Game game;
	private static JLabel payLoad;
	public Player1Panel(Game g) {
		super();
		this.game = g;
		this.setOpaque(false);
		Color x = Color.WHITE;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		JLabel playerName = new JLabel(g.getPlayer1().getName());
		if(Form.fontp=="League") {
			playerName.setFont(Theme.f);
			x  = Resources.league;
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
		payLoad = new JLabel("0/6");
		payLoad.setForeground(x);
		if(Form.fontp=="League") {
			payLoad.setFont(Theme.f);
		}else
			payLoad.setFont(Form.font);
		
		st.add(Score);
		st.add(payLoad);
		DeadCharacters dead = new DeadCharacters(game );
		//PlayerControl move = new PlayerControl();
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weighty = 0;
		add(playerName,c);
		c.gridy+=50;
		add(st,c);
	    c.gridy+=50;
	    add(dead,c);
	    c.gridy+=50;
	    //add(move,c);
	    
}
	
	public static void	setPayload(int n) {
		payLoad.setText(""+n+"/6");
		
	}

}
