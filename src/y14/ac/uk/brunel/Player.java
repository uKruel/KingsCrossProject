package y14.ac.uk.brunel;
/**
 * This class contains properties of each player
 * DO NOT include GUI elements here
 * ONLY for the management of players
 * Initial Creator: Limbu Anish
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */

public class Player {
    private String name;
    private int score = 0;
    private int lives = 3;
    public static int levels=1;
    private boolean isAlive=true;
    
    public Player(String name) {
    	this.setName(name);
    }            
    
    private void setName(String name) {
    		this.name = name;
    }
    
    public void incrementScore() {
        this.score += 1;
    }
    
    public void decreaseScore() {
    		score--;
        if(score <= 0) {
        		score = 0;
        }
    }
    
    public void decrementLives() {
        lives--;
        if(lives <= 0) {
            lives = 0;
            setIsAlive(false);
        }
    }
    
    public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
    
    public boolean getIsAlive() {
    		return this.isAlive;
    }

	public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }    
    
    public int getLives() {
        return this.lives;
    }
}
