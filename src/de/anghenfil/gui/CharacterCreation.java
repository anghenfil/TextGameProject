package de.anghenfil.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
	private int free_points = 30;
	private int points_hp = 0;
	private int points_ap = 0;
	private int points_speed = 0;
	private int points_eloquence = 0;
	private int points_charm = 0;
	private int points_intelligence = 0;
	
	private int df_hp;
	private int df_ap;
	private int df_speed;
	private int df_eloquence;
	private final int df_charm = 100; //Charm and intelligence are not special for each profession
	private final int df_intelligence = 100;
	
	private final int student_df_hp = 80;
	private final int student_df_ap = 80;
	private final int student_df_speed = 150;
	private final int student_df_eloquence = 120;
	
	private final int schriftsteller_df_hp = 80;
	private final int schriftsteller_df_ap = 100;
	private final int schriftsteller_df_speed = 80;
	private final int schriftsteller_df_eloquence = 150;
	
	private final int arzt_df_hp = 100;
	private final int arzt_df_ap = 120;
	private final int arzt_df_speed = 100;
	private final int arzt_df_eloquence = 80;
	
	private int bonus_hp = 0;
	private int bonus_ap = 0;
	private int bonus_speed = 0;
	private int bonus_eloquence = 0;
	private int bonus_charm = 0;
	private int bonus_intelligence = 0;
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
		frmTheTextgameproject.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
			String[] values = new String[] {"Mensch", "Zombie", "Sidekick"};
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
				//TODO: Unblock skilling if professioen was selected
				if(list_1.getSelectedValue() == "Student"){
					df_hp = student_df_hp;
					df_ap = student_df_ap;
					df_speed = student_df_speed;
					df_eloquence = student_df_eloquence;
				}
				if(list_1.getSelectedValue() == "Arzt"){
					df_hp = arzt_df_hp;
					df_ap =	arzt_df_ap;
					df_speed = arzt_df_speed;
					df_eloquence = arzt_df_eloquence;
				}
				if(list_1.getSelectedValue() == "Schriftsteller"){
					df_hp = schriftsteller_df_hp;
					df_ap = schriftsteller_df_ap;
					df_speed = schriftsteller_df_speed;
					df_eloquence = schriftsteller_df_eloquence;
				}
				table.getModel().setValueAt(df_hp, 1, 1);
				table.getModel().setValueAt(df_ap, 2, 1);
				table.getModel().setValueAt(df_speed, 3, 1);
				table.getModel().setValueAt(df_eloquence, 4, 1);
				table.getModel().setValueAt(df_charm, 5, 1);
				table.getModel().setValueAt(df_intelligence, 6, 1);
			}
		});
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Student", "Arzt", "Schriftsteller"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblKlasse = new JLabel("Beruf");
		lblKlasse.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		table = new JTable();
		table.setRowHeight(22);
		table.setRequestFocusEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBackground(UIManager.getColor("Button.background"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "Basic", "Bonus", "Gesamt"},
				{"Health Points (HP)", null, null, null},
				{"Action Points (AP)", null, null, null},
				{"Speed (SPD)", null, null, null},
				{"Eloquence (EQ)", null, null, null},
				{"Charm (CH)", null, null, null},
				{"Intelligence (INT)", null, null, null},
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
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(12);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.getColumnModel().getColumn(2).setPreferredWidth(54);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(54);
		
		JButton health_points_up = new JButton("");
		health_points_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		health_points_up.setPreferredSize(new Dimension(16, 16));
		health_points_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_hp = points_hp + 1;
					bonus_hp = (points_hp*10); 
					table.getModel().setValueAt(bonus_hp, 1, 2);
					table.getModel().setValueAt(df_hp + bonus_hp, 1, 3);
				}
			}
		});
		health_points_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton action_points_up = new JButton("");
		action_points_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_ap = points_ap + 1;
					bonus_ap = (points_ap*10); 
					table.getModel().setValueAt(bonus_ap, 2, 2);
					table.getModel().setValueAt(df_ap + bonus_ap, 2, 3);
				}
			}
		});
		action_points_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		action_points_up.setPreferredSize(new Dimension(16, 16));
		action_points_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton action_points_down = new JButton("");
		action_points_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points_ap > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_ap = points_ap - 1;
					bonus_ap = (points_ap*10); 
					table.getModel().setValueAt(bonus_ap, 2, 2);
					table.getModel().setValueAt(df_ap + bonus_ap, 2, 3);
				}
			}
		});
		action_points_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		action_points_down.setPreferredSize(new Dimension(16, 16));
		action_points_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton health_points_down = new JButton("");
		health_points_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points_hp > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_hp = points_hp - 1;
					bonus_hp = (points_hp*10); 
					table.getModel().setValueAt(bonus_hp, 1, 2);
					table.getModel().setValueAt(df_hp + bonus_hp, 1, 3);
				}
			}
		});
		health_points_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		health_points_down.setPreferredSize(new Dimension(16, 16));
		health_points_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
		
		JLabel lblFrei = new JLabel("Frei");
		
		JButton btnCharakterErstellen = new JButton("Charakter erstellen");
		btnCharakterErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> errorsrc = new ArrayList<String>();
				String name = textField.getText();
				String race;
				String profession;
				
				if(list.getSelectedValue() != null){ //If nothing selected set race to null
					race = list.getSelectedValue().toString();
				}else{
					race = null;
				}
				if(list_1.getSelectedValue() != null){ //If nothing selected set klasse to null
					profession = list_1.getSelectedValue().toString();
				}else{
					profession = null;
				}
				
				errorsrc = UserManager.checkInput(name, free_points, race, profession); //Check Charakter Name, if free_points 0 and if race and class selected
				
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
					if(errorsrc.contains("profession")){
						list_1.setBackground(Color.RED);
					}
				}else{
					//TODO: Save points too
					User user = new User();
					user.setName(name);
					user.setRace(race);
					user.setProfession(profession);
					user.setHealth(df_hp);
					user.setBonus_health(bonus_hp);
					user.setAp(df_ap);
					user.setBonus_ap(bonus_ap);
					user.setSpeed(df_speed);
					user.setBonusSpeed(bonus_speed);
					user.setEloquence(df_eloquence);
					user.setBonusEloquence(bonus_eloquence);
					user.setCharm(df_charm);
					user.setBonusCharm(bonus_charm);
					try {
						user.saveUser();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					frmTheTextgameproject.setVisible(false);
					MainGame.play();
				}
			}
		});
		
		JButton speed_up = new JButton("");
		speed_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(free_points > 0){
					free_points = free_points - 1;
					unvergeben.setText("" + free_points);
					points_speed = points_speed + 1;
					bonus_speed = (points_speed*10); 
					table.getModel().setValueAt(bonus_speed, 3, 2);
					table.getModel().setValueAt(df_speed + bonus_speed, 3, 3);
				}
			}
		});
		speed_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		speed_up.setPreferredSize(new Dimension(16, 16));
		speed_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton eloquence_up = new JButton("");
		eloquence_up.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_eloquence = points_eloquence + 1;
					bonus_eloquence = (points_eloquence*10); 
					table.getModel().setValueAt(bonus_eloquence, 4, 2);
					table.getModel().setValueAt(df_eloquence + bonus_eloquence, 4, 3);
				}
			}
		});
		eloquence_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		eloquence_up.setPreferredSize(new Dimension(16, 16));
		eloquence_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton charm_up = new JButton("");
		charm_up.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_charm = points_charm + 1;
					bonus_charm = (points_charm*10); 
					table.getModel().setValueAt(bonus_charm, 5, 2);
					table.getModel().setValueAt(df_charm + bonus_charm, 5, 3);
				}
			}
		});
		charm_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		charm_up.setPreferredSize(new Dimension(16, 16));
		charm_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton intelligence_up = new JButton("");
		intelligence_up.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(free_points > 0){
					free_points = free_points -1;
					unvergeben.setText("" + free_points);
					points_intelligence = points_intelligence + 1;
					bonus_intelligence = (points_intelligence*10); 
					table.getModel().setValueAt(bonus_intelligence, 6, 2);
					table.getModel().setValueAt(df_intelligence + bonus_intelligence, 6, 3);
				}
			}
		});
		intelligence_up.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p up.png")));
		intelligence_up.setPreferredSize(new Dimension(16, 16));
		intelligence_up.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton speed_down = new JButton("");
		speed_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(points_speed > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_speed = points_speed - 1;
					bonus_speed = (points_speed*10); 
					table.getModel().setValueAt(bonus_speed, 3, 2);
					table.getModel().setValueAt(df_speed + bonus_speed, 3, 3);
				}
			}
		});
		speed_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		speed_down.setPreferredSize(new Dimension(16, 16));
		speed_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton eloquence_down = new JButton("");
		eloquence_down.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(points_eloquence > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_eloquence = points_eloquence - 1;
					bonus_eloquence = (points_eloquence*10); 
					table.getModel().setValueAt(bonus_eloquence, 4, 2);
					table.getModel().setValueAt(df_eloquence + bonus_eloquence, 4, 3);
				}
			}
		});
		eloquence_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		eloquence_down.setPreferredSize(new Dimension(16, 16));
		eloquence_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton charm_down = new JButton("");
		charm_down.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(points_charm > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_charm = points_charm - 1;
					bonus_charm = (points_charm*10); 
					table.getModel().setValueAt(bonus_charm, 5, 2);
					table.getModel().setValueAt(df_charm + bonus_charm, 5, 3);
				}
			}
		});
		charm_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		charm_down.setPreferredSize(new Dimension(16, 16));
		charm_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
		JButton intelligence_down = new JButton("");
		intelligence_down.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(points_intelligence > 0){
					free_points = free_points + 1;
					unvergeben.setText("" + free_points);
					points_intelligence = points_intelligence - 1;
					bonus_intelligence = (points_intelligence*10); 
					table.getModel().setValueAt(bonus_intelligence, 6, 2);
					table.getModel().setValueAt(df_intelligence + bonus_intelligence, 6, 3);
				}
			}
		});
		intelligence_down.setIcon(new ImageIcon(CharacterCreation.class.getResource("/10p down.png")));
		intelligence_down.setPreferredSize(new Dimension(16, 16));
		intelligence_down.setFont(new Font("Dialog", Font.BOLD, 9));
		
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
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCharakterErstellen)
										.addComponent(table, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrei)
						.addComponent(intelligence_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(action_points_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(health_points_up, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(speed_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(eloquence_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(charm_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(intelligence_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(health_points_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(action_points_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(speed_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(eloquence_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(charm_down, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(unvergeben, 0, 0, Short.MAX_VALUE))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(lblCharaktererstellung, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFrei)
								.addComponent(unvergeben, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(health_points_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(action_points_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(speed_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(eloquence_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(charm_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(intelligence_down, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(health_points_up, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(action_points_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(speed_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(eloquence_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(charm_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(intelligence_up, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))))
					.addGap(63)
					.addComponent(btnCharakterErstellen)
					.addGap(104))
		);
		frmTheTextgameproject.getContentPane().setLayout(groupLayout);
	}
}
