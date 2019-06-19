/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Manager extends Person {
	private List<Table> list_filter = new ArrayList();
	public List<Table> list_table = new ArrayList();
	public List<Integer> listt = new ArrayList();//Siparişlerin hesaplanması için kullanılan listedir.
	public double total_price;
	private int id;
	
	public Manager(String name_surname, String tc, String address, String phone_number, int age, int id) {
		super(name_surname, tc, address, phone_number, age);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void payment(int table_number, List<Table> listt ) {
		for(int i=0; i<listt.size(); i++) {
			if(listt.get(i).getTable_number()== table_number) {
				listt.get(i).setEmpty_or_not(false);
			}
		}
	}
	public boolean findEmptyTable(Table T) {
		if(!T.isEmpty_or_not()) {
			return false;
		}
		return true;
	}
	public String lists(List<Table> list){ //Bos masaların görünmesini sağlar.	
		String output = "";
		for(int i=0;i<list.size();i++){
			if(!findEmptyTable(list.get(i))) {
				output += "Table number is: " + list.get(i).getTable_number() + " Table location is: " + list.get(i).getLocation() + "\n";
			}
		}
		return output;
	}
	public void reservation(int table_number, List<Table> list_table, String name_surname) {	
		for(int i=0;i<list_table.size();i++){
			if(list_table.get(i).getTable_number() == table_number) {
				list_table.get(i).setName_surname(name_surname);
				list_table.get(i).setEmpty_or_not(true);
			}
		}
	}
	public int removeReservation(String p_name_surname, List<Table> list_table) {
		int output=0;
		for(int i=0; i<list_table.size(); i++){
			if(list_table.get(i).getName_surname().equals(p_name_surname)){
				list_table.get(i).setEmpty_or_not(false);
				output = 1;
			}
		}
		return output;
	}
	public double calculate(int table_num, List<Table> list_table) {
		for(int i=0; i<list_table.size(); i++) {
			if(list_table.get(i).getTable_number() == table_num) {
				listt = list_table.get(i).getList();
				total_price = (listt.get(0)*(10)) + (listt.get(1)*(20)) + (listt.get(2)*(5)); 
				if(list_table.get(i).getLocation() == "balcony") {
					total_price += list_table.get(i).getNumber_of_person()*30;
				}
				else if(list_table.get(i).getLocation() == "garden") {

					total_price += list_table.get(i).getNumber_of_person()*20;
				}
				else {

					total_price += list_table.get(i).getNumber_of_person()*10;
				}
			}
		}
		
		return total_price;
	}
	public String show_order(int table_number, List<Table> list_table) {
		String order = "";
		for(int i=0; i<list_table.size(); i++) {
			if(list_table.get(i).getTable_number() == table_number) {
				order += "Number of soup: " + list_table.get(i).getList().get(0) + ", 10*" + 
						 list_table.get(i).getList().get(0) + "=" + list_table.get(i).getList().get(0)*(10) + "\n";
				order += "Number of main course: " + list_table.get(i).getList().get(1) + ", 20*" + 
						 list_table.get(i).getList().get(1) + "=" + list_table.get(i).getList().get(1)*(2) + "\n";
				order += "Number of dessert: " + list_table.get(i).getList().get(2) + ", 5*" + 
						 list_table.get(i).getList().get(2) + "=" + list_table.get(i).getList().get(2)*(5) + "\n";
				
				if(list_table.get(i).getLocation() == "balcony") {
					order += "Price of table service: " + list_table.get(i).getNumber_of_person()*30 + "\n";
				}
				else if(list_table.get(i).getLocation() == "garden") {
					order += "Price of table service: " + list_table.get(i).getNumber_of_person()*20 + "\n";
				}
				else {
					order += "Price of table service: " + list_table.get(i).getNumber_of_person()*10 + "\n";
				}
			}
		}
		return order;
	}
}
