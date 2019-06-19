/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;

import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class Costumer extends Person implements Species{
	public String banka_id;
	private List<Table> list_filter;
	public Costumer(String name_surname, String tc, String address, String phone_number, int age) {
		super(name_surname, tc, address, phone_number, age);
	}
	public String getBanka_id() {
		return banka_id;
	}
	public void setBanka_id(String banka_id) {
		this.banka_id = banka_id;
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
	@Override
	public int enterPerson() {//Species interface sınıfında bulunan metodlar tanımlanmak zorundadır.
		return 0;
	}
}

