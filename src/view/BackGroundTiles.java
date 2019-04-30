package view;


	import java.awt.Graphics;
	import java.awt.Image;

	import javax.swing.JPanel;

public class BackGroundTiles extends JPanel {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		Image bg ;
	    @Override
	    public void paintComponent(Graphics g) {
	    	g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
		public BackGroundTiles() {
			super();
			bg = Resources.bgTile;
		}
	    
	   
	}



