package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tut  extends JPanel{
	Image bg = new ImageIcon("assets/images/Tut.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

	/*public Tut() {
		super();
		this.setOpaque(false);
		this.setBackground(Color.black);
		Color x = Color.BLACK;
		Font f = new Font("Arial",Font.PLAIN,20);
		if(Form.fontp=="League") {
			f = Theme.fs;
			x = Resources.league;

	
	}
		JLabel instructions = new JLabel("WELCOME TO SUPERHERO CHESS");
		instructions.setFont(f);
		this.add(instructions);
		
		
		}*/
	



}

	
	

