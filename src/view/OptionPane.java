package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class OptionPane extends JOptionPane {
	JDialog frame;
	Object[] options =  {"Filter", "No Filter"};;
	public OptionPane(JDialog frame) {
		this.frame = frame;
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
