package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel topRightPanel;
	
	
	public MainFrame()
	{
		setSize(new Dimension(500,500));
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		topRightPanel = new JPanel();
		topRightPanel.setLayout(new BoxLayout(topRightPanel, BoxLayout.X_AXIS));
		
		rightPanel.add(topRightPanel);
		
		
		gridPanel = new JPanel(new GridLayout(7,5));//Set layout of Panel
		initializeButtonArray(); //Start initializing buttons and assigning thme to the grid
		//Set grid to content pane
		
		rightPanel.add(gridPanel);
		mainPanel.add(rightPanel);
		getContentPane().add(mainPanel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		revalidate();
	}
	
	

	
	public void initializeButtonArray() {
		buttonArray = new ButtonBlock[7][6];
		for(int i = 0 ; i < 7 ; i++) {
			for(int j = 0 ; j < 6; j++) {
				if(!(i == 0 && j == 0))
				{
					if(j == 0)
					{
						buttonArray[i][j] = new ButtonBlock("Query" + String.valueOf(i), i , j );
						buttonArray[i][j].setEnabled(false);
					}
					
					if(i == 0)
					{
						String value = "";
						switch(j)
						{
							case 1: value = "Original";
								break;
							case 2: value = "Heuristics";
								break;
							case 3: value = "Views";
								break;
							case 4: value = "Indexed";
								break;
							case 5: value = "Stored Procedures";
								break;
							default:
								break;
						}
						buttonArray[i][j] = new ButtonBlock(value, i , j );
						buttonArray[i][j].setEnabled(false);
					}
					
					else if(j != 0 && i != 0)
					{
						buttonArray[i][j] = new ButtonBlock("Execute Query",i,j);
						buttonArray[i][j] = QuerySetter.searchContext(buttonArray[i][j]);
					}
				}
				else buttonArray[i][j] = new ButtonBlock("Summary", i , j );
				gridPanel.add(buttonArray[i][j]);
			}
		}
	}

}
