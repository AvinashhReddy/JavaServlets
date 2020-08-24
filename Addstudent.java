package casestudy2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addstudent
 */
@WebServlet("/add")
public class Addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s;
		s=request.getParameter("id")+","+request.getParameter("name")+","+request.getParameter("gender")+","+request.getParameter("dob")+","+request.getParameter("city")+","+request.getParameter("state")+","+request.getParameter("mail")+","+request.getParameter("qual")+","+request.getParameter("stream");
		BufferedWriter b = new BufferedWriter(new FileWriter("C:\\Users\\harip\\eclipse-workspace\\Lbjcasestudy2\\students.csv",true));
		b.write(s);
		b.newLine();
		b.close();
		response.getWriter().println("Successfully Added Data!");
	}

}
