package view;

import java.util.Observable;

import javax.swing.JLabel;


public class SplashFrame extends AbstractPanel{

	private static final long serialVersionUID = 1L;

	public SplashFrame(int positionX, int positionY, int width, int height,
			MainFrame frame) {
		super(positionX, positionY, width, height, frame);
		this.add(new JLabel("Hello World!!!!!"));
		//this.add(new JLabel());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	}

	
}
