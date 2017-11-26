package y14.ac.uk.brunel;
/**
 * This class allows the user to select names for players
 * ONLY for the management of players' names
 * Initial Creator: Lucaci Paul Marian
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PlayerSelection {

	JDialog frmSimongameplayerselection;
	private JTextField txtAddPlayerName;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	public static int nPlayers;
	public static String title;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PlayerSelection window = new PlayerSelection(nPlayers, title);
					window.frmSimongameplayerselection.setVisible(true);
					window.frmSimongameplayerselection.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSelection(int nPlayers, String title) {
		initialize();
		PlayerSelection.nPlayers = nPlayers;
		PlayerSelection.title = title;
		frmSimongameplayerselection.setTitle(title);
	}
	
	public ArrayList<Player> setPlayers() {
		return this.players;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimongameplayerselection = new JDialog();
		frmSimongameplayerselection.setTitle(title);
		frmSimongameplayerselection.setBounds(100, 100, 300, 155);
		frmSimongameplayerselection.setModal(true);
		frmSimongameplayerselection.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JLabel lblPlayerName = new JLabel("Player #1 Name:");
		txtAddPlayerName = new JTextField();
		txtAddPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddPlayerName.setText("Add Player #1 Name");
		txtAddPlayerName.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Player");
		btnNewButton.addActionListener(new ActionListener() {
			int i=1;
			public void actionPerformed(ActionEvent arg0) {
				if(i<=nPlayers) {
					players.add(new Player(txtAddPlayerName.getText()));
					if(i<nPlayers) {
						txtAddPlayerName.setText("Add Player #"+(int)(i+1)+" Name");
						lblPlayerName.setText("Player #"+(int)(i+1)+" Name:");
					}
				}
				i++;
				if(i>nPlayers) {
					setPlayers();
					frmSimongameplayerselection.dispose();
				}

			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmSimongameplayerselection.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPlayerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(txtAddPlayerName, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(88)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAddPlayerName)
						.addComponent(lblPlayerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(20))
		);
		
		frmSimongameplayerselection.getContentPane().setLayout(groupLayout);
	}
}
