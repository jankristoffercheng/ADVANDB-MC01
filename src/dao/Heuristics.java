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

public class Heuristics extends AbstractDAO{

	public Heuristics() {
		super();
	}
/*******************************************START QUERY 1********************************************************/		
	@Override
	public ArrayList<Query> query1(int nTimes) {
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
		return results;
	}
	
	public ArrayList<Query> query1(int nTimes, boolean isStudying) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT id, memno, age, age_yr, birth_date, sex, educind, gradel, "
									+ "ynotsch, ynotsch_o, reln, jobind, occup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr >= 15 AND age_yr <=30 AND reln = 1 "
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
		return results;
	}
/*********************************************END QUERY 1********************************************************/
/*******************************************START QUERY 2********************************************************/	
	@Override
	public ArrayList<Query> query2(int nTimes) {
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
		return results;
	}

	public ArrayList<Query> query2(int nTimes, boolean isStudying) {
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
		return results;
	}
/*********************************************END QUERY 2********************************************************/
/*******************************************START QUERY 3********************************************************/	
	@Override
	public ArrayList<Query> query3(int nTimes) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 and 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "INNER JOIN  (SELECT H.id, COUNT(M.memno) AS mem_count "
							+ "FROM hpq_hh H, hpq_mem M "
							+ "WHERE H.id = M.id "
							+ "GROUP BY H.id) T "
				+ "ON H.id = T.id "
				+ "GROUP BY H.id;";
		
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
		return results;
	}
	
	public ArrayList<Query> query3(int nTimes, int memno, double lowerBracket, double higherBracket) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 and 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "INNER JOIN  (SELECT H.id, COUNT(M.memno) AS mem_count "
							+ "FROM hpq_hh H, hpq_mem M "
							+ "WHERE H.id = M.id "
							+ "GROUP BY H.id "
							+ "HAVING mem_count = " + memno + ") T "
				+ "ON H.id = T.id "
				+ "GROUP BY H.id "
				+ "HAVING monthly_income BETWEEN " + lowerBracket + " AND " + higherBracket;
		
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
		return results;
	}
/*********************************************END QUERY 3********************************************************/
/*******************************************START QUERY 4********************************************************/	
	@Override
	public ArrayList<Query> query4(int nTimes) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT A.mun, total_emp, total_num_mem, ((total_emp/total_num_mem)*100) AS rate_emp "
				+ "FROM (SELECT mun, COUNT(M.id) AS total_num_mem "
						+ "FROM (SELECT id, mun FROM hpq_hh) H "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
				+ "ON H.id = M.id GROUP BY H.mun) A "
				+ "INNER JOIN (SELECT mun, COUNT(M.id) AS total_emp "
							+ "FROM (SELECT id, mun FROM hpq_hh) H "
							+ "INNER JOIN (SELECT id "
										+ "FROM hpq_mem "
										+ "WHERE reln = 1 "
										+ "AND age_yr BETWEEN 15 AND 30 "
										+ "AND jobind = 1) M "
							+ "ON H.id = M.id GROUP BY H.mun) B "
				+ "ON A.mun = B.mun "
				+ "ORDER BY rate_emp DESC;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public ArrayList<Query> query4(int nTimes, boolean isEmployed) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT A.mun, total_emp, total_num_mem, ((total_emp/total_num_mem)*100) AS rate_emp "
				+ "FROM (SELECT mun, COUNT(M.id) AS total_num_mem "
						+ "FROM (SELECT id, mun FROM hpq_hh) H "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE reln = 1 AND age_yr BETWEEN 15 AND 30) M "
				+ "ON H.id = M.id GROUP BY H.mun) A "
				+ "INNER JOIN (SELECT mun, COUNT(M.id) AS total_emp "
							+ "FROM (SELECT id, mun FROM hpq_hh) H "
							+ "INNER JOIN (SELECT id "
										+ "FROM hpq_mem "
										+ "WHERE reln = 1 "
										+ "AND age_yr BETWEEN 15 AND 30 "
										+ "AND jobind = " + ((isEmployed) ? "1" : "2") +") M "
							+ "ON H.id = M.id GROUP BY H.mun) B "
				+ "ON A.mun = B.mun "
				+ "ORDER BY rate_emp DESC;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
