package gui;

import java.awt.Color;


import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import code.Model;
import code.Observer;
import gui.event_handlers.ClearButtonHandler;
import gui.event_handlers.GuessButtonHandler;
import gui.event_handlers.InventoryButtonHandler;
import gui.event_handlers.ShuffleButtonHandler;
import gui.event_handlers.SubmitButtonHandler;
import main.Driver;

public class GUI implements Observer {

	private JPanel _inventoryPanel;
	private JPanel _guessPanel;
	private Model _model;
	private Driver _windowHolder;

	public GUI(Model m, JPanel mp, Driver driver) {
		_windowHolder = driver;
		_model = m;
		
		JPanel _mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
		_mainPanel.add(middlePanel);
		
		
		JPanel words = new JPanel();
		_mainPanel.add(words);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		_mainPanel.add(controlPanel);

		_inventoryPanel = new JPanel();
		_inventoryPanel.setLayout(new BoxLayout(_inventoryPanel, BoxLayout.X_AXIS));

		_guessPanel = new JPanel();
		_guessPanel.setLayout(new BoxLayout(_guessPanel, BoxLayout.X_AXIS));
		
		middlePanel.add(new JLabel("INVENTORY: "));
		middlePanel.add(_inventoryPanel);
		middlePanel.add(new JLabel("GUESS: "));
		middlePanel.add(_guessPanel);
		
		
		
		JButton _submit = new JButton("Submit");
		setButtonProperties(_submit);
		_submit.addActionListener(new SubmitButtonHandler(_model));
		controlPanel.add(_submit);
		
		JButton _shuffle = new JButton("Shuffle");
		setButtonProperties(_shuffle);
		_shuffle.addActionListener(new ShuffleButtonHandler(_model));
		controlPanel.add(_shuffle);
		
		JButton _clear = new JButton("Clear");
		setButtonProperties(_clear);
		_clear.addActionListener(new ClearButtonHandler(_model));
		controlPanel.add(_clear);

		_model.startNewGame();
		_model.addObserver(this);
	}
	
	@Override
	public void update() {
		_inventoryPanel.removeAll();
		ArrayList<Character> inventoryLetters = _model.getInventoryLetters();
		for (int i=0; i<inventoryLetters.size(); i=i+1) {
			JButton b = new JButton(""+inventoryLetters.get(i));
			setButtonProperties(b);
			_inventoryPanel.add(b);
			b.addActionListener(new InventoryButtonHandler(_model, i));
		}
		_guessPanel.removeAll();
		ArrayList<Character> guessLetters = _model.getGuessLetters();
		for (int i=0; i<guessLetters.size(); i=i+1) {
			JButton b = new JButton(""+guessLetters.get(i));
			setButtonProperties(b);
			_guessPanel.add(b);
			b.addActionListener(new GuessButtonHandler(_model, i));
		}
		
		// This should be last statement of this method:
		updateJFrameIfNotHeadless();
	}

	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}

	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, 44));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}

	public void setLabelProperties(JLabel label) {
		label.setFont(new Font("Courier", Font.BOLD, 44));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
}
