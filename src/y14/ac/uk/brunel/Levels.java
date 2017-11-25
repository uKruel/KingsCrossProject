package y14.ac.uk.brunel;
/**
 * This class contains the Level switch
 * DO NOT include GUI elements here
 * It constructs the levels of the game
 * Initial Creator: Lungu Dragos
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
public  class Levels
{     
   private int[] levelArray = new int[2];
   
   public Levels() {
       
   }
   
   public int[] setLevel(int lvl) {
       
       switch(lvl){
           
           case 1:
            levelArray[0]=1; levelArray[1]=3;
            return levelArray;
           
           case 2:
             levelArray[0]=4; levelArray[1]=6;
             return levelArray;
           
           case 3:
             levelArray[0]=7; levelArray[1]=10;
             return levelArray;
           
           case 4:
            levelArray[0]=11; levelArray[1]=15;
            return levelArray;
           
           default:
            return null;
       }
    }
}