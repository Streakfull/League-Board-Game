package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ThemeButtons {
	private Form form;
	private JButton Button;
		public ThemeButtons(String name,Theme theme) {
			JButton ButtonT = new JButton(name);
			ButtonT.setFont(Form.font);
			ButtonT.setForeground(Color.WHITE);
			Border border = BorderFactory.createMatteBorder(0,0,5,0,Color.WHITE);
			ButtonT.setBorder(border);
			ButtonT.setContentAreaFilled(false);
			this.Button = ButtonT;
			ButtonT.addActionListener(theme);
			Button.setFocusable(false);
			
			}
		
		
		public JButton getButton() {
			return Button;
		}

		
		
}
