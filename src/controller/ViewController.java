package controller;


import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
import view.MainFrame;
import view.Observer;

public class ViewController {
	
	public static ViewController viewController = null;
	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	private Original original = new Original();
	private Heuristics heuristics = new Heuristics();
	private Indexed indexed = new Indexed();
	private Views views = new Views();
	private StoredProcedures storedProcedures = new StoredProcedures();
	private ScoreBoard scoreBoard = new ScoreBoard(7,5);
	private MainFrame mainFrame;
	public final static String[] COLUMN_NAMES =
		{"Original",
		"Heuristics",
		"Views",
		"Indexed",
		"Stored Procedures",
		};
	
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
	
	public void updateAllObservers(String[] columnNames, ArrayList<Query> results, String queryName, String type, int numOfRuns, boolean isFrameEnabled) {
		if(isFrameEnabled){
			for(int i = 0 ; i < observerList.size(); i++)
			{
				observerList.get(i).update(columnNames, QueryToTable.convertQuery(columnNames, results),getDuration() ,queryName ,type, numOfRuns);
				
			}
		}
	}
	
	public void updateAllObservers(String[] columnNames, Object[][] data, int numOfRuns) {
		for(int i = 0 ; i < observerList.size(); i++)
		{
			observerList.get(i).update(columnNames, data , numOfRuns);
			
		}
	}
	
	public JFrame getObserver1() {
		return mainFrame;
	}
	
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public MainFrame getFrame() {
		return mainFrame;
	}
	
	public double getDuration() {
		return currentDAO.getDuration();
	}

