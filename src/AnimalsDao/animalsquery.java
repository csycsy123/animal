package AnimalsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Animals.Animals;
import JdbcUilts.addjdbcuilts;
import JdbcUilts.jdbcuilts;

public class animalsquery {
	public static void main(String[] args) {

	}

	public List<Animals> Query() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Animals> animals = new ArrayList<>();
		try {
			conn = jdbcuilts.getConnection();
			stat = conn.createStatement();
			String sql = "select * from animals";
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
				animal.setHot(rs.getInt("hot"));
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

	public boolean insert(Animals animal) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean result = false;
		conn = addjdbcuilts.getConnection();
		String sql = "insert into animals (name,cover,description,distance,age,hot) values (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, animal.getName());
			pst.setString(2, animal.getCover());
			pst.setString(3, animal.getDescription());
			pst.setInt(4, animal.getDistance());
			pst.setInt(5, animal.getAge());
			pst.setInt(6, animal.getHot());
			int i = pst.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean update(Animals animal) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean result = false;
		conn = addjdbcuilts.getConnection();
		String sql = "update animals set name = ? , cover = ? ,description = ?,"
				+ " distance = ? , age = ? ,hot = ? where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, animal.getName());
			pst.setString(2, animal.getCover());
			pst.setString(3, animal.getDescription());
			pst.setInt(4, animal.getDistance());
			pst.setInt(5, animal.getAge());
			pst.setInt(6, animal.getHot());
			pst.setInt(7, animal.getId());
			int i = pst.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean result = false;
		conn = addjdbcuilts.getConnection();
		String sql = "delete from animals where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
