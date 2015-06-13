package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.TipSystem;

public interface AbstractAction extends ActionListener{

	TipSystem tipSystem = TipSystem.getInstance();
	@Override
	public abstract void actionPerformed(ActionEvent e);

}
