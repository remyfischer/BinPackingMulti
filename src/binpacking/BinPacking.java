/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author remy.fischer
 */

//Binpacking resolution algorithm project

public class BinPacking {
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // Variable menu
        
        char saisie;
        char continuer;
        Scanner sc = new Scanner(System.in);
        
        // Variables algorithme binpacking
        
        int tailleX;
        int tailley;
        int tailleZ;
        int maxDimX;
        int maxDimY;
        int maxDimZ;
        int nbSousConteneur;
        int tailleMax;
        int nbItem;
        int maxDimItem;
        double firstFit;
        double firstFitDecreasing;

            
        System.out.println("Choisissez votre langue / Choose your language");
        System.out.println("Appuyez sur F pour Français - F");
        System.out.println("Press E for English - E");
        saisie = testSaisie('e', 'E', 'f', 'F');
            

        
        
        if (saisie == 'f' || saisie == 'F'){
            
            do{
                
                clearConsole();
                
                System.out.println("1 - Espace 1 dimension");
                System.out.println("2 - Espace 2 dimensions");
                System.out.println("3 - Espace 3 dimensions");
                System.out.println();
                System.out.println("Q - Quitter");
                saisie = testSaisie('1', '2', '3', 'q', 'Q');
               
                
                if (saisie == '1'){

                    
                    clearConsole();
                    
                    System.out.println("1 - Faire un test aléatoire");
                    System.out.println("2 - Test sans valeur");
                    System.out.println("3 - Test avec valeurs");
                    System.out.println();
                    System.out.println("R - Retour");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        tailleX = rand(8,16);
                        System.out.println("Taille du conteneur : " + tailleX);
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        tailleMax = rand(3,5);
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleMax);
                        
                        maxDimItem = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimItem);
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur);
                        
