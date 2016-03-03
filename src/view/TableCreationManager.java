package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.QueryToTable;

public class TableCreationManager implements Observer {

	
	public TableCreationManager(){
		
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
	

	public void createJFrame(String[] columnNames, Object[][] data, int numOfRuns)
	{
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
	    JTable table = new JTable(data, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(new DecimalFormatRenderer() );
	      table.getColumnModel().getColumn(1).setCellRenderer(new DecimalFormatRenderer() );
	      table.getColumnModel().getColumn(2).setCellRenderer(new DecimalFormatRenderer() );
	      table.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer() );
	      table.getColumnModel().getColumn(4).setCellRenderer(new DecimalFormatRenderer() );
	   
	    JPanel infoPanel = new JPanel();
	    infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.X_AXIS));
	    
	    JLabel lblNumOfRunsLabel = new JLabel("Number of Runs: ");
	    JLabel lblNumOfRuns = new JLabel(numOfRuns + " ");
	    infoPanel.add(lblNumOfRunsLabel);
	    infoPanel.add(lblNumOfRuns);
	    frame.add(infoPanel);
	    frame.setSize(450, 300);
	    frame.setVisible(true);
	    
	}
	
	 static class DecimalFormatRenderer extends DefaultTableCellRenderer {
	      private static final DecimalFormat formatter = new DecimalFormat( "#.0000" );
	 
	      public Component getTableCellRendererComponent(
	         JTable table, Object value, boolean isSelected,
	         boolean hasFocus, int row, int column) {
	 
	         // First format the cell value as required
	 
	         value = formatter.format((Number)value);
	 
	            // And pass it on to parent class
	 
	         return super.getTableCellRendererComponent(
	            table, value, isSelected, hasFocus, row, column );
	      }
	   }

	@Override
	public void update(String[] columnNames, Object[][] data, double executionTime, String queryName, String type, int numOfRuns) {
		// TODO Auto-generated method stub
		createJFrame(columnNames,data,executionTime,queryName,type, numOfRuns);
	}

	@Override
	public void update(String[] columnNames, Object[][] data, int numOfRuns) {
		// TODO Auto-generated method stub
		createJFrame(columnNames,data,numOfRuns);
	}
	
}
