package view;
import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
public class Resources {
	public static Image bgMafia;
	public static Image bgTile;
	public static Image bgError;
	public static File Ashe;
	public static File Tristana;
	public static File Jax;
	public static File Blitz;
	public static File Nasus;
	public static File Sona;
	public static File Lulu;
	public static File MasterYi;
	public static File Lee_Sin;
	public static File Ekko;
	public static File Orianna;
	public static File Red;
	public static File Blue;
	public static File Khazix;
	public static File Ashep;
	public static File Tristanap;
	public static File Jaxp;
	public static File Blitzp;
	public static File Nasusp;
	public static File Sonap;
	public static File Lulup;
	public static File MasterYip;
	public static File Lee_Sinp;
	public static File Ekkop;
	public static File Oriannap;
	public static File Redp;
	public static File Bluep;
	public static File Khazixp;
	 // Create a Player object that realizes the audio
	 
	//rgb(226, 160, 34)
	//(198, 154, 67);
	public static Color league = new Color(226, 160, 34);
public static void Load() {
	  bgMafia=new ImageIcon("assets/"+Form.theme+"/mafia.jpg").getImage();
	  bgTile=new ImageIcon("assets/"+Form.theme+"/tile.jpg").getImage();
	  bgError =new  ImageIcon("assets/"+Form.theme+"/mafia.jpg").getImage();
	  Ashe = new File("assets/sounds/Ashe.wav");
	  Tristana = new File("assets/sounds/Tristana.wav");
	  Jax = new File("assets/sounds/Jax.wav");
	  Blitz = new File("assets/sounds/Blitz.wav");
	  Nasus = new File("assets/sounds/Nasus.wav");
	  Sona = new File("assets/sounds/Sona.wav");
	  Lulu = new File("assets/sounds/Lulu.wav");
	  MasterYi = new File("assets/sounds/MasterYi.wav");
	  Lee_Sin = new File("assets/sounds/Lee_Sin.wav");
	  Ekko = new File("assets/sounds/Ekko.wav");
	  Orianna = new File("assets/sounds/Oriana.wav");
	  Red = new File("assets/sounds/Red.wav");
	  Blue = new File("assets/sounds/Blue.wav");
	  Khazix = new File("assets/sounds/Khazix.wav");
	  Ashep = new File("assets/sounds/Ashep.wav");
	  Tristanap = new File("assets/sounds/Tristanap.wav");
	  Jaxp = new File("assets/sounds/Jaxp.wav");
	  Blitzp = new File("assets/sounds/Blitzp.wav");
	  Nasusp = new File("assets/sounds/Nasusp.wav");
	  Sonap = new File("assets/sounds/Sonap.wav");
	  Lulup = new File("assets/sounds/Lulup.wav");
	  MasterYip = new File("assets/sounds/MasterYip.wav");
	  Lee_Sinp = new File("assets/sounds/Lee_Sinp.wav");
	  Ekkop = new File("assets/sounds/Ekkop.wav");
	  Oriannap = new File("assets/sounds/Orianap.wav");
	  Khazixp = new File("assets/sounds/Khazixp.wav");
	  
	
	 }
}

