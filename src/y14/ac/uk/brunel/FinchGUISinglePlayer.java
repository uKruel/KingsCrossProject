package y14.ac.uk.brunel;
/**
 * This class is for Singleplayer ONLY
 * DO NOT include the game algorithm here
 * ONLY for the management of GUI
 * Initial Creator: Limbu Anish
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FinchGUISinglePlayer {
	
    protected Icon RedFinchIcon     = new ImageIcon(getClass().getResource("FinchRedImage.jpg"));
    protected Icon GreenFinchIcon   = new ImageIcon(getClass().getResource("FinchGreenImage.jpg"));
    protected Icon BlueFinchIcon    = new ImageIcon(getClass().getResource("FinchBlueImage.jpg"));
    protected Icon YellowFinchIcon  = new ImageIcon(getClass().getResource("FinchYellowImage.jpg"));    
    protected Icon AllFinchesIcon   = new ImageIcon(getClass().getResource("FinchesImage.jpg"));
    protected Icon BeakUpFinchIcon  = new ImageIcon(getClass().getResource("FinchBeakUpImage.jpg"));
    protected Icon FinchesImages[] = {RedFinchIcon, GreenFinchIcon, BlueFinchIcon, YellowFinchIcon};

	protected PlayerSelection ps;
    protected ArrayList<Player> players = new ArrayList<Player>();
    JFrame spFrame;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FinchGUISinglePlayer window = new FinchGUISinglePlayer();
					window.spFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public FinchGUISinglePlayer() {
    	initialize();
    }
    
    private void initialize() {
    	/**
    	 * Letting the app know this is a 1-player game
    	 * Set the amount of players, pass it to the PlayerSelection manager,
    	 * passing back the ArrayList<Players> to this class for using the names 
    	 */
    	ps = new PlayerSelection(1);
    	ps.frmSimongameplayerselection.setResizable(false);
    	ps.frmSimongameplayerselection.setVisible(true);
    	this.players = ps.setPlayers();
    	
    	/**
    	 * Starting the Singleplayer GUI 
    	 */
    	spFrame = new JFrame();
    	spFrame.setTitle("SimonGame [Singleplayer]");
    	spFrame.setBounds(100, 100, 637, 523);
    	spFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	/**
    	 * GameManager is being called for SinglePlayer
    	 * Let the match begin!
    	 */
        GameManager gm = new GameManager(players);
    	gm.startGame();
    	
    	JLabel simonLabel = new JLabel("The SimonFinches"); /**/ simonLabel.setFont(new Font("Calibri", Font.BOLD, 30));
    	JLabel playerOneNameLabel = new JLabel(players.get(0).getName() + "'s score: ");
    	JLabel playerOneScoreLabel = new JLabel(Integer.toString(players.get(0).getScore()));
    	JLabel playerOneLivesLabelText = new JLabel(players.get(0).getName() + "'s lives: ");
    	JLabel playerOneLivesLabel = new JLabel((Integer.toString(players.get(0).getLives())));
        JLabel finchesImagesLabel = new JLabel(AllFinchesIcon);
        JTextArea resultArea = new JTextArea(15, 52); /**/ resultArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GroupLayout groupLayout = new GroupLayout(spFrame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(finchesImagesLabel)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(60)
        			.addComponent(playerOneNameLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(playerOneScoreLabel)
        			.addGap(228)
        			.addComponent(playerOneLivesLabelText)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(playerOneLivesLabel)
        			.addGap(80))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(198)
        			.addComponent(simonLabel)
        			.addContainerGap(199, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(simonLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(finchesImagesLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(playerOneLivesLabel)
        				.addComponent(playerOneLivesLabelText)
        				.addComponent(playerOneNameLabel)
        				.addComponent(playerOneScoreLabel))
        			.addGap(18)
        			.addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(156))
        );
        spFrame.getContentPane().setLayout(groupLayout);
    }
}