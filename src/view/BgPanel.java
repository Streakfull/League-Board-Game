package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class BgPanel extends JPanel {
    Image bg =Resources.bgMafia;
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    
    public BgPanel() {
    	super();
    	
    }
}
