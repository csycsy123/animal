package AnimalsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Animals.Animals;
import JdbcUilts.jdbcuilts;

public class animals_cat {
	public static void main(String[] args) {

	}

	public List<Animals> Query() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Animals> animals = new ArrayList<Animals>();
		try {
			conn = jdbcuilts.getConnection();
			stat = conn.createStatement();
			String sql = "select * from animals where description like '%è%'";
			rs = stat.executeQuery(sql);
			Animals animal = null;
			while (rs.next()) {
				animal = new Animals();
				animal.setAge(rs.getInt("age"));
				animal.setCover(rs.getString("cover"));
				animal.setDescription(rs.getString("description"));
				animal.setId(rs.getInt("id"));
				animal.setName(rs.getString("name"));
				animal.setDistance(rs.getInt("distance"));
				animals.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcuilts.free(conn, stat, rs);
		}
		return animals;
	}
}
