package overweight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.ConstrainsDao;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;

public class ConstrainsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String comment=req.getParameter("comment");
		
		
		ConstrainsDao.create(name,email,comment);
		
		req.setAttribute("msg", "WE WILL GO THRUOGH YOUR SUGGESTION AND WE FIX THAT IN NEXT VERSION");  
		//resp.sendRedirect();
		String forward=OverWeightPages.contactPage;
		String role=(String) req.getSession().getAttribute("role");
		System.out.println("rile:"+role);
		if(role!=null){
			if(role.equals(OverWeightUtil.role_Doctor)){
				forward=OverWeightPages.contactPage_doctor;
			}else if(role.equals(OverWeightUtil.role_Patient)){
				forward=OverWeightPages.contactPage_patient;
			}
		}
		 RequestDispatcher rd=req.getRequestDispatcher(forward);  
         rd.forward(req,resp);  
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String forward = OverWeightPages.LIST_CONSTRAINS;
        req.setAttribute("constrains", ConstrainsDao.findAll());

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	
}
