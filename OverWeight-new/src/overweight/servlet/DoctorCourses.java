//package overweight.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import overweight.dao.DoctorTreatmentDao;
//import overweight.model.DoctorTreatment;
//import overweight.util.OverWeightPages;
//
//public class DoctorCourses extends HttpServlet{
//	
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//		String action=req.getParameter("action");
//		System.out.println("Doctor cources action onget:"+action);
//		String forward=OverWeightPages.doctor_CourseList;
//		String uname=(String) req.getSession().getAttribute("uName");
//		if(action.equals("list")){
//			 forward=OverWeightPages.doctor_CourseList;
//			 //req.setAttribute("listCources", DoctorTreatmentDao.findByDoctor(uname));
//			 req.setAttribute("listCources", DoctorTreatmentDao.getAllRecord());
//		}else if(action.equals("new")){
//			
//			forward=OverWeightPages.doctor_CourseForm;
//		}else if(action.equals("view") && req.getParameter("Id")!=null){
//			
//			System.out.println("view form should be edit");
//			forward=OverWeightPages.doctor_CourseForm;
//			req.setAttribute("cources", DoctorTreatmentDao.get(req.getParameter("Id")));
//		}if (action.equalsIgnoreCase("delete")){
//			
//            String Id = req.getParameter("Id");
//            DoctorTreatmentDao.delete(Id);
//            forward = OverWeightPages.doctor_CourseList;
//            req.setAttribute("listCources", DoctorTreatmentDao.getAllRecord());    
//        }
//		
//		
//		RequestDispatcher view = req.getRequestDispatcher(forward);
//        view.forward(req, resp);
//	}
//	
//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action=req.getParameter("action");
//		System.out.println("Doctor cources action dopost:"+action);
//		String forward="";
//		String uname=(String) req.getSession().getAttribute("uName");
//		
//		if(action.equals("create")){
//			String level=req.getParameter("level");
//			String description=req.getParameter("description");
//			//String v=validateCourse(level,bp,sugar,weight,bmi);
//			String id=req.getParameter("id");
//			DoctorTreatment dTreatment=DoctorTreatmentDao.findRecordBy(uname, level);
//			if(dTreatment==null){
//				System.out.println(dTreatment);
//				if(id==null || id.isEmpty())
//					DoctorTreatmentDao.createDoctorTreatment(level,description,uname);
//				else
//					DoctorTreatmentDao.updateDoctorTreatment(level,description,id);
//				
//				req.setAttribute("msg", "created Successfully");
//				forward=OverWeightPages.doctor_CourseList;
//				req.setAttribute("listCources", DoctorTreatmentDao.getAllRecord());
//			}else{
//				req.setAttribute("msg", "Alrady This Level created, Please try with another");
//				forward=OverWeightPages.doctor_CourseForm;
//			}
//			
//			//forward=ObesityPages.doctor_CourseList+"?action=list";
//			
//			
////			forward = "/course_Doctor?action=list";
//			RequestDispatcher view = req.getRequestDispatcher(forward);
//	        view.forward(req, resp);
//		}
//		
//	}
//
//	private String validateCourse(String level, String bp, String sugar, String weight, String bmi) {
//		String error="";
//		if(level==null || level.isEmpty()){
//			error="Please select Course";
//		}else if(bp==null || bp.isEmpty() || !bp.matches("[0-9]*")){
//			error="Please enter BP, it should be numeric";
//		}else if(sugar==null || sugar.isEmpty() || !sugar.matches("[0-9]*")){
//			error="Please enter Sugar, it should be numeric";
//		}else if(weight==null || weight.isEmpty() || !weight.matches("[0-9]*") || weight.length()>3){
//			error="Please enter Weight, it should be numeric and Length is 3";
//		}else if(bp==null || bp.isEmpty() || !bp.matches("[0-9]*") ){
//			error="Please enter BP, it should be numeric";
//		}else if(bmi==null || bmi.isEmpty() || !bmi.matches("[0-9]*")){
//			error="Please enter BMI, it should be numeric";
//		}
//		
//		return error;
//	}
//
//}
