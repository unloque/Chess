package lviv.chess;

public class Knight extends Figure {
	String color;
	String name = "Knight";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Knight(String color) {
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
		return color == "white" ? "H" : "h";
	}

	@Override
	public boolean moveRulesWhite(int a, int b, int c, int d) {
		if (a >= 0 && a <= 7 && b >= 0 && b <= 7 && c >= 0 && c <= 7 && d >= 0 && d <= 7
				&& (((c == a - 2) && (d == b + 1)) || ((c == a - 1) && (d == b + 2)) || ((c == a - 2) && (d == b - 1))
						|| ((c == a - 1) && (d == b - 2)) || ((c == a + 1) && (d == b - 2))
						|| ((c == a + 1) && (d == b + 2)) || ((c == a + 2) && (d == b + 1)))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean moveRulesBlack(int a, int b, int c, int d) {
		if (a >= 0 && a <= 7 && b >= 0 && b <= 7 && c >= 0 && c <= 7 && d >= 0 && d <= 7
				&& (((c == a - 2) && (d == b + 1)) || ((c == a - 1) && (d == b + 2)) || ((c == a - 2) && (d == b - 1))
						|| ((c == a - 1) && (d == b - 2)) || ((c == a + 1) && (d == b - 2))
						|| ((c == a + 1) && (d == b + 2)) || ((c == a + 2) && (d == b + 1))|| ((c == a + 2) && (d == b - 1)))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean moveRulesAttack(int a, int b, int c, int d) {
		return moveRulesWhite(a, b, c, d)?true:false;
	}
}
