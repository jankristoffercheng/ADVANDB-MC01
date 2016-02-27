package view;

import java.util.ArrayList;

import model.QueryReturnable;

public interface Observer {
	public void update(String[] columnNames, Object[][] data);
}