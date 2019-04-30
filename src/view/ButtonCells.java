package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import controller.ButtonControl;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;
public class ButtonCells extends JButton implements ActionListener {

	public  static ButtonControl listener = new ButtonControl();
	private String name;
	private Piece piece;
	private int i;
	private int j;
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	private Border border2 = BorderFactory.createLineBorder(Color.WHITE);
	private Border border3 = BorderFactory.createEmptyBorder();
	private static ImageIcon medic = scale(new ImageIcon("assets/"+Form.theme+"/Medic.png"),90,90);
	private static ImageIcon armored = scale(new ImageIcon("assets/"+Form.theme+"/armored.png"),90,90);
	private static ImageIcon ranged =	scale(new ImageIcon("assets/"+Form.theme+"/Ranged.png"),90,90);
	private static ImageIcon speedster =scale(new ImageIcon("assets/"+Form.theme+"/Speedster.png"),90,90);
	private static ImageIcon supert = scale(new ImageIcon("assets/"+Form.theme+"/Super.png"),90,90);
	private static ImageIcon tech = scale(new ImageIcon("assets/"+Form.theme+"/Tech.png"),90,90);
	private static ImageIcon sideKick1 = scale(new ImageIcon("assets/"+Form.theme+"/SideKick1.png"),90,90);
	private static ImageIcon sideKick2 = scale(new ImageIcon("assets/"+Form.theme+"/SideKick2p2.png"),90,90);
	private static ImageIcon medicp2 = 	scale(new ImageIcon("assets/"+Form.theme+"/Medicp2.png"),90,90);
	private static ImageIcon armoredp2 =scale(new ImageIcon("assets/"+Form.theme+"/Armoredp2.png"),90,90);
	private static ImageIcon rangedp2 =	scale(new ImageIcon("assets/"+Form.theme+"/Rangedp2.png"),90,90);
	private static ImageIcon speedsterp2 =scale(new ImageIcon("assets/"+Form.theme+"/Speedsterp2.png"),90,90);
	private static ImageIcon supertp2 = scale(new ImageIcon("assets/"+Form.theme+"/Superp2.png"),90,90);
	private static ImageIcon techp2 = scale(new ImageIcon("assets/"+Form.theme+"/Techp2.png"),90,90);
	private static ImageIcon medic2 = new ImageIcon("assets/"+Form.theme+"/Medic2.png");
	private static ImageIcon armored2 =	new ImageIcon("assets/"+Form.theme+"/Armored2.png");
	private static ImageIcon ranged2 = 	new ImageIcon("assets/"+Form.theme+"/ranged2.png");
	private static ImageIcon speedster2= new ImageIcon("assets/"+Form.theme+"/speedster2.png");
	private static ImageIcon supert2 =new ImageIcon("assets/"+Form.theme+"/Super2.png");
	private static ImageIcon tech2 = new ImageIcon("assets/"+Form.theme+"/tech2.png");
	private static ImageIcon sideKick1s =new ImageIcon("assets/"+Form.theme+"/SideKick1s.png");
	private static ImageIcon sideKick2s =new ImageIcon("assets/"+Form.theme+"/SidKick2s.png");
	private static ImageIcon medic2s = new ImageIcon("assets/"+Form.theme+"/Medicp2s.png");
	private static ImageIcon armored2s =	new ImageIcon("assets/"+Form.theme+"/Armoredp2s.png");
	private static ImageIcon ranged2s = 	new ImageIcon("assets/"+Form.theme+"/rangedp2s.png");
	private static ImageIcon speedster2s= new ImageIcon("assets/"+Form.theme+"/speedsterp2s.png");
	private static ImageIcon supert2s =new ImageIcon("assets/"+Form.theme+"/Superp2s.png");
	private static ImageIcon tech2s = new ImageIcon("assets/"+Form.theme+"/techp2s.png");
	
	
@Override
public Border getBorder() {
		return border;
	}
public void setI(int i) {
	this.i = i;
}
public void setJ(int j) {
	this.j = j;
}
public int getI() {
	return i;
}
public int getJ() {
	return j;
}


	public Border getBorder2() {
		return border2;
	}


	public Border getBorder3() {
		return border3;
	}


	public static ImageIcon getMedic() {
		return medic;
	}


	public static ImageIcon getArmored() {
		return armored;
	}


	public static ImageIcon getRanged() {
		return ranged;
	}


	public static ImageIcon getSpeedster() {
		return speedster;
	}


	public static ImageIcon getSupert() {
		return supert;
	}


	public static ImageIcon getTech() {
		return tech;
	}


	public static ImageIcon getSideKick1() {
		return sideKick1;
	}


