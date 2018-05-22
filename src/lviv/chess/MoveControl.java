package lviv.chess;

public class MoveControl {
	public int returnerI(char i) {
		int numToReturn=0;
		switch (i) {
		case '8':
			numToReturn=0;
			break;
		case '7':
			numToReturn= 1;
			break;
		case '6':
			numToReturn= 2;
			break;
		case '5':
			numToReturn= 3;
			break;
		case '4':
			numToReturn= 4;
			break;
		case '3':
			numToReturn= 5;
			break;
		case '2':
			numToReturn= 6;
			break;
		case '1':
			numToReturn= 7;
			break;
		default:
			numToReturn=10;
		}
		return numToReturn;
	}

	public int returnerJ(char j) {
		switch (j) {
		case ('a' | 'A'):
			return 0;
		case ('b' | 'B'):
			return 1;
		case ('c' | 'C'):
			return 2;
		case ('d' | 'D'):
			return 3;
		case ('e' | 'E'):
			return 4;
		case ('f' | 'F'):
			return 5;
		case ('g' | 'G'):
			return 6;
		case ('h' | 'H'):
			return 7;
		default:
			return 10;
		}
	}

}
