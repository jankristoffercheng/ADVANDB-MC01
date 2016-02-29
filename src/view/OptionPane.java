package view;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPane extends JOptionPane {
	Component frame;
	Object[] options =  {"Filter", "No Filter"};
	public OptionPane(JDialog frame) {
		this.frame = frame;
		setVisible(true);
	}
	
	public OptionPane(JFrame comp) {
		this.frame = comp;
		setVisible(true);
	}
	public int getResult(){
		return showOptionDialog(frame,
			    "Filter or No Filter?",	
			    	    "Filter Options",
			    	    JOptionPane.YES_NO_CANCEL_OPTION,
			    	    JOptionPane.QUESTION_MESSAGE,
			    	    null,
			    	    options,
			    	    options[1]);
		
	}
}
