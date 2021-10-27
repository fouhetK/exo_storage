package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/bonjour")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis bien dans la méthode post");

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String date = request.getParameter("datenaissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html >");
		out.println("<body >");
		out.println("<h1 > Bonjour " + prenom + " " + nom + " ! </h1 >");
		out.println("<p>Vous êtes né le : " + date + "</p>"); // la date de naissance
		out.println("<p>Votre adresse est : " + adresse + " " + pays + " " + ville + "</p>"); // � la place des **** :
																								// adresse + pays +
																								// ville
		out.println(" </body >");
		out.println(" </html >");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
