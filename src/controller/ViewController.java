package controller;


import java.util.ArrayList;

import dao.Original;
import model.Query;
import model.Query1;
import model.Query2;
import model.Query3;
import model.Query4;
import model.Query5;
import model.Query6;
import model.Query7;
import model.QueryToTable;
import view.MainFrame;
import view.Observer;

public class ViewController {
	
	public static ViewController viewController = null;
	MainFrame view;
	ArrayList<Observer> observerList = new ArrayList<Observer>();
	
	public ViewController() {
		this.view = null;

	}
	
	public ViewController(MainFrame mainFrame) {
		this.view = mainFrame;

	}
	
	public void setView(MainFrame mainFrame) {
		this.view = mainFrame;
	}

	
	public static ViewController getInstance() {
		if(viewController != null)
		{
			return viewController;
		}
		else{ 
			viewController = new ViewController();
			return viewController;
		}
	}
	
	public void addObserver(Observer observer)
	{
		observerList.add(observer);
	}
	
	public void updateAllObservers(String[] columnNames, ArrayList<Query> results) {
		for(int i = 0 ; i < observerList.size(); i++)
		{
			observerList.get(i).update(columnNames, QueryToTable.convertQuery(columnNames, results));
		}
	}

	public ArrayList<Query1> getQuery1(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query1 Original");
				Object[][] query = null;
				
				break;
			case 2://Heuristic
				System.out.println("Query1 Heuristics");
				break;
			case 3://Views
				System.out.println("Query1 Views");
				break;
			case 4://Indexed
				System.out.println("Query1 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query1 Stored Procedures");
				break;
			default:
				break;
		}
		Original original = new Original();
		updateAllObservers(Query1.COLUMN_NAMES, original.query1(1, true));
		return new ArrayList<Query1>();
	}
	
	public ArrayList<Query2> getQuery2(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query2 Original");
				break;
			case 2://Heuristic
				System.out.println("Query2 Heuristics");
				break;
			case 3://Views
				System.out.println("Query2 Views");
				break;
			case 4://Indexed
				System.out.println("Query2 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query2 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query2>();
	}
	
	public ArrayList<Query3> getQuery3(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query3 Original");
				break;
			case 2://Heuristic
				System.out.println("Query3 Heuristics");
				break;
			case 3://Views
				System.out.println("Query3 Views");
				break;
			case 4://Indexed
				System.out.println("Query3 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query3 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query3>();
	}
	
	public ArrayList<Query4> getQuery4(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query4 Original");
				break;
			case 2://Heuristic
				System.out.println("Query4 Heuristics");
				break;
			case 3://Views
				System.out.println("Query4 Views");
				break;
			case 4://Indexed
				System.out.println("Query4 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query4 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query4>();
	}
	
	public ArrayList<Query5> getQuery5(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query5 Original");
				break;
			case 2://Heuristic
				System.out.println("Query5 Heuristics");
				break;
			case 3://Views
				System.out.println("Query5 Views");
				break;
			case 4://Indexed
				System.out.println("Query5 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query5 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query5>();
	}
	
	public ArrayList<Query6> getQuery6(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query6 Original");
				break;
			case 2://Heuristic
				System.out.println("Query6 Heuristics");
				break;
			case 3://Views
				System.out.println("Query6 Views");
				break;
			case 4://Indexed
				System.out.println("Query6 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query6 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query6>();
	}
	
	public ArrayList<Query7> getQuery7(int type) {
		switch(type) {
			case 1://Original
				System.out.println("Query7 Original");
				break;
			case 2://Heuristic
				System.out.println("Query7 Heuristics");
				break;
			case 3://Views
				System.out.println("Query7 Views");
				break;
			case 4://Indexed
				System.out.println("Query7 Indexed");
				break;
			case 5://Stored Procedures
				System.out.println("Query7 Stored Procedures");
				break;
			default:
				break;
		}
		return new ArrayList<Query7>();
	}
}
	
	