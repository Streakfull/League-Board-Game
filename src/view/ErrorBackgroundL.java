package view;






	import java.awt.Graphics;
	import java.awt.Image;

	import javax.swing.ImageIcon;
	import javax.swing.JPanel;

	public class ErrorBackgroundL extends JPanel {
	   public static Image bg = new ImageIcon("assets/imagesL/mafia.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	
	




}
