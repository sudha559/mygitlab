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

import overweight.dao.UserDao;
import overweight.model.User;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;


public class ListUserServelet extends HttpServlet{

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            String userId = request.getParameter("userId");
	            UserDao.deleteUser(userId);
	            forward = OverWeightPages.LIST_USER;
	            request.setAttribute("users", UserDao.getAll_approved_Users());    
	        }else if (action.equalsIgnoreCase("approve")){
	            String userId = request.getParameter("userId");
	            UserDao.approve(userId);
	        	forward = OverWeightPages.un_approvedUsers;
	        	request.setAttribute("unusers", UserDao.getAll_unapproved_Users(OverWeightUtil.role_Doctor));  
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = OverWeightPages.INSERT_OR_EDIT_User;
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            User user = UserDao.getUserById(userId);
	            request.setAttribute("user", user);
	        } else if (action.equalsIgnoreCase("listUser")){
	            forward = OverWeightPages.LIST_USER;
	            request.setAttribute("users", UserDao.getAll_approved_Users());
	        } else if(action.equals("unapprovedlistUser")){
	        	forward = OverWeightPages.un_approvedUsers;
	        	request.setAttribute("unusers", UserDao.getAll_unapproved_Users(OverWeightUtil.role_Doctor));
	        }else {
	            forward = OverWeightPages.INSERT_OR_EDIT_User;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
		  if(action.equals("unapprovedlistUser")){
	        	request.setAttribute("unusers", UserDao.getAll_unapproved_Users(OverWeightUtil.role_Doctor));
	        	RequestDispatcher view = request.getRequestDispatcher(OverWeightPages.un_approvedUsers);
		        view.forward(request, response);
		        return;
	        }else{
		 
	        User user = new User();
	        user.setName(request.getParameter("Name"));
	        user.setPassword(request.getParameter("password"));
	        try {
	            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
//	            user.setDob(dob);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
//	        user.setEmail(request.getParameter("email"));
	        String userid = request.getParameter("userid");
	        if(userid == null || userid.isEmpty())
	        {
	        	user.setStatus("T");
	            UserDao.addUser(user);
	        }
	        else
	        {   user.setStatus("T");
	            user.setUserid(userid);
	            UserDao.updateUser(user);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(OverWeightPages.LIST_USER);
	        request.setAttribute("users", UserDao.getAll_approved_Users());
	        view.forward(request, response);
	        }
	    }
}
