package y14.ac.uk.brunel;
/*
 * This class is for Multiplayer ONLY
 * DO NOT include the game algorithm here
 * ONLY for the management of GUI
 * Initial Creator: Limbu Anish
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import y14.ac.uk.brunel.FinchGUIMultiPlayer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FinchGUIMultiPlayer {
	
	protected Icon RedFinchIcon = new ImageIcon(getClass().getResource("FinchRedImage.jpg"));
    protected Icon GreenFinchIcon = new ImageIcon(getClass().getResource("FinchGreenImage.jpg"));
    protected Icon BlueFinchIcon = new ImageIcon(getClass().getResource("FinchBlueImage.jpg"));
    protected Icon YellowFinchIcon = new ImageIcon(getClass().getResource("FinchYellowImage.jpg"));    
    protected Icon AllFinchesIcon = new ImageIcon(getClass().getResource("FinchesImage.jpg"));
    protected Icon BeakUpFinchIcon = new ImageIcon(getClass().getResource("FinchBeakUpImage.jpg"));
    protected Icon FinchesImages[] = {RedFinchIcon, GreenFinchIcon, BlueFinchIcon, YellowFinchIcon};
    
    
    
    JFrame mpFrame;
    
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
		mpFrame = new JFrame();
		mpFrame.setTitle("SimonGame [Multiplayer]");
		mpFrame.setBounds(100, 100, 643, 588);
		mpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
		JLabel simonLabel = new JLabel("The SimonFinches"); /**/ simonLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        JLabel playerOneNameLabel = new JLabel(" " + playerOne.getName() + "'s score: ");
        JLabel playerOneScoreLabel = new JLabel(Integer.toString(playerOne.getScore()));
        JLabel playerOneLivesLabelText = new JLabel(" " + playerOne.getName() + "'s lives: ");
        JLabel playerOneLivesLabel = new JLabel((Integer.toString(playerOne.getLives())));
        JLabel playerTwoNameLabel = new JLabel(" " + playerTwo.getName() + "'s score: ");
        JLabel playerTwoScoreLabel = new JLabel(Integer.toString(playerTwo.getScore()));
        JLabel playerTwoLivesLabelText = new JLabel(" " + playerTwo.getName() + "'s lives: ");
        JLabel playerTwoLivesLabel = new JLabel((Integer.toString(playerTwo.getLives())));
        JLabel finchesImagesLabel = new JLabel(AllFinchesIcon);
        JTextArea resultArea = new JTextArea(15, 52); /**/ resultArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        GroupLayout groupLayout = new GroupLayout(mpFrame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        					.addGap(51)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(playerOneLivesLabelText)
        						.addComponent(playerOneNameLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(playerOneLivesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(playerOneScoreLabel))
        					.addGap(215)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(playerTwoNameLabel)
        						.addComponent(playerTwoLivesLabelText))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(playerTwoLivesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(playerTwoScoreLabel)))
        				.addComponent(finchesImagesLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(playerOneNameLabel)
        						.addComponent(playerOneScoreLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(playerOneLivesLabelText)
        						.addComponent(playerOneLivesLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(playerTwoNameLabel)
        						.addComponent(playerTwoScoreLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(playerTwoLivesLabelText)
        						.addComponent(playerTwoLivesLabel))))
        			.addGap(18)
        			.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        			.addContainerGap())
        );
        mpFrame.getContentPane().setLayout(groupLayout);

	}
    
}
