package AnimalsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Animals.addcall;
import JdbcUilts.jdbcuilts;

public class address {
	public List<addcall> Query() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<addcall> adds = new ArrayList<addcall>();
		try {
			conn = jdbcuilts.getConnection();
			stat = conn.createStatement();
			String sql = "select * from address";
			rs = stat.executeQuery(sql);
			addcall add = null;
			while (rs.next()) {
				add = new addcall();
				add.setAddress(rs.getString("address"));
				add.setNumbers(rs.getString("numbers"));
				adds.add(add);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcuilts.free(conn, stat, rs);
		}
		return adds;
	}
}
