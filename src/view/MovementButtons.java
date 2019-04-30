package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class MovementButtons extends JButton {
	public static Font font = new Font("Yesteryear",Font.PLAIN,20);
	public MovementButtons(String name) {
		super();
		if(Form.fontp=="League") {
			this.setFont(Theme.f);
		}else
			this.setFont(Form.font);
		
		Dimension d = new Dimension(110,60);
		this.setBorderPainted(false);
		this.setPreferredSize(d);
		this.setForeground(Color.WHITE);
		this.setContentAreaFilled(false);
		this.setActionCommand(name);
	}
	
	
	

}
