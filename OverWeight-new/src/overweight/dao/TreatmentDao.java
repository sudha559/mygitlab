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

import overweight.model.Treatment;

public class TreatmentDao {
	
	public static boolean create(String pid, String bp, String sugar, String weight, String level, String bmi ) {
		boolean status = false;
		try {
			Connection con = DbConnection.getDBConnection();

			//PreparedStatement ps = con.prepareStatement("insert from user where name=? and password=? and role=?");
			PreparedStatement ps=con.prepareStatement( "INSERT INTO treatment (pid,level,bp,sugar,weight,createdDate,bmi) "
	                + "VALUES (?,?,?,?,?,?,?)");
			
			ps.setString(1, pid);
			ps.setString(2, level);
			ps.setString(3, bp);
			ps.setString(4, sugar);
			ps.setString(5, weight);
			//ps.setDate(6, new java.sql.Date(new Date().getTime()));
			ps.setTimestamp(6, Timestamp.valueOf(getTimeStamp(new Date())));
			ps.setString(7, bmi);
			
			return ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<Treatment> getAllRecordsOfPatient(String pid) {
		List<Treatment> tList=new ArrayList<>();
		try{  
			
			Connection con=DbConnection.getDBConnection();  
				PreparedStatement ps=con.prepareStatement( "select * from treatment where PID='"+pid+"' order by createddate asc;");
				ResultSet r=ps.executeQuery();
				while(r.next()){
					Treatment tre=new Treatment();
					
					tre.setId(r.getLong("id"));
					tre.setPid(r.getString("PID"));
					tre.setBp(r.getString("bp"));
					tre.setBmi(r.getString("bmi"));
					tre.setLevel(r.getString("level"));
					tre.setSugar(r.getString("sugar"));
					tre.setWeight(r.getString("weight"));
					tre.setResult(r.getString("result"));
					
					tList.add(tre);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println("list:"+tList.size());
		return tList;
	}

	 

	public static Treatment findPatientbyPidAndLevel(String pid, String level) {
		
try{  
			
			Connection con=DbConnection.getDBConnection();  
				PreparedStatement ps=con.prepareStatement( "select * from treatment where PID='"+pid+"' and level='"+level+"' order by createddate asc;");
				ResultSet r=ps.executeQuery();
				while(r.next()){
					Treatment tre=new Treatment();
					tre.setId(r.getLong("id"));
					tre.setPid(r.getString("PID"));
					tre.setBp(r.getString("bp"));
					tre.setBmi(r.getString("bmi"));
					tre.setLevel(r.getString("level"));
					tre.setSugar(r.getString("sugar"));
					tre.setWeight(r.getString("weight"));
					tre.setResult(r.getString("result"));
					
					return tre;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	public static Treatment findbyPID(String pid) {
		try{
		Connection con=DbConnection.getDBConnection();  
		PreparedStatement ps=con.prepareStatement( "select * from treatment where PID='"+pid+"';");
		ResultSet r=ps.executeQuery();
		while(r.next()){
			Treatment tre=new Treatment();
			
			tre.setId(r.getLong("id"));
			tre.setPid(r.getString("PID"));
			tre.setBp(r.getString("bp"));
			tre.setBmi(r.getString("bmi"));
			tre.setLevel(r.getString("level"));
			tre.setSugar(r.getString("sugar"));
			tre.setWeight(r.getString("weight"));
			tre.setResult(r.getString("result"));
			
			return tre;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return null;
	}

	public static Treatment getLatestRecord(String pid) {
		//order by createdDate desc limit 1
		try{
			Connection con=DbConnection.getDBConnection();  
			PreparedStatement ps=con.prepareStatement( "select * from treatment where PID='"+pid+"' order by createdDate desc ;");
			ResultSet r=ps.executeQuery();
			//r.getFetchSize()
			while(r.next()){
				Treatment tre=new Treatment();
				
				tre.setId(r.getLong("id"));
				tre.setPid(r.getString("PID"));
				tre.setBp(r.getString("bp"));
				tre.setBmi(r.getString("bmi"));
				tre.setLevel(r.getString("level"));
				tre.setSugar(r.getString("sugar"));
				tre.setWeight(r.getString("weight"));
				tre.setResult(r.getString("result"));
				
				return tre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
		
	}

	public static Treatment findbyID(String treatmentid) {
		try{
			Connection con=DbConnection.getDBConnection();  
			PreparedStatement ps=con.prepareStatement( "select * from treatment where id='"+treatmentid+"';");
			ResultSet r=ps.executeQuery();
			while(r.next()){
				Treatment tre=new Treatment();
				
				tre.setId(r.getLong("id"));
				tre.setPid(r.getString("PID"));
				tre.setBp(r.getString("bp"));
				tre.setBmi(r.getString("bmi"));
				tre.setLevel(r.getString("level"));
				tre.setSugar(r.getString("sugar"));
				tre.setWeight(r.getString("weight"));
				tre.setResult(r.getString("result"));
				
				return tre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private static String getTimeStamp(Date createdDate) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if(createdDate==null)
	    return f.format(new Date());
	    else 
	    	return f.format(createdDate);
	}

	public static int findByQuery(String q) {
		
		try{
			Connection con=DbConnection.getDBConnection();  
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet r=ps.executeQuery();
			int i=0;
			while(r.next()){
				i++;
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public static void deletePatientRecors(String patientid) {
		try {
			String q="delete from treatment where PID='"+patientid+"';";
			System.out.println("Query:"+q);
			Connection connection=DbConnection.getDBConnection();
			Statement statement = connection.createStatement();
			 statement.execute(q);//executeQuery(q);
	 	} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
