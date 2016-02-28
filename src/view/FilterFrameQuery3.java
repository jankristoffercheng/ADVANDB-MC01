package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.ViewController;

public class FilterFrameQuery3 extends JDialog {
	
	SpinnerNumberModel numModel;
	SpinnerNumberModel numPeopleModel;
	JLabel lblNumPeople;
	JSpinner spinNoPeople;
	JTextField tfLowerBracket;
	JTextField tfUpperBracket;
	JPanel filterPanel;
	JPanel bottomPanel;
	JButton btnSubmit;
	JSpinner spinNumQueries;
	
	public FilterFrameQuery3(int type) {
		setSize(new Dimension(350,150));
		setLocationRelativeTo(null);
		
		lblNumPeople = new JLabel("# of Household Members: ");
		tfLowerBracket = new JTextField("Lower Bracket");
		tfUpperBracket = new JTextField("Upper Bracket");
		
		tfLowerBracket.setMaximumSize(new Dimension(Integer.MAX_VALUE, tfLowerBracket.getMinimumSize().height));
		tfUpperBracket.setMaximumSize(new Dimension(Integer.MAX_VALUE, tfLowerBracket.getMinimumSize().height));
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		Integer value = new Integer(10);
		Integer max = Integer.MAX_VALUE;
		Integer min = new Integer(1);
		Integer step = new Integer(1);
		numModel = new SpinnerNumberModel(value,min,max,step);
		spinNumQueries = new JSpinner(numModel);
		
		Integer value1 = new Integer(0);
		Integer max1 = Integer.MAX_VALUE;
		Integer min1 = new Integer(0);
		Integer step1 = new Integer(1);
		numPeopleModel = new SpinnerNumberModel(value1,min1,max1,step1);
		spinNoPeople = new JSpinner(numPeopleModel);
		
		
		filterPanel = new JPanel(new GridLayout(2,4));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
		btnSubmit = new JButton("Submit");
		btnSubmit.setMinimumSize(new Dimension(100,100));
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfLowerBracket.getText().equals("Lower Bracket") || tfUpperBracket.getText().equals("Upper Bracket") || ((Integer)spinNoPeople.getValue()) == 0)
				{
					ViewController.getInstance().getQuery3(type, (Integer)spinNumQueries.getValue());
					System.out.println("Pass1");
				}
				else
				{
					System.out.println("Pass2");
					ViewController.getInstance().getQuery3(type, (Integer)spinNumQueries.getValue(), (Integer)spinNoPeople.getValue(), Double.parseDouble(tfLowerBracket.getText()), Double.parseDouble(tfUpperBracket.getText()));
				}
				dispose();
			}
			
		});
		filterPanel.add(lblNumPeople);
		filterPanel.add(spinNoPeople);
		filterPanel.add(tfLowerBracket);
		filterPanel.add(tfUpperBracket);
		
		
		bottomPanel.add(btnSubmit);
		bottomPanel.add(spinNumQueries);
		
		
		getContentPane().add(filterPanel);
		getContentPane().add(bottomPanel);
		
		//Create Box Layout Vertical
		//Box 1 = filterPanel
		//Create Box Layout Horizontal
		//Box 2 = buttonPanel, number of times of query execution
		setVisible(true);
		repaint();
		revalidate();
	}
}
