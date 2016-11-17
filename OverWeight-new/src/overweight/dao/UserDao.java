package overweight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import overweight.model.User;

public class UserDao {

	public static void deleteUser(String userId) {
		try {
			String q="delete from user where userid='"+userId+"';";
			System.out.println("Query:"+q);
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			 statement.execute(q);//executeQuery(q);
	 	} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static List<User>  getAllUsers() {
		List<User> users=new ArrayList<>();
		try {
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public static User getUserById(int userId) {
		return null;
	}

	public static void addUser(User user) {
		try {
			Connection con=DbConnection.getDBConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into user(userid,name,password,role,createdDate,status) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getUserid());
			preparedStatement.setString(2, user.getName());
			if(user.getPassword()!=null)
				preparedStatement.setString(3, user.getPassword());
			else
				preparedStatement.setString(3, "");
			preparedStatement.setString(4, user.getRole());
			//preparedStatement.setDate(5, new java.sql.Date(user.getCreatedDate().getTime()));
			preparedStatement.setTimestamp(5, Timestamp.valueOf(getTimeStamp(new Date())));
			preparedStatement.setString(6, user.getStatus());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void updateUser(User user) {
		 try {
			 Connection connection=DbConnection.getDBConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update user set name=?,  password=?, role=?" +
						"where id=?");
		// Parameters start with 1
		preparedStatement.setString(1, user.getName());
		//preparedStatement.setString(2, user.getUserid());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getRole());
		preparedStatement.setLong(4, user.getId());
		
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

	public static User finByUser(String userid) {
		
		try{ 
			Connection con=DbConnection.getDBConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from user where userid=?");  
			ps.setString(1,userid);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				
				return user;
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}  
		
		return null;
	}

	public static void updatePassword(String password, String userid) {

		try {
			 Connection connection=DbConnection.getDBConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update user set password=?" +
						"where userid=?");
		// Parameters start with 1
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, userid);
		
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
		

	}

	public static List<User> getAll_unapproved_Users(String role) {
		List<User> users=new ArrayList<>();
		try {
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where status='F' and role='"+role+"';");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}
	
	public static Object getAll_approved_Users() {
		List<User> users=new ArrayList<>();
		try {
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where status='T'");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public static void approve(String userId) {
		try {
			 Connection connection=DbConnection.getDBConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("update user set status=?" +
								"where userid=?");
				// Parameters start with 1
				preparedStatement.setString(1, "T");
				preparedStatement.setString(2, userId);
				
				preparedStatement.executeUpdate();
	 	} catch (SQLException e) {
			e.printStackTrace();
		}		
	}


	private static String getTimeStamp(Date createdDate) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if(createdDate==null)
	    return f.format(new Date());
	    else 
	    	return f.format(createdDate);
	}

	public static List<User> getAll_approved_Users(String role) {
		List<User> users=new ArrayList<>();
		try {
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where status='T' and role='"+role+"';");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

}
