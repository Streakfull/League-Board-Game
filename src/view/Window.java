package view;

import javax.swing.*;
import java.awt.*;

abstract public class Window extends JFrame {
private int width;
private int height;
private String title;
private Color Background;

	
	
	public Window(int width,int height,String title,Color color) {
		super();
		this.width = width;
		this.height = height;
		this.title = title;
		this.Background = color;
		setSize(width,height);
		setTitle(title);
		getContentPane().setBackground(color);
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		
		}



	
	
		
	

}





