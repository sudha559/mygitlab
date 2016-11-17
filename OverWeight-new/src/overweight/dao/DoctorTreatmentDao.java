//package overweight.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import overweight.model.DoctorTreatment;
//
//public class DoctorTreatmentDao {
//	
//	public static boolean createDoctorTreatment(String level, String description, String doctor) {
//		boolean status = false;
//		try {
//			Connection con = DbConnection.getDBConnection();
//
//			PreparedStatement ps=con.prepareStatement( "INSERT INTO doctortreatment (createdDate,level,description,doctor) "
//	                + "VALUES (?,?,?,?)");
//			
//		 
//			//ps.setDate(1, new java.sql.Date(new Date().getTime()));
//			ps.setTimestamp(1, Timestamp.valueOf(getTimeStamp(new Date())));
//			ps.setString(2, level);
//			ps.setString(3,description);
//			ps.setString(4,doctor);
//			
//			return ps.execute();
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return status;
//	}
//
//	public static List<DoctorTreatment> getAllRecord() {
//		List<DoctorTreatment> tList=new ArrayList<>();
//		try{  
//			
//			Connection con=DbConnection.getDBConnection();  
//				PreparedStatement ps=con.prepareStatement( "select * from doctortreatment;");
//				ResultSet r=ps.executeQuery();
//				while(r.next()){
//					DoctorTreatment tre=new DoctorTreatment();
//					tre.setId(r.getLong("id"));
//					tre.setLevel(r.getString("level"));
//					tre.setDescription(r.getString("description"));
//					
//					tList.add(tre);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//		return tList;
//	}
//
//	public static Object findByDoctor(String uname) {
//		List<DoctorTreatment> tList=new ArrayList<>();
//		try{  
//			
//			Connection con=DbConnection.getDBConnection();  
//				PreparedStatement ps=con.prepareStatement( "select * from doctortreatment where doctor='"+uname+"';");
//				ResultSet r=ps.executeQuery();
//				while(r.next()){
//					DoctorTreatment tre=new DoctorTreatment();
//					
//					tre.setId(r.getLong("id"));
//					tre.setLevel(r.getString("level"));
//					tre.setDescription(r.getString("description"));
//					
//					tList.add(tre);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//		return tList;
//	}
//
//	public static DoctorTreatment get(String id) {
//		try{  
//			
//			Connection con=DbConnection.getDBConnection();  
//				PreparedStatement ps=con.prepareStatement( "select * from doctortreatment where id='"+id+"';");
//				ResultSet r=ps.executeQuery();
//				while(r.next()){
//					DoctorTreatment tre=new DoctorTreatment();
//					
//					tre.setId(r.getLong("id"));
//					tre.setLevel(r.getString("level"));
//					tre.setDescription(r.getString("description"));
//					
//					return tre;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	return null;	
//	}
//
//	public static void delete(String id) {
//		try {
//			String q="delete from doctortreatment where id='"+id+"';";
//			System.out.println("Query:"+q);
//			Connection connection=DbConnection.getDBConnection();
//			Statement statement = connection.createStatement();
//			 statement.execute(q);//executeQuery(q);
//	 	} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void updateDoctorTreatment(String level, String description,String id) {
//		try {
//			Connection con = DbConnection.getDBConnection();
//
//			String sql="update  doctortreatment set level='"+level+"' ,description='"+description+"' where id='"+id+"';";
//			System.out.println("sql:"+sql);
//			Statement statement = con.createStatement();
//			
//			 statement.execute(sql);
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
//
//	public static DoctorTreatment findRecordBy(String doctor, String level) {
//		try{  
//			
//			Connection con=DbConnection.getDBConnection();  
//				PreparedStatement ps=con.prepareStatement( "select * from doctortreatment where doctor='"+doctor+"' and level='"+level+"';");
//				ResultSet r=ps.executeQuery();
//				while(r.next()){
//					DoctorTreatment tre=new DoctorTreatment();
//					
//					tre.setId(r.getLong("id"));
//					tre.setLevel(r.getString("level"));
//					tre.setDescription(r.getString("description"));
//					
//					return tre;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	return null;
//	}
//	
//	
//
//	private static String getTimeStamp(Date createdDate) {
//	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    if(createdDate==null)
//	    return f.format(new Date());
//	    else 
//	    	return f.format(createdDate);
//	}
//}
