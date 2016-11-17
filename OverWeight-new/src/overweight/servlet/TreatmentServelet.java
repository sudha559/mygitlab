package overweight.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import overweight.dao.PatientDao;
import overweight.dao.TreatmentDao;
import overweight.model.Patient;
import overweight.model.Treatment;
import overweight.util.OverWeightPages;

public class TreatmentServelet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		System.out.println("action post:"+action);
		String pid=(String) req.getSession().getAttribute("uName");
		String forward="";
		if(action.equals("create")){
			Patient patient=PatientDao.findByPID(pid);
			String bp=req.getParameter("bp");
			String sugar=req.getParameter("sugar");
			String weight=req.getParameter("weight");
			String level=req.getParameter("level");
			String bmi=req.getParameter("bmi");
			System.out.println("pid:"+pid);
			String  error=validateBasicRules(bp,sugar,weight,bmi);
			if(error==null) error=validationOnbeforCreation(pid,level);
			if(error==null) error=compareLevelCheck(bp,sugar,weight,bmi,pid);
			if(error==null){
				TreatmentDao.create(pid, bp, sugar, weight,level,bmi);
				req.setAttribute("PID", pid);
				req.setAttribute("treatmentList", TreatmentDao.getAllRecordsOfPatient(pid));
				forward=OverWeightPages.MyTreatment;
				req.setAttribute("msg", "Successfully go to next level");
			}else{
				req.setAttribute("bp", bp);
				req.setAttribute("sugar", sugar);
				req.setAttribute("weight", weight);
				req.setAttribute("bmi", bmi);
				req.setAttribute("level", level);
				
				
				
				req.setAttribute("msg", error);
				forward=OverWeightPages.TreatmentForm;
			}
//			TreatmentDao.create(pid, bp, sugar, weight,level,bmi);
//			String forward=ObesityPages.MyTreatment;
			req.getRequestDispatcher(forward).forward(req, resp);
			
			//RequestDispatcher view = req.getRequestDispatcher(forward);
			
	        //view.forward(req, resp);
		}
	}
	
	private String compareLevelCheck(String bp, String sugar, String weight, String bmi, String pid) {
		Treatment treatment=TreatmentDao.getLatestRecord(pid);
		
		if(treatment!=null){
		////int tbmi=Integer.valueOf(treatment.getBmi());
		int tweight=Integer.valueOf(treatment.getWeight());
			/*if(tbmi<Integer.valueOf(bmi)){
				return "Your BMI Level is very High, Please contact Doctor";
			}else*/
		if(tweight<=Integer.valueOf(weight)){
				return "Your body is not responding with the treatment, Please contact Doctor";
			}
		}
		
		return null;
	}

	private String validateBasicRules(String bp, String sugar, String weight, String bmi) {
		if(bp==null || bp.isEmpty() || !bp.matches("[0-9]*/[0-9]*")){
			return "BP value should be numeric, like: 120/80";
		}else if(sugar==null || sugar.isEmpty() || !sugar.matches("[0-9]*.[0-9]*")){
			return "Sugar value should be like: 120.80";
		}else if(weight==null || weight.isEmpty() || !weight.matches("[0-9]*.[0-9]*")){
			return "Weight value should be like: 120.80";
		}else if(bmi==null || bmi.isEmpty() || !bmi.matches("[0-9]*")){
			return "bmi value should be like: 30";
		}
		return null;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action=req.getParameter("action");
		System.out.println("action:"+action);
		String pid=(String) req.getSession().getAttribute("uName");
		String forward = "";
		
	   if(action.equals("getTreatment")){
			List<Treatment> treatment=TreatmentDao.getAllRecordsOfPatient(pid);
			req.setAttribute("treatmentList", treatment);
			req.setAttribute("PID", pid);
			forward=OverWeightPages.MyTreatment;
		}else if(action.equals("nextLevel")){
			String patientid=req.getParameter("PID");
			forward=OverWeightPages.doctorTreatmentForm;
		}else if(action.equals("guidLines")){
			String treatmentid=req.getParameter("Id");
			Treatment t=TreatmentDao.findbyID(treatmentid);
			String ptientid=t.getPid();
			Patient patient=PatientDao.findByPID(ptientid);
//			String doctor=patient.getDoctor();
//			DoctorTreatment doctorTreatment=DoctorTreatmentDao.findRecordBy(doctor,t.getLevel());
			req.setAttribute("doctorTreatment", t.getLevel());
			forward=OverWeightPages.doctorTreatmentView;
		}
		
		RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
		
	}


	/**
	 * we need to identify the patient is start's with level1,level2...etc
	 * observe the report
	 * 
	 */
	private String validationOnbeforCreation(String pid, String level) {
		Treatment treatment=TreatmentDao.findPatientbyPidAndLevel(pid,level);
		int selectedLevel=findLevel(level);

		if(treatment!=null){
			return "You alrady completed this level, Please select next Level ";
		}else if(treatment==null){
			 treatment=TreatmentDao.getLatestRecord(pid);
			if(treatment==null && !level.equals("Level1")){
				return "Please select Level1 ";		
			}
			if(treatment==null){
				//this is 1st time
				return null;
			} 
		}
		
		 
		if(treatment!=null){
			System.out.println("DB Level:"+treatment.getLevel());
			int dbLevel=findLevel(treatment.getLevel());
			int expected=1+dbLevel;
			
			System.out.println("dbLevel:"+dbLevel+", selectedLevel:"+selectedLevel);
			if(selectedLevel==5){
				return "All Stages Completed";
			}else if(selectedLevel!=expected){
				return "Please select Level"+expected;
			}else if(selectedLevel==4){
				//last level of treatment
				//so we need to validate 2 & 3
				
			} 
			 
		}
		
		return null;
	}

	private int findLevel(String level) {
		if(level.equals("Level1")){
			return 1;
		}else if(level.equals("Level2")){
			return 2;
		}else if(level.equals("Level3")){
			return 3;
		}else if(level.equals("Level4")){
			return 4;
		}
		return 0;
	}

	private List<String> loadLevels() {
		 List<String> levels=new ArrayList<>();
		   levels.add("Level1");
		   levels.add("Level2");
		   levels.add("Level3");
		   levels.add("Level4");
		 
		return null;
	}

}
