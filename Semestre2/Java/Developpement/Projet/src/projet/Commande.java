package projet;

import java.util.*;

public class Commande {
	public ArrayList<Plat> listePlats = new ArrayList<Plat>();
	public ArrayList<Boisson> listeBoissons = new ArrayList<Boisson>();
	public Addition addition;
	public int numeroTable;
	public boolean boissonsPretes = false;
	
	public Commande () {
		this.listePlats.clear();
		this.listeBoissons.clear();
	}
	
	public void setCommande(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, Addition addition, int numeroTable) {
		this.listePlats.addAll(listePlats);
		this.listeBoissons.addAll(listeBoissons);
		this.addition = addition;
		this.numeroTable = numeroTable;
	}
}
