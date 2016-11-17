package overweight.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.DoctorDao;
import overweight.dao.UserDao;
import overweight.model.User;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;

public class RegisterDoctor extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException { 
		response.setContentType("text/html");  
	    
	    String registerId=request.getParameter("registerId");
	    String dname=request.getParameter("dname");  
	    String dpsw=request.getParameter("dpsw");
	    String cdpsw=request.getParameter("cdpsw"); 
	    String ph=request.getParameter("ph");
	    String email=request.getParameter("email");
	    String address=request.getParameter("address");
	    String address2=request.getParameter("address2");
	    String state=request.getParameter("state");  
	    String zipcode=request.getParameter("zipcode");
//	    String exp=request.getParameter("exp");
	    
	    System.out.println(registerId+":"+dname+":"+dpsw+":"+cdpsw+":"+ph+":"+email);
	    String msg=formValidate(registerId,dname,dpsw,cdpsw,ph,email,state,zipcode);
	    
		request.setAttribute("registerId",registerId);
	    request.setAttribute("dname",dname);  
//	    request.setAttribute("dpsw");
//	    request.setAttribute("cdpsw"); 
	    request.setAttribute("ph",ph);
	    request.setAttribute("email",email);
	    request.setAttribute("address",address);
	    request.setAttribute("address2",address2);
	    request.setAttribute("state",state);  
	    request.setAttribute("zipcode",zipcode);
	    request.setAttribute("exp","");
	    
	    if(!msg.isEmpty()){
	    	request.setAttribute("msg",msg);
	    	 RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_registration);  
	         rd.include(request,response);
	         
	    }else if(DoctorDao.isExist(registerId)){
	    	System.out.println("Alrady Doctor is Registered");
	    	request.setAttribute("msg","Sorry Doctor ID already existing");
	    	 RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_registration);  
	         rd.include(request,response); 
	    }else{
	    	System.out.println("new Doctor is Registered");
	    	boolean status=DoctorDao.registerNewDoctor(registerId,dname,dpsw,ph,email,address,new Date(),state,zipcode,address2,"");
	    	System.out.println("status:"+status);
	    	if(status){
	    		User user=new User();
	    		user.setName(dname);
	    		user.setUserid(registerId);
	    		user.setRole(OverWeightUtil.role_Doctor);
	    		//user.setPassword(dpsw);
	    		user.setPassword("");
	    		user.setCreatedDate(new Date());
	    		user.setStatus("F");
	    		UserDao.addUser(user);
	    		
	    		request.setAttribute("msg","Successfully Registered, For Admin approval it's takes upto 10hrs, so please keep checking with '"+registerId+"' this ID in Signin page");
	    	 RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.WECOME_PAGE);  
		         rd.include(request,response);
		         return;
	    	}
	    	
	    }
	
	    
	}

	private String formValidate(String registerId, String name, String password, String confirmpassword, String ph, String email, String state, String zipcode) {
		
		if(registerId==null || registerId.isEmpty() || !registerId.matches("[a-zA-Z0-9]*")|| !registerId.startsWith("D")){
			return "RegisterId is Required & It should be allow Alpha,Numeric. It must start with 'D'";
		}else if(name==null || name.isEmpty() || !name.matches("[a-zA-Z]*")){
			return "Name is Required & It should be allow Alpha";
		}
		/*else if(password==null || confirmpassword==null ||
				password.isEmpty() || confirmpassword.isEmpty()){
			return "Password or ConfirmPassword is Required";
		}else if(!password.equals(confirmpassword)){
			return "Password and ConfirmPassword Should be equal";
		}else if(password.contains(" ")){
			return "space is not allowed to Password ";
		}*/
		else if(!email.matches(OverWeightUtil.EMAIL_FORMAT)){
			return "please enter valid email id ";
		}else if(!ph.matches(OverWeightUtil.PH_FORMAT)|| ph.length()!=10){
			return "please enter valid phone number,it should be numeric";
		}else if(!zipcode.matches(OverWeightUtil.PH_FORMAT)){
			return "please enter valid Zipcode, it should be numeric";
		}
		return "";
	}

	private boolean validatePassword(String password, String confirmpassword) {
		if(password==null || confirmpassword==null){
			return false;
		}else if(!password.equals(confirmpassword)){
			return false;
		}else if(!password.matches(" ")){
			return false;
		}
		return true;
	}

}
