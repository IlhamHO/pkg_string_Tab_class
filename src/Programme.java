import eu.epfc.prm2.Array;

public class Programme {
    public static boolean search(Array<Joueur> tab, String nom){
        boolean itExist=false;
        for(int i=0;i<tab.size();++i){
            if(tab.get(i).idJoueur.compareTo(nom)==0) itExist=true;
        }
        return itExist;
    }

    public static void addJ(Array<Joueur>tab,String nom, int score){
        tab.add(new Joueur(nom,score));
        for(int i=tab.size()-2;i>=0;--i) {
            if (tab.get(i).idJoueur.compareTo(tab.get(i + 1).idJoueur) > 0) {
                Joueur tmpJ = tab.get(i);
                tab.set(i, tab.get(i + 1));
                tab.set(i + 1, tmpJ);
            }
        }
    }

    public static int posJ(Array<Joueur>tab,String nom){
        int pos=0;
        int i=0;
        while(i<tab.size() && tab.get(i).idJoueur.compareTo(nom)!=0){
            ++i;
        }
        if(i<tab.size()) pos=i;
        return pos;
    }

    public static void deleteJ(Array<Joueur>tab,String nom){
        for(int j=posJ(tab,nom); j<tab.size()-1; ++j){
            tab.set(j,tab.get(j+1));

        }
        tab.reduceTo(tab.size()-1);
    }

    public static void changeScore(Array<Joueur>tab, String nom,int score){
        tab.get(posJ(tab,nom)).score=score;
    }


    public static void gestion(Array<Joueur> tab,String nom, int score){
        if(!search(tab,nom)){
            addJ(tab,nom,score);
        }else {
            if (tab.get(posJ(tab, nom)).score <= score) {
                changeScore(tab, nom, score);
            } else {
                deleteJ(tab, nom);
            }
        }
    }

    public static void affiche(Array<Joueur>tab){

        for(int i=0;i<tab.size();++i){
            System.out.println(tab.get(i).idJoueur);
            System.out.print(tab.get(i).score);
        }
    }


    public static void main(String[] args) {
        Joueur j3= new Joueur("Amine",10);
        Joueur j2= new Joueur("Achraf",8);
        Joueur j1= new Joueur("Abder Rahmane",9);

        Array<Joueur> joueurs=new Array<Joueur>();
        gestion(joueurs,"Ahmed",10);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Adel",6);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Amine",12);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Abder Rahmane",10);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Achraf",8);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Anwar",8);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);
        System.out.println("----------------------------------");
        gestion(joueurs,"Adel",3);
        System.out.println("Tableau après gestion: ");
        affiche(joueurs);

    }
}