package overweight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import overweight.model.User;

public class LoginDao {  
	
public static User validate(String name,String pass, String type){  

		try {
			Connection con = DbConnection.getDBConnection();

			//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
			PreparedStatement ps = con.prepareStatement("select * from user where userid=? and password=? and role=?");
			ps.setString(1,name );
			ps.setString(2, pass);
			ps.setString(3, type);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getLong("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				return user;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static boolean create(String name, String pass, String type) {
		boolean status = false;
		try {
			Connection con = DbConnection.getDBConnection();

			//PreparedStatement ps = con.prepareStatement("insert from user where name=? and password=? and role=?");
			PreparedStatement ps=con.prepareStatement( "INSERT INTO user (NAME,PASSWORD,ROLE) "
	                + "VALUES (?,?,?)");
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, type);
			return ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}  