package minesweeper;

import javax.swing.ImageIcon;

public enum State {
	UNTOUCHED(new ImageIcon("src\\minesweeper\\blank.png")),
	FLAGGED(new ImageIcon("src\\minesweeper\\flag.png")),
	QUESTIONED(new ImageIcon("src\\minesweeper\\questionMark.png"));
	
	private ImageIcon _stateImage;
	
	private State(ImageIcon stateImage) {
		_stateImage = stateImage;
	}
	
	public ImageIcon getImage() {
		return _stateImage;
	}
}
