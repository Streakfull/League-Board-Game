package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ExceptionWindow extends JFrame  implements ActionListener{
	public static Font font = new Font("Yesteryear",Font.PLAIN,40);
	public static Font fonts = new Font("Friz Quadrata Std",Font.PLAIN,28);
	public ExceptionWindow(String Message) {
		super();
		setBounds(515,250,500,300);
		setTitle("Error");
		Color x = Color.BLACK;
		if(Form.fontp=="League") {
			ErrorBackgroundL p = new ErrorBackgroundL();
			p.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			JLabel errorMessage = new JLabel(Message);
				errorMessage.setFont(fonts);
				errorMessage.setForeground(x);
				StartGame s = new StartGame("Ok",20,this);
				p.add(errorMessage);
				c.gridy +=40;
				p.add(s,c);
				this.add(p);
			}
		else {
			ErrorBackground p = new ErrorBackground();
			p.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			JLabel errorMessage = new JLabel(Message);
				errorMessage.setFont(font);
				errorMessage.setForeground(x);
				StartGame s = new StartGame("Ok",20,this);
				p.add(errorMessage);
				c.gridy +=40;
				p.add(s,c);
				this.add(p);
			
		}
			
		
			
	
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ok"))
			this.dispose();
	
		
	}

	
	
}
