package y14.ac.uk.brunel;
/**
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
	
	private int nPlayers, level;
	private int[] seq, seqInput;
	private ArrayList<Player> players = new ArrayList<Player>();
	private boolean onGoing;
	public GameManager(ArrayList<Player> players){
		this.players = players;
		this.nPlayers = players.size();
		this.level = players.get(0).levels;
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
		setOnGoing(true);
	}
	
	public static void main(String[] args) {
		
	}
	
	public boolean isOnGoing() {
		return this.onGoing;
	}
	
	private void setOnGoing(boolean onGoing) {
		this.onGoing = onGoing;
	}

	public void stopGame() {
		setOnGoing(false);
		
	}
}
