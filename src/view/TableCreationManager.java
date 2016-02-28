package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.QueryToTable;

public class TableCreationManager implements Observer {

	
	public TableCreationManager(){
		
	}
	
	@Override
	public void update(String[] columnNames, Object[][] data, double executionTime, String queryName, String type, int numOfRuns) {
		// TODO Auto-generated method stub
		createJFrame(columnNames,data,executionTime,queryName,type, numOfRuns);
	}
	
	public void createJFrame(String[] columnNames, Object[][] data, double executionTime, String queryName, String type, int numOfRuns)
	{
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
	    JTable table = new JTable(data, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	   
	    JPanel infoPanel = new JPanel();
	    infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.X_AXIS));
	    
	    JLabel lblQueryName = new JLabel(queryName + " ");
	    JLabel lblQueryTypeLabel = new JLabel("Query Type: ");
	    JLabel lblQueryType = new JLabel(type + " ");
	    JLabel lblExecTime = new JLabel("Execution Time: ");
	    JLabel execTime = new JLabel( String.valueOf(executionTime) + " ");
	    JLabel lblNumOfRunsLabel = new JLabel("Number of Runs: ");
	    JLabel lblNumOfRuns = new JLabel(numOfRuns + " ");
	    infoPanel.add(lblQueryName);
	    infoPanel.add(lblQueryTypeLabel);
	    infoPanel.add(lblQueryType);
	    infoPanel.add(lblExecTime);
	    infoPanel.add(execTime);
	    infoPanel.add(lblNumOfRunsLabel);
	    infoPanel.add(lblNumOfRuns);
	    frame.add(infoPanel);
	    frame.setSize(450, 300);
	    frame.setVisible(true);
	}
	
}
