package minesweeper;

import javax.swing.ImageIcon;

public enum Value {
	NUM0(new ImageIcon("src\\minesweeper\\0.png")),
	NUM1(new ImageIcon("src\\minesweeper\\1.png")),
	NUM2(new ImageIcon("src\\minesweeper\\2.png")),
	NUM3(new ImageIcon("src\\minesweeper\\3.png")),
	NUM4(new ImageIcon("src\\minesweeper\\4.png")),
	NUM5(new ImageIcon("src\\minesweeper\\5.png")),
	NUM6(new ImageIcon("src\\minesweeper\\6.png")),
	NUM7(new ImageIcon("src\\minesweeper\\7.png")),
	NUM8(new ImageIcon("src\\minesweeper\\8.png")),
	MINE(new ImageIcon("src\\minesweeper\\mine.png"));
	
	private ImageIcon _valueImage;
	
	private Value(ImageIcon valueImage) {
		_valueImage = valueImage;
	}
	
	public ImageIcon getImage() {
		return _valueImage;
	}
}
