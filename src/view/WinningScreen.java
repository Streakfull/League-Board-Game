package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.game.Game;

public class WinningScreen extends JPanel implements ActionListener {
	public static Font f;
	private Board b;
	public static String winner;
	public WinningScreen(Board b) {
		super();
		this.b = b;
		this.setLayout( new BorderLayout());
		BgPanel p = new BgPanel();
		p.setLayout(new BorderLayout());
		Color x = Color.WHITE;
		String message = "";
		JPanel Actual = new JPanel();
		Actual.setOpaque(false);
		Actual.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		String winner = "";
		if(Cells.getGame().getPlayer1().getPayloadPos()==6)
			winner = Cells.getGame().getPlayer1().getName();
		if(Cells.getGame().getPlayer2().getPayloadPos()==6)
			winner = Cells.getGame().getPlayer2().getName();
		if(Form.fontp=="League") {
			message = "CONGRATULATIONS "+winner+",YOU HAVE CONQUERED THE RIFT ";
	         x = Color.WHITE;
	         f = Theme.f;}
		else {
			message = "CONGRATULATIONS "+winner+",YOU HAVE WON THE BATTLE";
			f = Form.font;
		}
		
		
		JLabel cong = new JLabel(message);
		cong.setFont(f);
		cong.setForeground(x);
		Actual.add(cong);
		JButton ButtonT = new JButton("Play Again");
		ButtonT.setForeground(x);
		Border border = BorderFactory.createLineBorder(x,5);
		ButtonT.setBorder(border);
		ButtonT.setContentAreaFilled(false);
		ButtonT.addActionListener(this);
		ButtonT.setFont(f);
		c.gridy+=50;
		Actual.add(ButtonT,c);
		JButton ButtonTT = new JButton("Exit");
		ButtonTT.setForeground(x);
		Border borders = BorderFactory.createLineBorder(x,5);
		ButtonTT.setBorder(borders);
		ButtonTT.setContentAreaFilled(false);
		ButtonTT.addActionListener(this);
		ButtonTT.setFont(f);
		c.gridy+=100;
		Actual.add(ButtonTT,c);
		
		p.add(Actual);
		this.add(p);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getActionCommand().equals("Exit"))) {
			
			System.exit(0);
			}
		if((e.getActionCommand().equals("Play Again"))) {
			new Theme();
			b.dispose();
		
		}
			
			
	
	
	
	
	
	}

}
