package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public MainFrame(){
		this.setTitle("Tip Calculator v0.1");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		
		//this.panel = new SplashFrame(0,0,500,350,this);
		
		/*this.getContentPane().add(this.panel);*/
		this.setVisible(true);
		
		
		//Creating the panel which contains everything then add to frame and set visible
		MainPanel taxPanel = new MainPanel(10,10,400,300,this);
        this.add(taxPanel, BorderLayout.CENTER);
        this.setVisible(true);
        this.repaint();
        
	}
	public void changePanel(AbstractPanel frame){
	}
}
