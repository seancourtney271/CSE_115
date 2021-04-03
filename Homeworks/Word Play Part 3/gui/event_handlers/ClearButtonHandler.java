package gui.event_handlers;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import code.Model;

public class ClearButtonHandler implements ActionListener{
	private Model _m;

	public ClearButtonHandler(Model _model) {
		_m = _model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_m.clear();
	}
	
}
