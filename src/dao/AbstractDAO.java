package dao;

import java.util.ArrayList;

import connector.Executor;
import model.Query;
import model.Query1;
import model.Query2;
import model.Query3;
import model.Query4;
import model.Query5;
import model.Query6;
import model.Query7;

public abstract class AbstractDAO {
	protected Executor executor;
	public double getDuration() {
		return executor.getDuration();
	}
	public abstract ArrayList<Query> query1(int nTimes);
	public abstract ArrayList<Query> query2(int nTimes);
	public abstract ArrayList<Query> query3(int nTimes);
	public abstract ArrayList<Query> query4(int nTimes);
	public abstract ArrayList<Query> query5(int nTimes);
	public abstract ArrayList<Query> query6(int nTimes);
	public abstract ArrayList<Query> query7(int nTimes);
	
	public AbstractDAO() {
		executor = new Executor();
	}
}
