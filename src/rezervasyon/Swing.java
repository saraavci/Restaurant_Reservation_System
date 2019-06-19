/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;

import java.awt.EventQueue;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Panel;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing {

	private JFrame frameW;
	private JTextField calculate_text_field;
	private JTextField payment_text_field_t_number;
	private JTextField payment_text_field_c_number;
	private JTextField reservation_text_field_num_person;
	private JTextField reservation_text_field_t_number;
	private JTextField reservation_text_field_name;
	private JTextField remove_text_field_name;
	private JTextField have_id_text_field;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frameW.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 Swing() {
		initialize();
	}
	private void initialize() {
		int id =0;
		int table_number;
		double toto;
		List<Table> list_table = new ArrayList();
		List<Table> list_filter = new ArrayList();
		List<Integer> number_of_person = new ArrayList();
		
		AddTable add_table = new AddTable();//Masaların var olduğu kabul edilir.
		
		list_table.add(add_table.createTable(2, 1, true));//Konum içerisi.
		list_table.add(add_table.createTable(4, 2, false));
		list_table.add(add_table.createTable(6, 3, false));
		
		list_table.add(add_table.createTable(2, 10, true));//Konum bahçe.
		list_table.add(add_table.createTable(4, 11, false));
		list_table.add(add_table.createTable(6, 12, false));
		
		list_table.add(add_table.createTable(2, 20, true));//Konum balkon.
		list_table.add(add_table.createTable(4, 21, true));
		list_table.add(add_table.createTable(6, 22, false));

		//Polymorphizm gösterimi için tanımlanmıştır.
		Person W = new Waiter("Ali", "12348", "adres4", "telefon4", 23);
		Person cashier = new Cashier("Ayse", "12345", "adres1", "telefon1", 25, 2001);
		Person cashier2 = new Cashier("Fatma", "12346", "adres2", "telefon2", 22, 2002);
		Person manager = new Manager("Mustafa", "12347", "adres3", "telefon3", 35, 1001);
		
		Waiter W1 = new Waiter("Ali", "12348", "adres4", "telefon4", 23);
		Cashier C1 = new Cashier("Ayse", "12345", "adres1", "telefon1", 25, 2001);
		Cashier C2 = new Cashier("Fatma", "12346", "adres2", "telefon2", 22, 2002);
		Manager M = new Manager("Mustafa", "12347", "adres3", "telefon3", 35, 1001);
		
		W1.setOrder(2, 2, 1, list_table, 10);//Siparişin alındığı kabul edilir.
		W1.setOrder(4, 3, 5, list_table, 21);
		
		frameW = new JFrame();
		frameW.setBounds(100, 100, 890, 492);
		frameW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel calculate_label = new JLabel("Enter table number :");
		calculate_label.setBounds(43, 136, 120, 14);
		calculate_label.setVisible(false);
		frameW.getContentPane().setLayout(null);
		frameW.getContentPane().add(calculate_label);
		
		calculate_text_field = new JTextField();
		calculate_text_field.setBounds(43, 161, 86, 20);
		calculate_text_field.setVisible(false);
		frameW.getContentPane().add(calculate_text_field);
		calculate_text_field.setColumns(10);
		
		JButton calculate_show_button = new JButton("show");
		calculate_show_button.setBounds(43, 192, 89, 23);
		calculate_show_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=calculate_text_field.getText();
				try{
					   int s = Integer.parseInt(i);
					   if(s!=1 && s!=2 && s!=3 && s!=10 && s!=11 && s!=12 && s!=20 && s!=21 && s!=22) {
						   JOptionPane.showMessageDialog(frameW, "There is no such table!");
					   }
					   else {
						   //*****************************************************************************************CALCULATE
							Double toto = M.calculate(s, list_table);
							for(int j=0; j<list_table.size(); j++) {
								if(list_table.get(j).getTable_number() == s) {
									list_table.get(j).setTotal(toto);
								}
							}
							JOptionPane.showMessageDialog(frameW, "Total price is: " + toto  + "\nDETAİLS\n" + M.show_order(s, list_table));
					   }					   
					}catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(frameW, "This is not number! Pleas enter a number!");
					}catch(IndexOutOfBoundsException exx) {
						JOptionPane.showMessageDialog(frameW, "No order on this table!");
					}
				calculate_text_field.setText("");
			}
		});
		calculate_show_button.setVisible(false);
		frameW.getContentPane().add(calculate_show_button);
	
		
		JButton ButtonCalculate = new JButton("calculate");
		ButtonCalculate.setVisible(false);
		ButtonCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ButtonCalculate.addMouseListener(new MouseAdapter() {
			int c =0;
			@Override
			public void mouseClicked(MouseEvent ar) {
				if(ar.getClickCount()%2 == 1) {
					c++;
				}
				if(c%2 == 1) {
					calculate_text_field.setVisible(true);
					calculate_label.setVisible(true);
					calculate_show_button.setVisible(true);
				}
				if(c%2 == 0) {
					calculate_text_field.setVisible(false);
					calculate_label.setVisible(false);
					calculate_show_button.setVisible(false);
				}
			}
		});
		ButtonCalculate.setBounds(33, 111, 144, 23);
		frameW.getContentPane().add(ButtonCalculate);
		
		JLabel payment_label_table_number = new JLabel("Enter Table Number:");
		payment_label_table_number.setBounds(229, 136, 134, 14);
		payment_label_table_number.setVisible(false);
		frameW.getContentPane().add(payment_label_table_number);
		
		payment_text_field_t_number = new JTextField();
		payment_text_field_t_number.setBounds(229, 161, 86, 20);
		payment_text_field_t_number.setVisible(false);
		frameW.getContentPane().add(payment_text_field_t_number);
		payment_text_field_t_number.setColumns(10);
		
		JLabel payment_label_card_number = new JLabel("Enter card number:");
		payment_label_card_number.setBounds(229, 192, 134, 14);
		payment_label_card_number.setVisible(false);
		frameW.getContentPane().add(payment_label_card_number);
		
		payment_text_field_c_number = new JTextField();
		payment_text_field_c_number.setBounds(229, 217, 86, 20);
		payment_text_field_c_number.setVisible(false);
		frameW.getContentPane().add(payment_text_field_c_number);
		payment_text_field_c_number.setColumns(10);
		
		JButton payment_payment_button = new JButton("payment");
		payment_payment_button.setBounds(226, 255, 89, 23);
		payment_payment_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i_1=payment_text_field_t_number.getText();
				String i_2=payment_text_field_c_number.getText();
				
				try{
					   int s_1 = Integer.parseInt(i_1);
					   if(s_1!=1 && s_1!=2 && s_1!=3 && s_1!=10 && s_1!=11 && s_1!=12 && s_1!=20 && s_1!=21 && s_1!=22) {
						   JOptionPane.showMessageDialog(frameW, "There is no such table!");
					   }
					   else {
						   //**************************************************************************************************PAYMENT
							double tot1 = M.calculate(s_1, list_table);
							M.payment(s_1, list_table);
							JOptionPane.showMessageDialog(frameW, "Account number: " + i_2 + " paid " + tot1 + " price!");
					   }
					   
					}catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(frameW, "This is not number! Pleas enter a number!");
					}catch(IndexOutOfBoundsException exx) {
						JOptionPane.showMessageDialog(frameW, "This table haven't a price.");
					}
				payment_text_field_t_number.setText("");
				payment_text_field_c_number.setText("");
			}
		});
		payment_payment_button.setVisible(false);
		frameW.getContentPane().add(payment_payment_button);
		
		JButton ButtonPayment = new JButton("payment");
		ButtonPayment.setVisible(false);
		ButtonPayment.addMouseListener(new MouseAdapter() {
			int p = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 1) {
					p++;
				}
				if(p%2 == 1) {
					payment_label_table_number.setVisible(true);
					payment_text_field_t_number.setVisible(true);
					payment_label_card_number.setVisible(true);
					payment_text_field_c_number.setVisible(true);
					payment_payment_button.setVisible(true);
				}
				if(p%2 == 0) {
					payment_label_table_number.setVisible(false);
					payment_text_field_t_number.setVisible(false);
					payment_label_card_number.setVisible(false);
					payment_text_field_c_number.setVisible(false);
					payment_payment_button.setVisible(false);
				}
			}
		});
		ButtonPayment.setBounds(219, 111, 144, 23);
		frameW.getContentPane().add(ButtonPayment);
		
		JLabel reservation_label_num_person = new JLabel("Enter to number of person:");
		reservation_label_num_person.setBounds(418, 136, 184, 14);
		reservation_label_num_person.setVisible(false);
		frameW.getContentPane().add(reservation_label_num_person);
		
		reservation_text_field_num_person = new JTextField();
		reservation_text_field_num_person.setBounds(418, 160, 86, 20);
		reservation_text_field_num_person.setVisible(false);
		frameW.getContentPane().add(reservation_text_field_num_person);
		reservation_text_field_num_person.setColumns(10);
		
		JTextArea reservation_text_area = new JTextArea();
		reservation_text_area.setBounds(418, 217, 275, 63);
		reservation_text_area.setBackground(UIManager.getColor("Button.background"));
		reservation_text_area.setVisible(false);
		frameW.getContentPane().add(reservation_text_area);
		
		JLabel reservation_label_table_number = new JLabel("Enter table number:");
		reservation_label_table_number.setBounds(418, 291, 135, 14);
		reservation_label_table_number.setVisible(false);
		frameW.getContentPane().add(reservation_label_table_number);
		
		JLabel reservation_label_name = new JLabel("Enter name and surname:");
		reservation_label_name.setBounds(418, 347, 184, 14);
		reservation_label_name.setVisible(false);
		frameW.getContentPane().add(reservation_label_name);
		
		reservation_text_field_t_number = new JTextField();
		reservation_text_field_t_number.setBounds(418, 316, 86, 20);
		reservation_text_field_t_number.setVisible(false);
		frameW.getContentPane().add(reservation_text_field_t_number);
		reservation_text_field_t_number.setColumns(10);
		
		reservation_text_field_name = new JTextField();
		reservation_text_field_name.setBounds(418, 372, 86, 20);
		reservation_text_field_name.setVisible(false);
		frameW.getContentPane().add(reservation_text_field_name);
		reservation_text_field_name.setColumns(10);
		
		JButton reservation_save_button = new JButton("save");
		reservation_save_button.setBounds(418, 403, 86, 23);
		reservation_save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i_1 = reservation_text_field_t_number.getText();
				String i_2 = reservation_text_field_name.getText();
				try{
					   int s_1 = Integer.parseInt(i_1);
					   //***************************************************************************************************RESERVATİON_SAVE
					   if(s_1!=1 && s_1!=2 && s_1!=3 && s_1!=10 && s_1!=11 && s_1!=12 && s_1!=20 && s_1!=21 && s_1!=22) {
						   JOptionPane.showMessageDialog(frameW, "There is no such table!");
					   }
						for(int k=0; k<list_table.size(); k++) {
							if(number_of_person.get(0) != list_table.get(k).getNumber_of_person() && list_table.get(k).getTable_number() == s_1) {
								JOptionPane.showMessageDialog(frameW, "You can't select a table that is not listed!");
							}
							else if(list_table.get(k).getTable_number() == s_1 && !list_table.get(k).isEmpty_or_not()) {
								M.reservation(s_1, list_table, i_2);
								JOptionPane.showMessageDialog(frameW,"Reservation is successfuly.");
							}
							else if(list_table.get(k).getTable_number() == s_1 && list_table.get(k).isEmpty_or_not()) {
								JOptionPane.showMessageDialog(frameW, "You can not select that was full table!");
							}
						}
					}catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(frameW, "This is not number!");
					}catch(IndexOutOfBoundsException exx) {
						JOptionPane.showMessageDialog(frameW, "You must do listing! ");
					}
				reservation_text_field_t_number.setText("");
				reservation_text_field_name.setText("");
			}
		});
		reservation_save_button.setVisible(false);
		frameW.getContentPane().add(reservation_save_button);
		JButton reservation_list_button = new JButton("list");
		reservation_list_button.setBounds(418, 191, 89, 23);
		reservation_list_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=reservation_text_field_num_person.getText();
				try{
					   int s = Integer.parseInt(i);
					   number_of_person.clear();
					   number_of_person.add(s);//Save işlemi yapan butonun action'ı içinde burada girilen sayının kullanılması sağlanmıştır.
					   if(s!=2 && s!=4 && s!=6){
						   JOptionPane.showMessageDialog(frameW, "There is no table for " + s + " person! Pleas enter 2, 4 or 6!");
					   }
					   else {
						   //**************************************************************************************RESERVATİON_LİST
							for(int k=0; k<list_table.size(); k++) {
								if(list_table.get(k).getNumber_of_person() == s) {
									list_filter.add(list_table.get(k));
								}
							}
							if(M.lists(list_filter).equals("")) {
								reservation_text_area.setText("There is no proper table like you wanted!");
							}
							else {
								reservation_text_area.setText(M.lists(list_filter));
							}
					   }
					}catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(frameW, "This is not number! Pleas enter a number!");
					}
				reservation_text_field_num_person.setText("");
				list_filter.clear();
				reservation_label_table_number.setVisible(true);
				reservation_label_name.setVisible(true);
				reservation_text_field_t_number.setVisible(true);
				reservation_text_field_name.setVisible(true);
				reservation_save_button.setVisible(true);
			}
		});
		reservation_list_button.setVisible(false);
		frameW.getContentPane().add(reservation_list_button);
		
		JButton ButtonReservation = new JButton("rezervation");
		ButtonReservation.setVisible(false);
		ButtonReservation.addMouseListener(new MouseAdapter() {
			int r = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 1) {
					r++;
				}
				if(r%2 == 1) {
					reservation_label_num_person.setVisible(true);
					reservation_text_field_num_person.setVisible(true);
					reservation_list_button.setVisible(true);
					reservation_text_area.setVisible(true);
				}
				if(r%2 == 0) {
					reservation_label_num_person.setVisible(false);
					reservation_text_field_num_person.setVisible(false);
					reservation_list_button.setVisible(false);
					reservation_label_table_number.setVisible(false);
					reservation_label_name.setVisible(false);
					reservation_text_field_t_number.setVisible(false);
					reservation_text_field_name.setVisible(false);
					reservation_save_button.setVisible(false);
					reservation_text_area.setVisible(false);
				}
			}
		});
		ButtonReservation.setBounds(405, 111, 144, 23);
		frameW.getContentPane().add(ButtonReservation);
		
		
		JLabel remove_label_name = new JLabel("Enter name and surname:");
		remove_label_name.setBounds(695, 136, 158, 14);
		remove_label_name.setVisible(false);
		frameW.getContentPane().add(remove_label_name);
		
		remove_text_field_name = new JTextField();
		remove_text_field_name.setBounds(695, 160, 86, 20);
		remove_text_field_name.setVisible(false);
		frameW.getContentPane().add(remove_text_field_name);
		remove_text_field_name.setColumns(10);
		
		JButton remone_remove_button = new JButton("remove");
		remone_remove_button.setBounds(695, 199, 89, 23);
		remone_remove_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***************************************************************************************************************REMOVE
				String i = remove_text_field_name.getText();
				int a = M.removeReservation(i, list_table);
				if(a == 0){
					
					JOptionPane.showMessageDialog(frameW, "There is no reservation for that name!");
				}
				else{
					JOptionPane.showMessageDialog(frameW, "Reservation is removed.");
				}
				remove_text_field_name.setText("");
			}
		});
		remone_remove_button.setVisible(false);
		frameW.getContentPane().add(remone_remove_button);
		
		JButton ButtonRemoveReservation = new JButton("remove rezervation");
		ButtonRemoveReservation.setVisible(false);
		ButtonRemoveReservation.addMouseListener(new MouseAdapter() {
			int re = 0; 
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 1) {
					re++;
				}
				if(re%2 == 1) {
					remove_label_name.setVisible(true);
					remove_text_field_name.setVisible(true);
					remone_remove_button.setVisible(true);
				}
				if(re%2 == 0) {
					remove_label_name.setVisible(false);
					remove_text_field_name.setVisible(false);
					remone_remove_button.setVisible(false);
				}
			}
			
		});
		ButtonRemoveReservation.setBounds(685, 111, 144, 23);
		frameW.getContentPane().add(ButtonRemoveReservation);
		//**************************************************************************************************************************id mevzusu
		JLabel LABEL_WELCOME = new JLabel("WELCOME to RESTORANT");
		LABEL_WELCOME.setBounds(371, 11, 167, 14);
		frameW.getContentPane().add(LABEL_WELCOME);
		
		JButton ButtonForCostumer = new JButton("For Costumer");
		ButtonForCostumer.addMouseListener(new MouseAdapter(){
			int c = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()%2 == 1) {
					c++;
				}
				if(c%2 == 1) {
					ButtonReservation.setVisible(true);
					ButtonRemoveReservation.setVisible(true);
				}
				if(c%2 == 0) {
					ButtonReservation.setVisible(false);
					ButtonRemoveReservation.setVisible(false);
				}
			}
		});
		ButtonForCostumer.setBounds(299, 36, 120, 23);
		frameW.getContentPane().add(ButtonForCostumer);
		
		JLabel have_id_label = new JLabel("Enter the ID:");
		have_id_label.setVisible(false);
		have_id_label.setBounds(580, 40, 85, 14);
		frameW.getContentPane().add(have_id_label);
		
		have_id_text_field = new JTextField();
		have_id_text_field.setVisible(false);
		have_id_text_field.setBounds(671, 37, 86, 20);
		frameW.getContentPane().add(have_id_text_field);
		have_id_text_field.setColumns(10);
		
		JButton have_id_button_enter = new JButton("Enter");
		have_id_button_enter.setVisible(false);
		have_id_button_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String i=have_id_text_field.getText();
				
				try{
					   int s = Integer.parseInt(i);
					   if(s!=1001 && s!=2001 && s!=2002) {
						   JOptionPane.showMessageDialog(frameW, "This id not exist!");
					   }
					   else {
						   ButtonCalculate.setVisible(true);
						   ButtonPayment.setVisible(true);
						   ButtonReservation.setVisible(true);
						   ButtonRemoveReservation.setVisible(true); 
					   }
					}catch(NumberFormatException ex){ 
						JOptionPane.showMessageDialog(frameW, "This is not number! Pleas enter a number!");
					}
				have_id_text_field.setText("");
			}
		});
		have_id_button_enter.setBounds(776, 36, 77, 23);
		frameW.getContentPane().add(have_id_button_enter);
		
		JButton ButtonHaveaID = new JButton("Have a ID");
		ButtonHaveaID.addMouseListener(new MouseAdapter() {
			int h =0;
			@Override
			public void mouseClicked(MouseEvent a) {
				if(a.getClickCount()%2 == 1) {
					h++;
				}
				if(h%2 == 1) {
					have_id_label.setVisible(true);
					have_id_text_field.setVisible(true);
					have_id_button_enter.setVisible(true);
				}
				if(h%2 == 0) {
					have_id_label.setVisible(false);
					have_id_text_field.setVisible(false);
					have_id_button_enter.setVisible(false);
				}
			}
		});
		ButtonHaveaID.setBounds(450, 36, 120, 23);
		frameW.getContentPane().add(ButtonHaveaID);
		
	}
}
