package overweight.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.DoctorDao;
import overweight.dao.PatientDao;
import overweight.dao.UserDao;
import overweight.model.User;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;

public class RegisterPatient extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException { 
	
		 response.setContentType("text/html");  
//		    PrintWriter out = response.getWriter();  
		    
		    String pid=request.getParameter("PID");
		    String pname=request.getParameter("uname");  
		    String upsw=request.getParameter("upsw");
		    String cupsw=request.getParameter("cupsw");  
		    String ph=request.getParameter("ph");  
		    String state=request.getParameter("state");  
		    String zipcode=request.getParameter("zipcode");
		    String doctor=request.getParameter("doctor");
		    String dob=request.getParameter("dob");
		    
		    String msg = validateInputDetails(pid,pname,ph,state,zipcode,upsw,cupsw,dob);
		    //formValidate(registerId,dname,dpsw,cdpsw,ph,email,state,zipcode);
		    request.setAttribute("msg",msg);
	    	request.setAttribute("PID", pid);
	    	request.setAttribute("uname", pname);
	    	request.setAttribute("ph", ph);
	    	request.setAttribute("state", state);
	    	request.setAttribute("zipcode", zipcode);
	    	request.setAttribute("doctor", doctor);
	    	//request.setAttribute("dob", dob);
	    	request.setAttribute("doctors", DoctorDao.findAll());	
	    	
		    if(!msg.isEmpty()){
		    	 RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.patient_registration);  
		         rd.include(request,response);
		    }else if(!PatientDao.validatePatentbyPID(pid)){  
		    
		      //create new patient  exist, created by doctor
		    	System.out.println("create new patient ");
		    	PatientDao.createPatient(pid,pname,doctor,"M",dateformate(dob),state,zipcode,ph);
		    	User user=new User();
		    	user.setName(pname);
		    	user.setPassword(upsw);
		    	user.setUserid(pid);
		    	user.setRole(OverWeightUtil.role_Patient);
		    	user.setCreatedDate(new Date());
		    	user.setStatus("F");
		    	UserDao.addUser(user);
		    		request.setAttribute("msg","Successfully Registered, For Doctor approval it's takes upto 10hrs, so please keep checking with '"+pid+"' this ID in Signin page");
		    		request.getSession().setAttribute("uName", pid);
		    		request.getSession().setAttribute("role", OverWeightUtil.role_Patient);
		    	 /*RequestDispatcher rd=request.getRequestDispatcher(ObesityPages.WECOME_PAGE);  
		         rd.include(request,response);*/
//		    		getServletContext().getRequestDispatcher(ObesityPages.WECOME_PAGE).forward(request,response);
		    		RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.WECOME_PAGE);  
			         rd.forward(request,response);  
		    }else{
		    	
		    	
		    	request.setAttribute("msg","Sorry patient ID alrady existing, try with another PatientID");  
		         RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.patient_registration);  
		         rd.include(request,response);  
		    	
		    }
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("doctors", DoctorDao.findAll());
		RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.patient_registration);  
        rd.forward(request,response);
	}

	private String validateInputDetails(String pid, String pname, String ph, String state, String zipcode, String password,
			String confirmpassword, String dob) {

		if(pid==null || pid.isEmpty() || !pid.matches("[a-zA-Z0-9]*") || !pid.startsWith("P")){
			return "Enter PatientId, It must start's with 'P'";
		}else if(pname==null || pname.isEmpty() || !pname.matches("[a-zA-Z]*")){
			return "Name is Required & It should be allow Alpha only";
		}
		/*else if(password==null || confirmpassword==null ||
				password.isEmpty() || confirmpassword.isEmpty()){
			return "Password or ConfirmPassword is Required";
		}else if(!password.equals(confirmpassword)){
			return "Password and ConfirmPassword Should be equal";
		}else if(password.contains(" ")){
			return "space is not allowed to Password ";
		}*/
		else if(!ph.matches(OverWeightUtil.PH_FORMAT)|| ph.length()!=10 ){
			return "please enter valid phone number,it should be numeric";
		}else if(!zipcode.matches(OverWeightUtil.PH_FORMAT)){
			return "please enter valid Zipcode, it should be numeric";
		}else if(dateformate(dob)==null){
			return "wrong DOB formate,please enter valid DOB";
		}
		return "";
	}

	private Date dateformate(String dob) {
		
		try {
			SimpleDateFormat smp=new SimpleDateFormat("yyyy-mm-dd");
			Date d=smp.parse(dob);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
