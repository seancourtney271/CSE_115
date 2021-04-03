package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameHandler implements ActionListener {
 private	GUI g;
private String x;
	public NameHandler(GUI g, String x) {
		this.g = g;
		this.x = x;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.setFontName(x);
	}

}
