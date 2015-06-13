package view;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel implements Observer{

	protected MainFrame mainFrame;
	protected MainPanel mainPanel;
	private static final long serialVersionUID = 1L;

	public AbstractPanel(int positionX, int positionY, int width, int height, MainFrame frame){
		this.mainFrame = frame;
				
		this.setLayout(new BorderLayout());
		
		this.setVisible(true);
		this.setBounds(positionX, positionY, width,height);	
	}
	public AbstractPanel(int positionX, int positionY, int width, int height, MainPanel frame){
		this.mainPanel = frame;
				
		this.setLayout(new BorderLayout());
		
		this.setVisible(true);
		this.setBounds(positionX, positionY, width,height);	
	}
}
