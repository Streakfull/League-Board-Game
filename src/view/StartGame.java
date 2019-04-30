package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartGame extends JPanel  {

	
Form form;
	
	public StartGame(Form form) {
		this.form = form;
		setOpaque(false);
		setLayout(new FlowLayout());
		JButton ButtonT = new JButton("Begin The Battle");
		Color x = Color.WHITE;
		if(Form.fontp=="League") {
			ButtonT.setFont(Theme.f);
			x = Resources.league;
		}else
			ButtonT.setFont(Form.font);
		ButtonT.setForeground(x);
		Border border = BorderFactory.createLineBorder(x,5);
		ButtonT.setBorder(border);
		ButtonT.setContentAreaFilled(false);
		ButtonT.addActionListener(form);
		add(ButtonT);
	
	}
	public StartGame(String name,Form form,int size) {
		this.form = form;
		setOpaque(false);
		setLayout(new FlowLayout());
		JButton ButtonT = new JButton(name);
		Color x = Color.WHITE;
		if(Form.fontp=="League") {
			ButtonT.setFont(Theme.f);
			 x = Resources.league;
		}else
			ButtonT.setFont(Form.font);
		ButtonT.setForeground(x);
		Border border = BorderFactory.createLineBorder(x,2);
		ButtonT.setBorder(border);
		ButtonT.setContentAreaFilled(false);
		ButtonT.addActionListener(form);
		add(ButtonT);}
		
		public StartGame(String name,int size,ExceptionWindow e) {
			this.form = form;
			setOpaque(false);
			Color x = Color.BLACK;
			setLayout(new FlowLayout());
			JButton ButtonT = new JButton(name);
			if(Form.fontp=="League") {
				ButtonT.setFont(new Font("Friz Quadrata Std",Font.PLAIN,size));
				
			}else
			ButtonT.setFont(new Font("Yesteryear",Font.PLAIN,size));
			
			ButtonT.setForeground(x);
			Border border = BorderFactory.createLineBorder(x,2);
			ButtonT.setBorder(border);
			ButtonT.setContentAreaFilled(false);
			ButtonT.addActionListener(e);
			add(ButtonT);
}}
