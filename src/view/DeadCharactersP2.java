package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ButtonControl;
import model.game.Game;
import model.pieces.Piece;

public class DeadCharactersP2 extends JPanel {
	private Game game;
	private static ArrayList<Piece> deads;
	private static  ArrayList<ButtonCells> icons;
	private  GridBagConstraints c;
	private GridBagConstraints f;
	private JPanel p;
	private int counter;
	public DeadCharactersP2(Game g) {
		super();
		this.game = g;
		Color x = Color.BLACK;
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		f = new GridBagConstraints();
		//c.fill = GridBagConstraints.HORIZONTAL;
		JLabel dead = new JLabel("DEAD HEROES:");
		if(Form.fontp=="League") {
			dead.setFont(Theme.f);
			x = Resources.league;
		}else
			dead.setFont(Form.font);
		dead.setForeground(x);
		Border border = BorderFactory.createEmptyBorder(0,50,5,50);
		Border border2 = BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, x),BorderFactory.createLineBorder(x));
		dead.setBorder(border);
		deads = g.getPlayer2().getDeadCharacters();
		icons = new ArrayList<ButtonCells>();
		updateList();
		this.counter = 0;
		ButtonControl.setd2(this);
		this.add(dead);
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.setOpaque(false);
		c.gridy+=50;
		this.add(p,c);
		p.setBorder(border2);
		//this.setBorder(border2);
		
}
public  void updateList() {
	int j =0;
	for(int i=0;i<icons.size();i++) {
		j++;}
	
	for(int s = j;s<deads.size();s++) {
		ButtonCells d = new ButtonCells(this);
		d.setIconsCustom(deads.get(s),5);
		icons.add(d);
		d.setPiece(deads.get(s));
		if(counter%2==0) {
			f.gridy+=5;
			f.gridx = 0;
		p.add(d,f);
		
		}
		else {
			f.gridx+=2;
			p.add(d,f);
		}
		counter++;
		}}

public void resetMedic() {
	counter = 0;
	icons = new ArrayList<ButtonCells>();
	p.removeAll();
	for(int s = 0;s<deads.size();s++) {
		ButtonCells d = new ButtonCells(this);
		d.setIconsCustom(deads.get(s),5);
		icons.add(d);
		d.setPiece(deads.get(s));
		if(counter%2==0) {
			f.gridy+=5;
			f.gridx = 0;
		p.add(d,f);
		
		}
		else {
			f.gridx+=2;
			p.add(d,f);
		}
		counter++;
	
}}
	
	
public static void setdeads(ArrayList<Piece> d) {
	deads = d;
}
	
}



