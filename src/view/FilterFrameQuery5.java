package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.ViewController;

public class FilterFrameQuery5 extends JDialog {
	
	SpinnerNumberModel numModel;
	DefaultComboBoxModel modelFish;
	JComboBox cmbFishType;
	JPanel filterPanel;
	JPanel bottomPanel;
	JButton btnSubmit;
	JSpinner spinNumQueries;
	
	
	public FilterFrameQuery5(int type) {
		setSize(new Dimension(350,150));
		setLocationRelativeTo(null);
		cmbFishType = new JComboBox();
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		
		filterPanel = new JPanel(new GridLayout(2,4));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.X_AXIS));
		btnSubmit = new JButton("Submit");
		btnSubmit.setMinimumSize(new Dimension(100,100));
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!cmbFishType.getSelectedItem().toString().equals(""))
				{
					ViewController.getInstance().getQuery5(type, (Integer)spinNumQueries.getValue(), cmbFishType.getSelectedItem().toString());
				}
				else
				{
					ViewController.getInstance().getQuery5(type, (Integer)spinNumQueries.getValue());
				}
				dispose();
			}
			
		});
		
		Integer value = new Integer(1);
		Integer max = Integer.MAX_VALUE;
		Integer min = new Integer(1);
		Integer step = new Integer(1);
		numModel = new SpinnerNumberModel(value,min,max,step);
		spinNumQueries = new JSpinner(numModel);
		
		modelFish = new DefaultComboBoxModel();
		modelFish.addElement("None");
		modelFish.addElement("Tilapia");
		modelFish.addElement("Milkfish");
		modelFish.addElement("Catfish");
		modelFish.addElement("Mudfish");
		modelFish.addElement("Carp");
		modelFish.addElement("Lapu");
		modelFish.addElement("Danggit");
		modelFish.addElement("Octupus");
		modelFish.addElement("Maya-maya");
		modelFish.addElement("Tulingan");
		
		cmbFishType.setModel(modelFish);
		cmbFishType.setSelectedIndex(0);
		filterPanel.add(cmbFishType);
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
