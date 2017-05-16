package minesweeper;

import java.awt.GridBagConstraints;

public class Board {
	public static final int NUM_MINES = 10;
	public static final int SIZE = 10;
	
	private Button[][] _board = new Button[SIZE][SIZE];
	private int _buttonsRevealed;
	
	public Board(MinePane panel) {
		_buttonsRevealed = 0;
		buildMineButtons(panel);
		buildNonMineButtons(panel);
		addButtons(panel);
	}
	
	private void buildMineButtons(MinePane panel) {
		int numMines = 0;
		while (numMines < NUM_MINES) {
			int row = (int)(Math.random()*SIZE);
			int col = (int)(Math.random()*SIZE);
			if (_board[row][col] == null) {
				_board[row][col] = new Button(Value.MINE, this, row, col);
				numMines++;
			}
		}
	}
	
	private void buildNonMineButtons(MinePane panel) {
		int minesAdj = 0;
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (_board[row][col] == null) {
					for (int checkRow = Math.max(0, row-1); checkRow <= 
							Math.min(SIZE-1, row+1); checkRow++) {
						for (int checkCol = Math.max(0, col-1); checkCol <= 
								Math.min(SIZE-1, col+1); checkCol++) {
							Button checkIfMine = _board[checkRow][checkCol];
							if (checkIfMine != null && checkIfMine.isMine()) {
								minesAdj++;
							}
						}
					}
					Value value = findButtonValue(minesAdj);
					_board[row][col] = new Button(value, this, row, col);
				}
				minesAdj = 0;
			}
		}
	}
	
	private Value findButtonValue(int minesAdj) {
		if (minesAdj == 0) {
			return Value.NUM0;
		} else if (minesAdj == 1) {
			return Value.NUM1;
		} else if (minesAdj == 2) {
			return Value.NUM2;		} else if (minesAdj == 3) {
			return Value.NUM3;
		} else if (minesAdj == 4) {
			return Value.NUM4;
		} else if (minesAdj == 5) {
			return Value.NUM5;
		} else if (minesAdj == 6) {
			return Value.NUM6;
		} else if (minesAdj == 7) {
			return Value.NUM7;
		} else if (minesAdj == 8) {
			return Value.NUM8;
		} else {
			throw new RuntimeException("Invalid number " + minesAdj);
		}
	}
	
	private void addButtons(MinePane panel) {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.BOTH;
				panel.add(_board[row][col], c);
				_board[row][col].addMouseListener(new MineMouseAdapter());
			}
		}
	}
	
	public void makeMove(int row, int col) {
		Button button = _board[row][col];
		if (!button.isRevealed()) {
			if (button.isMine()) {
				button.revealValue();
				MineFrame._gameLost = true;
			} else if (!button.is0()){
				button.revealValue();
				_buttonsRevealed++;
			} else {
				revealZeros(row, col);
			}
			checkIfWon();
		}
	}
	
	private void revealZeros(int row, int col) {
		for (int checkRow = Math.max(0, row-1); checkRow <= 
				Math.min(9, row+1); checkRow++) {
			for (int checkCol = Math.max(0, col-1); checkCol <= 
					Math.min(9, col+1); checkCol++) {
				Button button = _board[checkRow][checkCol];
				if (button.is0() && !button.isRevealed()) {
					button.revealValue();
					_buttonsRevealed++;
					revealZeros(checkRow, checkCol);
				} else if (!button.isRevealed()){
					button.revealValue();
					_buttonsRevealed++;
				}
			}
		}
	}
	
	private void checkIfWon() {
		if (_buttonsRevealed == ((int)Math.pow(SIZE, 2) - NUM_MINES)) {
			MineFrame._gameWon = true;
		}
	}
}
