package projet;

import java.util.*;

public class App {
	public static void main(String[] args) {
		Stock stock = new Stock();
		
		Ingredient salade = new Ingredient("salade", 10);
		Ingredient tomate = new Ingredient("tomate", 10);
		Ingredient oignon = new Ingredient("oignon", 10);
		Ingredient champignon = new Ingredient("champignon", 10);
		Ingredient painBurger = new Ingredient("pain Burger", 10);
		Ingredient steak = new Ingredient("steak", 10);
		Ingredient patePizza = new Ingredient("pate Pizza", 10);
		Ingredient fromage = new Ingredient("fromage", 10);
		Ingredient saucisse = new Ingredient("saucisse", 10);
		Ingredient fajitas = new Ingredient("fajitas", 10);
		Ingredient riz = new Ingredient("riz", 10);
		Ingredient poulet = new Ingredient("poulet", 10);
		
		stock.ajouterAuStock(salade);
		stock.ajouterAuStock(saucisse);
		stock.ajouterAuStock(tomate);
		stock.ajouterAuStock(oignon);
		stock.ajouterAuStock(champignon);
		stock.ajouterAuStock(painBurger);
		stock.ajouterAuStock(steak);
		stock.ajouterAuStock(patePizza);
		stock.ajouterAuStock(fromage);
		stock.ajouterAuStock(fajitas);
		stock.ajouterAuStock(riz);
		stock.ajouterAuStock(poulet);
		
		HashMap <Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		ArrayList<Boisson> listeBoissons = new ArrayList<Boisson>();
		ArrayList<Employe> listeEmployes = new ArrayList<Employe>();
		
		ingredients.put(salade, 1);
		ingredients.put(tomate, 1);
		Plat salade_tomate = new Plat("Salade Tomate", ingredients, 9);
		listePlats.add(salade_tomate);
		ingredients.clear();
		
		ingredients.put(salade, 1);
		Plat salade_classique = new Plat("Salade", ingredients, 9);
		listePlats.add(salade_classique);
		ingredients.clear();
		
		ingredients.put(oignon, 3);
		Plat soupe_oignon = new Plat("Soupe oignon", ingredients, 8);
		listePlats.add(soupe_oignon);
		ingredients.clear();
		
		ingredients.put(tomate, 3);
		Plat soupe_tomate = new Plat("Soupe Tomate", ingredients, 8);
		listePlats.add(soupe_tomate);
		ingredients.clear();
		
		ingredients.put(champignon, 3);
		Plat soupe_champignon = new Plat("Soupe Champignons", ingredients, 8);
		listePlats.add(soupe_champignon);
		ingredients.clear();
		
		ingredients.put(painBurger, 1);
		ingredients.put(salade, 1);
		ingredients.put(tomate, 1);
		ingredients.put(steak,  1);
		Plat burger_complet = new Plat("Burger Complet", ingredients, 15);
		listePlats.add(burger_complet);
		ingredients.clear();
		
		ingredients.put(painBurger, 1);
		ingredients.put(salade, 1);
		ingredients.put(steak,  1);
		Plat burger_sans_tomate = new Plat("Burger Sans Tomate", ingredients, 15);
		listePlats.add(burger_sans_tomate);
		ingredients.clear();
		
		ingredients.put(painBurger, 1);
		ingredients.put(steak,  1);
		Plat burger_basique = new Plat("Burger basique", ingredients, 15);
		listePlats.add(burger_basique);
		ingredients.clear();
		
		ingredients.put(patePizza, 1);
		ingredients.put(fromage, 1);
		ingredients.put(tomate, 1);
		Plat pizza_margherita = new Plat("Pizza Margherita", ingredients, 12);
		listePlats.add(pizza_margherita);
		ingredients.clear();
		
		ingredients.put(patePizza, 1);
		ingredients.put(fromage, 1);
		ingredients.put(tomate, 1);
		ingredients.put(champignon,  1);
		Plat pizza_reine = new Plat("Pizza Reine", ingredients, 12);
		listePlats.add(pizza_reine);
		ingredients.clear();
		
		ingredients.put(patePizza, 1);
		ingredients.put(fromage, 1);
		ingredients.put(tomate, 1);
		ingredients.put(saucisse,  1);
		Plat pizza_saucisse = new Plat("Pizza Saucisse", ingredients, 12);
		listePlats.add(pizza_saucisse);
		ingredients.clear();
		
		ingredients.put(fajitas, 1);
		ingredients.put(poulet, 1);
		ingredients.put(riz, 1);
		Plat fajitas_poulet = new Plat("Fajitas Poulet", ingredients, 11);
		listePlats.add(fajitas_poulet);
		ingredients.clear();
		
		ingredients.put(fajitas, 1);
		ingredients.put(steak, 1);
		ingredients.put(riz, 1);
		Plat fajitas_steak = new Plat("Fajitas Steak", ingredients, 11);
		listePlats.add(fajitas_steak);
		ingredients.clear();
		
		
		Boisson limonade = new Boisson("Limonade", 4);
		listeBoissons.add(limonade);
		Boisson cidre_Doux = new Boisson("Cidre Doux", 5);
		listeBoissons.add(cidre_Doux);
		Boisson Biere_Sans_Alcool = new Boisson("Biere sans Alcool", 5);
		listeBoissons.add(Biere_Sans_Alcool);
		Boisson jus_de_Fruit = new Boisson("Jus de Fruit", 1);
		listeBoissons.add(jus_de_Fruit);
		Boisson eau = new Boisson("Eau", 0);
		listeBoissons.add(eau);
		
		ArrayList<Plat> listePlatsCommandes = new ArrayList<Plat>();
		ArrayList<Boisson> listeBoissonsCommandees = new ArrayList<Boisson>();
		ArrayList<Commande> listeCommandesPassees = new ArrayList<Commande>();
		
		Addition addition = new Addition();
		
		ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition);
		
	}
	
	public static void ChoixEcran(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlatsCommandes, ArrayList<Boisson> listeBoissonsCommandees, ArrayList<Commande> listeCommandesPassees, Addition addition, ArrayList<Employe> listeEmployes) {
		System.out.println("Quel �cran souhaitez vous afficher?");
		System.out.println("1- Ecran Commande");
		System.out.println("2- Ecran cuisine");
		System.out.println("3- Ecran bar");
		System.out.println("4- Ecran Monitoring");
		System.out.println("5- Etat des Stocks");
		
		Scanner scanner = new Scanner(System.in);
		
		int choixEcran = scanner.nextInt();
		
		PasserCommande(listePlats, listeBoissons, choixEcran, scanner, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes);
		
		scanner.close();
	}
	
	public static void PasserCommande(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, int choixEcran, Scanner scanner, ArrayList<Plat> listePlatsCommandes, ArrayList<Boisson> listeBoissonsCommandees, ArrayList<Commande> listeCommandesPassees, Addition addition, ArrayList<Employe> listeEmployes) {
		
		switch(choixEcran) {
		case 1:
			Boolean commandeTerminee = false;
			System.out.println("Vous avez choisi l'�cran: " + choixEcran);
			System.out.println("Rentrez le numero de la table :");
			int numeroTable = scanner.nextInt();
			System.out.println("Creation commande pour table " + numeroTable);
			
			while(!commandeTerminee) {
				int i = 1;
				int nombrePlats = listePlats.size();
				
				for(Plat elem: listePlats)
			       {
			       	 System.out.println("Plat " + i + ": " + elem.nom + " co�te " + elem.prix + "�");
			       	 i++;
			       }
				
				for(Boisson elem: listeBoissons) {
					System.out.println("Boisson " + i + ": " + elem.nom + " co�te " + elem.prix + "�");
			       	i++;
				}
				System.out.print("Choississez votre plat ou boisson : ");
				int choixPlatOuBoisson = scanner.nextInt();
				if (choixPlatOuBoisson < nombrePlats + 1) {
					listePlatsCommandes.add(listePlats.get(choixPlatOuBoisson - 1));
					addition.CalculPrix(listePlats.get(choixPlatOuBoisson - 1).prix);
					System.out.println("Vous avez choisi comme plat " + choixPlatOuBoisson + " qui est le " + listePlats.get(choixPlatOuBoisson - 1).nom + " qui co�te " + listePlats.get(choixPlatOuBoisson - 1).prix);
				}
				else if(choixPlatOuBoisson < 17) {
					listeBoissonsCommandees.add(listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1));
					addition.CalculPrix(listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).prix);
					System.out.println("Vous avez choisi comme boisson " + choixPlatOuBoisson + " qui est le " + listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).nom + " qui co�te " + listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).prix);
				}
				else if(choixPlatOuBoisson == 17) {
					Commande commande = new Commande(listePlatsCommandes, listeBoissonsCommandees, addition, numeroTable);
					listeCommandesPassees.add(commande);
					System.out.println("Cette commande pour la table " + commande.numeroTable +" contient " + commande.listePlats.size() + " plats et " + commande.listeBoissons.size() + " boissons et coutera : " + commande.addition.prix + "�");
					commandeTerminee = true;
				}
			}
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees,addition, listeEmployes);
			break;
			
		case 2:
			System.out.println("Vous avez choisi l'�cran: " + choixEcran);
			System.out.println("Plats en cours de preparation : ");
			System.out.println("Il y a actuellement " + listeCommandesPassees.size() + " commandes en pr�paration pour les tables ");
			for(Commande commande : listeCommandesPassees) {
				System.out.print(commande.numeroTable);
				System.out.print(" contenant les plats : ");
				for(Plat plat : commande.listePlats) {
					System.out.print(plat.nom + ", ");
				}
			}
			System.out.println("Et voila !");
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees,addition, listeEmployes);
			break;
			
		case 3:
			System.out.println("Vous avez choisi l'�cran: " + choixEcran);
			System.out.println("Boissons en cours de preparation : ");
			System.out.println("Il y a actuellement " + listeCommandesPassees.size() + " commandes en pr�paration pour les tables ");
			for(Commande commande : listeCommandesPassees) {
				System.out.print(commande.numeroTable);
				System.out.print(" contenant les boissons : ");
				for(Boisson boisson : commande.listeBoissons) {
					System.out.print(boisson.nom + ", ");
				}
			}
			System.out.println("Et voila !");
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees,addition, listeEmployes);
			break;
			
		case 4:
			System.out.println("Vous avez choisi l'�cran: " + choixEcran);
			
			System.out.println("Vous souhaitez ajouter, supprimer un employe ou gerer les roles ? (0/1/2)");
			int quoiFaire = scanner.nextInt();
			
			if(quoiFaire == 0) {
				System.out.println("Vous souhaitez donc ajouter un nouvel employe");
				
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Nom :");
				String surname = scanner2.nextLine();
				System.out.println("Prenom :");
				String name = scanner2.nextLine();
				System.out.println("Bifton :");
				int salary = scanner2.nextInt();
				Employe employe = new Employe(surname, name, salary);
				listeEmployes.add(employe);
				scanner2.close();
				
			}
			else if(quoiFaire == 1) {
				System.out.println("Vous souhaitez donc supprimer un employe");
				Scanner scanner3 = new Scanner(System.in);
				System.out.println("Nom :");
				String namename = scanner3.nextLine();
				System.out.println("Prenom :");
				String surname = scanner3.nextLine();
			}
			else if(quoiFaire == 2) {
				System.out.println("Vous souhaitez donc gerer l'equipe");
				
			}
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees,addition, listeEmployes);
			break;

			
		default:
			System.out.println("Vous avez choisi l'�cran: " + choixEcran);
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees,addition, listeEmployes);
			break;
		}
	}
}
