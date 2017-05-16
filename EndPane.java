package minesweeper;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class EndPane extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private FlowLayout _layout;
	private Border _border;
	private int _flowNum;
	private Color _borderCol;
	private int _borderSize;
	private Color _backgroundCol;
	private Color _fontCol;
	private int _fontSize;
	private String[] _line = new String[2];

	public void loseMinesweeper() {
		_flowNum = 1;
		_borderCol = Color.BLACK;
		_borderSize = 100;
		_backgroundCol = Color.BLACK;
		_fontCol = Color.RED;
		_fontSize = 40;
		_line[0] = "YOU LOSE! ";
		_line[1] = "";
		
		endMinesweeper();
	}
	
	public void winMinesweeper() {
		_flowNum = 2;
		_borderCol = Color.YELLOW;
		_borderSize = 70;
		_backgroundCol = Color.GREEN;
		_fontCol = Color.BLUE;
		_fontSize = 35;
		_line[0] = "CONGRATULATIONS!"; 
		_line[1] = "YOU WIN!         ";
		
		endMinesweeper();
	}
	
	private void endMinesweeper() {
		_layout = new FlowLayout(_flowNum);
		setLayout(_layout);
		_border = BorderFactory.createLineBorder(_borderCol, _borderSize);
		setBorder(_border);
		setBackground(_backgroundCol);
		
		for (int index = 0; index <= 1; index++) {
			JLabel message = new JLabel(_line[index]);
			message.setFont(new Font("Arial", Font.PLAIN, _fontSize));
			message.setForeground(_fontCol);
			add(message);
		}
	}
}
