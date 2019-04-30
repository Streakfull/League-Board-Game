package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.IOException;

public class Fonts{
	
public static void installFonts() throws FontFormatException, IOException {	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("assets/fonts/Yesteryear.ttf")));
	
}
public static void installFontsL() throws FontFormatException, IOException {	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("assets/fontsL/league.otf")));
	
}
}


