package connector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileConfiguration{

	private String url;
	private String dbName;
	private String driver;
	private String username;
	private String password;
	
	private String filename;
    private MySQLConnector connector;
	
	public TextFileConfiguration(String filename) {
		this.filename = filename;
	}
	
	public void read()
	{
        String temp;
        
        url = null;
        dbName = null;
        driver = null;
        username = null;
        password = null;
		
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            while((temp = reader.readLine()) != null)
            {/*
            	this.url = url;             //"jdbc:mysql://localhost:3306/"; 
                this.dbName = dbName;       //"udc";
                this.driver = driver;       //"com.mysql.jdbc.Driver"; 
                this.userName = userName;   //"root"; 
                this.pass = pass;           //"root";*/
            	if(temp.equalsIgnoreCase("url") && (temp = reader.readLine()) != null)
            	{
            		url = temp;
            	}
            	else if(temp.equalsIgnoreCase("databasename") && (temp = reader.readLine()) != null)
            	{
            		dbName = temp;
            	}
            	else if(temp.equalsIgnoreCase("driver") && (temp = reader.readLine()) != null)
            	{
            		driver = temp;
            	}
            	else if(temp.equalsIgnoreCase("username") && (temp = reader.readLine()) != null)
            	{
            		username = temp;
            	}
            	else if(temp.equalsIgnoreCase("password") && (temp = reader.readLine()) != null)
            	{
            		password = temp;
            	}
            }
            if(url != null && dbName != null && driver != null && username != null && password != null)
            	connector = new MySQLConnector(url, dbName, driver, username, password);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MySQLConnector getConnector()
    {
		return connector;
    }
}
