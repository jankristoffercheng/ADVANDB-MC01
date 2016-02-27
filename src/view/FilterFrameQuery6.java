package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class FilterFrameQuery6 extends JDialog {
	SpinnerNumberModel numModel;
	JComboBox cmbCropType;
	JPanel filterPanel;
	JPanel bottomPanel;
	JButton btnSubmit;
	JSpinner spinNumQueries;
	
	public FilterFrameQuery6(int type) {
		setSize(new Dimension(350,150));
		setLocationRelativeTo(null);
		cmbCropType = new JComboBox();
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		
		filterPanel = new JPanel(new GridLayout(2,4));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
		btnSubmit = new JButton("Submit");
		btnSubmit.setMinimumSize(new Dimension(100,100));
		
		Integer value = new Integer(1);
		Integer max = Integer.MAX_VALUE;
		Integer min = new Integer(1);
		Integer step = new Integer(1);
		numModel = new SpinnerNumberModel(value,min,max,step);
		spinNumQueries = new JSpinner(numModel);
		
		filterPanel.add(cmbCropType);
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
