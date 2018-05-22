package lviv.chess;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Figure {
	Boolean checkerForInterface = false;
	String color;
	Figure figures[][] = new Figure[8][8];
	String turnColor = "white";
	String name;
	Boolean pawnToQueen=false;
	boolean whiteChecker = false;
	boolean blackChecker = true;
	ImageIcon img = new ImageIcon("images/WhitePawn.jpg");

	public Figure(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void spawnFigures() {
		System.out.println("   A B C D E F G H");
		System.out.println("   ################");
		for (int i = 0, counter = 8; i < figures.length; i++, counter--) {
			System.out.print(counter + " |");
			for (int j = 0; j < figures[i].length; j++) {
				if (i == 1) {
					figures[i][j] = new Pawn("black");
				} else if (i == figures.length - 2) {
					figures[i][j] = new Pawn("white");
				} else if (i == 0 && j == 4) {
					figures[i][j] = new King("black");
				} else if (i == figures.length - 1 && j == 4) {
					figures[i][j] = new King("white");
				} else if ((i == 0) && (j == 0 || j == figures[i].length - 1)) {
					figures[i][j] = new Rook("black");
				} else if ((i == figures.length - 1) && (j == 0 || j == figures[i].length - 1)) {
					figures[i][j] = new Rook("white");
				} else if ((i == 0) && (j == 1 || j == figures[i].length - 2)) {
					figures[i][j] = new Knight("black");
				} else if ((i == figures.length - 1) && (j == 1 || j == figures[i].length - 2)) {
					figures[i][j] = new Knight("white");
				} else if ((i == 0) && (j == 2 || j == figures[i].length - 3)) {
					figures[i][j] = new Bishop("black");
				} else if ((i == figures.length - 1) && (j == 2 || j == figures[i].length - 3)) {
					figures[i][j] = new Bishop("white");
				} else if ((i == 0) && (j == 3 || j == figures[i].length - 4)) {
					figures[i][j] = new Queen("black");
				} else if ((i == figures.length - 1) && (j == 3 || j == figures[i].length - 4)) {
					figures[i][j] = new Queen("white");
				} else {
					figures[i][j] = new Figure("neutral");
				}
				System.out.print(figures[i][j].toString() + " ");
			}
			System.out.println("|");
		}

	}

	public String getName() {
		return "neutralFigure";
	}

	public void showFigures() {
		System.out.println("   A B C D E F G H");
		System.out.println("   ################");
		for (int i = 0, counter = 8; i < figures.length; i++, counter--) {
			System.out.print(counter + " |");
			for (int j = 0; j < figures[i].length; j++) {

				// Работаем с num

				System.out.print(figures[i][j].toString() + " ");
			}
			System.out.println("|");
		}
	}

	public void Move(int a, int b, int c, int d) {
		if ((((figures[a][b].getColor() == "black" && figures[c][d].getColor() == "white"
				&& figures[a][b].moveRulesAttack(a, b, c, d))
				|| (figures[a][b].getColor() == "white" && figures[c][d].getColor() == "black"
						&& figures[a][b].moveRulesAttack(a, b, c, d)))
				|| ((figures[a][b].getColor() == "white" && figures[c][d].getColor() == "neutral"
						&& figures[a][b].moveRulesWhite(a, b, c, d))
						|| (figures[a][b].getColor() == "black" && figures[c][d].getColor() == "neutral"
								&& figures[a][b].moveRulesBlack(a, b, c, d))))
				&& onWayChecker(a, b, c, d)) {
			if (figures[a][b].color == turnColor) {
				if (figures[c][d].color != figures[a][b].color) {
					figures[c][d] = figures[a][b];
					figures[a][b] = new Figure("neutral");
					checkerForInterface = true;
					if (turnColor == "white") {
						turnColor = "black";
					} else {
						turnColor = "white";

					}
				} else {
					System.out.println("You can't beat allies");
				}
			} else {
				System.out.println("Not Your move!");
				checkerForInterface = false;

			}
		} else {
			checkerForInterface = false;

			System.out.println("Whoops");
		}
	}

	@Override
	public String toString() {
		return "_";
	}

	public boolean moveRulesWhite(int a, int b, int c, int d) {
		return false;
	}

	public boolean moveRulesBlack(int a, int b, int c, int d) {
		return false;
	}

	public boolean moveRulesAttack(int a, int b, int c, int d) {
		return false;
	}

	public boolean onWayChecker(int a, int b, int c, int d) {
		boolean queenCheckerRook = true;
		boolean queenCheckerBishop = true;
		pawnToQueen=false;
		if (figures[a][b].getName() == "Rook" || figures[a][b].getName() == "Queen") {
			if (a == c) {
				int waychecker = b - d;
				if (waychecker > 0) {
					for (int i = 1; i < waychecker; i++) {
						if (figures[a][b - i].color == "white" || figures[a][b - i].color == "black") {
							if (figures[a][b].getName() == "Rook")
								return false;
							queenCheckerRook = false;
						}
					}
				} else if (d > b) {
					waychecker = d - b;
					for (int i = 1; i < waychecker; i++) {
						if (figures[a][b + i].color == "white" || figures[a][b + i].color == "black") {
							if (figures[a][b].getName() == "Rook")
								return false;
							queenCheckerRook = false;
						}
					}
				}
			}
			if (b == d && a != c) {
				int waychecker = a - c;
				if (waychecker > 0) {
					for (int i = 1; i < waychecker; i++) {
						if (figures[a - i][b].color == "white" || figures[a - i][b].color == "black") {
							if (figures[a][b].getName() == "Rook")
								return false;
							queenCheckerRook = false;
						}
					}
				} else if (waychecker < 0) {
					waychecker = c - a;
					for (int i = 1; i < waychecker; i++) {
						if (figures[a + i][b].color == "white" || figures[a + i][b].color == "black") {
							if (figures[a][b].getName() == "Rook")
								return false;
							queenCheckerRook = false;

						}
					}
				}
			}
		}
		if (figures[a][b].getName() == "Bishop" || figures[a][b].getName() == "Queen") {
			int checkerAB = a + b;
			int checkerCD = c + d;
			if (checkerCD == checkerAB) {
				if (a < c) {

					while (a < c) {
						int i = 1;
						if (figures[a + i][b - i].color == "white" || figures[a + i][b - i].color == "black") {
							if (figures[a][b].getName() == "Bishop")
								return false;
							queenCheckerBishop = false;
						}
						i++;
						break;
					}
				} else {
					while (a > c + 1) {
						int i = 1;
						if (figures[a - i][b + i].color == "white" || figures[a - i][b + i].color == "black") {
							if (figures[a][b].getName() == "Bishop")
								return false;
							queenCheckerBishop = false;
						}
						i++;
						break;
					}
				}
			} else if (checkerAB > checkerCD) {
				while (a > c) {
					int i = 1;
					if (figures[a - i][b - i].color == "white" || figures[a - i][b - i].color == "black") {
						if (figures[a][b].getName() == "Bishop")
							return false;
						queenCheckerBishop = false;
					}
					i++;
					break;
				}
			} else if (checkerAB < checkerCD) {
				while (a + 1 < c) {
					int i = 1;
					if (figures[a + i][b + i].color == "white" || figures[a + i][b + i].color == "black") {
						if (figures[a][b].getName() == "Bishop")
							return false;
						queenCheckerBishop = false;
					}
					i++;
					break;
				}
			}
		}
		if (figures[a][b].getName() == "Queen") {
			if (queenCheckerBishop
					&& (((a + b) < (c + d) && (c - a) == (d - b)) || ((a + b) > (c + d) && (a - c) == (b - d))
							|| (((a + b) == (c + d) && (d >= a)) && (d - a) == (b - c))
							|| (((a + b) == (c + d) && (d <= a)) && (a - d) == (c - b)))
					|| queenCheckerRook && (b == d || a == c)) {
				return true;
			} else {
				return false;
			}
		}
		if (figures[a][b].getName() == "Pawn") {
			if (figures[a][b].color == "white" && c == 0) {
				figures[a][b] = new Figure("neutral");
				figures[c][d] = new Queen("white");
				turnColor = "black";
				pawnToQueen=true;
			}
			if (figures[a][b].color == "black" && c == 7) {
				figures[a][b] = new Figure("neutral");
				figures[c][d] = new Queen("black");
				turnColor = "white";
				pawnToQueen=true;
			}
		}
		return true;
	}

	public boolean checkReturner() {
		int counter = 0;
		for (int i = 0; i < figures.length; i++) {
			for (int j = 0; j < figures[i].length; j++) {
				if (figures[i][j].getName() == "King") {
					counter++;
				}
			}
		}
		return counter == 2 ? true : false;
	}
}