	public static ImageIcon getSideKick2() {
		return sideKick2;
	}


public ButtonCells() {
		super();
		this.setFont(Form.font);
		this.setForeground(Color.WHITE);
		setContentAreaFilled(false);
		setOpaque(false);	
	   this.setBorder(border3);
	   this.piece = null;
	   this.name = "";
	   this.addActionListener(this);
	   this.setActionCommand("Cell");
	   
	}
public ButtonCells(DeadCharacters s) {
	super();
	this.setFont(Form.font);
	this.setForeground(Color.WHITE);
	setContentAreaFilled(false);
	setOpaque(false);
	this.setFocusable(false);
   this.setBorder(border3);
   this.setBorderPainted(false);
   this.setPreferredSize(new Dimension(40,40));
   this.piece = null;
   this.name = "";
   this.addActionListener(this);
   this.setActionCommand("dead");
}
public ButtonCells(DeadCharactersP2 s) {
	super();
	this.setFont(Form.font);
	this.setForeground(Color.BLACK);
	setContentAreaFilled(false);
	setOpaque(false);
	this.setFocusable(false);
	this.setBorder(border3);
	this.setBorderPainted(false);
	this.setPreferredSize(new Dimension(40,40));
	this.piece = null;
	this.name = "";
	this.addActionListener(this);
	this.setActionCommand("dead");
}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public static ImageIcon scale(ImageIcon is,int i,int j) {
		if(Form.fontp=="League")
			return is;
		Image img = is.getImage();  
		   Image newimg = img.getScaledInstance( i, j, java.awt.Image.SCALE_SMOOTH);
		   return  new ImageIcon(newimg);
	}
	public void setIconsCustom(Piece p) {
		boolean player2Flag = false;
		if(p.getOwner().equals(Cells.getGame().getPlayer2()))
				player2Flag = true;
		String R = "";
		String arm = "";
		String powerUse ="No";
		String owner = p.getOwner().getName();
		if(p instanceof Armored) {
			R = "Armored";
			if(player2Flag) {
				this.setIcon(armoredp2);}
				else {
					this.setIcon(armored);}
			if(((Armored) p).isArmorUp()) {
				arm = "Armor: Up";}
			else {
				arm = "Armor: Down";
			}
			}
		if(p instanceof Medic) {
			R = "Medic";
			
			if(((Medic) p).isPowerUsed())
				powerUse = "Yes";
			if(player2Flag)
				this.setIcon(medicp2);
			else
				this.setIcon(medic);}
		
		
		if(p instanceof Ranged) {
			R = "Ranged";
			
			if(((Ranged) p).isPowerUsed())
				powerUse = "Yes";
			
			if(player2Flag)
			this.setIcon(rangedp2);
		else
			this.setIcon(ranged);}
		
		if(p instanceof Speedster) {
			R = "Speedster";
			if(player2Flag)
				this.setIcon(speedsterp2);
			else
				this.setIcon(speedster);
		}
		    
		if(p instanceof Super) {
			R = "Super";
			
			if(((Super) p).isPowerUsed())
				powerUse = "Yes";
			if(player2Flag)
				this.setIcon(supertp2);
			else
				this.setIcon(supert);
			
		}
		if(p instanceof Tech) {
			R = "Tech";
			if(((Tech) p).isPowerUsed())
				powerUse = "Yes";
			if(player2Flag)
				this.setIcon(techp2);
			else
				this.setIcon(tech);
			
		}
		if(p instanceof SideKickP1) {
			R ="Sidekick";
			this.setIcon(sideKick1);
			
		}
		if(p instanceof SideKickP2) {
			R = "Sidekick";
			this.setIcon(sideKick2);
			
		}
		
		String own = "Owner: " +owner;
		String cls = "Type: "+ R ;
		this.setToolTipText("<html><p width=\"90\">" +own+"<br>"+cls+arm+"<br>"+"PowerUsed: "+powerUse+ "</p></html>");
			
			
		
	}public void setIconsCustom(Piece p,int x ) {
		if(Form.fontp=="League") {
			boolean player2Flag = false;
			if(p.getOwner().equals(Cells.getGame().getPlayer2()))
					player2Flag = true;
			String R = "";
			String arm = "";
			String powerUse ="No";
			String owner = p.getOwner().getName();
			if(p instanceof Armored) {
				R = "Armored";
				if(player2Flag) {
					this.setIcon(armored2s);}
					else {
						this.setIcon(armored2);}
				if(((Armored) p).isArmorUp()) {
					arm = "Armor: Up";}
				else {
					arm = "Armor: Down";
				}
				}
			if(p instanceof Medic) {
				R = "Medic";
				
				if(((Medic) p).isPowerUsed())
					powerUse = "Yes";
				if(player2Flag)
					this.setIcon(medic2s);
				else
					this.setIcon(medic2);}
			
			
			if(p instanceof Ranged) {
				R = "Ranged";
				
				if(((Ranged) p).isPowerUsed())
					powerUse = "Yes";
				
				if(player2Flag)
				this.setIcon(ranged2s);
			else
				this.setIcon(ranged2);}
			
			if(p instanceof Speedster) {
				R = "Speedster";
				if(player2Flag)
					this.setIcon(speedster2s);
				else
					this.setIcon(speedster2);
			}
			    
			if(p instanceof Super) {
				R = "Super";
				
				if(((Super) p).isPowerUsed())
					powerUse = "Yes";
				if(player2Flag)
					this.setIcon(supert2s);
				else
					this.setIcon(supert2);
				
			}
			if(p instanceof Tech) {
				R = "Tech";
				if(((Tech) p).isPowerUsed())
					powerUse = "Yes";
				if(player2Flag)
					this.setIcon(tech2s);
				else
					this.setIcon(tech2);
				
			}
			if(p instanceof SideKickP1) {
				R ="Sidekick";
				this.setIcon(sideKick1s);
				
			}
			if(p instanceof SideKickP2) {
				R = "Sidekick";
				this.setIcon(sideKick2s);
				
			}
			
			String own = "Owner: " +owner;
			String cls = "Type: "+ R ;
			this.setToolTipText("<html><p width=\"90\">" +own+"<br>"+cls+arm+"<br>"+"PowerUsed: "+powerUse+ "</p></html>");
			
			
			
		}
		
		
		
		else {
		String R = "";
		String arm = "";
		String powerUse ="No";
		String owner = p.getOwner().getName();
		if(p.getOwner().equals(Cells.getGame().getPlayer2())) {
			this.setBorder(border2);
		}
		if(p instanceof Armored) {
			R = "Armored";
			if(((Armored) p).isArmorUp()) {
				arm = "Armor: Up";
			}
			else {
				arm = "Armor: Down";
			}
			this.setIcon(armored2);
		
			
		}
		if(p instanceof Medic) {
			R = "Medic";
			this.setIcon(medic2);
			if(((Medic) p).isPowerUsed())
				powerUse = "Yes";
			}
		if(p instanceof Ranged) {
			R = "Ranged";
			this.setIcon(ranged2);
			if(((Ranged) p).isPowerUsed())
				powerUse = "Yes";
			
		}
		
		if(p instanceof Speedster) {
			R = "Speedster";
			this.setIcon(speedster2);
						
		}
		if(p instanceof Super) {
			R = "Super";
			this.setIcon(supert2);
			if(((Super) p).isPowerUsed())
				powerUse = "Yes";
			
		}
		if(p instanceof Tech) {
			R = "Tech";
			this.setIcon(tech2);
			if(((Tech) p).isPowerUsed())
				powerUse = "Yes";
			
		}
		if(p instanceof SideKickP1) {
			R ="Sidekick";
			this.setIcon(sideKick1s);
			
		}
		if(p instanceof SideKickP2) {
			R = "Sidekick";
			this.setIcon(sideKick2s);
			
		}
		
		String own = "Owner: " +owner +("\n");
		String cls = "Type: "+ R +("\n") ;
		this.setToolTipText("<html><p width=\"90\">" +own+"<br>"+cls+arm+"<br>"+"PowerUsed: "+powerUse+ "</p></html>");}}
	
	
	
	
	
	
	
	
	
	public void reset() {
		this.setPiece(null);
		this.setName("");
		this.setIcon(null);
		this.setText("");
		this.setBorder(border2);
		this.setToolTipText("");
	}


	public ActionListener getListener() {
		return listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getActionCommand().equals("Cell"))) {
			if(this.piece!=null&&ButtonControl.tp==false&&ButtonControl.tech==false&&(this!=ButtonControl.getCurrentCell()))
				this.piece.playChampSelect();
			listener.setCurrentCell(this);
			PlayerControl.setCurrentButton(this);
			PlayerControl2.setCurrentButton(this);			
			if(ButtonControl.getTech()) {
				if(ButtonControl.tp==true) {
					listener.setTechTp(this);
					listener.tele();
					return;}
				if(this.getPiece()==null) {
					System.out.println(i+" "+j);
					ButtonControl.tp = true;
					listener.Location = new Point(this.i,this.j);
					
				}
				else {
				
				listener.useTech();}  
				}}
			
				
		if((e.getActionCommand().equals("dead"))) {
			listener.setRevived(this);
			
		}
			
	}}
	 
	
	
	


