package projet;

import java.util.*;

public class Commande {
	public ArrayList<Plat> listePlats = new ArrayList<Plat>();
	public ArrayList<Boisson> listeBoissons = new ArrayList<Boisson>();
	public Addition addition;
	public int numeroTable;
	
	public Commande (ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, Addition addition, int numeroTable) {
		this.listePlats = listePlats;
		this.listeBoissons = listeBoissons;
		this.addition = addition;
		this.numeroTable = numeroTable;
	}
}
