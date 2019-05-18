package AnimalsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Animals.infocom;
import JdbcUilts.addjdbcuilts;

public class infocomment {

	public static void Addinfocom(infocom infocomment) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = addjdbcuilts.getConnection();
		String sql = "insert into infocomment (id,type,comment) values (?,?,?)";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, infocomment.getId());
		pst.setString(2, infocomment.getType());
		pst.setString(3, infocomment.getComment());

		int i = pst.executeUpdate();
	}

}
