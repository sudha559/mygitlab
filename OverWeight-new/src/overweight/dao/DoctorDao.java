package overweight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import overweight.model.Doctor;
import overweight.model.User;

public class DoctorDao {

	public static boolean isExist(String registerId) {
		boolean status=false;  
		try{ 
		Connection con=DbConnection.getDBConnection(); 
		PreparedStatement ps=con.prepareStatement("select * from doctor where registerId=?");  
		ps.setString(1,registerId);  
				   
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}  
		return status;
	}

	public static boolean registerNewDoctor(String registerId, String dname, String dpsw, String ph, String email,
			String address,java.util.Date date, String state, String zipcode, String address2, String exp) {
		boolean status=false;
		try{
		Connection con=DbConnection.getDBConnection();
		PreparedStatement ps=con.prepareStatement( "INSERT INTO doctor (NAME,REGISTERID,PHONE,ADDRESS,createdDate,state,zipcode,address2,EXPERIENCE) "
                + "VALUES (?,?,?,?,?,?,?,?,?)");
		ps.setString(1,dname);
		ps.setString(2,registerId);
		ps.setString(3,ph);
		ps.setString(4,address);
		//ps.setDate(5,new Date(date.getTime()));
		ps.setTimestamp(5, Timestamp.valueOf(getTimeStamp(date)));
		ps.setString(6, state);
		ps.setString(7, zipcode);
		ps.setString(8, address2);
		ps.setString(9, exp);
		
		ps.execute();
		 status=true;
		/*ResultSet rs=executeQuery();  
		status=rs.next();  
		rs.close();*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	public static Doctor findByDoctorid(String registerid) {
		
		try{ 
			Connection con=DbConnection.getDBConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from doctor where registerId=?");  
			ps.setString(1,registerid);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setId(rs.getLong("id"));
				doctor.setNAME(rs.getString("name"));
				doctor.setPHONE(rs.getString("phone"));
				doctor.setADDRESS(rs.getString("address"));
				doctor.setREGISTERID(rs.getString("registerid"));
				doctor.setEXPERIENCE(rs.getString("EXPERIENCE"));
				User u=UserDao.finByUser(registerid);
				doctor.setPassword(u.getPassword());
				return doctor;
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}  
		
		return null;
	}

	public static void updateInfo(String phone, String address, String name, String id) {
		try{
		Connection connection=DbConnection.getDBConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("update doctor set phone=?,  name=?, address=?" +
						"where id=?");
		
		preparedStatement.setString(1, phone);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, address);
		preparedStatement.setLong(4, Long.valueOf(id));
		
		preparedStatement.executeUpdate();
		
		}catch(Exception e){
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

	public static List<Doctor> findAll() {
		List<Doctor> doctors=new ArrayList<>();
		try{ 
			Connection con=DbConnection.getDBConnection(); 
			Statement statement = con.createStatement();  
//			ps.setString(1,registerid);  
			ResultSet rs = statement.executeQuery("select * from doctor");
			while (rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setId(rs.getLong("id"));
				doctor.setNAME(rs.getString("name"));
				doctor.setPHONE(rs.getString("phone"));
				doctor.setADDRESS(rs.getString("address"));
				doctor.setREGISTERID(rs.getString("registerid"));
				doctor.setEXPERIENCE(rs.getString("EXPERIENCE"));
				 
				doctors.add(doctor);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}  
		
		return doctors;

	}

	public static List<Doctor> findByEXp(String expD) {
		List<Doctor> doctors=new ArrayList<>();
		try{ 
			Connection con=DbConnection.getDBConnection(); 
			Statement statement = con.createStatement();  
//			ps.setString(1,registerid);  
			ResultSet rs = statement.executeQuery("select * from doctor where EXPERIENCE='"+expD+"';");
			while (rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setId(rs.getLong("id"));
				doctor.setNAME(rs.getString("name"));
				doctor.setPHONE(rs.getString("phone"));
				doctor.setADDRESS(rs.getString("address"));
				doctor.setREGISTERID(rs.getString("registerid"));
				doctor.setEXPERIENCE(rs.getString("EXPERIENCE"));
				 
				doctors.add(doctor);
			}
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}  
		
		return doctors;
	}
}
