package AnimalsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Animals.infocom;
import JdbcUilts.jdbcuilts;

public class infocomment_get {

public static void main(String[] args){
		
	}
	public List<infocom> Query(int id){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		List<infocom> infocom=new ArrayList<infocom>();
		try {
			conn=jdbcuilts.getConnection();
			stat=conn.createStatement();
			String sql="select * from infocomment where id=(?)";
			
			 PreparedStatement sta = conn.prepareStatement(sql);
		        sta.setInt(1, id);		
			
			
		        rs=sta.executeQuery();
			infocom infocomget=null;
			while(rs.next()){
				infocomget=new infocom();
				infocomget.setId(rs.getInt("id")); 
				infocomget.setType(rs.getString("type"));
				infocomget.setComment(rs.getString("comment"));
				infocom.add(infocomget);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			jdbcuilts.free(conn, stat, rs);
		}
		return infocom;
	}
}
