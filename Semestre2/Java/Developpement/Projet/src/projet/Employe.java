package projet;

public class Employe {
	public String nom;
	public String prenom;
	public float salaire;
	public String role;
	public int jourDeTravailDeSuite = 0;
	
	public Employe(String nom, String prenom, float salaire, String role) {
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.role = role;
	}
}
