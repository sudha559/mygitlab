package overweight.servlet;



import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import overweight.dao.DbConnection;
import overweight.dao.TreatmentDao;




public class PatientBarChart extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    JDBCCategoryDataset dataset = new JDBCCategoryDataset( DbConnection.getDBConnection());
    
    try {
    //dataset.executeQuery("SELECT SOURCE,PERCENTAGE FROM AIR_POLLUTION ORDER BY PERCENTAGE");
    	String pid=request.getParameter("PID");
    	System.out.println("pid:"+pid);
    	String action=request.getParameter("action");
    	if(action!=null && action.equals("weight")){
    		dataset.executeQuery("SELECT level,weight FROM treatment where pid='"+pid+"' ORDER BY level;");
    	}else{
    		action="BMI";
    		dataset.executeQuery("SELECT level,BMI FROM treatment where pid='"+pid+"' ORDER BY level;");
    	}
//    	dataset.addValue(value, rowKey, columnKey);
    	int countRecord=TreatmentDao.findByQuery("SELECT level,weight FROM treatment where pid='"+pid+"' ORDER BY level;");
    	//countRecord=countRecord
    	countRecord++;
    	for (int i = countRecord; i <= 4; i++) {
    		dataset.addValue(0, action, "level"+i);		
		}
    
    JFreeChart chart = ChartFactory.createBarChart(
           "Patient "+action+" Report", "Treatment", "Weight",
           dataset, PlotOrientation.VERTICAL, false, true, false);
    	   //chart.	
           chart.setBorderVisible(false);
//           Paint p=Paint.BITMASK;
           //chart.setBackgroundImage("");
           chart.setBackgroundPaint(Color.WHITE);
           
      
//           chart.getTitle().setPaint(Color.BLUE);    // Set the colour of the title  
           chart.setBackgroundPaint(Color.white);    // Set the background colour of the chart  
           CategoryPlot cp = chart.getCategoryPlot();  // Get the Plot object for a bar graph  
           cp.setBackgroundPaint(Color.white);       // Set the plot background colour  
           //cp.setRangeGridlinePaint(Color.BLUE); 
           ((BarRenderer)cp.getRenderer()).setBarPainter(new StandardBarPainter());
           /*double start=0,end=0;
           String title="Target Range";
           if(action.equals("weight")){start=250;end=500;title="Overweight Range";}
           else {start=30;end=300;title="Obesity Range";}
           final CategoryPlot plot = chart.getCategoryPlot();
           plot.setBackgroundPaint(Color.lightGray);
           final IntervalMarker target = new IntervalMarker(start, end);
           target.setLabel(title);
           target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
           target.setLabelAnchor(RectangleAnchor.LEFT);
           target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
           target.setPaint(new Color(222, 222, 255, 128));
           plot.addRangeMarker(target, Layer.BACKGROUND);*/
           
    if (chart != null) {
            int width = 600;
            int height = 400;
            response.setContentType("image/jpeg");
            BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
            //r.setSeriesPaint(0, Color.blue);
            r.setSeriesPaint(0, Color.black);
            r.setMaximumBarWidth(0.10);
            
            OutputStream out = response.getOutputStream();
            ChartUtilities.writeChartAsJPEG(out, chart, width, height);
    }
    }
    catch (SQLException e) {
    	e.printStackTrace();
            System.err.println(e.getMessage());
    }
}

         
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    JDBCCategoryDataset dataset = new JDBCCategoryDataset( DbConnection.getDBConnection());
	    
	    try {
	    //dataset.executeQuery("SELECT SOURCE,PERCENTAGE FROM AIR_POLLUTION ORDER BY PERCENTAGE");
	    	String pid=request.getParameter("PID");
	    	System.out.println("pid:"+pid);
	    dataset.executeQuery("SELECT level,result FROM treatment where pid='"+pid+"' ORDER BY level;");
//	    	dataset.addValue(value, rowKey, columnKey);
	    
	    JFreeChart chart = ChartFactory.createBarChart(
	           "Patient Report", "Treatment", "Result",
	           dataset, PlotOrientation.VERTICAL, false, true, false);
	    	   //chart.	
	           chart.setBorderVisible(true);
	    
	    if (chart != null) {
	            int width = 600;
	            int height = 400;
	            response.setContentType("image/jpeg");
	            OutputStream out = response.getOutputStream();
	            ChartUtilities.writeChartAsJPEG(out, chart, width, height);
	    }
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	            System.err.println(e.getMessage());
	    }

	}
	
}