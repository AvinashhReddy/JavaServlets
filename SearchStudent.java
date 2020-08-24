package casestudy2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/search")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Scanner x;
		
		String filePath ="C:\\Users\\harip\\eclipse-workspace\\Lbjcasestudy2\\students.csv" ;
		String studid = request.getParameter("id");
		
		String studId = "";
		String studName = "";
		String gender = "";
		String DOB = "";
		String studCity = "";
		String studState = "";
		String mail = "";
		String qual = "";
		String stream = "";
		
		x = new Scanner(new File(filePath));
		x.useDelimiter("[,\n]");
		
		PrintWriter writer = response.getWriter();
		boolean present = false;
		
		while(x.hasNext()) {
			
			studId = x.next();
			studName = x.next();
			gender = x.next();
			DOB = x.next();
			studCity = x.next();
			studState = x.next();
			mail = x.next();
			qual = x.next();
			stream = x.next();
			
			if(studId.equals(studid)) {
				present = true;
				String htmlResponse = "<html>";
				htmlResponse += "<table border = '1' cellpadding=\"0\" cellspacing='0' width = '30%'>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Student Id</th>";
				htmlResponse += "<td>"+studId+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Student Name </th>";
				htmlResponse += "<td>"+studName+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Gender </th>";
				htmlResponse += "<td>"+gender+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Date Of Birth</th>";
				htmlResponse += "<td>"+DOB+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> City </th>";
				htmlResponse += "<td>"+studCity+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> State </th>";
				htmlResponse += "<td>"+studState+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Email </th>";
				htmlResponse += "<td>"+mail+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Qualification </th>";
				htmlResponse += "<td>"+qual+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "<tr>";
				htmlResponse += "<th> Stream </th>";
				htmlResponse += "<td>"+stream+"</td>";
				htmlResponse += "</tr>";
				
				htmlResponse += "</table>";
				htmlResponse += "</html>";
				
				writer.println(htmlResponse);
			}
			
		}
		
		// If the student Id is not presnt
		
		if(present == false) {
			String htmlResponse = "<html>";
			htmlResponse += "<h3>Id not found!</h3>";
			htmlResponse += "</html>";
			writer.println(htmlResponse);
		}
	}

}
