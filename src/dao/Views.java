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
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getString(12));
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
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getString(12));
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
										+ "AND reln = 1 ;");
		
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
				"SELECT id, monthly_income, mem_count "
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
				"SELECT id, monthly_income, mem_count "
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
		MySQLConnector.executeStatement("CREATE TABLE query4view (mun INT, countRaw INT);");
		MySQLConnector.executeStatement("INSERT INTO query4view "
										+ "SELECT mun, COUNT(M.id) AS total_num_mem "
										+ "FROM (SELECT id, mun FROM hpq_hh) H "
										+ "INNER JOIN (SELECT id "
													+ "FROM hpq_mem "
													+ "WHERE reln = 1 "
													+ "AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun;");
		
		MySQLConnector.executeStatement("CREATE TABLE query4view1 (mun INT, countJob INT);");
		MySQLConnector.executeStatement("INSERT INTO query4view1 "
										+ "SELECT mun, COUNT(M.id) AS total_emp "
										+ "FROM (SELECT id, mun FROM hpq_hh) H "
										+ "INNER JOIN (SELECT id "
													+ "FROM hpq_mem "
													+ "WHERE reln = 1 "
													+ "AND age_yr BETWEEN 15 AND 30 "
													+ "AND jobind = 1) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT A.mun, countJob AS total_emp, countRaw AS total_num_mem, ((countJob/countRaw) * 100) AS rate_emp "
				+ "FROM query4view A "
				+ "INNER JOIN query4view1 B "
				+ "ON A.mun = B.mun "
				+ "GROUP BY A.mun "
				+ "ORDER BY rate_emp DESC;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query4view;");
		MySQLConnector.executeStatement("DROP TABLE query4view1;");
		return results;
	}
	
	public ArrayList<Query> query4(int nTimes, boolean isEmployed) {
		MySQLConnector.executeStatement("CREATE TABLE query4view (mun INT, countRaw INT);");
		MySQLConnector.executeStatement("INSERT INTO query4view "
										+ "SELECT mun, COUNT(M.id) AS total_num_mem "
										+ "FROM (SELECT id, mun FROM hpq_hh) H "
										+ "INNER JOIN (SELECT id "
													+ "FROM hpq_mem "
													+ "WHERE reln = 1 "
													+ "AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun;");
		
		MySQLConnector.executeStatement("CREATE TABLE query4view1 (mun INT, countJob INT);");
		MySQLConnector.executeStatement("INSERT INTO query4view1 "
										+ "SELECT mun, COUNT(M.id) AS total_emp "
										+ "FROM (SELECT id, mun FROM hpq_hh) H "
										+ "INNER JOIN (SELECT id "
													+ "FROM hpq_mem "
													+ "WHERE reln = 1 "
													+ "AND age_yr BETWEEN 15 AND 30 "
													+ "AND jobind = "+ ((isEmployed) ? "1" : "2")+ ") M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT A.mun, countJob AS total_emp, countRaw AS total_num_mem, ((countJob/countRaw) * 100) AS rate_emp "
				+ "FROM query4view A "
				+ "INNER JOIN query4view1 B "
				+ "ON A.mun = B.mun "
				+ "GROUP BY A.mun "
				+ "ORDER BY rate_emp DESC;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query4view;");
		MySQLConnector.executeStatement("DROP TABLE query4view1;");
		return results;
	}
/*********************************************END QUERY 4********************************************************/
/*******************************************START QUERY 5********************************************************/	
				
	@Override
	public ArrayList<Query> query5(int nTimes) {
		MySQLConnector.executeStatement("CREATE TABLE query5view (mun INT, id INT);");
		MySQLConnector.executeStatement("INSERT INTO query5view "
										+ "SELECT mun, M.id "
										+ "FROM (SELECT id, mun "
										+ "		 FROM hpq_hh) H "
										+ "INNER JOIN(SELECT id "
										+ "           FROM hpq_mem "
										+ "           WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun, H.id;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
				+ "FROM query5view H "
				+ "INNER JOIN hpq_aquani A "
				+ "ON H.id = A.hpq_hh_id "
				+ "WHERE A.aquani_vol < (SELECT AVG(aquani_vol)"
				+ "                		 FROM hpq_aquani) "
				+ "GROUP BY H.mun, H.id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query5 result = new Query5(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query5view;");
		return results;
	}
	
	public ArrayList<Query> query5(int nTimes, String fishType) {
		
		fishType = fishType.toLowerCase().trim();
		int aquanitype = 6;
		if(fishType.equals("tilapia")) {
			aquanitype = 1;
		} else if(fishType.equals("milkfish")) {
			aquanitype = 2;
		} else if(fishType.equals("catfish")) {
			aquanitype = 3;
		} else if(fishType.equals("mudfish")) {
			aquanitype = 4;
		} else if(fishType.equals("carp")) {
			aquanitype = 5;
		}
		
		MySQLConnector.executeStatement("CREATE TABLE query5view (mun INT, id INT);");
		MySQLConnector.executeStatement("INSERT INTO query5view "
										+ "SELECT mun, M.id "
										+ "FROM (SELECT id, mun "
										+ "		 FROM hpq_hh) H "
										+ "INNER JOIN(SELECT id "
										+ "           FROM hpq_mem "
										+ "           WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun, H.id;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
				+ "FROM query5view H "
				+ "INNER JOIN hpq_aquani A "
				+ "ON H.id = A.hpq_hh_id "
				+ "WHERE "+ ((aquanitype == 6)? 
						     "aquanitype = 6 AND aquanitype_o LIKE '%" + fishType + "%'" :
					         "aquanitype = " + aquanitype) + " " 
				+ "AND A.aquani_vol < (SELECT AVG(aquani_vol)"
				+ "                	   FROM hpq_aquani"
				+ "					   WHERE "+ 
									   ((aquanitype == 6)? 
								        "aquanitype = 6 AND aquanitype_o LIKE '%" + fishType + "%' )" :
									    "aquanitype = " + aquanitype + " )") 
				+ "GROUP BY H.mun, H.id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query5 result = new Query5(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query5view;");
		return results;
	}
