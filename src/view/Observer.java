package view;

import java.util.ArrayList;

public interface Observer {
	public void update(String[] columnNames, Object[][] data, double executionTime, String queryName, String type, int numOfRuns);
}