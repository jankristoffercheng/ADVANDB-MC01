import view.MainFrame;
import view.TableCreationManager;
import connector.MySQLConnector;
import connector.TextFileConfiguration;
import controller.ViewController;
import dao.Original;
import dao.StoredProcedures;
import model.*;

public class Main {

	public static void main(String[] args) {
		TextFileConfiguration file = new TextFileConfiguration("config.txt");
		file.read();
		file.getConnector();
		if(MySQLConnector.getConnection() != null)
			System.out.println("Connection successful!");
		else
			System.out.println("Connection error!");
		
		MainFrame mainFrame = new MainFrame();
		TableCreationManager tcm = new TableCreationManager();
		ViewController.getInstance().addObserver(tcm);
		ViewController.getInstance().setFrame(mainFrame);
	}
}
