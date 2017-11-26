package y14.ac.uk.brunel;
/**
 * This class allows the user to select the first level to start the game with
 * ONLY for the management of levels
 * Initial Creator: Lucaci Paul Marian
 * Developers: Lucaci Paul, Limbu Anish, Lungu Dragos;
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelSelection {

	JDialog frmSimongamelevel;
	private JTextField textField;
	protected int selectedLevel;
	public static String title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelection window = new LevelSelection(title);
					window.frmSimongamelevel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LevelSelection(String title) {
		initialize();
		LevelSelection.title = title;
		this.frmSimongamelevel.setTitle(title);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimongamelevel = new JDialog();
		frmSimongamelevel.setTitle(title);
		frmSimongamelevel.setBounds(100, 100, 363, 186);
		frmSimongamelevel.setModal(true);
		frmSimongamelevel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel lblSelectTheLevel = new JLabel("Select the level you want to start with");
		lblSelectTheLevel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("1");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					selectedLevel = Integer.parseInt(textField.getText()); // WARNING: Must treat exception for strings, like letters - BUG
					if(selectedLevel >=1 && selectedLevel<=4) {
						setLevel(selectedLevel);
						frmSimongamelevel.dispose();
					} else {
						JOptionPane.showMessageDialog(null, 
	                              "The value must be within the range of 1 up to 4 levels!", 
	                              "Ambigous Input", 
	                              JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception e) {e.printStackTrace();}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSimongamelevel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelectTheLevel, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblSelectTheLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(24))
		);
		frmSimongamelevel.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Set up the level
	 * @param level
	 */
	public void setLevel(int level) {
		this.selectedLevel = level;
	}
	
	/**
	 * Get the level
	 * @return the level
	 */
	public int getLevel() {
		return this.selectedLevel;
	}
}
