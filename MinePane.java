package minesweeper;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MinePane extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private GridLayout _layout;
	private Border _border;
	
	public MinePane() {
		_border = BorderFactory.createLineBorder(Color.white, 50);
		setBorder(_border);
		_layout = new GridLayout(Board.SIZE, Board.SIZE);
		setLayout(_layout);
	}
}
