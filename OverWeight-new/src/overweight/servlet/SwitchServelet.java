package overweight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;

public class SwitchServelet extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String type=request.getParameter("type");  

		   
		    RequestDispatcher rd=request.getRequestDispatcher(OverWeightPages.registration);
		    if(type.equals(OverWeightUtil.role_Doctor)){
		    	 rd=request.getRequestDispatcher(OverWeightPages.doctor_registration);   
		    }else if(type.equals(OverWeightUtil.role_Patient)){
		    	 rd=request.getRequestDispatcher(OverWeightPages.patient_registration);
		    }else{
		    	out.print("Please Select Type");
		    }
		    
		    rd.include(request,response); 
		    out.close();  
		    }  
		  

}
