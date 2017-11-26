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
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FinchGUISinglePlayer {
	
    protected Icon RedFinchIcon     = new ImageIcon(getClass().getResource("FinchRedImage.jpg"));
    protected Icon GreenFinchIcon   = new ImageIcon(getClass().getResource("FinchGreenImage.jpg"));
    protected Icon BlueFinchIcon    = new ImageIcon(getClass().getResource("FinchBlueImage.jpg"));
    protected Icon YellowFinchIcon  = new ImageIcon(getClass().getResource("FinchYellowImage.jpg"));    
    protected Icon AllFinchesIcon   = new ImageIcon(getClass().getResource("FinchesImage.jpg"));
    protected Icon BeakUpFinchIcon  = new ImageIcon(getClass().getResource("FinchBeakUpImage.jpg"));
    protected Icon FinchesImages[] = {RedFinchIcon, GreenFinchIcon, BlueFinchIcon, YellowFinchIcon};

	protected PlayerSelection ps; protected LevelSelection lvlsel;
    protected ArrayList<Player> players = new ArrayList<Player>();
    JFrame spFrame;
    private JTable table;
	private GameManager gm;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinchGUISinglePlayer window = new FinchGUISinglePlayer();
					window.spFrame.setVisible(true);
					window.spFrame.setResizable(false);
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
    	ps = new PlayerSelection(1, "SimonGame [Step-1]");
    	ps.frmSimongameplayerselection.setResizable(false);
    	ps.frmSimongameplayerselection.setVisible(true);
    	this.players = ps.setPlayers();
    	
    	/**
    	 * Picking the initial level to start from
    	 */
    	lvlsel = new LevelSelection("SimonGame [Step-2]");
    	lvlsel.frmSimongamelevel.setResizable(false);
    	lvlsel.frmSimongamelevel.setVisible(true);
		Player.levels = lvlsel.getLevel();
    	
    	/**
    	 * Starting the Singleplayer GUI 
    	 */
    	spFrame = new JFrame();
    	spFrame.addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowClosing(WindowEvent e) {
    			gm.stopGame();
    		}
    	});
    	spFrame.addComponentListener(new ComponentAdapter() {
    		@Override
    		public void componentHidden(ComponentEvent arg0) {
    			gm.stopGame();
    		}
    	});
    	spFrame.setTitle("SimonGame [Singleplayer]");
    	spFrame.setBounds(100, 100, 656, 387);
    	spFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	JLabel simonLabel = new JLabel("The SimonFinches"); /**/ simonLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        JLabel finchesImagesLabel = new JLabel(AllFinchesIcon);
        
        /**
         * Setting up the GUI environment
         */
        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(spFrame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(198)
        			.addComponent(simonLabel)
        			.addGap(30))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(finchesImagesLabel, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(simonLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(finchesImagesLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        /**
         * Table Data and Heading(PlayerNames)
         */
        table = new JTable(3, 1);
        table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue(players.get(0).getName());
        table.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer cellRender= new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.getColumn(players.get(0).getName()).setCellRenderer(cellRender);
        table.setRowHeight(43);
        table.repaint();
        
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        fillTableData(new GameManager(players));
        
        /**
    	 * GameManager is being called for SinglePlayer
    	 * Let the match begin!
    	 */
        gm = new GameManager(players);
        updateTable(table,gm);
    	gm.startGame();
    	
        //Final bind
        spFrame.getContentPane().setLayout(groupLayout);
    }
    
    /**
	 * Updating the table data*/
	private void updateTable(JTable table, GameManager gm) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
					if(gm.isOnGoing()) {
						fillTableData(gm);
					} else {
						this.cancel();
					}
				}
			},0,1*1000);
	}
	
	/**
	 * Fill the table with data
	 */
	private void fillTableData(GameManager gm) {
		table.setValueAt("Score: " + gm.getPlayers().get(0).getScore(), 0, 0);
		table.setValueAt("Lives: " + gm.getPlayers().get(0).getLives(), 1, 0);
		table.setValueAt("Level: " + Player.levels, 2, 0);
	}
}