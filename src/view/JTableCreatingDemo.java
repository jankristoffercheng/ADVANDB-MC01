package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connector.MySQLConnector;
import connector.TextFileConfiguration;
import controller.ViewController;
import dao.Original;
import model.Query;
import model.Query1;
import model.QueryToTable;

public class JTableCreatingDemo {
  public static void main(String args[]) {
	  TextFileConfiguration file = new TextFileConfiguration("config.txt");
		file.read();
		file.getConnector();
		if(MySQLConnector.getConnection() != null)
			System.out.println("Connection successful!");
		else
			System.out.println("Connection error!");
	  
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Original dao = new Original(); 
   
    Object rowData[][] = QueryToTable.convertQuery(Query1.COLUMN_NAMES, dao.query1(1, true)) ;
    Object columnNames[] = Query1.COLUMN_NAMES;
    JTable table = new JTable(rowData, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);

  }
}