/*********************************************END QUERY 4********************************************************/
/*******************************************START QUERY 5********************************************************/	
	@Override
	public ArrayList<Query> query5(int nTimes) {
		Connection connection = MySQLConnector.getConnection();

		String query = 
				"SELECT H.mun, H.id, aquanitype, aquanitype, aquani_vol "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT hpq_hh_id, aquanitype, aquanitype_o, aquani_vol "
							+ "FROM hpq_aquani "
							+ "WHERE aquani_vol < (SELECT AVG(aquani_vol) "
												+ "FROM hpq_aquani)) A "
				+ "ON H.id = A.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query5 result = new Query5(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Query> query5(int nTimes, String fishType) {
		Connection connection = MySQLConnector.getConnection();

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
		
		String query = 
				"SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT hpq_hh_id, aquanitype, aquanitype_o, aquani_vol "
							+ "FROM hpq_aquani "
							+ "WHERE "
							+ ((aquanitype == 6) ? 
							  "aquanitype = 6 AND aquanitype_o LIKE '%" + fishType + "%' " : 
							  "aquanitype = " + aquanitype + " ")
							+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
												+ "FROM hpq_aquani "
												+ "WHERE "
												+ ((aquanitype == 6) ? 
												   "aquanitype = 6 AND aquanitype_o LIKE '%" + fishType + "%' )) A " : 
												   "aquanitype = " + aquanitype + " )) A ")
				+ "ON H.id = A.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query5 result = new Query5(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
/*********************************************END QUERY 5********************************************************/	
/*********************************************START QUERY 6******************************************************/	
	@Override
	public ArrayList<Query> query6(int nTimes) {
		Connection connection = MySQLConnector.getConnection();

		String query = 
				"SELECT H.mun, H.id, croptype, croptype_o, crop_vol "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT hpq_hh_id, croptype, croptype_o, crop_vol "
							+ "FROM hpq_crop "
							+ "WHERE crop_vol < (SELECT AVG(crop_vol) "
												+ "FROM hpq_crop)) C "
				+ "ON H.id = C.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query6 result = new Query6(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public ArrayList<Query> query6(int nTimes, String cropType) {
		Connection connection = MySQLConnector.getConnection();

		cropType = cropType.toLowerCase().trim();
		int nCroptype = 4;
		if(cropType.equals("sugar cane")) {
			nCroptype = 1;
		} else if(cropType.equals("palay")) {
			nCroptype = 2;
		} else if(cropType.equals("corn")) {
			nCroptype = 3;
		}
		
		String query = 
				"SELECT H.mun, H.id, croptype, croptype_o, crop_vol "
				+ "FROM hpq_hh H "
				+ "INNER JOIN (SELECT hpq_hh_id, croptype, croptype_o, crop_vol "
							+ "FROM hpq_crop "
							+ "WHERE "
							+ ((nCroptype == 4) ? 
							  "croptype = 4 AND croptype_o LIKE '%" + cropType + "%' " : 
							  "croptype = " + cropType + " ")
							+ "AND crop_vol < (SELECT AVG(crop_vol) "
												+ "FROM hpq_crop "
												+ "WHERE "
												+ ((nCroptype == 4) ? 
												   "croptype = 4 AND croptype_o LIKE '%" + cropType + "%' ))C " : 
												   "croptype = " + cropType + " )) C ")
				+ "ON H.id = C.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query6 result = new Query6(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
/*********************************************END QUERY 6******************************************************/	
/*********************************************START QUERY 7******************************************************/
	public ArrayList<Query> query7(int nTimes) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
				+ "FROM hpq_hh H "
				+ "INNER JOIN hpq_aquani A "
				+ "ON H.id = A.hpq_hh_id "
				+ "INNER JOIN hpq_crop C "
				+ "ON H.id = C.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id;";
		
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
		return results;
	}
	
	public ArrayList<Query> query7(int nTimes, double lowerBracket, double higherBracket) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
				+ "FROM hpq_hh H "
				+ "INNER JOIN hpq_aquani A "
				+ "ON H.id = A.hpq_hh_id "
				+ "INNER JOIN hpq_crop C "
				+ "ON H.id = C.hpq_hh_id "
				+ "INNER JOIN (SELECT id "
							+ "FROM hpq_mem "
							+ "WHERE age_yr BETWEEN 15 AND 30 "
							+ "AND reln = 1) M "
				+ "ON H.id = M.id "
				+ "GROUP BY H.mun, H.id "
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
		return results;
	}
	
}
