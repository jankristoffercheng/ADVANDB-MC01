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

public class Original extends AbstractDAO{

	public Original() {
		super();
	}
/*******************************************START QUERY 1********************************************************/	
	@Override
	public ArrayList<Query> query1(int nTimes) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT *, id, memno, age_yr, birth_date, sex, educind, gradel, "
					+ "ynotsch, ynotsch_o, reln, jobind, occup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr BETWEEN 15 AND 30 AND reln = 1";
		
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
						rs.getInt("id"),
						rs.getInt("memno"),
						rs.getInt("age_yr"),
						rs.getString("birth_date"),
						rs.getInt("sex"),
						rs.getInt("educind"),
						rs.getInt("gradel"),
						rs.getInt("ynotsch"),
						rs.getString("ynotsch_o"),
						rs.getInt("reln"),
						rs.getInt("jobind"),
						rs.getString("occup"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Query> query1(int nTimes, boolean isStudying){
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT *, id, memno, age_yr, birth_date, sex, educind, gradel, "
					 + "ynotsch, ynotsch_o, reln, jobind, occup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr BETWEEN 15 AND 30 AND reln = 1 "
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
							rs.getInt("id"),
							rs.getInt("memno"),
							rs.getInt("age_yr"),
							rs.getString("birth_date"),
							rs.getInt("sex"),
							rs.getInt("educind"),
							rs.getInt("gradel"),
							rs.getInt("ynotsch"),
							rs.getString("ynotsch_o"),
							rs.getInt("reln"),
							rs.getInt("jobind"),
							rs.getString("occup"));
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
				"SELECT *, occup, COUNT(occup) AS numOccup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr BETWEEN 15 AND 30 "
				+ "AND reln = 1 "
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
				Query2 result = new Query2(rs.getString("occup"), rs.getInt("numOccup"));
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
				"SELECT *, occup, COUNT(occup) AS numOccup "
				+ "FROM hpq_mem "
				+ "WHERE age_yr BETWEEN 15 AND 30 "
				+ "AND reln = 1 "
				+ "AND educind = "+ ((isStudying) ? "1 " : "2 ")
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
				Query2 result = new Query2(rs.getString("occup"), rs.getInt("numOccup"));
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
				"SELECT *, H.id AS household, H.totin/12 AS monthly_income, T.mem_count "
						+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
								                   + "FROM hpq_hh H, hpq_mem M "
								                   + "WHERE H.id = M.id "
								                   + "GROUP BY H.id) T "
						+ "WHERE H.id = M.id "
						+ "AND M.id = T.id "
						+ "AND M.age_yr BETWEEN 15 AND 30 "
						+ "AND M.reln = 1 "
						+ "GROUP BY H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query3 result = new Query3(rs.getInt("household"), rs.getDouble("monthly_income"), rs.getInt("mem_count"));
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
				"SELECT *, H.id AS household, H.totin/12 AS monthly_income, T.mem_count "
						+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
								                   + "FROM hpq_hh H, hpq_mem M "
								                   + "WHERE H.id = M.id "
								                   + "GROUP BY H.id) T "
						+ "WHERE H.id = M.id "
						+ "AND M.id = T.id "
						+ "AND M.age_yr BETWEEN 15 AND 30 "
						+ "AND M.reln = 1 "
						+ "GROUP BY H.id "
						+ "HAVING monthly_income BETWEEN "+ lowerBracket +" AND "+ higherBracket 
						+ " AND mem_count = "+memno+";";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query3 result = new Query3(rs.getInt("household"), rs.getDouble("monthly_income"), rs.getInt("mem_count"));
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
				"SELECT *, H.mun, COUNT(Q.id) AS total_emp, T.total_num_mem, (COUNT(Q.id)/T.total_num_mem)*100 AS rate_emp "
				+ "FROM hpq_hh H, hpq_mem Q, (SELECT mun, COUNT(Q.id) AS total_num_mem "
											+ "FROM hpq_hh H, hpq_mem Q "
											+ "WHERE H.id = Q.id "
											+ "AND Q.reln = 1 "
											+ "AND Q.age_yr BETWEEN 15 and 30 "
											+ "GROUP BY H.mun) T "
				+ "WHERE H.id = Q.id AND T.mun = H.mun "
				+ "AND Q.reln = 1 "
				+ "AND Q.age_yr BETWEEN 15 and 30 "
				+ "GROUP BY H.mun "
				+ "ORDER BY T.total_num_mem DESC;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt("mun"), rs.getInt("total_emp"), rs.getInt("total_num_mem"), rs.getDouble("rate_emp"));
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
				"SELECT *, H.mun, COUNT(Q.id) AS total_emp, T.total_num_mem, (COUNT(Q.id)/T.total_num_mem)*100 AS rate_emp "
				+ "FROM hpq_hh H, hpq_mem Q, (SELECT mun, COUNT(Q.id) AS total_num_mem "
											+ "FROM hpq_hh H, hpq_mem Q "
											+ "WHERE H.id = Q.id "
											+ "AND Q.reln = 1 "
											+ "AND Q.age_yr BETWEEN 15 and 30 "
											+ "GROUP BY H.mun) T "
				+ "WHERE H.id = Q.id AND T.mun = H.mun "
				+ "AND Q.reln = 1 "
				+ "AND Q.age_yr BETWEEN 15 and 30 "
				+ "AND Q.jobind = " + ((isEmployed) ? "1 " : "2 ")
				+ "GROUP BY H.mun "
				+ "ORDER BY T.total_num_mem DESC;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query4 result = new Query4(rs.getInt("mun"), rs.getInt("total_emp"), rs.getInt("total_num_mem"), rs.getDouble("rate_emp"));
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
				"SELECT *, H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
				+ "FROM hpq_aquani A, hpq_hh H, query1 Q "
				+ "WHERE Q.id = H.id AND Q.id = A.hpq_hh_id "
				+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
								  + "FROM hpq_aquani)"
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query5 result = new Query5(rs.getInt("municipality"), rs.getInt("household"), rs.getInt("aquanitype"), rs.getString("aquanitype_o"), rs.getInt("aquani_vol"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				 "SELECT *, H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
				+ "FROM hpq_aquani A, hpq_hh H, hpq_mem Q "
				+ "WHERE Q.id = H.id AND Q.id = A.hpq_hh_id "
				+ "AND Q.age_yr BETWEEN 15 AND 30 "
				+ "AND Q.reln = 1 "
				+ "AND " + ((aquanitype == 6)? 
						    "aquanitype = 6 AND aquanitype_o LIKE '%" + fishType + "%' " :
					        "aquanitype = " + aquanitype + " ") 
				+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
								  + "FROM hpq_aquani "
								  + "WHERE " 
								  + ((aquanitype == 6)? 
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
				Query5 result = new Query5(rs.getInt("municipality"), rs.getInt("household"), rs.getInt("aquanitype"), rs.getString("aquanitype_o"), rs.getInt("aquani_vol"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
/*********************************************END QUERY 5********************************************************/
/*******************************************START QUERY 6********************************************************/	
		
	@Override
	public ArrayList<Query> query6(int nTimes) {
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT *, H.mun AS municipality, H.id AS household, C.croptype, C.croptype_o, C.crop_vol "
				+ "FROM hpq_crop C, hpq_hh H, query1 Q "
				+ "WHERE Q.id = H.id AND Q.id = C.hpq_hh_id "
				+ "AND crop_vol < (SELECT AVG(crop_vol) "
								+ "FROM hpq_crop) "
				+ "GROUP BY H.mun, H.id;";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query6 result = new Query6(rs.getInt("municipality"), rs.getInt("household"), rs.getInt("croptype"), rs.getString("croptype_o"), rs.getInt("crop_vol"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				  "SELECT *, H.mun AS municipality, H.id AS household, C.croptype, C.croptype_o, C.crop_vol "
				+ "FROM hpq_crop C, hpq_hh H, hpq_mem Q "
				+ "WHERE Q.id = H.id AND Q.id = C.hpq_hh_id "
				+ "AND Q.age_yr BETWEEN 15 AND 30 "
				+ "AND Q.reln = 1 "
				+ "AND " + ((nCroptype == 4)? 
						    "croptype = 4 AND croptype_o LIKE '%" + cropType + "%' " :
					        "croptype = " + nCroptype + " ") 
				+ "AND crop_vol < (SELECT AVG(crop_vol) "
								  + "FROM hpq_crop "
								  + "WHERE " 
								  + ((nCroptype == 4)? 
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
				Query6 result = new Query6(rs.getInt("municipality"), rs.getInt("household"), rs.getInt("croptype"), rs.getString("croptype_o"), rs.getInt("crop_vol"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
/*********************************************END QUERY 6********************************************************/
/*******************************************START QUERY 7********************************************************/	
		
	@Override
	public ArrayList<Query> query7(int nTimes) {
		// TODO Auto-generated method stub
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT *, H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
				+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
				+ "WHERE H.id = M.id "
				+ "AND H.id = A.hpq_hh_id "
				+ "AND H.id = C.hpq_hh_id "
				+ "AND M.age_yr BETWEEN 15 AND 30 "
				+ "AND M.reln = 1 "
				+ "GROUP BY H.mun, H.id;";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query7 result = new Query7(rs.getInt("mun"), rs.getInt("id"), rs.getInt("aquanitype"),
						rs.getString("aquanitype_o"), rs.getInt("aquani_vol"), rs.getInt("croptype"),
						rs.getString("croptype_o"), rs.getInt("crop_vol"), rs.getInt("monthly_income"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Query> query7(int nTimes, double lowerBracket, double higherBracket) {
		// TODO Auto-generated method stub
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"SELECT *, H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
				+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
				+ "WHERE H.id = M.id "
				+ "AND H.id = A.hpq_hh_id "
				+ "AND H.id = C.hpq_hh_id "
				+ "AND M.age_yr BETWEEN 15 AND 30 "
				+ "AND M.reln = 1 "
				+ "GROUP BY H.mun, H.id "
				+ "HAVING monthly_income BETWEEN " + lowerBracket + " AND " + higherBracket+ ";";
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query7 result = new Query7(rs.getInt("mun"), rs.getInt("id"), rs.getInt("aquanitype"),
						rs.getString("aquanitype_o"), rs.getInt("aquani_vol"), rs.getInt("croptype"),
						rs.getString("croptype_o"), rs.getInt("crop_vol"), rs.getInt("monthly_income"));
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
}
