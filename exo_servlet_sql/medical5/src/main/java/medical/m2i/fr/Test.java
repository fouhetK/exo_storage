package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/personne")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PersonneDAO personneDAO = new PersonneDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<body><table>");
		out.println(Personne.getHeadTab());
		out.println("<tbody>");

		Collection<Personne> personnes = personneDAO.findAll();

		for (Personne personne : personnes) {
			out.println(personne.toHTMLTable());
		}

		out.println("</tbody></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Je suis bien dans la méthode post");

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String date = request.getParameter("datenaissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");

		Personne personne = new Personne(prenom, nom, Date.valueOf(date), adresse, pays, ville);

		personneDAO.saveDB(personne);

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

}
