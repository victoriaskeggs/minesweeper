package minesweeper;

import javax.swing.ImageIcon;

/*Value encapsulates the value of a button. If a button is not a mine,
the button will have a value representing the number of mines adjacent
to it.*/
public enum Value {
	/*The root directory should contain 40x40 pixel images 0.png, 
	1.png,... 8.png and mine.png.*/
	NUM0(new ImageIcon("0.png")),
	NUM1(new ImageIcon("1.png")),
	NUM2(new ImageIcon("2.png")),
	NUM3(new ImageIcon("3.png")),
	NUM4(new ImageIcon("4.png")),
	NUM5(new ImageIcon("5.png")),
	NUM6(new ImageIcon("6.png")),
	NUM7(new ImageIcon("7.png")),
	NUM8(new ImageIcon("8.png")),
	MINE(new ImageIcon("mine.png"));
	
	private ImageIcon _valueImage;
	
	private Value(ImageIcon valueImage) {
		_valueImage = valueImage;
	}
	
	public ImageIcon getImage() {
		return _valueImage;
	}
}
