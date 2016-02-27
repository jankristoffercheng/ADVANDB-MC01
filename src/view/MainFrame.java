package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ViewController;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5249524970170521336L;
	private GridLayout grid;
	private ButtonBlock[][] buttonArray;
	private JPanel gridPanel;
	private JPanel mainPanel;
	
	public MainFrame()
	{
		setSize(new Dimension(500,500));
		mainPanel = new JPanel(new GridLayout(1,2));
		gridPanel = new JPanel(new GridLayout(7,5));//Set layout of Panel
		initializeButtonArray(); //Start initializing buttons and assigning thme to the grid
		//Set grid to content pane
		this.add(gridPanel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		revalidate();
	}
	
	

	
	public void initializeButtonArray() {
		buttonArray = new ButtonBlock[7][5];
		for(int i = 0 ; i < 7 ; i++) {
			for(int j = 0 ; j < 5; j++) {
				buttonArray[i][j] = new ButtonBlock("Execute Query",i,j);
				buttonArray[i][j] = QuerySetter.searchContext(buttonArray[i][j]);
				gridPanel.add(buttonArray[i][j]);
			}
		}
	}

}
