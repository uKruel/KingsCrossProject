package y14.ac.uk.brunel;
/**
 * This class serves as the core engine of application
 * DO NOT include GUI elements here
 * ONLY for generating the final result
 * Initial Creator: Lucaci Paul Marian
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

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
	private Finch redFinch = new Finch();
	private Finch greenFinch = new Finch();
	private Finch blueFinch = new Finch();
	private Finch yellowFinch = new Finch();
	private Finch beakupFinch = new Finch();
	private Finch[] finchArray = {redFinch, greenFinch, blueFinch, yellowFinch};
	private JFrame frame;
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
		while(!beakupFinch.isBeakDown()) {
			seqGenerator(level);
			for(Player player : getPlayers()) {
				if(!beakupFinch.isBeakUp()) {
					if(player.getIsAlive()) {
						
					}
				}
				else {
			        int input = JOptionPane.showConfirmDialog
			        		(
			        			null,
			                "Do you want to exit the game?",
			                "BeakUp Finch Detected",
			                JOptionPane.YES_NO_OPTION
			             );
			        if(input == JOptionPane.YES_OPTION) {
			        		
			        }
				}
			}
			
		}
		
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
