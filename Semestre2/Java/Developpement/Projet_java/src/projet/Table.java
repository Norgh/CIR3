package projet;

public class Table {
	public int numero; 
	public int places;
	public Commande commande;
	// public Serveur responsable;			Faudra voir comment g�rer �a
	
	public Table(int numero, int places, Commande commande) {
		this.numero = numero;
		this.places = places;
		this.commande = commande;
	}
}
