package AnimalsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Animals.info;
import JdbcUilts.addjdbcuilts;

public class infoform {

	public static void Addinfo(info infoform) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
			conn = addjdbcuilts.getConnection();
			String sql = "insert into infoform (name,description,image,specise,sex,weight,address) values (?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, infoform.getName());
			pst.setString(2, infoform.getDescription());
			pst.setString(3, infoform.getImage());
			pst.setString(4, infoform.getSpecise());
			pst.setString(5, infoform.getSex());
			pst.setString(6, infoform.getWeight());
			pst.setString(7, infoform.getAddress());
			int i=pst.executeUpdate();
	}
}
