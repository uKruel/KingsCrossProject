package y14.ac.uk.brunel;
/*
 * This class is the first one to run on application start-up
 * DO NOT include the game algorithm here
 * ONLY for the management of GUI
 * Initial Creator: Limbu Anish
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FinchGameMainFrame {
	
    JFrame mainFrame; 
    
    /*private String finchFacts[] = {"Did you know that Finch can be programmed using many different programming languages? For example C, C++, Python, etc",
                                   "Did you know that Finch robot has many different methods you can use to program it?",
                                   "Did you know that Finch robot has many sensors that can be used to interact with its environment?",
                                   "Did you know that Finch suppports varieties of IDE? Such as Code::Blocks, BlueJ, Eclipse, Visual Studio, etc." };*/
    
    public FinchGameMainFrame() {
    	initialize();
    }
        
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinchGameMainFrame window = new FinchGameMainFrame();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    private void initialize() {
    	mainFrame = new JFrame();
    	mainFrame.setTitle("SimonGame [MainMenu]");
    	mainFrame.setBounds(100, 100, 519, 370);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setResizable(false);
    	
    	JButton singlePlayerButton = new JButton("Singleplayer");
    	JButton multiPlayerButton = new JButton("Multiplayer");
    	
        singlePlayerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		FinchGUISinglePlayer finchSinglePlayerFrame = new FinchGUISinglePlayer();
        		finchSinglePlayerFrame.spFrame.setVisible(true);
        		finchSinglePlayerFrame.spFrame.setResizable(false);
        	}        
        });
        multiPlayerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		FinchGUIMultiPlayer finchMultiPlayerFrame = new FinchGUIMultiPlayer();
        		finchMultiPlayerFrame.mpFrame.setVisible(true);
        		finchMultiPlayerFrame.mpFrame.setResizable(false);
        	}
        });
        
        //SecureRandom randomEngine = new SecureRandom(); /**/ int randomValue = randomEngine.nextInt(finchFacts.length);
        JLabel labelNameOne = new JLabel("Powered By Yellow14"); /**/ labelNameOne.setFont(new Font("Calibri", Font.BOLD, 15));
        JLabel imageIconLabel = new JLabel(new ImageIcon(getClass().getResource("finch.jpg")));
        //imageIconLabel.setHorizontalAlignment(SwingConstants.LEADING);/**/ imageIconLabel.setToolTipText(finchFacts[randomValue]);
        GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(singlePlayerButton, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        							.addGap(54)
        							.addComponent(multiPlayerButton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addComponent(labelNameOne)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(144)
        					.addComponent(imageIconLabel)))
        			.addContainerGap(114, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(imageIconLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(singlePlayerButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        				.addComponent(multiPlayerButton, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        			.addGap(41)
        			.addComponent(labelNameOne)
        			.addContainerGap())
        );
        mainFrame.getContentPane().setLayout(groupLayout);
    }
    
}
