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

import overweight.model.Patient;
import overweight.model.User;
import overweight.util.OverWeightUtil;

public class PatientDao {

	 
	
	public static boolean validatePatentbyPID(String pid) {
		boolean status=false;  
		try{  
		  
		Connection con=DbConnection.getDBConnection();  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from patient where pid=?");  
		ps.setString(1,pid);  
		   
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}  
		return status;  
	}

	public static boolean registerPatentwithPatientDetails(String pid, String pname, String ph,Date dob, String state, String zipcode, String doctor, String string) {
		boolean status=false;  
		try{  
			
		Connection con=DbConnection.getDBConnection();  
		PreparedStatement ps=con.prepareStatement(  
		"UPDATE patient SET ph ='"+ph+"',dob='"+new java.sql.Date(dob.getTime())+"',state='"+state+"',zipcode='"+zipcode+"'  WHERE pid ='"+pid+"' ;");
		System.out.println();
		 int i=ps.executeUpdate();
		          
		}catch(Exception e){
			e.printStackTrace();
		}  
		return status; 
		
	}

	public static List<Patient> findAllPatients() {
		List<Patient> patients=new ArrayList<>();
	try{  
		
	Connection con=DbConnection.getDBConnection();  
		PreparedStatement ps=con.prepareStatement( "select * from patient");
		ResultSet r=ps.executeQuery();
		while(r.next()){
			long l=r.getLong("id");
			String pid=r.getString("pid");
			String name=r.getString("name");
			String ph=r.getString("ph");
			Patient p=new Patient();
			p.setId(l);
			p.setPid(pid);
			p.setName(name);
			p.setPh(ph);
			patients.add(p);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("patients Size:"+patients.size());
		return patients;
	}

	public static boolean createPatient(String patientId, String pname, String doctorname, String sex, Date dob, String state, String zipcode, String ph) {
		boolean status = false;
		try {
			Connection con = DbConnection.getDBConnection();

			PreparedStatement ps=con.prepareStatement( "INSERT INTO patient (PID,name,doctor,sex,createdDate,ph,state,zipcode,dob) "
	                + "VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, patientId);
			ps.setString(2, pname);
			ps.setString(3, doctorname);
			ps.setString(4, sex);
			ps.setTimestamp(5, Timestamp.valueOf(getTimeStamp(new Date())));
			ps.setString(6, ph);
			ps.setString(7, state);
			ps.setString(8, zipcode);
			ps.setTimestamp(9, Timestamp.valueOf(getTimeStamp(dob)));
			
			//ph ='"+ph+"',dob='"+new java.sql.Date(dob.getTime())+"',state='"+state+"',zipcode='"+zipcode+"'  WHERE pid ='"+pid+"' ;");
			return ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;		
	}

	public static List<Patient> findByDoctorPatients(String doctorName) {
List<Patient> patients=new ArrayList<>();
		
		List<User> users=UserDao.getAll_approved_Users(OverWeightUtil.role_Patient);
		for (User user : users) {
			Patient p=findByPID(user.getUserid());
			if(p!=null && p.getDoctor().equals(doctorName)){
				patients.add(p);
			}
		}
		
		return patients;
		
	}

	public static Patient findByPID(String pid) {
		try{ 
			Connection con=DbConnection.getDBConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from patient where pid=?");  
			ps.setString(1,pid);  
					   
			ResultSet rs=ps.executeQuery();  
			while (rs.next()) {
				Patient p=new Patient();
				p.setId(rs.getLong("id"));
				p.setDoctor(rs.getString("doctor"));
				p.setName(rs.getString("name"));
				p.setPh(rs.getString("ph"));
				p.setPid(rs.getString("pid"));
				
				User u=UserDao.finByUser(p.getPid());
				p.setPassword(u.getPassword());
				return p;
						
			}
		}catch(Exception e){
			e.printStackTrace();
				
		}
		return null;
	}

	public static void updateInfo(String phone, String name, String id) {
		try{
			Connection connection=DbConnection.getDBConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update patient set ph=?,  name=?" +
							"where id=?");
			
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, name);
			preparedStatement.setLong(3, Long.valueOf(id));
			
			preparedStatement.executeUpdate();
			
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	public static boolean isPatientexist(String patientId) {
		
		try{
		Connection con = DbConnection.getDBConnection();

		//PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=? and role=?");
		PreparedStatement ps = con.prepareStatement("select * from patient where pid=?");
		ps.setString(1,patientId );

		ResultSet rs = ps.executeQuery();
		return rs.next();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

 
	private static String getTimeStamp(Date createdDate) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if(createdDate==null)
	    return f.format(new Date());
	    else 
	    	return f.format(createdDate);
	}

	public static void deletePatient(String patientid) {
		try {
			String q="delete from patient where pid='"+patientid+"';";
			System.out.println("Query:"+q);
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			 statement.execute(q);//executeQuery(q);
	 	} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	public static Object findByDoctorUnApprovedPatients(String doctorName) {
		List<Patient> patients=new ArrayList<>();
		
		List<User> users=UserDao.getAll_unapproved_Users(OverWeightUtil.role_Patient);
		for (User user : users) {
			Patient p=findByPID(user.getUserid());
			if(p!=null && p.getDoctor().equals(doctorName)){
				patients.add(p);
			}
		}
		
		return patients;
	}
	
}
