package lviv.chess;

import java.util.Arrays;

import javax.swing.ImageIcon;

public class ChessPawn extends ChessInterface {
	ImageIcon pawnwhite = new ImageIcon("images/negr.jpg");
	String color;

	ChessPawn(String color) {
		ImageIcon pawnwhite = new ImageIcon("images/negr.jpg");
		ChessPawn[][] figures = new ChessPawn[8][8];
		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				if (i == 1) {
					figures[i][j] = new ChessPawn("black");
					System.out.println("BlackPawn created");
				} else if (i == figures.length - 2) {
					figures[i][j] = new ChessPawn("white");
					System.out.println("WhitePawn created");
				}
			}
		}

	}

	void PawnLogic() {

	}
}
