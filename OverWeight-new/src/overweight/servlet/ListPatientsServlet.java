package overweight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.PatientDao;
import overweight.dao.TreatmentDao;
import overweight.dao.UserDao;
import overweight.util.OverWeightPages;

public class ListPatientsServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward="";
		System.out.println("get is called");
		String action = req.getParameter("action");
		String doctorName=(String) req.getSession().getAttribute("uName");
		System.out.println("action:"+action);
		
		
		if(action.equals("listPatients")){
		
			forward = OverWeightPages.LIST_PATIENT;
	        req.setAttribute("patients", PatientDao.findByDoctorPatients(doctorName));
		}else if(action.equals("unapp")){
			forward = OverWeightPages.doctor_unapprovedPatients;
	        req.setAttribute("patients", PatientDao.findByDoctorUnApprovedPatients(doctorName));
		}else if(action.equals("approvePatient")){
			String pid=req.getParameter("PId");
			UserDao.approve(pid);
			forward = OverWeightPages.doctor_unapprovedPatients;
	        req.setAttribute("patients", PatientDao.findByDoctorUnApprovedPatients(doctorName));
		}
		else if(action.equals("view")){
			
			String pid=req.getParameter("PId");
			System.out.println("pid:"+pid);
			req.setAttribute("PID", pid);
			req.setAttribute("patientDetails", TreatmentDao.getAllRecordsOfPatient(pid));
			forward = OverWeightPages.patient_Details;
			 
		}else if(action.equals("Level1")){
			String patientid=req.getParameter("PID");
			req.setAttribute("msg", "");
			forward=OverWeightPages.doctorTreatmentForm;
		}else if(action.equals("delete")){
			String patientid=req.getParameter("PId");
			//to delete user table,patient,treatment
			UserDao.deleteUser(patientid);
			PatientDao.deletePatient(patientid);
			TreatmentDao.deletePatientRecors(patientid);
			
			forward = OverWeightPages.LIST_PATIENT;
	        req.setAttribute("patients", PatientDao.findByDoctorPatients(doctorName));
		}else if(action.equals("deletePatient")){
			String patientid=req.getParameter("PId");
			//to delete user table,patient,treatment
			UserDao.deleteUser(patientid);
			PatientDao.deletePatient(patientid);
			TreatmentDao.deletePatientRecors(patientid);
			
			forward = OverWeightPages.doctor_unapprovedPatients;
	        req.setAttribute("patients", PatientDao.findByDoctorUnApprovedPatients(doctorName));
		}
		

        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 System.out.println("post is called");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("put is called");
	}
	
}
