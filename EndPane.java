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

	public void loseMinesweeper() {
		_layout = new FlowLayout(1);
		setLayout(_layout);
		_border = BorderFactory.createLineBorder(Color.BLACK, 100);
		setBorder(_border);
		setBackground(Color.BLACK);
		
		JLabel message = new JLabel("YOU LOSE!");
		message.setFont(new Font("Arial", Font.PLAIN, 40));
		message.setForeground(Color.RED);
		add(message);
	}
	
	public void winMinesweeper() {
		_layout = new FlowLayout(2);
		setLayout(_layout);
		_border = BorderFactory.createLineBorder(Color.YELLOW, 70);
		setBorder(_border);
		setBackground(Color.GREEN);
		
		for (int iterations = 1; iterations <= 2; iterations++) {
			String line;
			if (iterations == 1) {
				line = "CONGRATULATIONS!";
			} else {
				line = "YOU WIN!         ";
			}
			JLabel message = new JLabel(line);
			message.setFont(new Font("Arial", Font.PLAIN, 35));
			message.setForeground(Color.BLUE);
			add(message);
		}
	}
}
