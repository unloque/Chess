package lviv.chess;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Pawn extends Figure {
	String color;
	String name = "Pawn";
	ImageIcon img = new ImageIcon("images/WhitePawn.jpg");

	public String getName() {
		return name;
	}

	public Pawn(String color) {
		super(color);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color == "white" ? "P" : "p";
	}

	@Override
	public void Move(int a, int b, int c, int d) {
		if (figures[a][b].color == turnColor) {
			if (figures[c][d].color != figures[a][b].color) {
				figures[c][d] = figures[a][b];
				figures[a][b] = new Figure("pidr");
				if (turnColor == "white") {
					turnColor = "black";
				} else {
					turnColor = "white";
				}
			} else {
				System.out.println("You can't beat allies");
			}
		} else {
			System.out.println("Not Your PAWN move!");
		}
		System.out.println("PAWN WAS MOVED BOOOOOY");
	}

	@Override
	public boolean moveRulesWhite(int a, int b, int c, int d) {
		if (b != d || a < c || (a == 6 && (a - c) > 2) || (a != 6 && (a - c) > 1)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean moveRulesBlack(int a, int b, int c, int d) {
		if (b != d || a > c || (a == 1 && (a + c) > 4) || (a != 1 && (c - a) >= 2)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean moveRulesAttack(int a, int b, int c, int d) {
		if ((b - 1 == d || b + 1 == d) && (c == a + 1 || c == a - 1)) {
			return true;
		} else {
			return false;
		}
	}
}