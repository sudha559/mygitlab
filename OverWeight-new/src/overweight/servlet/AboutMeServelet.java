package overweight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.DoctorDao;
import overweight.dao.PatientDao;
import overweight.dao.UserDao;
import overweight.model.Doctor;
import overweight.model.Patient;
import overweight.model.User;
import overweight.util.OverWeightPages;
import overweight.util.OverWeightUtil;



public class AboutMeServelet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse response)  
	        throws ServletException, IOException { 
		
		String action=req.getParameter("action");
		System.out.println("about me post");
		String forward="";
		if(action==null){
			System.err.println("something worng!!!");
			return;
		}
		
		if( action.equals("admin")){
						String userid=(String) req.getSession().getAttribute("uName");	
			String Id=req.getParameter("id");
			String uid=req.getParameter("userid");
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String cpassword=req.getParameter("cpassword");
			
			if(!password.equals(cpassword)){
				req.setAttribute("msg", "Password and Confirm Password should be equal");
				forward=OverWeightPages.about_admin;
				User u=UserDao.finByUser(userid);
				req.setAttribute("user", u);
			}else{
				System.out.println("action:"+action+",id:"+Id);
				User user=new User();
				user.setId(Long.valueOf(Id));
				user.setUserid(uid);
				user.setName(name);
				user.setPassword(cpassword);
				user.setRole(OverWeightUtil.role_admin);
				UserDao.updateUser(user);
				req.setAttribute("msg", "successfully Update");
				forward=OverWeightPages.admin_homePage;
			}
		}else if( action.equals("doctor")){
			String userid=(String) req.getSession().getAttribute("uName");	
			String Id=req.getParameter("id");
			
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String address=req.getParameter("address");
			String password=req.getParameter("password");
			String cpassword=req.getParameter("cpassword");
			if(!password.equals(cpassword)){
				req.setAttribute("msg", "Password and Confirm Password should be equal");
				forward=OverWeightPages.about_doctor;
				User u=UserDao.finByUser(userid);
				req.setAttribute("user", u);
			}else{
				DoctorDao.updateInfo(phone,address,name,Id);
				UserDao.updatePassword(password,userid);
				req.setAttribute("msg", "Successfully updated");
				forward=OverWeightPages.doctor_homePage;
			}
			
			
		}else if( action.equals("patient")){
			String userid=(String) req.getSession().getAttribute("uName");	
			String Id=req.getParameter("id");
			
			String name=req.getParameter("name");
			String phone=req.getParameter("phone");
			String password=req.getParameter("password");
			String cpassword=req.getParameter("cpassword");
			if(!password.equals(cpassword)){
				req.setAttribute("msg", "Password and Confirm Password should be equal");
				forward=OverWeightPages.about_patient;
				User u=UserDao.finByUser(userid);
				req.setAttribute("user", u);
			}else{
				PatientDao.updateInfo(phone,name,Id);
				UserDao.updatePassword(password,userid);
				req.setAttribute("msg", "Successfully updated");
				forward=OverWeightPages.patient_homePage;
			}
			
		}
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, response);
		
	}

 	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid=(String) req.getSession().getAttribute("uName");
		String role=(String) req.getSession().getAttribute("role");
		String forward="";
		System.out.println(role+":"+userid);
		String action=req.getParameter("action");
		if(role.equals(OverWeightUtil.role_admin)){
			forward = OverWeightPages.about_admin;
				User u=UserDao.finByUser(userid);
				req.setAttribute("user", u);
		}else if(role.equals(OverWeightUtil.role_Doctor)){
			forward = OverWeightPages.about_doctor;
			Doctor d=DoctorDao.findByDoctorid(userid);
			req.setAttribute("doctor", d);
		}else if(role.equals(OverWeightUtil.role_Patient)){
			forward = OverWeightPages.about_patient;
			Patient p=PatientDao.findByPID(userid);
			System.out.println("p:"+p);
			req.setAttribute("patient", p);
		}
		
		System.out.println(forward);
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
		
		
		
	}

}
