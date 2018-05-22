package lviv.chess;

public class Queen extends Figure {
	String color;
	String name = "Queen";

	public Queen(String color) {
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
		return color == "white" ? "Q" : "q";
	}

	@Override
	public boolean moveRulesWhite(int a, int b, int c, int d) {
		if (((a + b) < (c + d) && (c - a) == (d - b)) || ((a + b) > (c + d) && (a - c) == (b - d))
				|| (((a + b) == (c + d) && (d >= a)) && (d - a) == (b - c))
				|| (((a + b) == (c + d) && (d <= a)) && (a - d) == (c - b))) {
			return true;
		} else if ((b != d && a != c)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean moveRulesBlack(int a, int b, int c, int d) {
		if (((a + b) < (c + d) && (c - a) == (d - b)) || ((a + b) > (c + d) && (a - c) == (b - d))
				|| (((a + b) == (c + d) && (d >= a)) && (d - a) == (b - c))
				|| (((a + b) == (c + d) && (d <= a)) && (a - d) == (c - b))) {
			return true;
		} else if ((b == d || a == c)) {
			return false;
		} else {
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean moveRulesAttack(int a, int b, int c, int d) {
		return true;
	}
}
