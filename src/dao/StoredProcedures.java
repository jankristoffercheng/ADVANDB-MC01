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

public class StoredProcedures extends AbstractDAO{

	public StoredProcedures() {
		super();
	}
	
	@Override
	public ArrayList<Query> query1(int nTimes) {
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery1()"
				+ "BEGIN"
					+ "SELECT id, memno, age, age_yr, birth_date, sex, educind, gradel, "
									+ "ynotsch, ynotsch_o, reln, jobind, occup "
					+ "FROM hpq_mem "
					+ "WHERE age_yr >= 15 AND age_yr <=30 AND reln = 1;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery1()";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery1;");
		return results;
	}
	
	public ArrayList<Query> query1(int nTimes, boolean isStudying) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery1(IN studying INT)"
				+ "BEGIN"
					+ "SELECT id, memno, age, age_yr, birth_date, sex, educind, gradel, "
									+ "ynotsch, ynotsch_o, reln, jobind, occup "
					+ "FROM hpq_mem "
					+ "WHERE age_yr >= 15 AND age_yr <=30 AND reln = 1 AND educind = studying;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery1(" + ((isStudying) ? "1" : "2") + ")";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery1;");
		return results;
	}

	@Override
	public ArrayList<Query> query2(int nTimes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Query> query2(int nTimes, boolean isStudying) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery2(IN isStudying INT) "
				+ "BEGIN "
					+ "IF (studying != 0) THEN"
						+ "SELECT occup, COUNT(occup) AS numOccup"
						+ "FROM hpq_mem  "
						+ "WHERE jobind = 1 AND reln = 1"
						+ "AND age_yr >= 15 AND age_yr <= 30"
						+ "AND educind = studying"
						+ "GROUP BY occup"
						+ "ORDER BY numOccup DESC;"
					+ "ELSE"
						+ "SELECT occup, COUNT(occup) AS numOccup"
						+ "FROM hpq_mem  "
						+ "WHERE jobind = 1 AND reln = 1"
						+ "AND age_yr >= 15 AND age_yr <= 30"
						+ "GROUP BY occup"
						+ "ORDER BY numOccup DESC;"
						+ "END IF;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery2(" + ")";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery2;");
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
