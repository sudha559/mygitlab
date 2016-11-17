//package overweight.servlet;
//
//import java.io.IOException;
//import java.util.Date;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import overweight.dao.PatientDao;
//import overweight.util.ObesityPages;
//
//
//
//
//public class AssignPatient extends HttpServlet {
//	
//	public AssignPatient() {
//	}
//	public void doPost(HttpServletRequest request, HttpServletResponse response)  
//	        throws ServletException, IOException { 
//		
//		
//		System.out.println("doPost is callling");
//		//response
//		
//		
//		String patientId=(String) request.getParameter("patientId");
//		String sex=(String) request.getParameter("sex");
//		String pname=(String) request.getParameter("name");
//		String uname=(String) request.getSession().getAttribute("uName");
//		System.out.println("patientId:"+patientId+",pname:"+pname+",admin name:"+pname+",sex:"+sex);
//		String forword=ObesityPages.LIST_PATIENT;
//		if(!patientId.startsWith("P")){
//			request.setAttribute("msg", "Please enter PatientId,Must be start's with 'P'");
//			forword=ObesityPages.assign_Patient;
//		}else if(PatientDao.isPatientexist(patientId)){
//			request.setAttribute("msg", patientId+": This PatientID alrady exist, Please try another patientId");
//			forword=ObesityPages.assign_Patient;
//		}else{
//			PatientDao.createPatient(patientId,pname,uname,sex,new Date());
//			request.setAttribute("msg", "Created Successfully");
//			request.setAttribute("patients", PatientDao.findByDoctorPatients(uname));
//		}
//		//getServletContext().getRequestDispatcher().forward(request,response);
//		
//		RequestDispatcher view = request.getRequestDispatcher(forword);
//        view.forward(request,response);
//	}
// 
//	
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String action=req.getParameter("action");
//		
//		//GenerateRandomString gRandom=new GenerateRandomString();
//		System.out.println("assignpatient action onget:"+action);
//		if(action==null){
//			System.out.println("No Action Found");
//			return;
//		}
//		if(action.equals("new")){
//			//req.setAttribute("patientId", "P01"+gRandom.getNumeric(6));
//			getServletContext().getRequestDispatcher(ObesityPages.assign_Patient).forward(req, resp);
//		}else if(action.equals("Level1")){
//			String patientid=req.getParameter("PID");
//			req.setAttribute("msg", "");
//			req.setAttribute("PID", patientid);
//			String forward=ObesityPages.doctorTreatmentForm;
//			getServletContext().getRequestDispatcher(forward).forward(req, resp);
//		}
//		
//		
//	}
//
//
//	 
//}
