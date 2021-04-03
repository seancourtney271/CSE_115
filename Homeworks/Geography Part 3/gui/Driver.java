package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Model;

public class Driver implements Runnable {
	
	private Model _model;
	private JFrame _mapWindow;
	private JFrame _controlWindow;
	private JFrame _searchWindow;
	
	public Driver(Model m) {
		_model = m;
	}
	
	@Override
	public void run() {
		_mapWindow = new JFrame("Map");
		JPanel mapPanel = new JPanel();
		_mapWindow.getContentPane().add(mapPanel);
		
		_controlWindow = new JFrame("Controls");
		JPanel controlPanel = new JPanel();
		_controlWindow.getContentPane().add(controlPanel);

		_searchWindow = new JFrame("Results of most recent search");
		JPanel searchPanel = new JPanel();
		_searchWindow.getContentPane().add(searchPanel);

		new GUI(_model, mapPanel, controlPanel, searchPanel, this);
		
		frameBasics(_mapWindow);	
		frameBasics(_controlWindow);	
		frameBasics(_searchWindow);	
	}
	
	public void updateJFrame() {
		frameUpdate(_mapWindow);
		frameUpdate(_controlWindow);
		frameUpdate(_searchWindow);
	}

	public void frameBasics(JFrame f) {
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void frameUpdate(JFrame f) {
		f.pack();
		f.repaint();
	}
	
	public static void main(String[] args) {
		Model m = new Model("Data/WorldCitiesPop.csv");
		SwingUtilities.invokeLater(new Driver(m));
	}

}
