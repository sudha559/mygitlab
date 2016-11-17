package overweight.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.LoginDao;
import overweight.dao.UserDao;
import overweight.model.User;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;  
  
  
public class SigninServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
//    PrintWriter out = response.getWriter();  
    
    String n=request.getParameter("uname");  
    String p=request.getParameter("upsw");
    String cp=request.getParameter("cdpsw");
    
    String type=request.getParameter("type");  
          System.out.println(n+":"+p+":"+type);
          request.getSession().removeAttribute("uName");
          request.getSession().removeAttribute("role");
          User u=UserDao.finByUser(n);
    
          if(p!=null && cp!=null ){
        	  String msg=validatePassword(p,cp);
        	  if(msg!=null){
        		  request.setAttribute("msg", msg);
        		  request.setAttribute("uname", n);
        		  request.setAttribute("ut", "1");
        		  request.setAttribute("rd", "readonly");
        		  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_SIGNIN);  
                  rd.include(request,response);  
                  return;
        	  }
        	  if(u!=null && u.getStatus().equals("T")){
        		  UserDao.updatePassword(p, n);  
        	  }else{
        		  request.setAttribute("msg", "Admin approval is pending");
        		  request.setAttribute("uname", n);
        		  request.setAttribute("ut", "1");
        		  request.setAttribute("rd", "readonly");
        		  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_SIGNIN);  
                  rd.include(request,response);  
                  return;
        	  }
        	  
          }
          
          if(type.equals(OverWeightUtil.role_Doctor) && (p==null ||p.isEmpty()) ){
        	  if(u!=null && u.getStatus().equals("T")){
        		  request.setAttribute("uname", n);
        		  request.setAttribute("rd", "readonly");
        		  if(u.getPassword()==null || u.getPassword().isEmpty()){
        			  request.setAttribute("ut", "1");
        			  request.setAttribute("msg", "your are 1st time login to the system");
        		  }else{
        			  request.setAttribute("ut", "2");
        		  }
        		  
            	  //getServletContext().getRequestDispatcher(ObesityPages.doctor_SIGNIN).forward(request,response);
            	  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_SIGNIN);  
                  rd.include(request,response);  
            	  return;  
        	  }else{
        		  if(u==null)
        			  request.setAttribute("msg", "Doctor Not Registered");
        		  else
        			  request.setAttribute("msg", "Admin approval is pending");
        		  
        		  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.doctor_SIGNIN);  
                  rd.include(request,response);
            	  return;
        	  }
        	  
          }else if(type.equals(OverWeightUtil.role_Patient) && (p==null ||p.isEmpty()) ){
        	  if(u!=null && u.getStatus().equals("T")){
        		  request.setAttribute("uname", n);
        		  request.setAttribute("rd", "readonly");
        		  if(u.getPassword()==null || u.getPassword().isEmpty()){
        			  request.setAttribute("ut", "1");
        			  request.setAttribute("msg", "your are 1st time login to the system");
        		  }else{
        			  request.setAttribute("ut", "2");
        		  }
        		  
            	  //getServletContext().getRequestDispatcher(ObesityPages.doctor_SIGNIN).forward(request,response);
            	  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.patient_SIGNIN);  
                  rd.include(request,response);  
            	  return;  
        	  }else{
        		  if(u==null)
        			  request.setAttribute("msg", "Patient Not Registered");
        		  else
        			  request.setAttribute("msg", "Doctor approval is pending");
        		  
        		  RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.patient_SIGNIN);  
                  rd.include(request,response);
            	  return;
          }
          }
          User user=LoginDao.validate(n, p,type);
    if(user!=null && user.getStatus().equals("T")){
    	request.getSession().setAttribute("uName", n);
    	request.getSession().setAttribute("role", type);
    	response.addHeader("uName", n);
    	request.setAttribute("msg", "Sign In Successfully");
    	if(type.equals(OverWeightUtil.role_admin)){
    		
    		request.setAttribute("uName", n);
    		
    		getServletContext().getRequestDispatcher(OverWeightPages.admin_homePage).forward(request,response);
    	}else if(type.equals(OverWeightUtil.role_Doctor)){
    		System.out.println("login as doctor");
    		getServletContext().getRequestDispatcher(OverWeightPages.doctor_homePage).forward(request,response);
    	}else if(type.equals("Patient")){
    		getServletContext().getRequestDispatcher(OverWeightPages.patient_homePage).forward(request,response);
    	}
        /*RequestDispatcher rd=request.getRequestDispatcher("servlet_welcome");  
        rd.forward(request,response);  */
    }  
    else{  
//        out.print("Please check your details and try again"); 
    	if(user!=null && user.getStatus().equals("F"))
    		request.setAttribute("msg", "Admin Approvied is required, Please contact Admin and try again");
    	else
    		request.setAttribute("msg", "Please check your details and try again");
    	
    	String frwd=OverWeightPages.SIGNIN;
    	if(type.equals(OverWeightUtil.role_Doctor))frwd=OverWeightPages.doctor_SIGNIN;
    	if(type.equals(OverWeightUtil.role_Patient))frwd=OverWeightPages.patient_SIGNIN;
        RequestDispatcher rd=request.getRequestDispatcher(frwd);  
        rd.include(request,response);  
    }  
          
//    out.close();  
    }

	private String validatePassword(String password, String confirmpassword) {
		 if(password==null || confirmpassword==null ||
				password.isEmpty() || confirmpassword.isEmpty()){
			return "Password or ConfirmPassword is Required";
		}else if(!password.equals(confirmpassword)){
			return "Password and ConfirmPassword Should be equal";
		}else if(password.contains(" ")){
			return "space is not allowed to Password ";
		}
		return null;
	}
	
}  