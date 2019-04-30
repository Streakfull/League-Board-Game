package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButtons extends JPanel{
	Form form;
	
	public MenuButtons(Form form) {
		this.form = form;
		setOpaque(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		Buttons Start = new Buttons("Start Game",form);
		JButton ButtonT = Start.getButton();
		Buttons Tut  = new Buttons("Tutorial",form);
		JButton Tutorial = Tut.getButton();
		Buttons Ex = new Buttons("Exit",form);
		JButton Exit = Ex.getButton();
		c.anchor = GridBagConstraints.CENTER;
		add(ButtonT,c);
		c.gridy +=50;
		add(Tutorial,c);
		c.gridy+=50;
		add(Exit,c);
		
		
		
	
	}

	
	}

