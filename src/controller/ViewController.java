package controller;


import java.util.ArrayList;

import dao.AbstractDAO;
import dao.Heuristics;
import dao.Indexed;
import dao.Original;
import dao.StoredProcedures;
import dao.Views;
import model.Query;
import model.Query1;
import model.Query2;
import model.Query3;
import model.Query4;
import model.Query5;
import model.Query6;
import model.Query7;
import model.QueryToTable;
import view.Observer;

public class ViewController {
	
	public static ViewController viewController = null;
	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	private Original original = new Original();
	private Heuristics heuristics = new Heuristics();
	private Indexed indexed = new Indexed();
	private Views views = new Views();
	private StoredProcedures storedProcedures = new StoredProcedures();
	
	private AbstractDAO currentDAO;
	
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
	
	public double getDuration() {
		return currentDAO.getDuration();
	}

	public void getQuery1(int type, int nTimes) {
		switch(type) {
			case 1://Original
				System.out.println("Query1 Original");
				currentDAO = original;
				updateAllObservers(Query1.COLUMN_NAMES, original.query1(nTimes));
				break;
			case 2://Heuristic
				System.out.println("Query1 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query1.COLUMN_NAMES, heuristics.query1(nTimes));
				break;
			case 3://Views
				System.out.println("Query1 Views");
				currentDAO = views;
				updateAllObservers(Query1.COLUMN_NAMES, views.query1(nTimes));
				break;
			case 4://Indexed
				System.out.println("Query1 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query1.COLUMN_NAMES, indexed.query1(nTimes));
				break;
			case 5://Stored Procedures
				System.out.println("Query1 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query1.COLUMN_NAMES, storedProcedures.query1(nTimes));
				break;
			default:
				break;
		}
	}
	
	public void getQuery1(int type, int nTimes, boolean isStudying) {
		switch(type) {
			case 1://Original
				System.out.println("Query1 Original");
				currentDAO = original;
				updateAllObservers(Query1.COLUMN_NAMES, original.query1(nTimes, isStudying));
				break;
			case 2://Heuristic
				System.out.println("Query1 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query1.COLUMN_NAMES, heuristics.query1(nTimes, isStudying));
				break;
			case 3://Views
				System.out.println("Query1 Views");
				currentDAO = views;
				updateAllObservers(Query1.COLUMN_NAMES, views.query1(nTimes, isStudying));
				break;
			case 4://Indexed
				System.out.println("Query1 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query1.COLUMN_NAMES, indexed.query1(nTimes, isStudying));
				break;
			case 5://Stored Procedures
				System.out.println("Query1 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query1.COLUMN_NAMES, storedProcedures.query1(nTimes, isStudying));
				break;
			default:
				break;
		}
	}
	
	public void getQuery2(int type, int nTimes) {
		switch(type) {
		case 1://Original
			System.out.println("Query2 Original");
			currentDAO = original;
			updateAllObservers(Query2.COLUMN_NAMES, original.query2(nTimes));
			break;
		case 2://Heuristic
			System.out.println("Query2 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query2.COLUMN_NAMES, heuristics.query2(nTimes));
			break;
		case 3://Views
			System.out.println("Query2 Views");
			currentDAO = views;
			updateAllObservers(Query2.COLUMN_NAMES, views.query2(nTimes));
			break;
		case 4://Indexed
			System.out.println("Query2 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query2.COLUMN_NAMES, indexed.query2(nTimes));
			break;
		case 5://Stored Procedures
			System.out.println("Query2 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query2.COLUMN_NAMES, storedProcedures.query2(nTimes));
			break;
		default:
			break;
		}
	}
	
	public void getQuery2(int type, int nTimes, boolean isStudying) {
		switch(type) {
		case 1://Original
			System.out.println("Query2 Original");
			currentDAO = original;
			updateAllObservers(Query2.COLUMN_NAMES, original.query2(nTimes, isStudying));
			break;
		case 2://Heuristic
			System.out.println("Query2 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query2.COLUMN_NAMES, heuristics.query2(nTimes, isStudying));
			break;
		case 3://Views
			System.out.println("Query2 Views");
			currentDAO = views;
			updateAllObservers(Query2.COLUMN_NAMES, views.query2(nTimes, isStudying));
			break;
		case 4://Indexed
			System.out.println("Query2 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query2.COLUMN_NAMES, indexed.query2(nTimes, isStudying));
			break;
		case 5://Stored Procedures
			System.out.println("Query2 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query2.COLUMN_NAMES, storedProcedures.query2(nTimes, isStudying));
			break;
		default:
			break;
		}
	}
	
	public void getQuery3(int type, int nTimes) {
		switch(type) {
		case 1://Original
			System.out.println("Query3 Original");
			currentDAO = original;
			updateAllObservers(Query3.COLUMN_NAMES, original.query3(nTimes));
			break;
		case 2://Heuristic
			System.out.println("Query3 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query3.COLUMN_NAMES, heuristics.query3(nTimes));
			break;
		case 3://Views
			System.out.println("Query3 Views");
			currentDAO = views;
			updateAllObservers(Query3.COLUMN_NAMES, views.query3(nTimes));
			break;
		case 4://Indexed
			System.out.println("Query3 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query3.COLUMN_NAMES, indexed.query3(nTimes));
			break;
		case 5://Stored Procedures
			System.out.println("Query3 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query3.COLUMN_NAMES, storedProcedures.query3(nTimes));
			break;
		default:
			break;
		}
	}
	
	public void getQuery3(int type, int nTimes, int memno, double lowerBracket, double higherBracket) {
		switch(type) {
		case 1://Original
			System.out.println("Query3 Original");
			currentDAO = original;
			updateAllObservers(Query3.COLUMN_NAMES, original.query3(nTimes, memno, lowerBracket, higherBracket));
			break;
		case 2://Heuristic
			System.out.println("Query3 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query3.COLUMN_NAMES, heuristics.query3(nTimes, memno, lowerBracket, higherBracket));
			break;
		case 3://Views
			System.out.println("Query3 Views");
			currentDAO = views;
			updateAllObservers(Query3.COLUMN_NAMES, views.query3(nTimes, memno, lowerBracket, higherBracket));
			break;
		case 4://Indexed
			System.out.println("Query3 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query3.COLUMN_NAMES, indexed.query3(nTimes, memno, lowerBracket, higherBracket));
			break;
		case 5://Stored Procedures
			System.out.println("Query3 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query3.COLUMN_NAMES, storedProcedures.query3(nTimes, memno, lowerBracket, higherBracket));
			break;
		default:
			break;
		}
	}
	
	public void getQuery4(int type, int nTimes) {
		switch(type) {
			case 1://Original
				System.out.println("Query4 Original");
				currentDAO = original;
				updateAllObservers(Query4.COLUMN_NAMES, original.query4(nTimes));
				break;
			case 2://Heuristic
				System.out.println("Query4 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query4.COLUMN_NAMES, heuristics.query4(nTimes));
				break;
			case 3://Views
				System.out.println("Query4 Views");
				currentDAO = views;
				updateAllObservers(Query4.COLUMN_NAMES, views.query4(nTimes));
				break;
			case 4://Indexed
				System.out.println("Query4 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query4.COLUMN_NAMES, indexed.query4(nTimes));
				break;
			case 5://Stored Procedures
				System.out.println("Query4 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query4.COLUMN_NAMES, storedProcedures.query4(nTimes));
				break;
			default:
				break;
		}
	}
	
	public void getQuery4(int type, int nTimes, boolean isEmployed) {
		switch(type) {
		case 1://Original
			System.out.println("Query4 Original");
			currentDAO = original;
			updateAllObservers(Query4.COLUMN_NAMES, original.query4(nTimes, isEmployed));
			break;
		case 2://Heuristic
			System.out.println("Query4 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query4.COLUMN_NAMES, heuristics.query4(nTimes, isEmployed));
			break;
		case 3://Views
			System.out.println("Query4 Views");
			currentDAO = views;
			//updateAllObservers(Query4.COLUMN_NAMES, views.query4(nTimes, isEmployed));
			break;
		case 4://Indexed
			System.out.println("Query4 Indexed");
			currentDAO = indexed;
			//updateAllObservers(Query4.COLUMN_NAMES, indexed.query4(nTimes, isEmployed));
			break;
		case 5://Stored Procedures
			System.out.println("Query4 Stored Procedures");
			currentDAO = storedProcedures;
			//updateAllObservers(Query4.COLUMN_NAMES, storedProcedures.query4(nTimes, isEmployed));
			break;
		default:
			break;
		}
	}
	
	public void getQuery5(int type, int nTimes) {
		switch(type) {
			case 1://Original
				System.out.println("Query5 Original");
				currentDAO = original;
				updateAllObservers(Query5.COLUMN_NAMES, original.query5(nTimes));
				break;
			case 2://Heuristic
				System.out.println("Query5 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query5.COLUMN_NAMES, heuristics.query5(nTimes));
				break;
			case 3://Views
				System.out.println("Query5 Views");
				currentDAO = views;
				updateAllObservers(Query5.COLUMN_NAMES, views.query5(nTimes));
				break;
			case 4://Indexed
				System.out.println("Query5 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query5.COLUMN_NAMES, indexed.query5(nTimes));
				break;
			case 5://Stored Procedures
				System.out.println("Query5 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query5.COLUMN_NAMES, storedProcedures.query5(nTimes));
				break;
			default:
				break;
		}
	}
	
	public void getQuery5(int type, int nTimes, String fishType) {
		switch(type) {
			case 1://Original
				System.out.println("Query5 Original");
				currentDAO = original;
				updateAllObservers(Query5.COLUMN_NAMES, original.query5(nTimes, fishType));
				break;
			case 2://Heuristic
				System.out.println("Query5 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query5.COLUMN_NAMES, heuristics.query5(nTimes, fishType));
				break;
			case 3://Views
				System.out.println("Query5 Views");
				currentDAO = views;
				updateAllObservers(Query5.COLUMN_NAMES, views.query5(nTimes, fishType));
				break;
			case 4://Indexed
				System.out.println("Query5 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query5.COLUMN_NAMES, indexed.query5(nTimes, fishType));
				break;
			case 5://Stored Procedures
				System.out.println("Query5 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query5.COLUMN_NAMES, storedProcedures.query5(nTimes, fishType));
				break;
			default:
				break;
		}
	}
	
	public void getQuery6(int type, int nTimes) {
		switch(type) {
			case 1://Original
				System.out.println("Query6 Original");
				currentDAO = original;
				updateAllObservers(Query6.COLUMN_NAMES, original.query6(nTimes));
				break;
			case 2://Heuristic
				System.out.println("Query6 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query6.COLUMN_NAMES, heuristics.query6(nTimes));
				break;
			case 3://Views
				System.out.println("Query6 Views");
				currentDAO = views;
				updateAllObservers(Query6.COLUMN_NAMES, views.query6(nTimes));
				break;
			case 4://Indexed
				System.out.println("Query6 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query6.COLUMN_NAMES, indexed.query6(nTimes));
				break;
			case 5://Stored Procedures
				System.out.println("Query6 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query6.COLUMN_NAMES, storedProcedures.query6(nTimes));
				break;
			default:
				break;
		}
	}
	
	public void getQuery6(int type, int nTimes, String cropType) {
		switch(type) {
			case 1://Original
				System.out.println("Query6 Original");
				currentDAO = original;
				updateAllObservers(Query6.COLUMN_NAMES, original.query6(nTimes, cropType));
				break;
			case 2://Heuristic
				System.out.println("Query6 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query6.COLUMN_NAMES, heuristics.query6(nTimes, cropType));
				break;
			case 3://Views
				System.out.println("Query6 Views");
				currentDAO = views;
				updateAllObservers(Query6.COLUMN_NAMES, views.query6(nTimes, cropType));
				break;
			case 4://Indexed
				System.out.println("Query6 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query6.COLUMN_NAMES, indexed.query6(nTimes, cropType));
				break;
			case 5://Stored Procedures
				System.out.println("Query6 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query6.COLUMN_NAMES, storedProcedures.query6(nTimes, cropType));
				break;
			default:
				break;
		}
	}
	
	public void getQuery7(int type, int nTimes) {
		switch(type) {
			case 1://Original
				System.out.println("Query7 Original");
				currentDAO = original;
				updateAllObservers(Query7.COLUMN_NAMES, original.query7(nTimes));
				break;
			case 2://Heuristic
				System.out.println("Query7 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query7.COLUMN_NAMES, heuristics.query7(nTimes));
				break;
			case 3://Views
				System.out.println("Query7 Views");
				currentDAO = views;
				updateAllObservers(Query7.COLUMN_NAMES, views.query7(nTimes));
				break;
			case 4://Indexed
				System.out.println("Query7 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query7.COLUMN_NAMES, indexed.query7(nTimes));
				break;
			case 5://Stored Procedures
				System.out.println("Query7 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query7.COLUMN_NAMES, storedProcedures.query7(nTimes));
				break;
			default:
				break;
		}
	}
	
	public void getQuery7(int type, int nTimes, double lowerBracket, double higherBracket) {
		switch(type) {
			case 1://Original
				System.out.println("Query7 Original");
				currentDAO = original;
				updateAllObservers(Query7.COLUMN_NAMES, original.query7(nTimes, lowerBracket, higherBracket));
				break;
			case 2://Heuristic
				System.out.println("Query7 Heuristics");
				currentDAO = heuristics;
				//updateAllObservers(Query7.COLUMN_NAMES, heuristics.query7(nTimes, lowerBracket, higherBracket));
				break;
			case 3://Views
				System.out.println("Query7 Views");
				currentDAO = views;
				//updateAllObservers(Query7.COLUMN_NAMES, views.query7(nTimes, lowerBracket, higherBracket));
				break;
			case 4://Indexed
				System.out.println("Query7 Indexed");
				currentDAO = indexed;
				//updateAllObservers(Query7.COLUMN_NAMES, indexed.query7(nTimes, lowerBracket, higherBracket));
				break;
			case 5://Stored Procedures
				System.out.println("Query7 Stored Procedures");
				currentDAO = storedProcedures;
				//updateAllObservers(Query7.COLUMN_NAMES, storedProcedures.query7(nTimes, lowerBracket, higherBracket));
				break;
			default:
				break;
		}
	}
}
	
	