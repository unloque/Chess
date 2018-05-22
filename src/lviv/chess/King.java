package lviv.chess;

public class King extends Figure {
	String color;
	String name = "King";

	@Override
	public boolean moveRulesWhite(int a, int b, int c, int d) {
		if (((c == a + 1) && (d == b + 1) || ((c == a + 1) && (d == b - 1)) || ((c == a + 1) && (d == b))
				|| ((c == a) && (d == b + 1)) || ((c == a) && (d == b - 1)) || ((c == a - 1) && (d == b + 1))
				|| ((c == a - 1) && (d == b - 1)) || ((c == a - 1) && (d == b)))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean moveRulesBlack(int a, int b, int c, int d) {
		if (((c == a + 1) && (d == b + 1) || ((c == a + 1) && (d == b - 1)) || ((c == a + 1) && (d == b))
				|| ((c == a) && (d == b + 1)) || ((c == a) && (d == b - 1)) || ((c == a - 1) && (d == b + 1))
				|| ((c == a - 1) && (d == b - 1)) || ((c == a - 1) && (d == b)))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean moveRulesAttack(int a, int b, int c, int d) {

		return moveRulesWhite(a, b, c, d)?true:false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public King(String color) {
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
		return color == "white" ? "K" : "k";
	}

}
