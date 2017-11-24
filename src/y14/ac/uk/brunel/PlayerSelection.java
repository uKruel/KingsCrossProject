package y14.ac.uk.brunel;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class PlayerSelection {

	JDialog frmSimongameplayerselection;
	private JTextField txtAddPlayerName;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	public static int nPlayers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PlayerSelection window = new PlayerSelection(nPlayers);
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
	public PlayerSelection(int nPlayers) {
		initialize();
		PlayerSelection.nPlayers = nPlayers;
	}

	public ArrayList<Player> setPlayers() {
		return this.players;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimongameplayerselection = new JDialog();
		frmSimongameplayerselection.setTitle("SimonGame [PlayerSelection]");
		frmSimongameplayerselection.setBounds(100, 100, 300, 155);
		frmSimongameplayerselection.setModal(true);
		frmSimongameplayerselection.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel lblPlayerName = new JLabel("Player #1 Name:");
		txtAddPlayerName = new JTextField();
		txtAddPlayerName.setText("Add Player #1 Name");
		txtAddPlayerName.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Player");
		btnNewButton.addActionListener(new ActionListener() {
			int i=1;
			public void actionPerformed(ActionEvent arg0) {
				if(i<=nPlayers) {
					players.add(new Player(txtAddPlayerName.getText()));
					if(i<3) {
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
							.addGap(87)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblPlayerName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAddPlayerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAddPlayerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlayerName))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmSimongameplayerselection.getContentPane().setLayout(groupLayout);
	}
}
