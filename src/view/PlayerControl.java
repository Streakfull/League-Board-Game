package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerControl extends JPanel {
	private static JButton MoveUp =    new MovementButtons("UP");
	private static JButton MoveDown = new MovementButtons("Down");
	private static JButton MoveLeft = new MovementButtons("Left");
	private static JButton MoveRight = new MovementButtons("Right");
	private static JButton MoveDownLeft = new MovementButtons("DownLeft");
	private static JButton MoveDownRight = new MovementButtons("DownRight");
	private static JButton MoveUpLeft = new MovementButtons("UpLeft");
	private static JButton MoveUpRight = new MovementButtons("UpRight");
	private static JButton usePower = new MovementButtons("usePower");
	private static ImageIcon upLeft = new ImageIcon("assets/Images/UpLeft .png");
	private static ImageIcon up = new ImageIcon("assets/Images/UP.png");
	private static ImageIcon upRight = new ImageIcon("assets/Images/upRight.png");
	private static ImageIcon left = new ImageIcon("assets/Images/Left.png");
	private static ImageIcon power = new ImageIcon("assets/"+Form.theme+"/cigar.png");
	private static ImageIcon right = new ImageIcon("assets/Images/Right.png");
	private static ImageIcon downLeft = new ImageIcon("assets/Images/DownLeft.png");
	private static ImageIcon Down = new ImageIcon("assets/Images/Down.png");
	private static ImageIcon DownRight = new ImageIcon("assets/Images/DownRight.png");
	private static ImageIcon [] icons = {upLeft,up,upRight,left,power,right,downLeft,Down,DownRight};
	private  static JButton[] cButtons= {MoveUpLeft,MoveUp,MoveUpRight,MoveLeft,usePower,MoveRight,MoveDownLeft,MoveDown,MoveDownRight};
    private static BackgroundMove[] tiless = new BackgroundMove[9];
	public PlayerControl() {
		super();
		this.setOpaque(false);
		this.setLayout(new GridLayout(3,3));
		this.setBackground(Color.WHITE);
		for(int i =0;i<tiless.length;i++) {
			tiless[i] = new BackgroundMove();
			tiless[i].setOpaque(false);
		}
	    for(int i=0;i<cButtons.length;i++) {
	    	tiless[i].add(cButtons[i]);
	    	tiless[i].setButton(cButtons[i]);
	    }
	    for(int i =0;i<tiless.length;i++) {
	    	this.add(tiless[i]);
	    }
	    
	    
	    
	    setIcons();
	
	
	}
	
	
	
	
	
		
	public static void setCurrentButton(ButtonCells b) {
		for(int i =0;i<cButtons.length;i++) {
			cButtons[i].addActionListener(b.getListener());
		}
	}
	
	public void setIcons() {
		for(int i =0;i<tiless.length;i++) {
		tiless[i].getButton().setIcon(icons[i]);
			
		}
		
	}
	}
	




	
	
	


