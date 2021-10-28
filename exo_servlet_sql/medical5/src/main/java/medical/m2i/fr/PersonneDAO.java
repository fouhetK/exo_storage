package medical.m2i.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class PersonneDAO {
	Connection connection;

	public PersonneDAO() {
		String url = "jdbc:mysql://localhost:3306/java_jee?serverTimezone=UTC";
		String user = "root";
		String password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveDB(Personne personne) {
		try (PreparedStatement prepareStatementVoiture = connection.prepareStatement(
				"INSERT INTO Personne (prenom, nom, datenaissance, adresse, pays, ville) VALUES(?,?,?,?,?,?)");) {

			connection.setAutoCommit(false);

			prepareStatementVoiture.setString(1, personne.getPrenom());
			prepareStatementVoiture.setString(2, personne.getNom());
			prepareStatementVoiture.setDate(3, personne.getDatenaissance());
			prepareStatementVoiture.setString(4, personne.getAdresse());
			prepareStatementVoiture.setString(5, personne.getPays());
			prepareStatementVoiture.setString(6, personne.getVille());

			System.out.println(prepareStatementVoiture.toString());

			prepareStatementVoiture.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Personne> findAll() {
		Collection<Personne> personnes = new ArrayList<Personne>();
		String query = "SELECT * FROM personne";
		Personne personneTmp = null;

		try (Statement statement = connection.createStatement();) {

			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				personneTmp = new Personne(result);
				personnes.add(personneTmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personnes;
	}
}
