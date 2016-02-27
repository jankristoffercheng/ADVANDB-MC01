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

public class Indexed extends AbstractDAO{

	public Indexed() {
		super();
	}
	
	@Override
	public ArrayList<Query> query1(int nTimes) {
		MySQLConnector.executeStatement("ALTER TABLE hpq_mem ADD KEY (reln);");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT id, memno, age, age_yr, birth_date, sex, educind, gradel, "
									+ "ynotsch, ynotsch_o, reln, jobind, occup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr >= 15 AND age_yr <=30 AND reln = 1";
		
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
		MySQLConnector.executeStatement("DROP INDEX reln ON hpq_mem;");
		return results;
	}
	
	public ArrayList<Query> query1(int nTimes, boolean isStudying) {
		
		MySQLConnector.executeStatement("ALTER TABLE hpq_mem ADD KEY (reln);");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT id, memno, age, age_yr, birth_date, sex, educind, gradel, "
									+ "ynotsch, ynotsch_o, reln, jobind, occup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr >= 15 AND age_yr <=30 AND reln = 1"
				+ "AND educind = " + ((isStudying) ? "1" : "2");
		
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
		MySQLConnector.executeStatement("DROP INDEX reln ON hpq_mem;");
		return results;
	}
	
	@Override
	public ArrayList<Query> query2(int nTimes) {
		MySQLConnector.executeStatement("CREATE INDEX index1 ON hpq_mem (age_yr);");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT occup, COUNT(occup) AS numOccup "
				+ "FROM (SELECT occup "
						+ "FROM hpq_mem "
						+ "WHERE age_yr >= 15 AND age_yr <= 30 "
						+ "AND reln = 1) A "
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
		MySQLConnector.executeStatement("DROP INDEX index1 ON hpq_mem;");
		return results;
	}

	public ArrayList<Query> query2(int nTimes, boolean isStudying) {
		
		MySQLConnector.executeStatement("CREATE INDEX index1 ON hpq_mem (age_yr);");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT occup, COUNT(occup) AS numOccup "
				+ "FROM (SELECT occup "
						+ "FROM hpq_mem "
						+ "WHERE age_yr >= 15 AND age_yr <= 30 "
						+ "AND reln = 1 AND educind = " + ((isStudying) ? "1" : "2") + ") A "
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
		MySQLConnector.executeStatement("DROP INDEX index1 ON hpq_mem;");
		return results;
	}
	
	@Override
	public ArrayList<Query> query3(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Query> query3(int nTimes, int memno, double lowerBracket, double higherBracket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> query4(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> query5(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query5(int nTimes, String fishType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Query> query6(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Query> query6(int nTimes, String cropType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Query> query7(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
