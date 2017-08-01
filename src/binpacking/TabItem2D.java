/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;
import java.util.*;

/**
 *
 * @author remy.fischer
 */

// classe TabItem permettant de contenir des Item et de faire des opérations sur ce tableau


public class TabItem2D {
    
    private int nbItem;
    private ArrayList<Item2D> tabItem;
    
    
    public TabItem2D(){
        
        nbItem = 0;
        tabItem = new ArrayList<Item2D>();
        
    }
    
    public void AjoutItem(Item2D _item){
        
        tabItem.add(_item);
        nbItem++;
        
    }
    
    public Item2D getItem(int i){
        
        return tabItem.get(i);
        
    }

    public void SupprItem(int indice){
        
        if (tabItem.get(indice) != null ){
            
            tabItem.remove(indice);
            nbItem--;           
            
        }
        
    }
    
    // fonction permettant d'ajouter des items dans le tableau
    
    public void initTabItem(){
        
        Scanner sc = new Scanner(System.in);
        int nbItemAAjouter;
        int tailleXItem;
        int tailleYItem;
        
        System.out.println("Combien d'item souhaitez vous ajouter ?");
        nbItemAAjouter = sc.nextInt();
        
        for (int i = 0 ; i < nbItemAAjouter ; i++ ){
            
            System.out.println("Saisissez une taille X pour votre item");
            tailleXItem = sc.nextInt();
            System.out.println("Saisissez une taille Y pour votre item");
            tailleYItem = sc.nextInt();
            tabItem.add(new Item2D(tailleXItem, tailleYItem));
            nbItem++;
        }
        
    }
    
    public void afficherContenuFr(){
        
        System.out.println("-------------------------------");
        
        for(int i = 0 ; i < nbItem ; i++){
            
            System.out.println("Taille item " + i + " : " + (tabItem.get(i)).getTailleX()+" ; "+(tabItem.get(i)).getTailleY());
        
        }
        
        System.out.println("-------------------------------");
        
    }
    
    public void afficherContenuEn(){
        
        System.out.println("-------------------------------");
        
        for(int i = 0 ; i < nbItem ; i++){
            
            System.out.println("Item' size " + i + " : " + (tabItem.get(i)).getTailleX()+" ; "+(tabItem.get(i)).getTailleY());
        
        }
        
        System.out.println("-------------------------------");
        
    }
            
            
         
    
    public int getNbItem(){
        
        return nbItem;
        
    }
    
    // fonction permettant de retourner la plus grande dimension X de tous les items présents dans le tableau
    
    public int getPlusGrandeDimensionX(){
        
        int maxX = -1;
        
        for(int i=0 ; i < nbItem ; i++){
            
            if(tabItem.get(i).getTailleX() > maxX ){
                
                maxX = tabItem.get(i).getTailleX();
                
            }
            
        }
        
        return maxX;
        
    }
    
     // fonction permettant de retourner la plus grande dimension Y de tous les items présents dans le tableau
    
    public int getPlusGrandeDimensionY(){
        
        int maxY = -1;
        
        for(int i=0 ; i < nbItem ; i++){
            
            if(tabItem.get(i).getTailleY() > maxY ){
                
                maxY = tabItem.get(i).getTailleY();
                
            }
            
        }
        
        return maxY;
        
    }
    
    public void randomize(char langue){
        
        Scanner sc = new Scanner(System.in);
        int nbItemAAjouter;
        int xMax, yMax;
        
        System.out.println("Combien d'item voulez vous créer ?");
        nbItemAAjouter = sc.nextInt();
        System.out.println("Donnez la dimension x maximale");
        xMax = sc.nextInt();
        System.out.println("Donnez la dimension y maximale");
        yMax = sc.nextInt();
        
        int x,y;
        Item2D[] item = new Item2D[nbItemAAjouter];
        
        for(int i = 0 ; i < nbItemAAjouter ; i++){
            
            x = (int)((Math.random() * xMax)+1);
            y = (int)((Math.random() * yMax)+1);
            
            item[i] = new Item2D(x, y);
            
            this.AjoutItem(item[i]);
            
        }
        
        if(langue == 'f' || langue == 'F') {
            
            this.afficherContenuFr();
            
        } else {
            
            this.afficherContenuEn();
            
        }
        
        
        
        
    }
    
      public void randomize(int _nbItemAAjouter, int _xMax, int _yMax, char langue){
        
        int x,y;
        Item2D[] item = new Item2D[_nbItemAAjouter];
        
        for(int i = 0 ; i < _nbItemAAjouter ; i++){
            
            x = (int)((Math.random() * _xMax)+1);
            y = (int)((Math.random() * _yMax)+1);
            
            item[i] = new Item2D(x, y);
            
            this.AjoutItem(item[i]);
            
        }
        
        if(langue == 'f' || langue == 'F') {
            
            this.afficherContenuFr();
            
        } else {
            
            this.afficherContenuEn();
            
        }       
        
        
    }
    
    // fonction permettant de trier les items par ordre décroissant de surface
    // on utilise la méthode du tri par selection
    
    public void triSelectionDecroissant(){
        
        int i, j, k, max;
        Item2D _max;
        i=0;
        while (i < this.getNbItem() - 1 ){
            
            k = i;
            max = this.getItem(k).getTailleX() * this.getItem(k).getTailleY();
            _max = this.getItem(k);
            j=i+1;
            while(j <= this.getNbItem() -1){
                
                if(this.getItem(j).getTailleX() * this.getItem(j).getTailleY() > max){
                    
                    k = j;
                    max = this.getItem(k).getTailleX() * this.getItem(k).getTailleY();
                    _max = this.getItem(k);
                    
                }
                j++;
                
            }
            tabItem.set(k, this.getItem(i));
            tabItem.set(i, _max);
            i++;
            
        }
        
    }
    
    
    
}
