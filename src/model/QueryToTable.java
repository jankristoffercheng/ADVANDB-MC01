package model;

import java.util.ArrayList;

import view.ButtonBlock;
import view.QuerySetter;

public class QueryToTable {
	
	public static Object[][] convertQuery(String[] columnNames, ArrayList<Query> results) {
		Object data[][] = new Object[results.size()][columnNames.length];
		for(int i=0; i<data.length; i++) {
			data[i] = results.get(i).getRow();
		}
		return data;
	}
}
