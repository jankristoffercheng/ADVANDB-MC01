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
	private JLabel lblQuery1;
	private JLabel lblQuery2;
	private JLabel lblQuery3;
	private JLabel lblQuery4;
	private JLabel lblQuery5;
	private JLabel lblQuery6;
	private JLabel lblQuery7;
	private JLabel lblTypeOriginal;
	private JLabel lblTypeHeuristics;
	private JLabel lblTypeViews;
	private JLabel lblTypeIndexed;
	private JLabel lblTypeStoredProcedures;
	
	
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
		
		lblQuery1 = new JLabel("Query 1");
		lblQuery2 = new JLabel("Query 2");
		lblQuery3 = new JLabel("Query 3");
		lblQuery4 = new JLabel("Query 4");
		lblQuery5 = new JLabel("Query 5");
		lblQuery6 = new JLabel("Query 6");
		lblQuery7 = new JLabel("Query 7");
		lblTypeOriginal = new JLabel("Original");
		lblTypeHeuristics = new JLabel("Heuristics");
		lblTypeViews = new JLabel("Views");
		lblTypeIndexed = new JLabel("Indexed");
		lblTypeStoredProcedures = new JLabel("Stored Procedures");
		
		leftPanel.add(lblQuery1);
		leftPanel.add(lblQuery2);
		leftPanel.add(lblQuery3);
		leftPanel.add(lblQuery4);
		leftPanel.add(lblQuery5);
		leftPanel.add(lblQuery6);
		leftPanel.add(lblQuery7);
		topRightPanel.add(lblTypeOriginal);
		topRightPanel.add(lblTypeHeuristics);
		topRightPanel.add(lblTypeViews);
		topRightPanel.add(lblTypeIndexed);
		topRightPanel.add(lblTypeStoredProcedures);
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
		buttonArray = new ButtonBlock[8][6];
		for(int i = 0 ; i < 7 ; i++) {
			for(int j = 0 ; j < 6; j++) {
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
				gridPanel.add(buttonArray[i][j]);
			}
		}
	}

}
