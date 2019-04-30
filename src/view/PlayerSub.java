package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PlayerSub extends JPanel {
	private Font sFont = new Font("Yesteryear",Font.PLAIN,20);
	private JTextField player1;
	private JTextField player2;
	
    public PlayerSub() {
        setOpaque(false);
        setLayout(new FlowLayout());
        Color NaelBack = Color.WHITE;
        Color x = Color.BLACK;
        JLabel prompt = new JLabel(" Player1,Dare Enter Your Name:");
        if(Form.fontp=="League") {
			prompt.setFont(Theme.f);
			prompt.setForeground(Resources.league);
			NaelBack = Resources.league;
			x = Resources.league;
		}else {
			prompt.setFont(Form.font);
        	prompt.setForeground(NaelBack);}
		
		Border border = BorderFactory.createMatteBorder(0,0,5,0,NaelBack);
		Border border2 = BorderFactory.createMatteBorder(0,0,5,0,x);
		prompt.setBorder(border);
		add(prompt);
		this.player1 = new JTextField(30);
		
		
		add(player1);
		JLabel prompt2 = new JLabel(" Player2,Dare Enter Your Name:");
		if(Form.fontp=="League") {
			prompt2.setFont(Theme.f);
		}else
			prompt2.setFont(Form.font);
		
		prompt2.setForeground(x);
		prompt2.setBorder(border2);
		add(prompt2); 
		this.player2 = new JTextField(30);
		if(Form.fontp=="League") {
			player2.setFont(Theme.fs);
			player1.setFont(Theme.fs);
		}else {
			player1.setFont(Form.fonts);
			player2.setFont(Form.fonts);
			
		}
		
		add(player2);
		
       
       
    }
    
    public String getPlayer1Name() {
    	return this.player1.getText();
    }
    public String getPlayer2Name() {
    	return this.player2.getText();
    }
    
}
