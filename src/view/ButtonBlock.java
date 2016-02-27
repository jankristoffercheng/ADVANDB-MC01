package view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				ViewController.getInstance().getQuery1(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery1(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery1(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery1(4);
			}
			else
			{
				ViewController.getInstance().getQuery1(5);
			}
		}
		else if(query.contains("query2"))
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery2(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery2(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery2(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery2(4);
			}
			else
			{
				ViewController.getInstance().getQuery2(5);
			}
		}
		else if(query.contains("query3"))
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery3(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery3(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery3(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery3(4);
			}
			else
			{
				ViewController.getInstance().getQuery3(5);
			}
		}
		else if(query.contains("query4"))
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery4(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery4(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery4(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery4(4);
			}
			else
			{
				ViewController.getInstance().getQuery4(5);
			}
		}
		else if(query.contains("query5"))
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery5(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery5(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery5(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery5(4);
			}
			else
			{
				ViewController.getInstance().getQuery5(5);
			}
		}
		else if(query.contains("query6"))
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery6(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery6(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery6(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery6(4);
			}
			else
			{
				ViewController.getInstance().getQuery6(5);
			}
		}
		else 
		{
			if(query.contains("original"))
			{
				ViewController.getInstance().getQuery7(1);
			}
			else if(query.contains("heuristics"))
			{
				ViewController.getInstance().getQuery7(2);
			}
			else if(query.contains("views"))
			{
				ViewController.getInstance().getQuery7(3);
			}
			else if(query.contains("indexed"))
			{
				ViewController.getInstance().getQuery7(4);
			}
			else
			{
				ViewController.getInstance().getQuery7(5);
			}
		}
	}

	public String getCommand() {
		return getActionCommand();
	}

	public void setCommand(String command) {
		setActionCommand(command);
		
	}

	public String getName() {
		return getLabel();
	}

	public void setName(String name) {
		this.setLabel(name);
	}
	
	public Point getLocation() {
		return location;
	}


	public void setLocation(Point location) {
		this.location = location;
	}
	
	
}
