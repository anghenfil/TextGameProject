package de.anghenfil.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import de.anghenfil.maingame.MainGame;
import de.anghenfil.user.User;
import de.anghenfil.user.UserManager;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class CharacterCreation {

	public JFrame frmTheTextgameproject = new JFrame();
	private JTextField textField;
	private JTable table;
	private JTextField unvergeben;
	private int free_points = 10;
	private int points_hp = 0;
	private int points_ap = 0;
	private int df_hp;
	private int df_ap;
	private int magier_df_hp = 100;
	private int priester_df_hp = 150;
	private int krieger_df_hp = 200;
	private int magier_df_ap = 200;
	private int priester_df_ap = 100;
	private int krieger_df_ap = 75;
	private int bonus_hp = 0;
	private int total_hp = 0;
	private int bonus_ap = 0;
	private int total_ap = 0;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public CharacterCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheTextgameproject.setIconImage(Toolkit.getDefaultToolkit().getImage(CharacterCreation.class.getResource("/TGP Test.png")));
		frmTheTextgameproject.setTitle("The TextGameProject 1.0");
		frmTheTextgameproject.setResizable(false);
		frmTheTextgameproject.setBounds(100, 100, 750, 462);
		frmTheTextgameproject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCharaktererstellung = new JLabel("Charaktererstellung");
		lblCharaktererstellung.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblCharaktername = new JLabel("Charaktername");
		lblCharaktername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		unvergeben = new JTextField();
		unvergeben.setBackground(UIManager.getColor("Label.background"));
		unvergeben.setHorizontalAlignment(SwingConstants.CENTER);
		unvergeben.setEditable(false);
		unvergeben.setFont(new Font("Tahoma", Font.PLAIN, 10));
		unvergeben.setColumns(10);
		unvergeben.setText("" + free_points);
		JLabel lblRasse = new JLabel("Rasse");
		lblRasse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Mensch", "Elf", "Halbelf"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JList list_1 = new JList();
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list_1.getSelectedValue() == "Magier"){
					df_hp = magier_df_hp;
					df_ap = magier_df_ap;
				}
				if(list_1.getSelectedValue() == "Krieger"){
					df_hp = krieger_df_hp;
					df_ap =	krieger_df_ap;
				}
				if(list_1.getSelectedValue() == "Priester"){
					df_hp = priester_df_hp;
					df_ap = priester_df_ap;
				}
				table.getModel().setValueAt(df_hp, 1, 1);
				table.getModel().setValueAt(df_ap, 2, 1);
				
			}
		});
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Magier", "Krieger", "Priester"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblKlasse = new JLabel("Klasse");
		lblKlasse.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		table = new JTable();
		table.setRequestFocusEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBackground(UIManager.getColor("Button.background"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "Basic", "Bonus", "Gesamt"},
				{"Health (HP)", null, null, null},
				{"Action Points (AP)", null, null, null},
			},
			new String[] {
				"", "Basic", "Bonuspunkte", "Gesamt"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(0).setMinWidth(8);
		
		JButton btnUp = new JButton("");
		btnUp.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		btnUp.setPreferredSize(new Dimension(16, 16));
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_hp = points_hp + 1;
					bonus_hp = (points_hp*10); 
					total_hp = df_hp + bonus_hp;
					table.getModel().setValueAt(bonus_hp, 1, 2);
					table.getModel().setValueAt(total_hp, 1, 3);
				}
			}
		});
		btnUp.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_ap = points_ap + 1;
					bonus_ap = (points_ap*10); 
					total_ap = df_ap + bonus_ap;
					table.getModel().setValueAt(bonus_ap, 2, 2);
					table.getModel().setValueAt(total_ap, 2, 3);
				}
			}
		});
		button.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		button.setPreferredSize(new Dimension(16, 16));
		button.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points_ap > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_ap = points_ap - 1;
					bonus_ap = (points_ap*10); 
					total_ap = df_ap + bonus_ap;
					table.getModel().setValueAt(bonus_ap, 2, 2);
					table.getModel().setValueAt(total_ap, 2, 3);
				}
			}
		});
		button_1.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		button_1.setPreferredSize(new Dimension(16, 16));
		button_1.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points_hp > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_hp = points_hp - 1;
					bonus_hp = (points_hp*10); 
					total_hp = df_hp + bonus_hp;
					table.getModel().setValueAt(bonus_hp, 1, 2);
					table.getModel().setValueAt(total_hp, 1, 3);
				}
			}
		});
		button_2.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		button_2.setPreferredSize(new Dimension(16, 16));
		button_2.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JLabel lblFrei = new JLabel("Frei");
		
		JButton btnCharakterErstellen = new JButton("Charakter erstellen");
		btnCharakterErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> errorsrc = new ArrayList<String>();
				String name = textField.getText();
				String race;
				String klasse;
				
				if(list.getSelectedValue() != null){ //If nothing selected set race to null
					race = list.getSelectedValue().toString();
				}else{
					race = null;
				}
				if(list_1.getSelectedValue() != null){ //If nothing selected set klasse to null
					klasse = list_1.getSelectedValue().toString();
				}else{
					klasse = null;
				}
				
				errorsrc = UserManager.checkInput(name, free_points, race, klasse); //Check Charakter Name, if free_points 0 and if race and class selected
				
				textField.setBackground(Color.WHITE);
				//TODO: Label default swing color
				list.setBackground(Color.WHITE);
				list_1.setBackground(Color.WHITE);
				
				if(!errorsrc.isEmpty()){
					if(errorsrc.contains("name")){
						textField.setBackground(Color.RED);
					}
					if(errorsrc.contains("free_points")){
						unvergeben.setBackground(Color.RED);
					}
					if(errorsrc.contains("race")){
						list.setBackground(Color.RED);
					}
					if(errorsrc.contains("klasse")){
						list_1.setBackground(Color.RED);
					}
				}else{
					//TODO: Save points too
					User user = new User();
					user.setName(name);
					user.setRasse(race);
					user.setKlasse(klasse);
					user.setAct_room(0);
					user.setHealth(df_hp);
					user.setBonus_health(bonus_hp);
					user.setAp(df_ap);
					user.setBonus_ap(bonus_ap);
					user.saveUser();
					MainGame.play();
					System.exit(1);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmTheTextgameproject.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(272)
							.addComponent(lblCharaktererstellung))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCharaktername)
								.addComponent(lblRasse, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKlasse, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(list, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(button, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblFrei))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(unvergeben, 0, 0, Short.MAX_VALUE)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(310)
					.addComponent(btnCharakterErstellen)
					.addContainerGap(309, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(lblCharaktererstellung, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFrei)
								.addComponent(unvergeben, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addGap(0)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCharaktername)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRasse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(list))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list_1)
								.addComponent(lblKlasse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(94)
					.addComponent(btnCharakterErstellen)
					.addGap(73))
		);
		frmTheTextgameproject.getContentPane().setLayout(groupLayout);
	}
}
