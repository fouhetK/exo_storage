package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	private void saveDB(String prenom, String nom, String date, String adresse, String pays, String ville) {

		String url = "jdbc:mysql://localhost:3306/java_jee";
		String user = "root";
		String password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement prepareStatementVoiture = connection.prepareStatement(
						"INSERT INTO Personne (prenom, nom, datenaissance, adresse, pays, ville) VALUES(?,?,?,?,?,?)");) {

			connection.setAutoCommit(false);

			prepareStatementVoiture.setString(1, prenom);
			prepareStatementVoiture.setString(2, nom);
			prepareStatementVoiture.setString(3, date);
			prepareStatementVoiture.setString(4, adresse);
			prepareStatementVoiture.setString(5, pays);
			prepareStatementVoiture.setString(6, ville);

			System.out.println(prepareStatementVoiture.toString());

			prepareStatementVoiture.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

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

		this.saveDB(prenom, nom, date, adresse, pays, ville);

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
