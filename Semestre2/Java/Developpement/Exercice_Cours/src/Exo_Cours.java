import java.util.*;
import java.io.*;
import java.math.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Player {
    public static int numSites;
    public static Map<Integer, Carte> listeCarte = new HashMap<>();
    public static Map<Integer, Armee> listeArmee = new HashMap<>();
    public static Map<Integer, Site> listeSite = new HashMap<>();
    public static int idSiteProche;
    public static int idSiteProcheTmp;
    public static List sitesConstruits = new ArrayList();
    public static int i = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        instanciateGame(in);
        int tour = 0;
 
        // game loop
        while (true) {
            int gold = in.nextInt();
            actualiserCarte(in);
            actualiserArmee(in);
            if(sitesConstruits.size() == 50)
            {
                System.err.println("On Arrete de Build");
                System.out.println("BUILD ");
                if(sitesConstruits.isEmpty()){
                    System.out.println("TRAIN");
                }
                else System.out.println("TRAIN " + sitesConstruits.get(i));
                if (i < sitesConstruits.size()){
                    i++;
                }
                else i = 0;
            }
            else {
                if(sitesConstruits.contains(idSiteProche) || sitesConstruits.isEmpty()){
                    calculSiteProche();
                }
                System.out.println("BUILD " + idSiteProche + " BARRACKS-KNIGHT");
                if(sitesConstruits.isEmpty()){
                    System.out.println("TRAIN");
                }
                else System.out.println("TRAIN " + sitesConstruits.get(i));
                if (i < sitesConstruits.size()){
                    i++;
                }
                else i = 0;
            }
        }
    }

    public static void calculSiteProche() {
        Armee reine = listeArmee.get(-1);
        int reineX = reine.x;
        int reineY = reine.x;
        System.err.println("Owner: " + reine.owner);
        System.err.println("X: " + reine.x);
        System.err.println("Y: " + reine.y);
        double tmp;
        double distance;
        double distanceMin = 999999999;
        for (Map.Entry<Integer, Site> entry : listeSite.entrySet()) {
            tmp = Math.pow((entry.getValue().x - reineX), 2) + Math.pow((entry.getValue().y - reineY), 2);
	        distance = Math.sqrt(tmp);
            if(distance < distanceMin && !sitesConstruits.contains(entry.getKey())) {
                distanceMin = distance;
                idSiteProcheTmp = entry.getKey();
            }
	    }
        idSiteProche = idSiteProcheTmp;
        System.err.println("Site le plus proche : " + idSiteProche);
    }

    public static void instanciateGame(Scanner in) {
        numSites = in.nextInt();
        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            Site site = new Site(siteId, x, y, radius);
            listeSite.put(siteId, site);
        }
    }

    public static void actualiserArmee(Scanner in) {
        int numUnits = in.nextInt();
        for (int i = 0; i < numUnits; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int owner = in.nextInt();
            int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
            int health = in.nextInt();
            if(owner == 1 && unitType==-1){
                Armee armee = new Armee(x, y, owner, -2, health);
                listeArmee.put(-2, armee);
            }
            else{
                Armee armee = new Armee(x, y, owner, unitType, health);
                listeArmee.put(unitType, armee);
            }
            
        }
    }
    
    public static void actualiserCarte(Scanner in) {
        int touchedSite = in.nextInt(); // -1 if none
        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int ignore1 = in.nextInt(); // used in future leagues
            int ignore2 = in.nextInt(); // used in future leagues
            int structureType = in.nextInt(); // -1 = No structure, 2 = Barracks
            int owner = in.nextInt(); // -1 = No structure, 0 = Friendly, 1 = Enemy
            int param1 = in.nextInt();
            int param2 = in.nextInt();
            Carte carte = new Carte(siteId, ignore1, ignore2, structureType, owner, param1, param2);
            listeCarte.put(siteId, carte);
            if(structureType == 2 && owner == 0 && !sitesConstruits.contains(siteId)){
                sitesConstruits.add(siteId);
            }
        }
    }
}

class Site {
    public int siteId;
    public int x;
    public int y;
    public int radius;

    public Site(int siteId, int x, int y, int radius) {
        this.siteId = siteId;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}

class Carte {
    int siteId;
    int ignore1;
    int ignore2;
    int structureType;
    int owner;
    int param1;
    int param2;

    public Carte(int siteId, int ignore1, int ignore2, int structureType, int owner, int param1, int param2) {
        this.siteId = siteId;
        this.ignore1 = ignore1;
        this.ignore2 = ignore2;
        this.structureType = structureType;
        this.owner = owner;
        this.param1 = param1;
        this.param2 = param2;
    }
}

class Armee {
    public int x;
    public int y;
    public int owner;
    public int unitType;
    public int health;

    public Armee(int x, int y, int owner, int unitType, int health) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.unitType = unitType;
        this.health = health;
    }
}