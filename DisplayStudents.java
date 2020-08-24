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
 * Servlet implementation class DisplayStudents
 */
@WebServlet("/dis")
public class DisplayStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub

	Scanner x;
	String filePath = "C:\\Users\\harip\\eclipse-workspace\\Lbjcasestudy2\\students.csv";
	
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
	
	PrintWriter writer = resp.getWriter();
	String htmlResponse = "<html>";
	htmlResponse += "<body>";
	htmlResponse += "<table border = '1' cellpadding=\"0\" cellspacing='0' width = '100%'>";
	
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

		htmlResponse += "<tr>";
		htmlResponse += "<td>"+studId+"</td>";
		htmlResponse += "<td>"+studName+"</td>";
		htmlResponse += "<td>"+gender+"</td>";
		htmlResponse += "<td>"+DOB+"</td>";
		htmlResponse += "<td>"+studCity+"</td>";
		htmlResponse += "<td>"+studState+"</td>";
		htmlResponse += "<td>"+mail+"</td>";
		htmlResponse += "<td>"+qual+"</td>";
		htmlResponse += "<td>"+stream+"</td>";
		htmlResponse += "</tr>";

	}
	writer.println(htmlResponse);
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
		response.getWriter().println("ashc");
	}

}
