package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import model.Observer;

public class GUI implements Observer {

	private Model _model;
	private Driver _windowHolder;

	/** 
	 * A constructor for the GUI.  Run the provided DEMO.jar to see the basic
	 * arrangement of the GUI.  Remember to use a JScrollPane for the search
	 * results.  See sample code in lecture code repository from 2017_11_27. 
	 * 
	 * @param m - the Model object
	 * @param mapPanel - the JPanel in which the map is to be shown
	 * @param controlPanel - the JPanel in which the controls are to be shown
	 * @param searchPanel - the JPanel in which search results are to be shown
	 * @param driver - the object that holds the JFrames
	 */
	public GUI(Model m, JPanel mapPanel, JPanel controlPanel, JPanel searchPanel, Driver driver) {
		_windowHolder = driver;
		_model = m;
	}
	
	/**
	 * All GUI update code must be in this method.  Called by the model when 
	 * any GUI update needs to occur.
	 * 
	 * Ensure that call to updateJFrameIfNotHeadless() is last statement in
	 * this method.
	 */
	@Override
	public void update() {
		updateJFrameIfNotHeadless();
	}

	/**
	 * Do not modify this method.
	 */
	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}
}
