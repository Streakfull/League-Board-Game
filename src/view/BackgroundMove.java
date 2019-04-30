package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BackgroundMove extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton b;
	 Image bg = new ImageIcon("assets/images/rounded.png").getImage();
	 
	 @Override
	public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	 
	 
	 public void setButton(JButton b) {
		 this.b = b;
	 }
	 public JButton getButton() {
		 return this.b;
	 }
		

}
