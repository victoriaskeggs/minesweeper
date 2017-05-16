package minesweeper;

import javax.swing.JFrame;

public class MineFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static boolean _gameLost = false;
	public static boolean _gameWon = false;
	
	private MineFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520, 520);
		setTitle("Minesweeper!");
		setResizable(false);
	}

	public static void main(String[] args) {
		MineFrame frame = new MineFrame();
		MinePane panel = new MinePane();
		Board board = new Board(panel);
		frame.add(panel);
		frame.validate();
		
		frame.setVisible(true);
		
		while (!_gameLost && !_gameWon) { } //do nothing
		
		frame.endMinesweeper(panel);
	}
	
	private void endMinesweeper(MinePane panel) {
		pause();
		remove(panel);
		EndPane endPanel = new EndPane();
		if (_gameLost) {
			endPanel.loseMinesweeper();
		} else {
			endPanel.winMinesweeper();
		}
		add(endPanel);
		revalidate();
		repaint();
		pause();
		
		setVisible(false);
		dispose();
	}
	
	private void pause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
