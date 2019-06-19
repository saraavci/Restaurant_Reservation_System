/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
	private int table_number;
	private int number_of_person;
	private String location;
	private String name_surname;
	private boolean empty_or_not = false;
	private double total;
	private List<Integer> list = new ArrayList<Integer>(); //Siparişlerin tutulduğu listedir.
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public int getTable_number() {
		return table_number;
	}
	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}
	public int getNumber_of_person() {
		return number_of_person;
	}
	public void setNumber_of_person(int number_of_person) {
		this.number_of_person = number_of_person;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName_surname() {
		return name_surname;
	}
	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}
	public boolean isEmpty_or_not() {
		return empty_or_not;
	}
	public void setEmpty_or_not(boolean empty_or_not) {
		this.empty_or_not = empty_or_not;
	}	
}

