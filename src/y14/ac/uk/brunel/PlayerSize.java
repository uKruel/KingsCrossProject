package y14.ac.uk.brunel;
/**
 * This class allows the user to select how many players will join the game
 * ONLY for the management of players
 * Initial Creator: Lucaci Paul Marian
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PlayerSize {

	JDialog frmSimongamesize;
	private JTextField textField;
	private int sizeP;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSize window = new PlayerSize();
					window.frmSimongamesize.setVisible(true);
					window.frmSimongamesize.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSize() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimongamesize = new JDialog();
		frmSimongamesize.setTitle("SimonGame [Step-1]");
		frmSimongamesize.setBounds(100, 100, 307, 162);
		frmSimongamesize.setModal(true);
		frmSimongamesize.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Add Size");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				try{
					sizeP = Integer.parseInt(textField.getText()); // WARNING: Must treat exception for strings, like letters - BUG
					if(sizeP >=2 && sizeP<=9) {
						setSizeP(sizeP);
						frmSimongamesize.dispose();
					} else {
						JOptionPane.showMessageDialog(null, 
	                              "The size must be within the range of 2 up to 9 players!", 
	                              "Ambigous Input", 
	                              JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception e) {e.printStackTrace();}
			}
		});
		
		textField = new JTextField("2");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTellMeHow = new JLabel("How many players will join?");
		lblTellMeHow.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmSimongamesize.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTellMeHow)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, 83, 83, 83)
								.addComponent(btnNewButton, Alignment.TRAILING))
							.addGap(38)))
					.addGap(64))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTellMeHow, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmSimongamesize.getContentPane().setLayout(groupLayout);

	}

	/**
	 * Set the size of the game
	 * @param size
	 */
	public void setSizeP(int size) {
		this.sizeP = size;
	}
	
	/**
	 * Get the size of the game
	 * @return size
	 */
	public int getSizeP() {
		return this.sizeP;
	}
	
}