/*********************************************END QUERY 5********************************************************/
/*******************************************START QUERY 6********************************************************/	
			
	@Override
	public ArrayList<Query> query6(int nTimes) {
		MySQLConnector.executeStatement("CREATE TABLE query6view (mun INT, id INT);");
		MySQLConnector.executeStatement("INSERT INTO query6view "
										+ "SELECT mun, M.id "
										+ "FROM (SELECT id, mun "
										+ "		 FROM hpq_hh) H "
										+ "INNER JOIN(SELECT id "
										+ "           FROM hpq_mem "
										+ "           WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun, H.id;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun, H.id, C.croptype, C.croptype_o, C.crop_vol "
				+ "FROM query6view H "
				+ "INNER JOIN hpq_crop C "
				+ "ON H.id = C.hpq_hh_id "
				+ "WHERE C.crop_vol < (SELECT AVG(crop_vol) "
				+ "                    FROM hpq_crop ) "
				+ "GROUP BY H.mun, H.id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query6 result = new Query6(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query6view;");
		return results;
	}
	
	public ArrayList<Query> query6(int nTimes, String cropType) {
		
		cropType = cropType.toLowerCase().trim();
		int nCroptype = 4;
		if(cropType.equals("sugar cane")) {
			nCroptype = 1;
		} else if(cropType.equals("palay")) {
			nCroptype = 2;
		} else if(cropType.equals("corn")) {
			nCroptype = 3;
		}
		
		MySQLConnector.executeStatement("CREATE TABLE query6view (mun INT, id INT);");
		MySQLConnector.executeStatement("INSERT INTO query6view "
										+ "SELECT mun, M.id "
										+ "FROM (SELECT id, mun "
										+ "		 FROM hpq_hh) H "
										+ "INNER JOIN(SELECT id "
										+ "           FROM hpq_mem "
										+ "           WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
										+ "ON H.id = M.id "
										+ "GROUP BY H.mun, H.id;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun, H.id, C.croptype, C.croptype_o, C.crop_vol "
				+ "FROM query6view H "
				+ "INNER JOIN hpq_crop C "
				+ "ON H.id = C.hpq_hh_id "
				+ "WHERE "
				+ 			((nCroptype == 4)? 
						    "croptype = 4 AND croptype_o LIKE '%" + cropType + "%' " :
					        "croptype = " + nCroptype + " ")  
				+ "AND C.crop_vol < (SELECT AVG(crop_vol) "
				+ "                  FROM hpq_crop "
				+ "                  WHERE " 
				+ 					((nCroptype == 4)? 
								     "croptype = 4 AND croptype_o LIKE '%" + cropType + "%' )" :
									 "croptype = " + nCroptype + " ) ") 
				+ "GROUP BY H.mun, H.id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query6 result = new Query6(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query6view;");
		return results;
	}
/*********************************************END QUERY 6********************************************************/
/*******************************************START QUERY 7********************************************************/	
				
	@Override
	public ArrayList<Query> query7(int nTimes) {
	
		MySQLConnector.executeStatement("CREATE TABLE query7view (mun INT, id INT, aquanitype INT, "
										+ "aquanitype_o VARCHAR(255), aquani_vol INT, croptype INT, "
										+ "croptype_o VARCHAR(255), crop_vol INT, monthly_income DOUBLE);");
		MySQLConnector.executeStatement("INSERT INTO query7view "
										+ "SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol,"
										+ "       croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
										+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
										+ "WHERE H.id = M.id "
										+ "AND H.id = A.hpq_hh_id AND H.id = C.hpq_hh_id "
										+ "AND M.age_yr BETWEEN 15 AND 30 "
										+ "AND M.reln = 1;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT mun, id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, monthly_income "
				+ "FROM query7view "
				+ "GROUP BY mun, id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query7 result = new Query7(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
						                   rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), 
						                   rs.getDouble(9));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP TABLE query7view;");
		return results;
	}
	
	public ArrayList<Query> query7(int nTimes, double lowerBracket, double higherBracket) {
		MySQLConnector.executeStatement("CREATE TABLE query7view (mun INT, id INT, aquanitype INT, "
										+ "aquanitype_o VARCHAR(255), aquani_vol INT, croptype INT, "
										+ "croptype_o VARCHAR(255), crop_vol INT, monthly_income DOUBLE);");
		MySQLConnector.executeStatement("INSERT INTO query7view "
										+ "SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol,"
										+ "       croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
										+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
										+ "WHERE H.id = M.id "
										+ "AND H.id = A.hpq_hh_id AND H.id = C.hpq_hh_id "
										+ "AND M.age_yr BETWEEN 15 AND 30 "
										+ "AND M.reln = 1;");
		Connection connection = MySQLConnector.getConnection();
		String query = 
						"SELECT mun, id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, monthly_income "
						+ "FROM query7view "
						+ "GROUP BY mun, id "
						+ "HAVING monthly_income BETWEEN "+lowerBracket+" AND "+higherBracket+";";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query7 result = new Query7(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
				                   rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), 
				                   rs.getDouble(9));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MySQLConnector.executeStatement("DROP TABLE query7view;");
		return results;
	}
}
