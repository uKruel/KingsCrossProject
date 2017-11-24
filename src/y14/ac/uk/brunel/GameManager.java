package y14.ac.uk.brunel;
/*
 * This class serves as the core engine of application
 * DO NOT include GUI elements here
 * ONLY for generating the final result
 * Initial Creator: Lucaci Paul Marian
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import java.util.ArrayList;

/**
 * 
 * Class to be discussed/explained
 *
 */
public class GameManager {
	
	private int nPlayers;
	private int[] seq, seqInput;
	private ArrayList<Player> players = new ArrayList<Player>();
	public GameManager(ArrayList<Player> players){
		this.players = players;
		this.nPlayers = players.size();
	}
	
	private boolean seqGenerator(int level) {
		return false;
		
	}
	
	private boolean seqChecker() {
		return false;
		
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public void startGame() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
