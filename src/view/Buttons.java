package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Buttons {
private Form form;
private JButton Button;
	public Buttons(String name,Form form) {
		JButton ButtonT = new JButton(name);
		ButtonT.setFont(Form.font);
		ButtonT.setForeground(Color.WHITE);
		Border border = BorderFactory.createMatteBorder(0,0,5,0,Color.WHITE);
		ButtonT.setBorder(border);
		ButtonT.setContentAreaFilled(false);
		this.Button = ButtonT;
		ButtonT.addActionListener(form);
		
		}
	public Buttons(String name,Form form,int size,Color color) {
		JButton ButtonT = new JButton(name);
		ButtonT.setFont(new Font("Yesteryear",Font.PLAIN,size));
		ButtonT.setForeground(color);
		Border border = BorderFactory.createLineBorder(color);
		//Border border = BorderFactory.createLineBorder(color);	
		ButtonT.setBorder(border);
		ButtonT.setContentAreaFilled(false);
		this.Button = ButtonT;
		ButtonT.addActionListener(form);
		
		
		
	}
	
	
	
	public JButton getButton() {
		return Button;
	}

	
	
	
}
