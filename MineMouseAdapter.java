package minesweeper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class MineMouseAdapter extends MouseAdapter {

	@Override
	public void mouseReleased(MouseEvent e) {
		Object button = e.getSource();
		if (button instanceof Button) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				((Button) button).leftClickButton();
			}
			if (SwingUtilities.isRightMouseButton(e)) {
				((Button) button).rightClickButton();
			}
		}
	}
}
