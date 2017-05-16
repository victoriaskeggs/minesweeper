package minesweeper;

import javax.swing.ImageIcon;

/*State encapsulates the state of a button whose value has not been revealed.
The button can be blank, flagged (meaning the player has indicated that
button is a mine) or questioned (meaning the player that button might be a 
mine).*/
public enum State {
	/*The root directly should contain images blank.png, flag.png and 
	questionMark.png.*/
	UNTOUCHED(new ImageIcon("blank.png")),
	FLAGGED(new ImageIcon("flag.png")),
	QUESTIONED(new ImageIcon("questionMark.png"));
	
	private ImageIcon _stateImage;
	
	private State(ImageIcon stateImage) {
		_stateImage = stateImage;
	}
	
	public ImageIcon getImage() {
		return _stateImage;
	}
}
