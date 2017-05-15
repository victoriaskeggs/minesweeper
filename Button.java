package minesweeper;

import javax.swing.JButton;

public class Button extends JButton {
	private static final long serialVersionUID = 1L;
	
	private Board _board;
	private int _row;
	private int _col;
	private boolean _valueIsVisible;
	private State _state;
	private final Value _value;
	
	public Button(Value value, Board board, int row, int col) {
		_board = board;
		_row = row;
		_col = col;
		_valueIsVisible = false;
		_state = State.UNTOUCHED;
		setIcon(_state.getImage());
		_value = value;
	}
	
	public void revealValue() {
		_valueIsVisible = true;
		setIcon(_value.getImage());
	}
	
	public void rightClickButton() {
		if (_valueIsVisible) {
			return;
		} else {
			if (_state.equals(State.UNTOUCHED)) {
				_state = State.FLAGGED;
			} else if (_state.equals(State.FLAGGED)) {
				_state = State.QUESTIONED;
			} else if (_state.equals(State.QUESTIONED)) {
				_state = State.UNTOUCHED;
			} else {
				throw new RuntimeException("Invalid State");
			}
		}
		setIcon(_state.getImage());
	}
	
	public void leftClickButton() {
		if (_state.equals(State.UNTOUCHED)) {
			_board.makeMove(_row, _col);
		}
	}
	
	public boolean isMine() {
		if (_value.equals(Value.MINE)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean is0 () {
		if (_value.equals(Value.NUM0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRevealed() {
		return _valueIsVisible;
	}
}
