package AnimalsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Animals.info;
import JdbcUilts.jdbcuilts;

public class info_get {
	public static void main(String[] args) {

	}

	public List<info> Query() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<info> info = new ArrayList<info>();
		try {
			conn = jdbcuilts.getConnection();
			stat = conn.createStatement();
			String sql = "select * from infoform";
			rs = stat.executeQuery(sql);
			info infoget = null;
			while (rs.next()) {
				infoget = new info();
				infoget.setId(rs.getInt("tid"));
				infoget.setImage(rs.getString("image"));
				infoget.setDescription(rs.getString("description"));
				infoget.setName(rs.getString("name"));
				info.add(infoget);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcuilts.free(conn, stat, rs);
		}
		return info;
	}
}