	public void getQuery1(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query1 Original");
				currentDAO = original;
				updateAllObservers(Query1.COLUMN_NAMES, original.query1(nTimes), "Query 1", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 0, currentDAO.getDuration());
				
				break;
			case 2://Heuristic
				System.out.println("Query1 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query1.COLUMN_NAMES, heuristics.query1(nTimes), "Query 1", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query1 Views");
				currentDAO = views;
				updateAllObservers(Query1.COLUMN_NAMES, views.query1(nTimes), "Query 1", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query1 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query1.COLUMN_NAMES, indexed.query1(nTimes) ,"Query 1", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query1 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query1.COLUMN_NAMES, storedProcedures.query1(nTimes) ,"Query 1", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery1(int type, int nTimes, boolean isStudying, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query1 Original");
				currentDAO = original;
				updateAllObservers(Query1.COLUMN_NAMES, original.query1(nTimes, isStudying) , "Query 1", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query1 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query1.COLUMN_NAMES, heuristics.query1(nTimes, isStudying) , "Query 1", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query1 Views");
				currentDAO = views;
				updateAllObservers(Query1.COLUMN_NAMES, views.query1(nTimes, isStudying), "Query 1", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query1 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query1.COLUMN_NAMES, indexed.query1(nTimes, isStudying) , "Query 1", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query1 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query1.COLUMN_NAMES, storedProcedures.query1(nTimes, isStudying), "Query 1", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(0, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery2(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
		case 1://Original
			System.out.println("Query2 Original");
			currentDAO = original;
			updateAllObservers(Query2.COLUMN_NAMES, original.query2(nTimes), "Query 2", "Original", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 0, currentDAO.getDuration());
			break;
		case 2://Heuristic
			System.out.println("Query2 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query2.COLUMN_NAMES, heuristics.query2(nTimes), "Query 2", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 1, currentDAO.getDuration());
			break;
		case 3://Views
			System.out.println("Query2 Views");
			currentDAO = views;
			updateAllObservers(Query2.COLUMN_NAMES, views.query2(nTimes) , "Query 2", "Views", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 2, currentDAO.getDuration());
			break;
		case 4://Indexed
			System.out.println("Query2 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query2.COLUMN_NAMES, indexed.query2(nTimes) , "Query 2", "Indexed", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 3, currentDAO.getDuration());
			break;
		case 5://Stored Procedures
			System.out.println("Query2 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query2.COLUMN_NAMES, storedProcedures.query2(nTimes), "Query 2", "Stored Procedures", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 4, currentDAO.getDuration());
			break;
		default:
			break;
		}
	}
	
	public void getQuery2(int type, int nTimes, boolean isStudying, boolean isFrameEnabled) {
		switch(type) {
		case 1://Original
			System.out.println("Query2 Original");
			currentDAO = original;
			updateAllObservers(Query2.COLUMN_NAMES, original.query2(nTimes, isStudying) , "Query 2", "Original", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 0, currentDAO.getDuration());
			break;
		case 2://Heuristic
			System.out.println("Query2 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query2.COLUMN_NAMES, heuristics.query2(nTimes, isStudying),  "Query 2", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 1, currentDAO.getDuration());
			break;
		case 3://Views
			System.out.println("Query2 Views");
			currentDAO = views;
			updateAllObservers(Query2.COLUMN_NAMES, views.query2(nTimes, isStudying),  "Query 2", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 2, currentDAO.getDuration());
			break;
		case 4://Indexed
			System.out.println("Query2 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query2.COLUMN_NAMES, indexed.query2(nTimes, isStudying),  "Query 2", "Indexed", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 3, currentDAO.getDuration());
			break;
		case 5://Stored Procedures
			System.out.println("Query2 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query2.COLUMN_NAMES, storedProcedures.query2(nTimes, isStudying),  "Query 2", "Stored Procedures", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(1, 4, currentDAO.getDuration());
			break;
		default:
			break;
		}
	}
	
	public void getQuery3(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
		case 1://Original
			System.out.println("Query3 Original");
			currentDAO = original;
			updateAllObservers(Query3.COLUMN_NAMES, original.query3(nTimes), "Query 3", "Original", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 0, currentDAO.getDuration());
			break;
		case 2://Heuristic
			System.out.println("Query3 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query3.COLUMN_NAMES, heuristics.query3(nTimes), "Query 3", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 1, currentDAO.getDuration());
			break;
		case 3://Views
			System.out.println("Query3 Views");
			currentDAO = views;
			updateAllObservers(Query3.COLUMN_NAMES, views.query3(nTimes), "Query 3", "Views", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 2, currentDAO.getDuration());
			break;
		case 4://Indexed
			System.out.println("Query3 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query3.COLUMN_NAMES, indexed.query3(nTimes), "Query 3", "Indexed", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 3, currentDAO.getDuration());
			break;
		case 5://Stored Procedures
			System.out.println("Query3 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query3.COLUMN_NAMES, storedProcedures.query3(nTimes),  "Query 3", "Stored Procedures", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 4, currentDAO.getDuration());
			break;
		default:
			break;
		}
	}
	
	public void getQuery3(int type, int nTimes, int memno, double lowerBracket, double higherBracket, boolean isFrameEnabled) {
		switch(type) {
		case 1://Original
			System.out.println("Query3 Original");
			currentDAO = original;
			updateAllObservers(Query3.COLUMN_NAMES, original.query3(nTimes, memno, lowerBracket, higherBracket), "Query 3", "Original", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 0, currentDAO.getDuration());
			break;
		case 2://Heuristic
			System.out.println("Query3 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query3.COLUMN_NAMES, heuristics.query3(nTimes, memno, lowerBracket, higherBracket), "Query 3", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 1, currentDAO.getDuration());
			break;
		case 3://Views
			System.out.println("Query3 Views");
			currentDAO = views;
			updateAllObservers(Query3.COLUMN_NAMES, views.query3(nTimes, memno, lowerBracket, higherBracket), "Query 3", "Views", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 2, currentDAO.getDuration());
			break;
		case 4://Indexed
			System.out.println("Query3 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query3.COLUMN_NAMES, indexed.query3(nTimes, memno, lowerBracket, higherBracket), "Query 3", "Indexed", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 3, currentDAO.getDuration());
			break;
		case 5://Stored Procedures
			System.out.println("Query3 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query3.COLUMN_NAMES, storedProcedures.query3(nTimes, memno, lowerBracket, higherBracket), "Query 3", "Stored Procedures", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(2, 4, currentDAO.getDuration());
			break;
		default:
			break;
		}
	}
	
	public void getQuery4(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query4 Original");
				currentDAO = original;
				updateAllObservers(Query4.COLUMN_NAMES, original.query4(nTimes), "Query 4", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(3, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query4 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query4.COLUMN_NAMES, heuristics.query4(nTimes), "Query 4", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(3, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query4 Views");
				currentDAO = views;
				updateAllObservers(Query4.COLUMN_NAMES, views.query4(nTimes), "Query 4", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(3, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query4 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query4.COLUMN_NAMES, indexed.query4(nTimes), "Query 4", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(3, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query4 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query4.COLUMN_NAMES, storedProcedures.query4(nTimes), "Query 4", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(3, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery4(int type, int nTimes, boolean isEmployed, boolean isFrameEnabled) {
		switch(type) {
		case 1://Original
			System.out.println("Query4 Original");
			currentDAO = original;
			updateAllObservers(Query4.COLUMN_NAMES, original.query4(nTimes, isEmployed), "Query 4", "Original", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(3, 0, currentDAO.getDuration());
			break;
		case 2://Heuristic
			System.out.println("Query4 Heuristics");
			currentDAO = heuristics;
			updateAllObservers(Query4.COLUMN_NAMES, heuristics.query4(nTimes, isEmployed), "Query 4", "Heuristics", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(3, 1, currentDAO.getDuration());
			break;
		case 3://Views
			System.out.println("Query4 Views");
			currentDAO = views;
			updateAllObservers(Query4.COLUMN_NAMES, views.query4(nTimes, isEmployed), "Query 4", "Views", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(3, 2, currentDAO.getDuration());
			break;
		case 4://Indexed
			System.out.println("Query4 Indexed");
			currentDAO = indexed;
			updateAllObservers(Query4.COLUMN_NAMES, indexed.query4(nTimes, isEmployed), "Query 4", "Indexed", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(3, 3, currentDAO.getDuration());
			break;
		case 5://Stored Procedures
			System.out.println("Query4 Stored Procedures");
			currentDAO = storedProcedures;
			updateAllObservers(Query4.COLUMN_NAMES, storedProcedures.query4(nTimes, isEmployed), "Query 4", "Stored Procedures", nTimes, isFrameEnabled);
			scoreBoard.setDataToElement(3, 4, currentDAO.getDuration());
			break;
		default:
			break;
		}
	}
	
	public void getQuery5(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query5 Original");
				currentDAO = original;
				updateAllObservers(Query5.COLUMN_NAMES, original.query5(nTimes), "Query 5", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query5 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query5.COLUMN_NAMES, heuristics.query5(nTimes), "Query 5", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query5 Views");
				currentDAO = views;
				updateAllObservers(Query5.COLUMN_NAMES, views.query5(nTimes), "Query 5", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query5 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query5.COLUMN_NAMES, indexed.query5(nTimes), "Query 5", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query5 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query5.COLUMN_NAMES, storedProcedures.query5(nTimes), "Query 5", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery5(int type, int nTimes, String fishType, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query5 Original");
				currentDAO = original;
				updateAllObservers(Query5.COLUMN_NAMES, original.query5(nTimes, fishType) , "Query 5", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query5 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query5.COLUMN_NAMES, heuristics.query5(nTimes, fishType) , "Query 5", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query5 Views");
				currentDAO = views;
				updateAllObservers(Query5.COLUMN_NAMES, views.query5(nTimes, fishType) , "Query 5", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query5 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query5.COLUMN_NAMES, indexed.query5(nTimes, fishType) , "Query 5", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query5 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query5.COLUMN_NAMES, storedProcedures.query5(nTimes, fishType) , "Query 5", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(4, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery6(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query6 Original");
				currentDAO = original;
				updateAllObservers(Query6.COLUMN_NAMES, original.query6(nTimes) , "Query 6", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query6 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query6.COLUMN_NAMES, heuristics.query6(nTimes) , "Query 6", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query6 Views");
				currentDAO = views;
				updateAllObservers(Query6.COLUMN_NAMES, views.query6(nTimes) , "Query 6", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query6 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query6.COLUMN_NAMES, indexed.query6(nTimes) , "Query 6", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query6 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query6.COLUMN_NAMES, storedProcedures.query6(nTimes) , "Query 6", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery6(int type, int nTimes, String cropType, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query6 Original");
				currentDAO = original;
				updateAllObservers(Query6.COLUMN_NAMES, original.query6(nTimes, cropType), "Query 6", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query6 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query6.COLUMN_NAMES, heuristics.query6(nTimes, cropType), "Query 6", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query6 Views");
				currentDAO = views;
				updateAllObservers(Query6.COLUMN_NAMES, views.query6(nTimes, cropType), "Query 6", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query6 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query6.COLUMN_NAMES, indexed.query6(nTimes, cropType), "Query 6", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query6 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query6.COLUMN_NAMES, storedProcedures.query6(nTimes, cropType), "Query 6", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(5, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery7(int type, int nTimes, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query7 Original");
				currentDAO = original;
				updateAllObservers(Query7.COLUMN_NAMES, original.query7(nTimes), "Query 7", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query7 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query7.COLUMN_NAMES, heuristics.query7(nTimes), "Query 7", "Heuristics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query7 Views");
				currentDAO = views;
				updateAllObservers(Query7.COLUMN_NAMES, views.query7(nTimes), "Query 7", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query7 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query7.COLUMN_NAMES, indexed.query7(nTimes), "Query 7", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query7 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query7.COLUMN_NAMES, storedProcedures.query7(nTimes), "Query 7", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getQuery7(int type, int nTimes, double lowerBracket, double higherBracket, boolean isFrameEnabled) {
		switch(type) {
			case 1://Original
				System.out.println("Query7 Original");
				currentDAO = original;
				updateAllObservers(Query7.COLUMN_NAMES, original.query7(nTimes, lowerBracket, higherBracket), "Query 7", "Original", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 0, currentDAO.getDuration());
				break;
			case 2://Heuristic
				System.out.println("Query7 Heuristics");
				currentDAO = heuristics;
				updateAllObservers(Query7.COLUMN_NAMES, heuristics.query7(nTimes, lowerBracket, higherBracket), "Query 7", "Heursitics", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 1, currentDAO.getDuration());
				break;
			case 3://Views
				System.out.println("Query7 Views");
				currentDAO = views;
				updateAllObservers(Query7.COLUMN_NAMES, views.query7(nTimes, lowerBracket, higherBracket), "Query 7", "Views", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 2, currentDAO.getDuration());
				break;
			case 4://Indexed
				System.out.println("Query7 Indexed");
				currentDAO = indexed;
				updateAllObservers(Query7.COLUMN_NAMES, indexed.query7(nTimes, lowerBracket, higherBracket), "Query 7", "Indexed", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 3, currentDAO.getDuration());
				break;
			case 5://Stored Procedures
				System.out.println("Query7 Stored Procedures");
				currentDAO = storedProcedures;
				updateAllObservers(Query7.COLUMN_NAMES, storedProcedures.query7(nTimes, lowerBracket, higherBracket), "Query 7", "Stored Procedures", nTimes, isFrameEnabled);
				scoreBoard.setDataToElement(6, 4, currentDAO.getDuration());
				break;
			default:
				break;
		}
	}
	
	public void getSummary() {
		updateAllObservers(COLUMN_NAMES, scoreBoard.getData(), 1);
		
	}
	
}
	
	