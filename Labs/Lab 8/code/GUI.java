package code;

import java.awt.Font;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI {
	
	private String fontName;
	private JTextArea textArea;

	/*
	 * For this exercise you don't have to worry about the JFrame.
	 * The Driver creates it and adds a JPanel (mainPanel) to it.
	 */
	public GUI(JPanel mainPanel) {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		textArea = new JTextArea("You can type in this window", 12, 80);
		setFontName("Courier");
		mainPanel.add(textArea);
		JPanel j = new JPanel();
		j.add(createFontNameButton(this  , "Arial"));
		j.add(createFontNameButton(this  , "Courier"));
		j.add(createFontNameButton(this  , "Helvetica"));;
		j.add(createFontNameButton(this  , "Times"));
		mainPanel.add(j);
		/*
		 * Create a new JPanel to hold four JButtons.  You may use whatever
		 * LayoutManager you'd like, e.g. a FlowLayout or BoxLayout is fine.
		 * Be sure to add it to the mainPanel *after* the textArea is added.
		 * 
		 * Create JButtons that allow a user to change the name of the font
		 * of the textArea.  Allow the user to select the following four
		 * font names: Arial, Courier, Helvetica, or Times.  Have one JButton
		 * for each font name.
		 * 
		 * The text on the JButton must be the name of the font it represents.
		 * E.g. "Arial", "Courier", "Helvetica", and "Times".
		 * 
		 * HINT: See the createFontNameButton method, below.
		 * 
		 * Add the JButtons to your new JPanel.
		 * 
		 * Create a new event handling class (i.e. a class that implements
		 * the ActionListener interface) that will handle button clicks.
		 * 
		 * Each JButton must be associated with its own instance of this
		 * event handling class.
		 * 
		 * HINT: See the createFontNameButton method, below.
		 * 
		 * HINT: In your event handler you will want to call the setFontName
		 * method defined in this (the GUI) class.
		 * 
		 */
	}
	
	public void setFontName(String name) {
		fontName = name;
		textArea.setFont(new Font(fontName, Font.PLAIN, 12));
	}

	public JButton createFontNameButton(GUI g, String x) {
		JButton button = new JButton(x);
		button.addActionListener(new NameHandler(g,x));
		return button;
	}
}