                        poursuivre();                     
                                         
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre(); 
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre(); 
                        
                    }
                    
                    

                }

                if (saisie == '2'){

                    clearConsole();
                    
                    System.out.println("1 - Faire un test aléatoire");
                    System.out.println("2 - Test sans valeur");
                    System.out.println("3 - Test avec valeurs");
                    System.out.println();
                    System.out.println("R - Retour");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre(); 
                        
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre(); 
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre(); 
                        
                    }

                }

                if (saisie == '3'){

                    clearConsole();
                    
                    System.out.println("1 - Faire un test aléatoire");
                    System.out.println("2 - Test sans valeur");
                    System.out.println("3 - Test avec valeurs");
                    System.out.println();
                    System.out.println("R - Retour");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre();                        
                        
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre();                        
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Non disponible pour le moment");
                        poursuivre();                        
                        
                    }
                    

                }
            
            
            
            } while (saisie != 'q' && saisie != 'Q');
            
        }
        
    }
    
    public static void poursuivre(){
        
        char continuer;
        Scanner sc = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Appuyez sur une touche puis Entrée pour continuer");
        continuer = sc.next().charAt(0); 
        
    }
    
    public static int rand(int a, int b){
        
        int rand;
        return rand = ThreadLocalRandom.current().nextInt(a, b+1);
        
    }
    
    public static char testSaisie(char... caracteres){
        
        char saisie;
        Scanner sc = new Scanner(System.in);
        boolean saisieTest = false;
        
        do {
            
            System.out.println();
            saisie = sc.next().charAt(0);
            for(char car:caracteres){
                
                if (saisie == car){
                    
                    saisieTest = true;
                    
                }
                
            }           
            
            
        } while(saisieTest == false);
        
        return saisie;
        
    }
    
        public static void testOptimisationAlgorithmeTri1D(TabItem1D _tabItem, Conteneur1D _conteneur, int _nbSousconteneur){
        
        Conteneur1D cFirstFit = new Conteneur1D();
        Conteneur1D cFirstFitDecreasing = new Conteneur1D();
        
        cFirstFit.clone(_conteneur);
        cFirstFitDecreasing.clone(_conteneur);
        
        double firstFit;
        double firstFitDecreasing;
        
        firstFit = firstFit1D(_tabItem, cFirstFit, _nbSousconteneur);
        firstFitDecreasing = firstFitDecreasing1D(_tabItem, cFirstFitDecreasing, _nbSousconteneur);
        
        System.out.println("Methode First Fit : "+firstFit+"% de remplissage");
        System.out.println("Methode First Fit Decreasing : "+firstFitDecreasing+"% de remplissage");
        
        if (firstFit >= firstFitDecreasing){
            
            System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
            _conteneur.clone(cFirstFit);
            _conteneur.afficherValues();
            
        }
        
        if (firstFit < firstFitDecreasing){
            
            System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
            _conteneur.clone(cFirstFitDecreasing);
            _conteneur.afficherValues();
        }
        
        
    }
    
    // fonction permettant de lancer les deux algorithmes de tri et de retenir le plus optimisé    
    public static void testOptimisationAlgorithmeTri2D(TabItem2D _tabItem, Conteneur2D _conteneur, int _nbSousconteneur){
        
        Conteneur2D cFirstFit = new Conteneur2D();
        Conteneur2D cFirstFitDecreasing = new Conteneur2D();
        
        cFirstFit.clone(_conteneur);
        cFirstFitDecreasing.clone(_conteneur);
        
        double firstFit;
        double firstFitDecreasing;
        
        firstFit = firstFit2D(_tabItem, cFirstFit, _nbSousconteneur);
        firstFitDecreasing = firstFitDecreasing2D(_tabItem, cFirstFitDecreasing, _nbSousconteneur);
        
        System.out.println("Methode First Fit : "+firstFit+"% de remplissage");
        System.out.println("Methode First Fit Decreasing : "+firstFitDecreasing+"% de remplissage");
        
        if (firstFit >= firstFitDecreasing){
            
            System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
            _conteneur.clone(cFirstFit);
            _conteneur.afficherValues();
            
        }
        
        if (firstFit < firstFitDecreasing){
            
            System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
            _conteneur.clone(cFirstFitDecreasing);
            _conteneur.afficherValues();
        }
        
        
    }
    
    public static double firstFit1D(TabItem1D _tabItem, Conteneur1D _conteneur, int _nbSousConteneur){
        
        int compteur;
        boolean sousConteneurLibre;
        int cptSousConteneur;
        int i;
        int numConteneur;
        double remplissage = 0;
       
        for(int k = 0 ; k < _tabItem.getNbItem() ; k++){
           
           sousConteneurLibre = false;
           cptSousConteneur = 1;
           numConteneur = 0;
           i = 0;
           
            do{

                compteur = 0;
                if ( i >= _conteneur.getTailleX()) break;
                
                do{
                    
                    //if ( i >= _conteneur.getTailleX()) break;
                    if(_conteneur.getX(i)== -1) compteur++;
                    i++;
                    if ( i >= _conteneur.getTailleX()) break;
                    
                } while (_conteneur.getID(i) == cptSousConteneur);

                if (compteur >= (_tabItem.getItem(k).getTailleX())){ 

                    sousConteneurLibre = true;
                    numConteneur = cptSousConteneur;

                }

                cptSousConteneur++;

            } while(sousConteneurLibre == false && cptSousConteneur <= _nbSousConteneur);

            if (sousConteneurLibre == true ){

                i=0;


                while (_conteneur.getID(i) != numConteneur || _conteneur.getX(i) != -1 ){
                    
                    i++;

                }

                for(int j = i ; j < _tabItem.getItem(k).getTailleX()+i ; j++){

                    _conteneur.setX(j, _tabItem.getItem(k).getID());

                }


            }
        }
        
        for (i = 0 ; i < _conteneur.getTailleX() ; i++){
            
            if (_conteneur.getX(i) != -1) remplissage++;
            
        }
        
        remplissage = (remplissage/_conteneur.getTailleX())*100;
        return remplissage;
        
    
    
    }
    
    public static double firstFitDecreasing1D(TabItem1D _tabItem, Conteneur1D _conteneur, int _nbSousConteneur){
        
        double remplissage;
        
        _tabItem.triSelectionDecroissant();
        remplissage = firstFit1D(_tabItem, _conteneur, _nbSousConteneur);
        
        return remplissage;
        
    }
    
    // algorithme en firstfit
    // firstfit : vérifie si l'item rentre, si il rentre on le place dans le conteneur, si il ne rentre pas on passe à l'item suivant
    // et ainsi de suite jusqu'à avoir essayé de placer tous les item
    
    // Pour ce faire, on vérifie si un item rentre dans un sous conteneur, si il trouve un sous conteneur dans lequel il rentre
    public static double firstFit2D(TabItem2D _tabItem, Conteneur2D _conteneur, int _nbSousConteneur){
        
        int compteurX;
        int compteurY;
        boolean sousConteneurLibre;
        int cptSousConteneur;
        double remplissage = 0;
        
        for(int k = 0 ; k < _tabItem.getNbItem() ; k++){
        
            int ii = 0;
            int jj = 0;
            sousConteneurLibre = false;
            cptSousConteneur = 0;
            
            
            // boucle permettant de vérifier si il y a un sous conteneur permettant d'accueillir l'item
            // sousConteneurLibre prend la valeur true si c'est le cas
            do{
                
                cptSousConteneur++;
                ii=0;
                compteurX=0;
                compteurY=0;
                
                while( ii < _conteneur.getTailleX() && sousConteneurLibre == false){

                    compteurY = 0;

                    while ( jj < _conteneur.getTailleY() && compteurY != _tabItem.getItem(k).getTailleY() ){

                        if(_conteneur.getXY(ii, jj) == -1 && cptSousConteneur == _conteneur.getID(ii, jj)){
                            
                            compteurY++;
                            
                        }
                        jj++;

                    }
                    
                    if(compteurY == _tabItem.getItem(k).getTailleY()) compteurX++;
                    if(compteurX == _tabItem.getItem(k).getTailleX()) sousConteneurLibre = true;
                    ii++;
                    jj=0;

                }


            } while (cptSousConteneur <= _nbSousConteneur && sousConteneurLibre==false);
            
            
            // si un sous conteneur est libre (sousConteneurLibre == true), on le place dans ce sous-conteneur
            if(sousConteneurLibre == true){
            
            compteurX=0;
            compteurY=0;
            int iii=0;
            int jjj=0;
            
                while(iii < _conteneur.getTailleX() && compteurX < _tabItem.getItem(k).getTailleX()){

                    while(jjj < _conteneur.getTailleY() && compteurY < _tabItem.getItem(k).getTailleY()){

                        if(cptSousConteneur == _conteneur.getID(iii, jjj) && _conteneur.getXY(iii, jjj)==-1){

                            _conteneur.setXY(iii, jjj, _tabItem.getItem(k).getID());
                            compteurY++;
                            if(compteurY == _tabItem.getItem(k).getTailleY()) compteurX++;
                            

                        }
                        jjj++;

                    }
                    if(compteurY != _tabItem.getItem(k).getTailleY()){
                                
                        for(int i=0 ; i<_conteneur.getTailleY() ; i++){

                            if(_conteneur.getXY(iii, i) == _tabItem.getItem(k).getID())

                                _conteneur.setXY(iii, i, -1);

                        }

                    }
                    iii++;
                    jjj=0;
                    compteurY=0;

                }
                
            }
            
        }
        
        // cette boucle permet à la fin du traitement de tous les item de définir le pourcentage de surface remplie du conteneur
        // (plus on s'approche de 100%, plus l'algorithme aura été efficace)
        
        for(int i = 0 ; i < _conteneur.getTailleX() ; i++){
            
            for(int j = 0 ; j < _conteneur.getTailleY() ; j++){
                
                if(_conteneur.getXY(i, j) != -1) remplissage++;
                
            }
            
        }
        
        remplissage = (remplissage/(_conteneur.getTailleX()*_conteneur.getTailleY()))*100;
        
        return remplissage;
        
    }
     
    // algorithme first fit decreasing
    // même principe que le first fit sauf que nous aurons au préalable classé les items du plus grand au plus petit
    
    public static double firstFitDecreasing2D(TabItem2D _tabItem, Conteneur2D _conteneur, int _nbSousConteneur){
        
        double remplissage;
        
        _tabItem.triSelectionDecroissant();
        remplissage = firstFit2D(_tabItem, _conteneur, _nbSousConteneur);
        
        return remplissage;
        
    }
    
    public final static void clearConsole()
    {
        
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
    
}
