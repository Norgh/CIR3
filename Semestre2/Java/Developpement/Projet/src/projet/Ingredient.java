package projet;

public class Ingredient {
	public String nom;
	public int quantite;
	
	public Ingredient(String nom, int quantite) {
		this.nom = nom;
		this.quantite = quantite;
	}
	
	public void mettreAJourQuantite(int _quantite) {
		this.quantite = _quantite;
	}
}
