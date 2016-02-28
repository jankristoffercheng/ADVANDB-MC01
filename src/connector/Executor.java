package connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Executor {

	private double duration;
	
	public ResultSet executeQuery(int nTimes, PreparedStatement ps) throws SQLException {
		ResultSet rs = null;
		for(int i=0; i<nTimes; i++) {
			long start = System.currentTimeMillis();
			rs = ps.executeQuery();
			long result = System.currentTimeMillis() - start;
			duration += result;
			System.out.printf("%.4f\n", result/1000.0);
		}
		duration /= nTimes;
		duration /= 1000;
		return rs;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void reset() {
		duration = 0;
	}
}
