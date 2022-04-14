package projet;

import java.util.*;

public class Plat {
	public String nom;
	public HashMap<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();
	public int prix;
	
	public Plat(String nom, HashMap<Ingredient, Integer> ingredients, int prix) {
		this.nom = nom;
		this.ingredients = ingredients;
		this.prix = prix;
	}
}
