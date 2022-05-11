package projet;

import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		ArrayList<Employe> listeEmployes = new ArrayList<Employe>();
		ArrayList<Employe> equipeDuJour = new ArrayList<Employe>();
		ArrayList<Ingredient> listeIngredients = new ArrayList<Ingredient>();
		
		Ingredient salade = new Ingredient("salade", 10);
		listeIngredients.add(salade);
		Ingredient tomate = new Ingredient("tomate", 10);
		listeIngredients.add(tomate);
		Ingredient oignon = new Ingredient("oignon", 10);
		listeIngredients.add(oignon);
		Ingredient champignon = new Ingredient("champignon", 10);
		listeIngredients.add(champignon);
		Ingredient painBurger = new Ingredient("pain Burger", 10);
		listeIngredients.add(painBurger);
		Ingredient steak = new Ingredient("steak", 10);
		listeIngredients.add(steak);
		Ingredient patePizza = new Ingredient("pate Pizza", 10);
		listeIngredients.add(patePizza);
		Ingredient fromage = new Ingredient("fromage", 10);
		listeIngredients.add(fromage);
		Ingredient saucisse = new Ingredient("saucisse", 10);
		listeIngredients.add(saucisse);
		Ingredient fajitas = new Ingredient("fajitas", 10);
		listeIngredients.add(fajitas);
		Ingredient riz = new Ingredient("riz", 10);
		listeIngredients.add(riz);
		Ingredient poulet = new Ingredient("poulet", 10);
		listeIngredients.add(poulet);
		
		HashMap <Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();
		ArrayList<Plat> listePlats = new ArrayList<Plat>();
		ArrayList<Boisson> listeBoissons = new ArrayList<Boisson>();
		
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
		
		ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
		
	}
	
	public static void ChoixEcran(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, ArrayList<Plat> listePlatsCommandes, ArrayList<Boisson> listeBoissonsCommandees, ArrayList<Commande> listeCommandesPassees, Addition addition, ArrayList<Employe> listeEmployes, ArrayList<Employe> equipeDuJour, ArrayList<Ingredient> listeIngredients) {
		System.out.println("Quel écran souhaitez vous afficher?");
		System.out.println("1- Ecran Commande");
		System.out.println("2- Ecran cuisine");
		System.out.println("3- Ecran bar");
		System.out.println("4- Ecran Monitoring");
		System.out.println("5- Etat des Stocks");
		System.out.println("6- Equipe du jour");
		
		Scanner scanner = new Scanner(System.in);
		
		int choixEcran = scanner.nextInt();
		
		AfficherEcran(listePlats, listeBoissons, choixEcran, scanner, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
		
		scanner.close();
	}
	
	public static void AfficherEcran(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons, int choixEcran, Scanner scanner, ArrayList<Plat> listePlatsCommandes, ArrayList<Boisson> listeBoissonsCommandees, ArrayList<Commande> listeCommandesPassees, Addition addition, ArrayList<Employe> listeEmployes, ArrayList<Employe> equipeDuJour, ArrayList<Ingredient> listeIngredients) {
		switch(choixEcran) {
		case 1:
			Commande commande = new Commande();
			System.out.println("Effectuer la commande");
			Boolean commandeTerminee = false;
			System.out.println("Rentrez le numero de la table :");
			int numeroTable = scanner.nextInt();
			System.out.println("Création de la commande pour la table " + numeroTable);
			System.out.println("Commander à la carte (1) ou avec le menu spécial (2) ? ");
			int choixCommande = scanner.nextInt();
			if(choixCommande == 1) {
				while(!commandeTerminee) {
					int i = 1;
					int nombrePlats = listePlats.size();
					
					for(Plat elem: listePlats)
				       {
				       	 System.out.println("Plat " + i + ": " + elem.nom + " coûte " + elem.prix + "€");
				       	 i++;
				       }
					
					for(Boisson elem: listeBoissons) {
						System.out.println("Boisson " + i + ": " + elem.nom + " coûte " + elem.prix + "€");
				       	i++;
					}
					System.out.print("Choississez votre plat ou boisson : ");
					int choixPlatOuBoisson = scanner.nextInt();
					if (choixPlatOuBoisson < nombrePlats + 1) {
						listePlatsCommandes.add(listePlats.get(choixPlatOuBoisson - 1));
						addition.CalculPrix(listePlats.get(choixPlatOuBoisson - 1).prix);
						System.out.println("Vous avez choisi comme plat " + choixPlatOuBoisson + " qui est le " + listePlats.get(choixPlatOuBoisson - 1).nom + " qui coûte " + listePlats.get(choixPlatOuBoisson - 1).prix);
					}
					else if(choixPlatOuBoisson < 19) {
						listeBoissonsCommandees.add(listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1));
						addition.CalculPrix(listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).prix);
						System.out.println("Vous avez choisi comme boisson " + choixPlatOuBoisson + " qui est le " + listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).nom + " qui coûte " + listeBoissons.get(choixPlatOuBoisson - nombrePlats - 1).prix);
					}
					else if(choixPlatOuBoisson == 19) {
						commande.setCommande(listePlatsCommandes, listeBoissonsCommandees, addition, numeroTable);
						listeCommandesPassees.add(commande);
						String fileName = "Facture_Table_" + String.valueOf(commande.numeroTable) + ".txt";
					    String encoding = "UTF-8";
					    try{
					    	PrintWriter writer = new PrintWriter(fileName, encoding);
					    	writer.println("Facture de la table " + commande.numeroTable + " :");
					    	writer.println("");
					    	writer.println("Cette facture contient " + commande.listePlats.size() + " plats et " + commande.listeBoissons.size() + " boissons.");
					    	writer.println("");
					    	writer.println("Les plats commandés :");
					    	for(Plat plat : commande.listePlats) {
					    		writer.println("	" + plat.nom + " à " + plat.prix + "€");
					    	}
					    	writer.println("");
					    	writer.println("Les boissons commandées :");
					    	for(Boisson boisson : commande.listeBoissons) {
					    		writer.println("	" + boisson.nom + " à " + boisson.prix + "€");
					    	}
					    	writer.println("Cette addition coûte au total : " + addition.prix + "€");
					    	writer.println("");
					    	writer.close();
					    }
					    catch (IOException e){
					      System.out.println("An error occurred.");
					      e.printStackTrace();
					    }
						System.out.println("Cette commande pour la table " + commande.numeroTable +" contient " + commande.listePlats.size() + " plats et " + commande.listeBoissons.size() + " boissons et coutera : " + commande.addition.prix + "€");
						commandeTerminee = true;
						listePlatsCommandes.clear();
						listeBoissonsCommandees.clear();
					}
				}
			}
			else if(choixCommande == 2) {
				System.out.println("Choisisser vos 7 plats et 7 boissons pour 100€ :");
				for(int i = 1; i < 8; i++) {
					int j = 1;
					for(Plat elem: listePlats){
					       	System.out.println("Plat n°" + j + ": " + elem.nom);
					       	j++;
					   }
					int choixPlat = scanner.nextInt();
					listePlatsCommandes.add(listePlats.get(choixPlat - 1));
					addition.CalculPrix(0);
					System.out.println("Vous avez choisi comme plat (" + i + ") " + choixPlat + " qui est le " + listePlats.get(choixPlat - 1).nom);
				}
					
				for(int i = 1; i < 8; i++) {
					int j = 1;
					for(Boisson elem: listeBoissons){
					       	System.out.println("Boisson n° " + j + ": " + elem.nom);
					       	j++;
					   }
					int choixBoisson = scanner.nextInt();
					listeBoissonsCommandees.add(listeBoissons.get(choixBoisson - 1));
					addition.CalculPrix(0);
					System.out.println("Vous avez choisi comme boisson (" + i + ") " + choixBoisson + " qui est le " + listeBoissons.get(choixBoisson - 1).nom);
				}
				addition.prix = 100;
				commande.setCommande(listePlatsCommandes, listeBoissonsCommandees, addition, numeroTable);
				listeCommandesPassees.add(commande);
				String fileName = "Facture_Table_" + String.valueOf(commande.numeroTable) + ".txt";
				String encoding = "UTF-8";
				try{
				   	PrintWriter writer = new PrintWriter(fileName, encoding);
				   	writer.println("Facture de la table " + commande.numeroTable + " :");
				   	writer.println("");
				   	writer.println("Cette facture contient " + commande.listePlats.size() + " plats et " + commande.listeBoissons.size() + " boissons du menu ");
				   	writer.println("");
				   	writer.println("Les plats commandés :");
				   	for(Plat plat : commande.listePlats) {
				   		writer.println("	" + plat.nom);
				    }
				    writer.println("");
				    writer.println("Les boissons commandées :");
				    for(Boisson boisson : commande.listeBoissons) {
				    	writer.println("	" + boisson.nom );
				    }
				    writer.println("Cette addition coûte au total : 100€");
				    writer.println("");
				    writer.close();
				   }
				 catch (IOException e){
				     System.out.println("An error occurred.");
				     e.printStackTrace();
				 }
				System.out.println("Cette commande pour la table " + commande.numeroTable +" contient " + commande.listePlats.size() + " plats et " + commande.listeBoissons.size() + " boissons et coutera : " + commande.addition.prix + "€");
				commandeTerminee = true;
				listePlatsCommandes.clear();
				listeBoissonsCommandees.clear();
			}
			
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;
			
		case 2:
			System.out.println("Plats en cours de preparation : ");
			System.out.println("Il y a actuellement " + listeCommandesPassees.size() + " commandes en préparation ");
			for(Commande commande1 : listeCommandesPassees) {
				System.out.print("pour la table ");
				System.out.print(commande1.numeroTable);
				System.out.print(" contenant les plats : ");
				for(Plat plat : commande1.listePlats) {
					System.out.print(plat.nom + ", ");
				}
				System.out.println("");
			}
			System.out.println("Et voila !");
			System.out.println("Avez-vous fini la préparation d'une commmande ? (0/1)");
			int choixSuite = scanner.nextInt();
			if(choixSuite == 1) {
				int indexCommandePrete = 0;
				System.out.println("Donner le numéro de la table de la commande qui est prête :");
				int commandePrete = scanner.nextInt();
				
				for(Commande commande1 : listeCommandesPassees) {
					int i = 0;
					if(commande1.numeroTable == commandePrete) {
						System.out.println(commande1.numeroTable + " = " + commandePrete);
						indexCommandePrete = i;
						for(Plat plat : commande1.listePlats) {
							for(Map.Entry<Ingredient, Integer> entry : plat.ingredients.entrySet()) {
								System.out.println("Ceci est un test");
								Ingredient ingredient = entry.getKey();
								int quantite = entry.getValue();
								System.out.println(ingredient.nom + " " + ingredient.quantite);
								ingredient.mettreAJourQuantite(quantite);
							}
						}
					}
					i++;
				}
				listeCommandesPassees.remove(indexCommandePrete);
			}
			else if(choixSuite == 0) {
				ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			}	
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;
			
		case 3:
			System.out.println("Vous avez choisi l'écran: " + choixEcran);
			System.out.println("Boissons en cours de preparation : ");
			System.out.println("Il y a actuellement " + listeCommandesPassees.size() + " commandes en préparation pour les tables ");
			for(Commande commande1 : listeCommandesPassees) {
				System.out.print(commande1.numeroTable);
				System.out.print(" contenant les boissons : ");
				for(Boisson boisson : commande1.listeBoissons) {
					System.out.print(boisson.nom + ", ");
				}
			}
			System.out.println("Et voila !");
			System.out.println("Avez-vous fini la préparation d'une commmande ? (0/1)");
			choixSuite = scanner.nextInt();
			if(choixSuite == 1) {
				int i = 0;
				System.out.println("Donner le numéro de la table de la commande qui est prête :");
				int commandePrete = scanner.nextInt();
				for(Commande commande1 : listeCommandesPassees) {
					if(commande1.numeroTable == commandePrete) {
						listeCommandesPassees.get(i).boissonsPretes = true;

					}
				}
				i++;
			}
			else if(choixSuite == 0) {
				ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			}
			break;
			
		case 4:
			System.out.println("Vous avez choisi l'écran: " + choixEcran);
			
			System.out.println("Vous souhaitez supprimer, ajouter un employe ? (0/1)");
			int quoiFaire = scanner.nextInt();
			
			if(quoiFaire == 1) {
				System.out.println("Vous souhaitez donc ajouter un nouvel employe ");
				System.out.println("Entrez son nom : ");
				String nom = scanner.next();
				System.out.println("Entrez son prenom : ");
				String prenom = scanner.next();
				System.out.println("Entrez son salaire : ");
				float salaire = scanner.nextFloat();
				System.out.println("Entrez son role : ");
				String role = scanner.next();
				Employe employe = new Employe(nom, prenom, salaire, role);
				System.out.println("Vous avez ajoute " + employe.prenom + " " + employe.nom + " qui est " + employe.role + " et doit etre paye " + employe.salaire + "€");
				listeEmployes.add(employe);
			}
			else if(quoiFaire == 0) {
				System.out.println("Vous souhaitez donc supprimer un employe");
				System.out.println("Voici la liste des employes : ");
				int i = 1;
				for(Employe elem : listeEmployes) {
					System.out.println("Employe n°" + i + " : " + elem.nom + " " + elem.prenom + "qui est " + elem.role + ", ");
					i++;
				}
				System.out.println("Renseignez le numéro de l'employé que vous souhaitez supprimer : ");
				int numeroEmploye = scanner.nextInt();
				System.out.println("Vous avez enlevé " + listeEmployes.get(numeroEmploye - 1).nom  + listeEmployes.get(numeroEmploye - 1).prenom + " et qui était " + listeEmployes.get(numeroEmploye - 1).role);
				listeEmployes.remove(numeroEmploye - 1);
			}
			
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;
			
		case 5:
			System.out.println("Gérer l'état des stocks");
			System.out.println("Vous souhaitez voir le stock (1) ou le mettre à jour (2)");
			int choixStock = scanner.nextInt();
			if(choixStock == 1) {
				for(Ingredient ingredient : listeIngredients) {
					System.out.println("Il y a " + ingredient.quantite + " " + ingredient.nom + " en stock");
				}
			}
			else if(choixStock == 2) {
				for(Ingredient ingredient : listeIngredients) {
					System.out.println("Mettre à jour la quantité de " + ingredient.nom);
					int quantiteEnStock = scanner.nextInt();
					ingredient.mettreAJourQuantite(quantiteEnStock);
				}
			}
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;

		case 6:
			System.out.println("Vous voulez donc définir l'équipe du jour :");
			String cuisinier = new String("cuisinier");
			String serveur = new String("serveur");
			String manager = new String("manager");
			String barman = new String("barman");
			
			System.out.println("Liste des cuisiniers disponibles");
			int i = 1;
			for(Employe employe : listeEmployes) {
				if(employe.role.equals(cuisinier)) {
					System.out.println("Employe n°" + i + " : " + employe.nom + " " + employe.prenom + "qui a déjà travaillé " + employe.jourDeTravailDeSuite + " jours de suite.");
				}
				i++;
			}
			for(int j = 1; j < 5; j++) {
				System.out.println("Entrez le numéro du cuisinier qui travaillera aujourd'hui : (" + j + ")");
				int numeroCuisinier = scanner.nextInt();
				listeEmployes.get(numeroCuisinier - 1).jourDeTravailDeSuite++;	
				equipeDuJour.add(listeEmployes.get(numeroCuisinier - 1));
			}
			
			System.out.println("Liste des serveurs disponibles");
			i = 1;
			for(Employe employe : listeEmployes) {
				if(employe.role.equals(serveur) && employe.jourDeTravailDeSuite < 3) {
					System.out.println("Employe n°" + i + " : " + employe.nom + " " + employe.prenom + "qui a déjà travaillé " + employe.jourDeTravailDeSuite + " jours de suite.");
				}
				i++;
			}
			for(int j = 1; j < 3; j++) {
				System.out.println("Entrez le numéro du serveur qui travaillera aujourd'hui : (" + j + ")");
				int numeroServeur = scanner.nextInt();
				listeEmployes.get(numeroServeur - 1).jourDeTravailDeSuite++;
				equipeDuJour.add(listeEmployes.get(numeroServeur - 1));
			}
			
			System.out.println("Liste des managers disponibles");
			i = 1;
			for(Employe employe : listeEmployes) {
				if(employe.role.equals(manager) && employe.jourDeTravailDeSuite < 3) {
					System.out.println("Employe n°" + i + " : " + employe.nom + " " + employe.prenom + "qui a déjà travaillé " + employe.jourDeTravailDeSuite + " jours de suite.");
				}
				i++;
			}
			System.out.println("Entrez le numéro du manager qui travaillera aujourd'hui :");
			int numeroManager = scanner.nextInt();
			listeEmployes.get(numeroManager - 1).jourDeTravailDeSuite++;
			equipeDuJour.add(listeEmployes.get(numeroManager - 1));
			
			System.out.println("Liste des barmen disponibles");
			i = 1;
			for(Employe employe : listeEmployes) {
				if(employe.role.equals(barman) && employe.jourDeTravailDeSuite < 3) {
					System.out.println("Employe n°" + i + " : " + employe.nom + " " + employe.prenom + "qui a déjà travaillé " + employe.jourDeTravailDeSuite + " jours de suite.");
				}
				i++;
			}
			System.out.println("Entrez le numéro du barman qui travaillera aujourd'hui :");
			int numeroBarman = scanner.nextInt();
			listeEmployes.get(numeroBarman - 1).jourDeTravailDeSuite++;
			equipeDuJour.add(listeEmployes.get(numeroBarman - 1));
			
			System.out.println("L'équipe du jour est composée de : ");
			for(Employe employe : equipeDuJour) {
				System.out.println(employe.nom + " " + employe.prenom + " " + employe.role + ",");
			}
			
			
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;
			
		default:
			System.out.println("Vous avez choisi l'écran: " + choixEcran);
			ChoixEcran(listePlats, listeBoissons, listePlatsCommandes, listeBoissonsCommandees, listeCommandesPassees, addition, listeEmployes, equipeDuJour, listeIngredients);
			break;
		}
	}
}