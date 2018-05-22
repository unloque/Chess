package lviv.chess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ResourceBundle.Control;

@SuppressWarnings("serial")

public class ChessInterface extends JFrame implements ActionListener {
	Figure figure = new Figure("nomatter");
	int result1;
	MoveControl movecontrol = new MoveControl();
	JLabel label1;
	JLabel label2;
	JLabel chessBoard;
	Panel panel;
	Boolean goodBoy;
	JLabel[][] label = new JLabel[8][8];

	ChessInterface() {
		super("it will be chess, m8");
		JLayeredPane layeredPane = new JLayeredPane();
		ImageIcon blackPawn = new ImageIcon("images/BlackPawn.png");
		ImageIcon whitePawn = new ImageIcon("images/WhitePawn.png");
		ImageIcon blackQueen = new ImageIcon("images/BlackQueen.png");
		ImageIcon blackRook = new ImageIcon("images/BlackRook.png");
		ImageIcon blackBishop = new ImageIcon("images/BlackBishop.png");
		ImageIcon blackKing = new ImageIcon("images/BlackKing.png");
		ImageIcon blackKnight = new ImageIcon("images/BlackKnight.png");
		ImageIcon whiteQueen = new ImageIcon("images/WhiteQueen.png");
		ImageIcon whiteRook = new ImageIcon("images/WhiteRook.png");
		ImageIcon whiteKing = new ImageIcon("images/WhiteKing.png");
		ImageIcon whiteKnight = new ImageIcon("images/WhiteKnight.png");
		ImageIcon whiteBishop = new ImageIcon("images/WhiteBishop.png");
		ImageIcon transparent = new ImageIcon("images/trans.png");
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				if (i == 1) {
					label[i][j] = new JLabel(blackPawn);
					label[i][j].setBounds(j * 69, i * 72, 66, 67);

				} else if (i == label.length - 2) {
					label[i][j] = new JLabel(whitePawn);
					label[i][j].setBounds(j * 69, 413, 66, 67);

				} else if (i == 0 && j == 4) {
					label[i][j] = new JLabel(blackKing);
					label[i][j].setBounds(275, 3, 66, 67);

				} else if (i == label.length - 1 && j == 4) {
					label[i][j] = new JLabel(whiteKing);
					label[i][j].setBounds(275, 480, 66, 67);

				} else if ((i == 0) && (j == 0 || j == label[i].length - 1)) {
					label[i][j] = new JLabel(blackRook);
					if (j == 0) {
						label[i][j].setBounds(0, 2, 66, 67);
					} else {
						label[i][j].setBounds(478, 2, 66, 67);
					}

				} else if ((i == label.length - 1) && (j == 0 || j == label[i].length - 1)) {
					label[i][j] = new JLabel(whiteRook);
					if (j == 0) {
						label[i][j].setBounds(0, 482, 66, 67);
					} else {
						label[i][j].setBounds(478, 480, 66, 67);
					}

				} else if ((i == 0) && (j == 1 || j == label[i].length - 2)) {
					label[i][j] = new JLabel(blackKnight);
					if (j == 1) {
						label[i][j].setBounds(70, 2, 66, 67);
					} else {
						label[i][j].setBounds(412, 2, 66, 67);
					}

				} else if ((i == label.length - 1) && (j == 1 || j == label[i].length - 2)) {
					label[i][j] = new JLabel(whiteKnight);
					if (j == 1) {
						label[i][j].setBounds(70, 480, 66, 67);
					} else {
						label[i][j].setBounds(412, 480, 66, 67);
					}

				} else if ((i == 0) && (j == 2 || j == label[i].length - 3)) {
					label[i][j] = new JLabel(blackBishop);
					if (j == 2) {
						label[i][j].setBounds(140, 2, 66, 67);
					} else {
						label[i][j].setBounds(345, 2, 66, 67);
					}
				} else if ((i == label.length - 1) && (j == 2 || j == label[i].length - 3)) {
					label[i][j] = new JLabel(whiteBishop);
					if (j == 2) {
						label[i][j].setBounds(140, 480, 66, 67);
					} else {
						label[i][j].setBounds(345, 480, 66, 67);
					}
				} else if ((i == 0) && (j == 3 || j == label[i].length - 4)) {
					label[i][j] = new JLabel(blackQueen);
					label[i][j].setBounds(208, 2, 66, 67);

				} else if ((i == label.length - 1) && (j == 3 || j == label[i].length - 4)) {
					label[i][j] = new JLabel(whiteQueen);
					label[i][j].setBounds(208, 480, 66, 67);

				} else {
					label[i][j] = new JLabel(transparent);
					label[i][j].setBounds(j * 69, i * 69, 66, 67);
				}
				layeredPane.add(label[i][j], new Integer(2));
			}
		}
		label1 = new JLabel(new ImageIcon("images/chessboard.png"));
		label1.setBounds(0, 0, 549, 550);
		JLabel abc = new JLabel(
				"          A                     B                     C                   D                     E                    F                  G                    H");
		abc.setBounds(0, 550, 550, 30);
		layeredPane.add(abc);
		JLabel nums = new JLabel(
				"<html>8<br><br><br><br>7<br><br><br><br>6<br><br><br><br><br>5<br><br><br><br>4<br><br><br><br>3<br><br><br><br>2<br><br><br><br><br>1<br></html>");
		nums.setBounds(550, 0, 10, 550);
		layeredPane.add(nums);
		JLabel turn = new JLabel(figure.turnColor + "'s turn!");
		turn.setBounds(0, 560, 70, 70);
		layeredPane.add(turn);
		layeredPane.add(label1, new Integer(1));
		JTextField textField = new JTextField();
		textField.setBounds(550, 250, 50, 25);
		layeredPane.add(textField);
		add(layeredPane);
		setSize(615, 650);
		setResizable(true);
		figure.spawnFigures();
		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String checker = textField.getText();
				if (checker.length() == 5 && checker.indexOf(" ") == 2) {
					String[] moves = checker.split(" ");
					String currentPosition = "2";
					String wantedPosition = "2";
					if (moves[0].length() == 2) {
						currentPosition = moves[0];
					}
					if (moves[1].length() == 2) {
						wantedPosition = moves[1];
					}
					char[] curPos = currentPosition.toCharArray();
					char[] wantPos = wantedPosition.toCharArray();
					figure.Move(movecontrol.returnerI(curPos[1]), movecontrol.returnerJ(curPos[0]),
							movecontrol.returnerI(wantPos[1]), movecontrol.returnerJ(wantPos[0]));
					if (figure.checkerForInterface) {
//						System.out.println("Prevrashenie: " + figure.pawnToQueen);
//						if (figure.pawnToQueen) {
//							System.out.println("Я ЗАШЕЛ В БЛОК ПРЕВРАЩЕНИЯ");
//							label[movecontrol.returnerI(wantPos[1])][movecontrol.returnerJ(wantPos[0])]
//									.setIcon(whiteQueen);
//							label[movecontrol.returnerI(curPos[1])][movecontrol.returnerJ(curPos[0])]
//									.setIcon(new ImageIcon());
//						}
						visualMove(movecontrol.returnerI(curPos[1]), movecontrol.returnerJ(curPos[0]),
								movecontrol.returnerI(wantPos[1]), movecontrol.returnerJ(wantPos[0]));
					}
					figure.showFigures();
					System.out.println();
				} else {
					System.out.println("Enter your move correctly");
					JOptionPane.showMessageDialog(ChessInterface.this, "Enter Your move correctly");
				}
				turn.setText(figure.turnColor + "'s turn!");
				textField.setText("");
				if(figure.checkReturner()==false) {
					JOptionPane.showMessageDialog(ChessInterface.this, "GAME OVER");
					textField.disable();
				}
			}
		});
		setLocationByPlatform(true);// платформа(виндуза)сама выберет расположение фрейма
		Image img = new ImageIcon("images/negr.jpg").getImage();
		setIconImage(img);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

	}

	public void visualMove(int a, int b, int c, int d) {
		label[c][d].setIcon(label[a][b].getIcon());
		label[a][b].setIcon(new ImageIcon());
	}
}
