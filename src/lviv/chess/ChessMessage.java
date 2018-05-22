package lviv.chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

class ChessMessage extends JComponent {
	public static int MESSAGE_X = 0;
	public static int MESSAGE_Y = 0;
	private static final int DEFAULT_WIDTH = 549;
	private static final int DEFAULT_HEIGHT = 550;

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("images/chessboard.png").getImage();
		Image blackPawn=new ImageIcon("images/BlackKing.png").getImage();
		g.drawImage(img, 0, 0, this);
		System.out.println(MESSAGE_X);
		for(int i=0;i<8;i++) {
			g.drawImage(blackPawn, 0, 0, this);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
