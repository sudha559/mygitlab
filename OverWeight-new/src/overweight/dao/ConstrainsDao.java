package overweight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import overweight.model.Constrains;

public class ConstrainsDao {

	public static boolean create(String name, String email, String comment) {
		boolean status=false;
		try{
		Connection con=DbConnection.getDBConnection();
		PreparedStatement ps=con.prepareStatement( "INSERT INTO constrains (name,email,comments) "
                + "VALUES (?,?,?)");
		ps.setString(1,name);
		ps.setString(2,email);
		ps.setString(3,comment);
		ps.execute();
		 status=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;		
	}

	 

	public static List<Constrains> findAll() {

		List<Constrains> users=new ArrayList<>();
		try {
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from constrains");
			while (rs.next()) {
				Constrains user = new Constrains();
				
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setComments(rs.getString("comments"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	
	}

}
