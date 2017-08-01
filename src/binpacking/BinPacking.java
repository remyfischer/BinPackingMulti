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
        char langue;
        Scanner sc = new Scanner(System.in);
        
        // Variables algorithme binpacking
        
        int tailleX;
        int tailleY;
        int tailleZ;
        int maxDimX;
        int maxDimY;
        int maxDimZ;
        int nbSousConteneur;
        int tailleXMax;
        int tailleYMax;
        int tailleZMax;
        int nbItem;

            
        System.out.println("Choisissez votre langue / Choose your language");
        System.out.println("Appuyez sur F pour Français - F");
        System.out.println("Press E for English - E");
        langue = testSaisie('e', 'E', 'f', 'F');
            

        
        
        if (langue == 'f' || langue == 'F'){
            
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
                    
                    System.out.println("-------------------------------");
                    System.out.println("Espace 1 dimension");
                    System.out.println("-------------------------------");
                    System.out.println();
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
                        tailleXMax = rand(3,5);
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre();                     
                                         
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Saisir une taille X");
                        tailleX = sc.nextInt();
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        
                        if(tailleX >5){
                            tailleXMax = rand(3,tailleX/2);
                        } else tailleXMax = rand(1,3);
                        
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre();
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Saisir une taille X");
                        tailleX = sc.nextInt();
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        
                        tabItem.initTabItem();
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        tabItem.afficherContenuFr();
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre(); 
                        
                    }
                    
                    

                }

                if (saisie == '2'){

                    clearConsole();
                    
                    System.out.println("-------------------------------");
                    System.out.println("Espace 2 dimensions");
                    System.out.println("-------------------------------");
                    System.out.println();
                    System.out.println("1 - Faire un test aléatoire");
                    System.out.println("2 - Test sans valeur");
                    System.out.println("3 - Test avec valeurs");
                    System.out.println();
                    System.out.println("R - Retour");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        tailleX = rand(8,16);
                        tailleY = rand(8,16);
                        System.out.println("Taille du conteneur : " + tailleX +";" + tailleY);
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        tailleXMax = rand(3,5);
                        tailleYMax = rand(3,5);
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, tailleYMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre(); 
                        
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Saisir une taille X");
                        tailleX = sc.nextInt();
                        System.out.println("Saisir une taille Y");
                        tailleY = sc.nextInt();
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        
                        if(tailleX >5){
                            tailleXMax = rand(3,tailleX/2);
                        } else tailleXMax = rand(1,3);
                        
                        if(tailleY >5){
                            tailleYMax = rand(3,tailleY/2);
                        } else tailleYMax = rand(1,3);
                        
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, tailleYMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre(); 
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Saisir une taille X");
                        tailleX = sc.nextInt();
                        System.out.println("Saisir une tailleY");
                        tailleY = sc.nextInt();
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        
                        tabItem.initTabItem();
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        tabItem.afficherContenuFr();
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        poursuivre(); 
                        
                    }

                }

                if (saisie == '3'){

                    clearConsole();
                    
                    System.out.println("-------------------------------");
                    System.out.println("Espace 3 dimensions");
                    System.out.println("-------------------------------");
                    System.out.println();
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
        
        if (langue == 'e' || langue == 'E'){
            
            do{
                
                clearConsole();
                
                System.out.println("1 - 1 dimensional space");
                System.out.println("2 - 2 dimensional space");
                System.out.println("3 - 3 dimensional space");
                System.out.println();
                System.out.println("E - Exit");
                saisie = testSaisie('1', '2', '3', 'e', 'E');
               
                
                if (saisie == '1'){

                    
                    clearConsole();
                    
                    System.out.println("-------------------------------");
                    System.out.println("1 dimensional space");
                    System.out.println("-------------------------------");
                    System.out.println();
                    System.out.println("1 - Random test");
                    System.out.println("2 - Test without values");
                    System.out.println("3 - Test with values");
                    System.out.println();
                    System.out.println("R - Return");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        tailleX = rand(8,16);
                        System.out.println("Container' size : " + tailleX);
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        tailleXMax = rand(3,5);
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();                       
                                         
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Key in X size");
                        tailleX = sc.nextInt();
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        
                        if(tailleX >5){
                            tailleXMax = rand(3,tailleX/2);
                        } else tailleXMax = rand(1,3);
                        
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();  
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Key in X size");
                        tailleX = sc.nextInt();
                        Conteneur1D conteneur = new Conteneur1D(tailleX);
                        conteneur.init();
                        
                        TabItem1D tabItem = new TabItem1D();
                        
                        tabItem.initTabItem();
                        
                        maxDimX = tabItem.getPlusGrandeDimension();
                        nbSousConteneur = conteneur.split(maxDimX);
                        
                        tabItem.afficherContenuEn();
                        
                        testOptimisationAlgorithmeTri1D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();   
                        
                    }
                    
                    

                }

                if (saisie == '2'){

                    clearConsole();
                    
                    System.out.println("-------------------------------");
                    System.out.println("2 dimensional space");
                    System.out.println("-------------------------------");
                    System.out.println();
                    System.out.println("1 - Random test");
                    System.out.println("2 - Test without values");
                    System.out.println("3 - Test with values");
                    System.out.println();
                    System.out.println("R - Return");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        tailleX = rand(8,16);
                        tailleY = rand(8,16);
                        System.out.println("Container' size : " + tailleX +";" + tailleY);
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        tailleXMax = rand(3,5);
                        tailleYMax = rand(3,5);
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, tailleYMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();   
                        
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Key in X size");
                        tailleX = sc.nextInt();
                        System.out.println("Key in Y size");
                        tailleY = sc.nextInt();
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        
                        if(tailleX >5){
                            tailleXMax = rand(3,tailleX/2);
                        } else tailleXMax = rand(1,3);
                        
                        if(tailleY >5){
                            tailleYMax = rand(3,tailleY/2);
                        } else tailleYMax = rand(1,3);
                        
                        nbItem = rand(8,16);
                        tabItem.randomize(nbItem, tailleXMax, tailleYMax, langue);
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();   
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Key in X size");
                        tailleX = sc.nextInt();
                        System.out.println("Key in Y size");
                        tailleY = sc.nextInt();
                        Conteneur2D conteneur = new Conteneur2D(tailleX, tailleY);
                        conteneur.init();
                        
                        TabItem2D tabItem = new TabItem2D();
                        
                        tabItem.initTabItem();
                        
                        maxDimX = tabItem.getPlusGrandeDimensionX();
                        maxDimY = tabItem.getPlusGrandeDimensionY();
                        nbSousConteneur = conteneur.split(maxDimX, maxDimY);
                        
                        tabItem.afficherContenuEn();
                        
                        testOptimisationAlgorithmeTri2D(tabItem, conteneur, nbSousConteneur, langue);
                        
                        pursue();   
                        
                    }

                }

                if (saisie == '3'){

                    clearConsole();
                    
                    System.out.println("-------------------------------");
                    System.out.println("3 dimensional space");
                    System.out.println("-------------------------------");
                    System.out.println();
                    System.out.println("1 - Random test");
                    System.out.println("2 - Test without values");
                    System.out.println("3 - Test with values");
                    System.out.println();
                    System.out.println("R - Return");                  
                    saisie = testSaisie('1', '2', '3', 'r', 'R');
                    
                    if(saisie == '1'){
                        
                        clearConsole();
                        
                        System.out.println("Not available at the moment");
                        pursue();                          
                        
                    }
                    
                    if(saisie == '2'){
                        
                        clearConsole();
                        
                        System.out.println("Not available at the moment");
                        pursue();                          
                        
                    }
                    
                    if(saisie == '3'){
                        
                        clearConsole();
                        
                        System.out.println("Not available at the moment");
                        pursue();                        
                        
                    }
                    

                }
                
                
            
            
            
            } while (saisie != 'e' && saisie != 'E');
            
        }
        
    }
    
    public static void poursuivre(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Appuyez sur une touche pour continuer...");
        sc.nextLine();
        
    }
    
    public static void pursue(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Press any key...");
        sc.nextLine();
        
    }
    
    
    
    public static int rand(int a, int b){
        
        // fonction rand qui ne semble pas très bien fonctionner
        
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
    
        public static void testOptimisationAlgorithmeTri1D(TabItem1D _tabItem, Conteneur1D _conteneur, int _nbSousconteneur, char langue){
        
        Conteneur1D cFirstFit = new Conteneur1D();
        Conteneur1D cFirstFitDecreasing = new Conteneur1D();
        
        
        
        cFirstFit.clone(_conteneur);
        cFirstFitDecreasing.clone(_conteneur);
        
        double firstFit;
        double firstFitDecreasing;
        
        firstFit = firstFit1D(_tabItem, cFirstFit, _nbSousconteneur);
        firstFitDecreasing = firstFitDecreasing1D(_tabItem, cFirstFitDecreasing, _nbSousconteneur);
        
        if (langue == 'f' || langue == 'F'){
            
            _conteneur.afficherIDFr();
            System.out.println("Methode First Fit : "+firstFit+"% de remplissage");
            System.out.println("Methode First Fit Decreasing : "+firstFitDecreasing+"% de remplissage");
            
        } else {
            
            _conteneur.afficherIDEn();
            System.out.println("First fit method : "+firstFit+"% filling rate");
            System.out.println("First Fit Decreasing method: "+firstFitDecreasing+"% filling rate");
            
        }
        
        if (firstFit >= firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit method is more optimized, here is the result");
                
            }
            _conteneur.clone(cFirstFit);
            _conteneur.afficherValues();
            
        }
        
        if (firstFit < firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit decreasing method is more optimized, here is the result");
                
            }
            _conteneur.clone(cFirstFitDecreasing);
            _conteneur.afficherValues();
        }
        
        
    }
    
    // fonction permettant de lancer les deux algorithmes de tri et de retenir le plus optimisé    
    public static void testOptimisationAlgorithmeTri2D(TabItem2D _tabItem, Conteneur2D _conteneur, int _nbSousconteneur, char langue){
        
        Conteneur2D cFirstFit = new Conteneur2D();
        Conteneur2D cFirstFitDecreasing = new Conteneur2D();
        
        cFirstFit.clone(_conteneur);
        cFirstFitDecreasing.clone(_conteneur);
        
        
        
        double firstFit;
        double firstFitDecreasing;
        
        firstFit = firstFit2D(_tabItem, cFirstFit, _nbSousconteneur);
        firstFitDecreasing = firstFitDecreasing2D(_tabItem, cFirstFitDecreasing, _nbSousconteneur);
        
        if (langue == 'f' || langue == 'F'){
            
            _conteneur.afficherIDFr();
            System.out.println("Methode First Fit : "+firstFit+"% de remplissage");
            System.out.println("Methode First Fit Decreasing : "+firstFitDecreasing+"% de remplissage");
            
        } else {
            
            _conteneur.afficherIDEn();
            System.out.println("First fit method : "+firstFit+"% filling rate");
            System.out.println("First Fit Decreasing method: "+firstFitDecreasing+"% filling rate");
            
        }
        
        
        if (firstFit >= firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit method is more optimized, here is the result");
                
            }
            
            _conteneur.clone(cFirstFit);
            _conteneur.afficherValues();
            
        }
        
        if (firstFit < firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit decreasing method is more optimized, here is the result");
                
            }
            _conteneur.clone(cFirstFitDecreasing);
            _conteneur.afficherValues();
        }
        
        
    }
    
    public static void testOptimisationAlgorithmeTri3D(TabItem3D _tabItem, Conteneur3D _conteneur, int _nbSousconteneur, char langue){
        
        Conteneur3D cFirstFit = new Conteneur3D();
        Conteneur3D cFirstFitDecreasing = new Conteneur3D();
        
        cFirstFit.clone(_conteneur);
        cFirstFitDecreasing.clone(_conteneur);
        
        
        
        double firstFit;
        double firstFitDecreasing;
        
        firstFit = firstFit3D(_tabItem, cFirstFit, _nbSousconteneur);
        firstFitDecreasing = firstFitDecreasing3D(_tabItem, cFirstFitDecreasing, _nbSousconteneur);
        
        if (langue == 'f' || langue == 'F'){
            
            _conteneur.afficherIDFr();
            System.out.println("Methode First Fit : "+firstFit+"% de remplissage");
            System.out.println("Methode First Fit Decreasing : "+firstFitDecreasing+"% de remplissage");
            
        } else {
            
            _conteneur.afficherIDEn();
            System.out.println("First fit method : "+firstFit+"% filling rate");
            System.out.println("First Fit Decreasing method: "+firstFitDecreasing+"% filling rate");
            
        }
        
        if (firstFit >= firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit method is more optimized, here is the result");
                
            }
            _conteneur.clone(cFirstFit);
            _conteneur.afficherValues();
            
        }
        
        if (firstFit < firstFitDecreasing){
            
            if (langue == 'f' || langue == 'F'){
                
                System.out.println("La solution firstfit decreasing est la plus optimisée, voici le résultat");
                
            } else {
                
                System.out.println("The firstfit decreasing method is more optimized, here is the result");
                
            }
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
    
    public static double firstFit3D(TabItem3D _tabItem, Conteneur3D _conteneur, int _nbSousconteneur){
        
        double a = 0;
        return a;
        
    }
    
    public static double firstFitDecreasing3D(TabItem3D _tabItem, Conteneur3D _conteneur, int _nbSousConteneur){
        
        double remplissage;
        _tabItem.triSelectionDecroissant();
        remplissage = firstFit3D(_tabItem, _conteneur, _nbSousConteneur);
        
        return remplissage;
        
    }
    
    public final static void clearConsole()
    {
        
        // Solution de secours pour simuler un clearscreen
        // Voir si ce n'est pas possible d'implémenter une vraie fonction clearscreen
        
        for (int y = 0; y < 25; y++)
        System.out.println("\n");

        /*
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
        }*/
    }
    
}
