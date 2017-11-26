package y14.ac.uk.brunel;
/**
 * This class is for Multiplayer ONLY
 * DO NOT include the game algorithm here
 * ONLY for the management of GUI
 * Initial Creator: Limbu Anish
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

import y14.ac.uk.brunel.FinchGUIMultiPlayer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FinchGUIMultiPlayer {
	
	protected Icon RedFinchIcon = new ImageIcon(getClass().getResource("FinchRedImage.jpg"));
    protected Icon GreenFinchIcon = new ImageIcon(getClass().getResource("FinchGreenImage.jpg"));
    protected Icon BlueFinchIcon = new ImageIcon(getClass().getResource("FinchBlueImage.jpg"));
    protected Icon YellowFinchIcon = new ImageIcon(getClass().getResource("FinchYellowImage.jpg"));    
    protected Icon AllFinchesIcon = new ImageIcon(getClass().getResource("FinchesImage.jpg"));
    protected Icon BeakUpFinchIcon = new ImageIcon(getClass().getResource("FinchBeakUpImage.jpg"));
    protected Icon FinchesImages[] = {RedFinchIcon, GreenFinchIcon, BlueFinchIcon, YellowFinchIcon};
    
    protected PlayerSelection ps; protected PlayerSize psz = new PlayerSize();
    protected ArrayList<Player> players = new ArrayList<Player>();
    JFrame mpFrame;
    private JTable table;
	private GameManager gm;
	protected LevelSelection lvlsel;
	
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinchGUIMultiPlayer window = new FinchGUIMultiPlayer();
					window.mpFrame.setVisible(true);
					window.mpFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public FinchGUIMultiPlayer() { 
    	initialize();
    }
    
	private void initialize() {
		
		/**
    	 * Letting the app know this is a more-than-1-player game
    	 * Set the amount of players, pass it to the PlayerSelection manager,
    	 * passing back the ArrayList<Players> to this class for using the names.
    	 * Closing the form if user's input is not valid
    	 */
		psz.frmSimongamesize.setResizable(false);
		psz.frmSimongamesize.setVisible(true);
    	ps = new PlayerSelection(psz.getSizeP(), "SimonGame[Step-2]");
    	ps.frmSimongameplayerselection.setResizable(false);
    	ps.frmSimongameplayerselection.setVisible(true);
    	this.players = ps.setPlayers();
    	
    	/**
    	 * Picking the initial level to start from
    	 */
    	lvlsel = new LevelSelection("SimonGame [Step-3]");
    	lvlsel.frmSimongamelevel.setResizable(false);
    	lvlsel.frmSimongamelevel.setVisible(true);
		Player.levels = lvlsel.getLevel();
    	
    	/**
    	 * Starting the Multiplayer GUI 
    	 */
		mpFrame = new JFrame();
		mpFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gm.stopGame();
			}
		});
		mpFrame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				gm.stopGame();
			}
		});
		mpFrame.setTitle("SimonGame [Multiplayer]");
		mpFrame.setBounds(100, 100, 643, 588);
		mpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel simonLabel = new JLabel("The SimonFinches"); /**/ simonLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        JLabel finchesImagesLabel = new JLabel(AllFinchesIcon);
    	
    	/**
    	 * Setting up the GUI environment
    	 */
        
        JScrollPane scrollPane = new JScrollPane();
        GroupLayout groupLayout = new GroupLayout(mpFrame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        				.addComponent(finchesImagesLabel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(183)
        					.addComponent(simonLabel)))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(23)
        			.addComponent(simonLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(finchesImagesLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        /**
         * Table Data and Heading
         */
        table = new JTable(psz.getSizeP(), 4);
        table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("PlayerName");
        table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Score");
        table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Lives");
        table.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Level");
        table.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer cellRender= new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.getColumn("PlayerName").setCellRenderer(cellRender);
        table.getColumn("Score").setCellRenderer(cellRender);
        table.getColumn("Lives").setCellRenderer(cellRender);
        table.getColumn("Level").setCellRenderer(cellRender);
        table.setRowHeight(40);
        table.repaint();
        
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        fillTableData(new GameManager(players));
        
        /**
    	 * GameManager is being called for MultiPlayer
    	 * Let the match begin!
    	 */
        gm = new GameManager(players);
        updateTable(table,gm);
    	gm.startGame();
    	
    	//Final bind
        mpFrame.getContentPane().setLayout(groupLayout);
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
		int i;
		for(i=0;i<psz.getSizeP();i++) {
			table.setValueAt(gm.getPlayers().get(i).getName(), i, 0);
			table.setValueAt(gm.getPlayers().get(i).getScore(), i, 1);
			table.setValueAt(gm.getPlayers().get(i).getLives(), i, 2);
			table.setValueAt(Player.levels, i, 3);
		}
	}
}
