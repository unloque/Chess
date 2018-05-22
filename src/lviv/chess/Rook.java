package lviv.chess;

public class Rook extends Figure {
	String color;
	Figure figure = new Figure("pidr");
	String name="Rook";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rook(String color) {
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
		return color == "white" ? "R" : "r";
	}

	@Override
	public boolean moveRulesWhite(int a, int b, int c, int d) {
		if ((b != d && a != c)) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public boolean moveRulesBlack(int a, int b, int c, int d) {
		if ((b != d && a != c)) {
			return false;
		} else {
			return true;
		}
	}
	public boolean moveRulesAttack(int a, int b, int c, int d) {
		return moveRulesWhite(a, b, c, d)?true:false;

	}
}
