package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Game;

public class CurrentPlayer extends JPanel {
  private  static JLabel CurrentPlayer;	
  private Game game;
  Font f;
 public CurrentPlayer(Game game) {
	 super();
	 Color c = Color.WHITE;
	 if(Form.fontp=="League") {
		 f = new Font("Friz Quadrata Std",Font.PLAIN,45);
		 c = Resources.league;
 }
	 else {
		 f = Form.font;
	 }
	 this.setOpaque(false);
	 this.game = game;
	 this.setLayout(new GridBagLayout());
	 CurrentPlayer = new JLabel();
	 CurrentPlayer.setFont(f);
	 CurrentPlayer.setText("CURRENT PLAYER: "+ game.getCurrentPlayer().getName()+" ");
	 CurrentPlayer.setForeground(c);
	 this.add(CurrentPlayer);
	 
	 
 }
 
 public static void setPlayer(String string) {
	 CurrentPlayer.setText("Current Player: "+ string+" ");
	 
	 
 }
 
  
  

}
