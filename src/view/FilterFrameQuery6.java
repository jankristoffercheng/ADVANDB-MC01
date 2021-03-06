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

public class FilterFrameQuery6 extends JDialog {
	SpinnerNumberModel numModel;
	DefaultComboBoxModel modelCrop;
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
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!cmbCropType.getSelectedItem().toString().equals(""))
				{
					ViewController.getInstance().getQuery6(type, (Integer)spinNumQueries.getValue(), cmbCropType.getSelectedItem().toString(), true);
				}
				else
				{
					ViewController.getInstance().getQuery6(type, (Integer)spinNumQueries.getValue(), true);
				}
				dispose();
			}
			
		});
		
		modelCrop = new DefaultComboBoxModel();
		modelCrop.addElement("None");
		modelCrop.addElement("Sugar Cane");
		modelCrop.addElement("Palay");
		modelCrop.addElement("Corn");
		modelCrop.addElement("Banana");
		modelCrop.addElement("Kamote");
		modelCrop.addElement("Cassava");
		modelCrop.addElement("Mango");
		modelCrop.addElement("Pakwan");
		modelCrop.addElement("Sili");
		
		cmbCropType.setModel(modelCrop);
		
		Integer value = new Integer(10);
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
	
	private JDialog getThis()
	{
		return this;
	}
}
