package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class Form extends Window  implements ActionListener {
public String pl1Name;
private static Color background = new Color(255,251,242);
private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
public  static int ScreenWidth = (int)(0.5*dim.getWidth());
public static int ScreenHeight = (int)(0.5*dim.getHeight());
public static String theme="";
public static String fontp="fonts";
private static JPanel cards;
private CardLayout cardLayout;
private PlayerSub plzWork;
static File file  = new File("assets/sounds/click.wav");
public static Font font = new Font("Yesteryear",Font.PLAIN,45);
public static Font fonts = new Font("Yesteryear",Font.PLAIN,20);
	public Form() throws FontFormatException, IOException {
		super(400,100,"Main Menu",background);
		setBounds(100, 100, ScreenWidth,ScreenHeight);
		setLocationRelativeTo(null);
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		this.add(cards);
		JPanel bgPanel = new BgPanel();
	    bgPanel.setLayout(new BorderLayout());
		this. plzWork = new PlayerSub();
		bgPanel.add(plzWork,BorderLayout.CENTER);
		bgPanel.add(new StartGame(this),BorderLayout.SOUTH);
		cards.add(bgPanel,"PlayerSub");
		JPanel bgPanel2 = new BgPanel();
		bgPanel2.setLayout(new BorderLayout());
		JPanel buttons = new MenuButtons(this);
		bgPanel2.add(buttons,BorderLayout.CENTER);
		cards.add(bgPanel2,"MainMenu");
		JPanel Tutorial = new Tut();
		Tutorial.setLayout( new BorderLayout());
		Tutorial.add(new StartGame("Back",this,25),BorderLayout.SOUTH);
		cards.add(Tutorial,"Tutorial");
		CardLayout cardLayout = (CardLayout) cards.getLayout();
		cardLayout.show(cards,"MainMenu");
		this.setVisible(true);
	
		
		
		
	
	}
	public  static JPanel getCards() {
		return cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cardLayout = (CardLayout) cards.getLayout();
		if((e.getActionCommand().equals("Start Game"))) {
			this.cardLayout.show(cards,"PlayerSub");
			playMouseClick();
			}
		if((e.getActionCommand().equals("Tutorial"))) {
			this.cardLayout.show(cards, "Tutorial");
			playMouseClick();
			}
		
		if((e.getActionCommand().equals("Back"))) {
			this.cardLayout.show(cards, "MainMenu");
			playMouseClick();
			}
		if((e.getActionCommand().equals("Begin The Battle"))) {
			playMouseClick();
			String player1Name = plzWork.getPlayer1Name();
			String player2Name = plzWork.getPlayer2Name();
		    try {
				new Board(player1Name,player2Name);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			}
		
		
		if((e.getActionCommand().equals("Exit"))) {
			playMouseClick();
			System.exit(0);
			}
			

	}
	public static void setTheme(String c) {
		theme = c;
	}

	public static void playMouseClick() {
		try {		
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			return;
		}
		catch(Exception e) {
			System.err.print(e.getMessage());
			
			
		}
	}

}

	
	
		
	


