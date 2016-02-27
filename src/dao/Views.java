package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.MySQLConnector;
import model.Query;
import model.Query1;
import model.Query2;
import model.Query3;
import model.Query4;
import model.Query5;
import model.Query6;
import model.Query7;

public class Views extends AbstractDAO{

	public Views() {
		super();
	}
/*******************************************START QUERY 1********************************************************/	
	@Override
	public ArrayList<Query> query1(int nTimes) {
		
		MySQLConnector.executeStatement("CREATE TABLE query1view (id INT, memno INT, age_yr INT, birth_date VARCHAR(45), "
				                                               + "sex INT, educind INT, gradel INT, ynotsch INT, "
				                                               + "ynotsch_o VARCHAR(255), reln INT, jobind INT, "
				                                               + "occup VARCHAR(255));");
		MySQLConnector.executeStatement("INSERT INTO query1view "
				                      + "SELECT id, memno, age_yr, birth_date, sex, educind, gradel, ynotsch, "
				                      + "ynotsch_o, reln, jobind, occup "
				                      + "FROM hpq_mem "
				                      + "WHERE age_yr BETWEEN 15 AND 30 AND reln = 1;");
		
		Connection connection = MySQLConnector.getConnection();		
		String query = "SELECT * FROM query1view;";
	
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query1 result = 
						new Query1(
						rs.getInt(1),
						rs.getInt(2),
						rs.getFloat(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getString(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getString(13));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MySQLConnector.executeStatement("DROP TABLE query1view;");
		return results;
	}
	
	public ArrayList<Query> query1(int nTimes, boolean isStudying) {
	
		MySQLConnector.executeStatement("CREATE TABLE query1view (id INT, memno INT, age_yr INT, birth_date VARCHAR(45), "
												                + "sex INT, educind INT, gradel INT, ynotsch INT, "
												                + "ynotsch_o VARCHAR(255), reln INT, jobind INT, "
												                + "occup VARCHAR(255));");
		MySQLConnector.executeStatement("INSERT INTO query1view "
										+ "SELECT id, memno, age_yr, birth_date, sex, educind, gradel, ynotsch, "
										+ "ynotsch_o, reln, jobind, occup "
										+ "FROM hpq_mem "
										+ "WHERE age_yr BETWEEN 15 AND 30 AND reln = 1;");

		Connection connection = MySQLConnector.getConnection();
		String query = 
				   "SELECT * "
				 + "FROM query1view "
				 + "WHERE educind = " + ((isStudying) ? "1" : "2");
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query1 result = 
						new Query1(
						rs.getInt(1),
						rs.getInt(2),
						rs.getFloat(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getString(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getString(13));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query1view;");
		return results;
	}
/*********************************************END QUERY 1********************************************************/
/*******************************************START QUERY 2********************************************************/	
					
	@Override
	public ArrayList<Query> query2(int nTimes) {
		MySQLConnector.executeStatement("CREATE TABLE query2view( occup varchar(255) );");
		MySQLConnector.executeStatement("INSERT INTO query2view "
										+ "SELECT occup "
										+ "FROM hpq_mem "
										+ "WHERE age_yr BETWEEN 15 AND 30 "
										+ "AND reln = 1 "
										+ "AND educind = 2;");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT occup, COUNT(occup) AS numOccup "
				+ "FROM query2view "
				+ "GROUP BY occup "
				+ "ORDER BY numOccup DESC;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query2 result = new Query2(rs.getString(1), rs.getInt(2));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query2view;");
		return results;
	}

	public ArrayList<Query> query2(int nTimes, boolean isStudying) {

		MySQLConnector.executeStatement("CREATE TABLE query2view( occup varchar(255) );");
		
		String insert = "INSERT INTO query2view "
						+ "SELECT occup "
						+ "FROM hpq_mem "
						+ "WHERE age_yr >= 15 AND age_yr <= 30 "
						+ "AND reln = 1 "
						+ "AND educind = " + ((isStudying) ? "1" : "2");
		
		MySQLConnector.executeStatement(insert);
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT occup, COUNT(occup) AS numOccup "
				+ "FROM query2view "
				+ "GROUP BY occup "
				+ "ORDER BY numOccup DESC;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query2 result = new Query2(rs.getString(1), rs.getInt(2));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query2view;");
		return results;
	}
/*********************************************END QUERY 2********************************************************/
/*******************************************START QUERY 3********************************************************/	
				
	@Override
	public ArrayList<Query> query3(int nTimes) {
		MySQLConnector.executeStatement("CREATE TABLE query3view (id int, monthly_income float, mem_count int);");
		MySQLConnector.executeStatement("INSERT INTO query3view	"
										+ "SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
										+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
																   + "FROM hpq_hh H, hpq_mem M "
																   + "WHERE H.id = M.id "
																   + "GROUP BY H.id) T	"
										+ "WHERE H.id = M.id AND M.id = T.id "
										+ "AND M.age_yr BETWEEN 15 AND 30 "
										+ "AND M.reln = 1 "
										+ "GROUP BY H.id;");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT id, monthly_income, mem_count"
			   + "FROM query3view;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query3 result = new Query3(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query3view;");
		return results;
	}
	
	public ArrayList<Query> query3(int nTimes, int memno, double lowerBracket, double higherBracket) {
		MySQLConnector.executeStatement("CREATE TABLE query3view (id int, monthly_income float, mem_count int);");
		MySQLConnector.executeStatement("INSERT INTO query3view	"
										+ "SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
										+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
																   + "FROM hpq_hh H, hpq_mem M "
																   + "WHERE H.id = M.id "
																   + "GROUP BY H.id) T	"
										+ "WHERE H.id = M.id AND M.id = T.id "
										+ "AND M.age_yr BETWEEN 15 AND 30 "
										+ "AND M.reln = 1 "
										+ "GROUP BY H.id;");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT id, monthly_income, mem_count"
			   + "FROM query3view "
			   + "WHERE monthly_income BETWEEN " + lowerBracket +" AND "+higherBracket+" "
			   + "AND mem_count = "+memno+ ";";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query3 result = new Query3(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query3view;");
		return results;
	}
/*********************************************END QUERY 3********************************************************/
/*******************************************START QUERY 4********************************************************/	
			
	@Override
	public ArrayList<Query> query4(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query4(int nTimes, int isEmployed) {
		// TODO Auto-generated method stub
		return null;
	}
/*********************************************END QUERY 4********************************************************/
/*******************************************START QUERY 5********************************************************/	
				
	@Override
	public ArrayList<Query> query5(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query5(int nTimes, String fishType) {
		// TODO Auto-generated method stub
		return null;
	}
/*********************************************END QUERY 5********************************************************/
/*******************************************START QUERY 6********************************************************/	
			
	@Override
	public ArrayList<Query> query6(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query6(int nTimes, String cropType) {
		// TODO Auto-generated method stub
		return null;
	}
/*********************************************END QUERY 6********************************************************/
/*******************************************START QUERY 7********************************************************/	
				
	@Override
	public ArrayList<Query> query7(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query7(int nTimes, double lowerBracket, double higherBracket) {
		// TODO Auto-generated method stub
		return null;
	}
}
