package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Theme extends Window implements ActionListener{
		public static Font f;
		public static Font fs;
	public Theme() {
		super(400,100,"Main Menu",Color.BLACK);
		setBounds(100, 100, Form.ScreenWidth,Form.ScreenHeight);
		setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		JLabel prompt = new JLabel(" Please Choose a Theme:");
		prompt.setForeground(Color.WHITE);
		prompt.setFont(Form.font);
		Border border = BorderFactory.createMatteBorder(0,0,5,0,Color.WHITE);
		prompt.setBorder(border);
		JPanel b = new JPanel();
		b.setOpaque(false);
		b.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		ThemeButtons Start = new ThemeButtons("Mafia",this);
		JButton ButtonT = Start.getButton();
		ThemeButtons Tut  = new ThemeButtons(" LeagueOfLegends",this);
		JButton Tutorial = Tut.getButton();
		ThemeButtons Ex = new ThemeButtons("Exit",this);
		JButton Exit = Ex.getButton();
		c.anchor = GridBagConstraints.CENTER;
		b.add(ButtonT,c);
		c.gridy +=50;
		b.add(Tutorial,c);
		c.gridy+=50;
		b.add(Exit,c);
		p.setOpaque(false);
		p.add(prompt);
		
		
		this.add(p,BorderLayout.PAGE_START);
		this.add(b,BorderLayout.CENTER);
		this.setVisible(true);
		
		
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getActionCommand().equals("Mafia"))) {
			Form.setTheme("Images");
			Form.fontp = ("fonts");
			Resources.Load();
			try {
				new Form();
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*try {
				new Board("Youssef","ASHE");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			this.dispose();
			
		}
		if((e.getActionCommand().equals(" LeagueOfLegends"))) {
			Form.setTheme("ImagesL");
			Form.fontp="League";
			 f = new Font("Friz Quadrata Std",Font.PLAIN,45);
			 fs = new Font("Friz Quadrata Std",Font.PLAIN,15);
			 
			 
			try {
				Fonts.installFontsL();
			} catch (FontFormatException | IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			Resources.Load();
			
			try {
				Fonts.installFonts();
			} catch (FontFormatException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				new Form();
				
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*try {
				new Board("youssef","ASHE");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		this.dispose();
	}
		if((e.getActionCommand().equals("Exit"))) {
			System.exit(0);
			}
	
	
}}
