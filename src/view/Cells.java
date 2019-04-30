package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import model.game.Game;

public class Cells extends JPanel {
	private static Tiles[][] tiles;
	private static Game game;
	public Cells(Game games ) {
		
		super();
		game = games;
		this.setLayout(new GridLayout(7,6));
		//setBorder(BorderFactory.createEmptyBorder());
		tiles = new Tiles [7][6];
		setEmptyTiles();
		updatesButtons();
		
	}
	public void setEmptyTiles(){
		for(int i=0;i<7;i++) {
			for(int j =0;j<6;j++) {
				Tiles tile = new Tiles();
				this.add(tile);
				tiles[i][j] = tile;
			}
			}
	}
	
					
public static void updatesButtons() {
		for(int i=0;i<7;i++) {
			for(int j =0;j<6;j++) {
				ButtonCells b = tiles[i][j].GetButtons();
				b.setI(i);
				b.setJ(j);
				if(!(game.getCellAt(i, j).isEmpty())) {
					b.setPiece(game.getCellAt(i, j).getPiece());
					b.setName(game.getCellAt(i,j).getPiece().getName());
					b.setIconsCustom(game.getCellAt(i, j).getPiece());
				}else {
					b.reset();
					//tiles[i][j].setWhiteBorder();
				}
				
									}
			
		
						}
				
					
					
						
						
				
}
public static Game getGame() {
	return game;
}

	
	
	
	

}
