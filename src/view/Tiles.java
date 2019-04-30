package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Tiles extends JPanel{
	private ButtonCells buttons;
	private Border borderW;
	private Border borderB;
	public static Font font = new Font("Yesteryear",Font.PLAIN,20);
	public Tiles() {
		super();
		this.setLayout(new BorderLayout());
		this.buttons = new ButtonCells();
		  borderB = BorderFactory.createMatteBorder(3,3,3,3,Color.BLACK);
		 borderW = BorderFactory.createLineBorder(Color.WHITE);
		this.setBorder(borderW);
		
		BackGroundTiles background = new BackGroundTiles();
		background.setLayout(new BorderLayout());
		background.add(buttons,BorderLayout.CENTER);
		
		this.add(background);
		
		
		
		
	}
	
	
	public ButtonCells GetButtons() {
		return buttons;
	}
	
	public void setBlackBorder() {
		this.setBorder(borderB);
	}
	public void setWhiteBorder() {
		this.setBorder(borderW);
	}
	
}
	

