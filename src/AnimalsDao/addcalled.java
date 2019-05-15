package AnimalsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Animals.addcall;
import JdbcUilts.addjdbcuilts;

public class addcalled {
	
	
	public static void Addcalleds(addcall music) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;

			conn = addjdbcuilts.getConnection();
			String sql = "insert into address (address,numbers) values (?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, music.getAddress());
			pst.setString(2, music.getNumbers());
			int i=pst.executeUpdate();
	}

}
