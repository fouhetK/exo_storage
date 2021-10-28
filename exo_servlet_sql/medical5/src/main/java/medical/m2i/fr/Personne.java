package medical.m2i.fr;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personne {

	private String nom;
	private String prenom;
	private Date datenaissance;
	private String adresse;
	private String ville;
	private String pays;

	public Personne() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param datenaissance
	 * @param adresse
	 * @param ville
	 * @param pays
	 */
	public Personne(String nom, String prenom, Date datenaissance, String adresse, String ville, String pays) {
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}

	public Personne(ResultSet resultquery) {
		try {
			this.nom = resultquery.getString("nom");
			this.prenom = resultquery.getString("prenom");
			this.datenaissance = resultquery.getDate("datenaissance");
			this.adresse = resultquery.getString("adresse");
			this.ville = resultquery.getString("ville");
			this.pays = resultquery.getString("pays");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the datenaissance
	 */
	public Date getDatenaissance() {
		return datenaissance;
	}

	/**
	 * @param datenaissance the datenaissance to set
	 */
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	public static String getHeadTab() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("<thead><tr>");
		buffer.append("<th>").append("Nom").append("</th>");
		buffer.append("<th>").append("Prenom").append("</th>");
		buffer.append("<th>").append("Date de naissance").append("</th>");
		buffer.append("<th>").append("Adresse").append("</th>");
		buffer.append("<th>").append("Ville").append("</th>");
		buffer.append("<th>").append("Pays").append("</th>");
		buffer.append("</tr></thead>");

		return buffer.toString();
	}

	public String toHTMLTable() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("<tr>");
		buffer.append("<td>").append(nom).append("</td>");
		buffer.append("<td>").append(prenom).append("</td>");
		buffer.append("<td>").append(datenaissance.toString()).append("</td>");
		buffer.append("<td>").append(adresse).append("</td>");
		buffer.append("<td>").append(ville).append("</td>");
		buffer.append("<td>").append(pays).append("</td>");
		buffer.append("</tr>");

		return buffer.toString();
	}

}
