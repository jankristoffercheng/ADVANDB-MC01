import connector.MySQLConnector;
import connector.TextFileConfiguration;
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
		
		/*Original original = new Original();
		for(Query7 result : original.query7(100)) {
			System.out.println(result.getHousehold());
		}
		System.out.println(original.getDuration());*/
	}
}
