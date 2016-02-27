package view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import controller.ViewController;


/**
 * @author MSI LEOPARD
 *
 */
public class ButtonBlock extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1192521985705920426L;
	private String name;
	private Point location;	
	private String command;
	private FilterFrameQuery1 filterFrameQuery1;
	private FilterFrameQuery2 filterFrameQuery2;
	private FilterFrameQuery3 filterFrameQuery3;
	private FilterFrameQuery4 filterFrameQuery4;
	private FilterFrameQuery5 filterFrameQuery5;
	private FilterFrameQuery6 filterFrameQuery6;
	private FilterFrameQuery7 filterFrameQuery7;
	
	
	//Set Button Block's Coordinates
	public ButtonBlock(int x, int y)
	{
		super("Execute Query");
		setLocation(new Point(x,y));
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				parseQuery(getActionCommand());
			}
			
		});
	}
	
	//Set Button Block's Command and Coordinates
	public ButtonBlock(String name, int x, int y)
	{
		super(name);
		setLocation(new Point(x,y));
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				parseQuery(getActionCommand());
			}
			
		});
	}
	
	public void parseQuery(String query)
	{
		if(query.contains("query1")) 
		{
			
			if(query.contains("original"))
			{
				filterFrameQuery1 = new FilterFrameQuery1(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery1 = new FilterFrameQuery1(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery1 = new FilterFrameQuery1(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery1 = new FilterFrameQuery1(4);
			}
			else
			{
				filterFrameQuery1 = new FilterFrameQuery1(5);
			}
		}
	
		else if(query.contains("query2"))
		{
			if(query.contains("original"))
			{
				filterFrameQuery2 = new FilterFrameQuery2(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery2 = new FilterFrameQuery2(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery2 = new FilterFrameQuery2(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery2 = new FilterFrameQuery2(4);
			}
			else
			{
				filterFrameQuery2 = new FilterFrameQuery2(5);
			}
		}
		else if(query.contains("query3"))
		{
			
			if(query.contains("original"))
			{
				filterFrameQuery3 = new FilterFrameQuery3(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery3 = new FilterFrameQuery3(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery3 = new FilterFrameQuery3(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery3 = new FilterFrameQuery3(4);
			}
			else
			{
				filterFrameQuery3 = new FilterFrameQuery3(5);
			}
		}
		else if(query.contains("query4"))
		{
			
			if(query.contains("original"))
			{
				filterFrameQuery4 = new FilterFrameQuery4(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery4 = new FilterFrameQuery4(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery4 = new FilterFrameQuery4(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery4 = new FilterFrameQuery4(4);
			}
			else
			{
				filterFrameQuery4 = new FilterFrameQuery4(5);
			}
		}
		else if(query.contains("query5"))
		{
			if(query.contains("original"))
			{
				filterFrameQuery5 = new FilterFrameQuery5(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery5 = new FilterFrameQuery5(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery5 = new FilterFrameQuery5(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery5 = new FilterFrameQuery5(4);
			}
			else
			{
				filterFrameQuery5 = new FilterFrameQuery5(5);
			}
		}
		else if(query.contains("query6"))
		{

			if(query.contains("original"))
			{
				filterFrameQuery6 = new FilterFrameQuery6(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery6 = new FilterFrameQuery6(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery6 = new FilterFrameQuery6(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery6 = new FilterFrameQuery6(4);
			}
			else
			{
				filterFrameQuery6 = new FilterFrameQuery6(5);
			}
		}
		else 
		{
			
			if(query.contains("original"))
			{
				filterFrameQuery7 = new FilterFrameQuery7(1);
			}
			else if(query.contains("heuristics"))
			{
				filterFrameQuery7 = new FilterFrameQuery7(2);
			}
			else if(query.contains("views"))
			{
				filterFrameQuery7 = new FilterFrameQuery7(3);
			}
			else if(query.contains("indexed"))
			{
				filterFrameQuery7 = new FilterFrameQuery7(4);
			}
			else
			{
				filterFrameQuery7 = new FilterFrameQuery7(5);
			}
		}
		
	}
	

	public String getCommand() {
		return getActionCommand();
	}

	public void setCommand(String command) {
		setActionCommand(command);
		
	}
	
	public Point getLocation() {
		return location;
	}


	public void setLocation(Point location) {
		this.location = location;
	}
	
	
}
