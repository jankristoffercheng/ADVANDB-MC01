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
				"CREATE PROCEDURE getQuery1() "
				+ "BEGIN "
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
				+ "BEGIN "
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
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery2() "
				+ "BEGIN "
					+ "SELECT occup, COUNT(occup) AS numOccup "
					+ "FROM hpq_mem  "
					+ "WHERE jobind = 1 AND reln = 1 "
					+ "AND age_yr >= 15 AND age_yr <= 30 "
					+ "GROUP BY occup "
					+ "ORDER BY numOccup DESC;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery2()";
		
		ArrayList<Query> results = new ArrayList<Query>();
		PreparedStatement ps;
		ResultSet rs;
		executor.reset();
		try {
			ps = connection.prepareStatement(query);
			rs = executor.executeQuery(nTimes, ps);
			while(rs.next()) {
				Query2 result = new Query2(rs.getString(1), rs.getInt(2));
				System.out.println(result.getOccup());
				results.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery2;");
		return results;
	}
	
	public ArrayList<Query> query2(int nTimes, boolean isStudying) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery2(IN isStudying INT) "
				+ "BEGIN "
					+ "SELECT occup, COUNT(occup) AS numOccup "
					+ "FROM hpq_mem  "
					+ "WHERE jobind = 1 AND reln = 1 "
					+ "AND age_yr >= 15 AND age_yr <= 30 "
					+ "AND educind = isStudying "
					+ "GROUP BY occup "
					+ "ORDER BY numOccup DESC;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery2(" + ((isStudying) ? "1" : "2") + ")";
		
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
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery3() "
				+ "BEGIN "
					+ "SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
					+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
												+ "FROM hpq_hh H, hpq_mem M "
												+ "WHERE H.id = M.id "
												+ "GROUP BY H.id) T "
					+ "WHERE H.id = M.id "
					+ "AND M.id = T.id "
					+ "AND M.age_yr BETWEEN 15 AND 30 "
					+ "AND M.reln = 1 "
					+ "GROUP BY H.id;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery3()";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery3;");
		return results;
	}
	
	public ArrayList<Query> query3(int nTimes, int memno, double lowerBracket, double higherBracket) {
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery3(IN memCount INT, IN lowerBracket DOUBLE, IN higherBracket DOUBLE) "
				+ "BEGIN "
					+ "SELECT H.id AS houshold, H.totin/12 AS monthly_income, T.mem_count "
					+ "FROM hpq_hh H, hpq_mem M, (SELECT H.id, COUNT(M.memno) AS mem_count "
												+ "FROM hpq_hh H, hpq_mem M "
												+ "WHERE H.id = M.id "
												+ "GROUP BY H.id) T "
					+ "WHERE H.id = M.id "
					+ "AND M.id = T.id "
					+ "AND M.age_yr BETWEEN 15 AND 30 "
					+ "AND M.reln = 1 "
					+ "GROUP BY H.id "
					+ "HAVING monthly_income BETWEEN lowerBracket AND higherBracket "
					+ "AND mem_count = memCount;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery3(" + memno + ", " + lowerBracket + ", " + higherBracket + ")";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery3;");
		return results;
	}

	@Override
	public ArrayList<Query> query4(int nTimes) {

		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery4() "
				+ "BEGIN "
				+ "SELECT J.mun, J.total_emp, T.total_num_mem, (J.total_emp/T.total_num_mem)*100 AS rate_emp "
				+ "FROM (SELECT mun, COUNT(Q.id) AS total_emp "
						+ "FROM hpq_hh H, hpq_mem Q "
						+ "WHERE H.id = Q.id "
						+ "AND Q.reln = 1 "
						+ "AND Q.age_yr BETWEEN 15 and 30 "
						+ "GROUP BY H.mun) J "
				+ "INNER JOIN (SELECT mun, COUNT(Q.id) AS total_num_mem "
							+ "FROM hpq_hh H, hpq_mem Q "
							+ "WHERE H.id = Q.id "
							+ "AND Q.reln = 1 "
							+ "AND Q.age_yr BETWEEN 15 and 30 "
							+ "GROUP BY H.mun) T "
				+ "ON J.mun = T.mun "
				+ "ORDER BY rate_emp DESC;"
			+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery4()";
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery4;");
		return results;
	}
	
	public ArrayList<Query> query4(int nTimes, boolean isEmployed) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery4(IN isWorking INT) "
				+ "BEGIN "
				+ "SELECT J.mun, J.total_emp, T.total_num_mem, (J.total_emp/T.total_num_mem)*100 AS rate_emp "
				+ "FROM (SELECT mun, COUNT(Q.id) AS total_emp "
						+ "FROM hpq_hh H, hpq_mem Q "
						+ "WHERE H.id = Q.id "
						+ "AND Q.reln = 1 "
						+ "AND Q.age_yr BETWEEN 15 and 30 "
						+ "AND jobind = isWorking "
						+ "GROUP BY H.mun) J "
				+ "INNER JOIN (SELECT mun, COUNT(Q.id) AS total_num_mem "
							+ "FROM hpq_hh H, hpq_mem Q "
							+ "WHERE H.id = Q.id "
							+ "AND Q.reln = 1 "
							+ "AND Q.age_yr BETWEEN 15 and 30 "
							+ "GROUP BY H.mun) T "
				+ "ON J.mun = T.mun "
				+ "ORDER BY rate_emp DESC;"
			+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery4(" + ((isEmployed) ? "1" : "2") + ")";
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery4;");
		return results;
	}
	
	@Override
	public ArrayList<Query> query5(int nTimes) {

		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery5() "
				+ "BEGIN "
					+ "SELECT H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
					+ "FROM hpq_aquani A, hpq_hh H, hpq_mem Q "
					+ "WHERE Q.id = H.id AND Q.id = A.hpq_hh_id "
					+ "AND Q.age_yr BETWEEN 15 AND 30 "
					+ "AND Q.reln = 1 "
					+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
										+ "FROM hpq_aquani) "
					+ "GROUP BY H.mun, H.id;"
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery5()";
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery5;");
		return results;
	}

	public ArrayList<Query> query5(int nTimes, String fishType) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery5(IN typeno INT, IN fishname VARCHAR(30)) "
				+ "BEGIN "
					+ "IF typeno BETWEEN 1 AND 5 THEN "
						+ "SELECT H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
						+ "FROM hpq_aquani A, hpq_hh H, hpq_mem Q "
						+ "WHERE Q.id = H.id AND Q.id = A.hpq_hh_id "
						+ "AND Q.age_yr BETWEEN 15 AND 30 "
						+ "AND Q.reln = 1 "
						+ "AND aquanitype = typeno "
						+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
											+ "FROM hpq_aquani "
											+ "WHERE aquanitype = typeno) "
						+ "GROUP BY H.mun, H.id; "
					+ "ELSEIF typeno = 6 THEN "
						+ "SELECT H.mun AS municipality, H.id AS household, A.aquanitype, A.aquanitype_o, A.aquani_vol "
						+ "FROM hpq_aquani A, hpq_hh H, hpq_mem Q "
						+ "WHERE Q.id = H.id AND Q.id = A.hpq_hh_id "
						+ "AND Q.age_yr BETWEEN 15 AND 30 "
						+ "AND Q.reln = 1 "
						+ "AND aquanitype_o LIKE CONCAT('%',fishname,'%') "
						+ "AND aquanitype = typeno "
						+ "AND aquani_vol < (SELECT AVG(aquani_vol) "
											+ "FROM hpq_aquani "
											+ "WHERE aquanitype_o LIKE CONCAT('%',fishname,'%') "
											+ "AND aquanitype = typeno) "
						+ "GROUP BY H.mun, H.id; "
					+ "END IF; "
				+ "END");
		
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
				"CALL getQuery5(" + aquanitype + ", '" + fishType + "')";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery5;");
		return results;
	}

	@Override
	public ArrayList<Query> query6(int nTimes) {

		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery6() "
				+ "BEGIN "
					+ "SELECT H.mun, H.id, C.croptype, C.croptype_o, C.crop_vol "
					+ "FROM hpq_crop C, hpq_hh H, hpq_mem Q "
					+ "WHERE Q.id = H.id AND Q.id = C.hpq_hh_id "
					+ "AND Q.age_yr BETWEEN 15 AND 30 "
					+ "AND Q.reln = 1 "
					+ "AND crop_vol < (SELECT AVG(crop_vol) "
									+ "FROM hpq_crop) "
					+ "GROUP BY H.mun, H.id; "
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		
		String query = 
				"CALL getQuery6()";
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery6;");
		return results;
	}
	
	public ArrayList<Query> query6(int nTimes, String cropType) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery6(IN typeno INT, IN cropname VARCHAR(30)) "
				+ "BEGIN "
					+ "IF typeno BETWEEN 1 AND 3 THEN "
						+ "SELECT H.mun, H.id, C.croptype, C.croptype_o, C.crop_vol "
						+ "FROM hpq_crop C, hpq_hh H, hpq_mem Q "
						+ "WHERE Q.id = H.id AND Q.id = C.hpq_hh_id "
						+ "AND Q.age_yr BETWEEN 15 AND 30 "
						+ "AND Q.reln = 1 "
						+ "AND croptype = typeno "
						+ "AND crop_vol < (SELECT AVG(crop_vol) "
										+ "FROM hpq_crop "
										+ "WHERE croptype =  typeno) "
						+ "GROUP BY H.mun, H.id; "
					+ "ELSEIF typeno = 4 THEN "
						+ "SELECT H.mun, H.id, C.croptype, C.croptype_o, C.crop_vol "
						+ "FROM hpq_crop C, hpq_hh H, hpq_mem Q "
						+ "WHERE Q.id = H.id AND Q.id = C.hpq_hh_id "
						+ "AND Q.age_yr BETWEEN 15 AND 30 "
						+ "AND Q.reln = 1 "
						+ "AND croptype_o LIKE CONCAT('%',cropname,'%') "
						+ "AND croptype = typeno "
						+ "AND crop_vol < (SELECT AVG(crop_vol) "
										+ "FROM hpq_crop "
										+ "WHERE croptype_o LIKE CONCAT('%',cropname,'%') "
										+ "AND croptype = typeno) "
						+ "GROUP BY H.mun, H.id; "
					+ "END IF; "
				+ "END");
		
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
				"CALL getQuery6(" + nCroptype + ", '" + cropType + "')";
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery6;");
		return results;
	}

	@Override
	public ArrayList<Query> query7(int nTimes) {
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery7() "
				+ "BEGIN "
					+ "SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
					+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
					+ "WHERE H.id = M.id "
					+ "AND H.id = A.hpq_hh_id "
					+ "AND H.id = C.hpq_hh_id "
					+ "AND M.age_yr BETWEEN 15 AND 30 "
					+ "AND M.reln = 1 "
					+ "GROUP BY H.mun, H.id; "
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery7()";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery7;");
		return results;
	}
	
	public ArrayList<Query> query7(int nTimes, double lowerBracket, double higherBracket) {
		
		MySQLConnector.executeStatement(
				"CREATE PROCEDURE getQuery7(IN lowerBracket DOUBLE, IN higherBracket DOUBLE) "
				+ "BEGIN "
					+ "SELECT H.mun, H.id, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, totin/12 AS monthly_income "
					+ "FROM hpq_hh H, hpq_aquani A, hpq_crop C, hpq_mem M "
					+ "WHERE H.id = M.id "
					+ "AND H.id = A.hpq_hh_id "
					+ "AND H.id = C.hpq_hh_id "
					+ "AND M.age_yr BETWEEN 15 AND 30 "
					+ "AND M.reln = 1 "
					+ "GROUP BY H.mun, H.id "
					+ "HAVING monthly_income BETWEEN lowerBracket AND higherBracket; "
				+ "END");
		
		Connection connection = MySQLConnector.getConnection();
		String query = 
				"CALL getQuery7(" + lowerBracket + ", " + higherBracket + ")";
		
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
		MySQLConnector.executeStatement("DROP PROCEDURE getQuery7;");
		return results;
	}
}
