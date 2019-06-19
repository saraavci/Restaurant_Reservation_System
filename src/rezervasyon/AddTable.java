/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;

public class AddTable {

	public Table createTable(int number_of_person, int table_number, Boolean empty) {
		Table T = new Table();
		if(table_number < 10) {
			T.setLocation("inside");
			T.setName_surname("-");
			T.setNumber_of_person(number_of_person);
			T.setTable_number(table_number);
			T.setEmpty_or_not(empty);
		}
		else if(table_number >= 10 && table_number < 20) {
			T.setLocation("garden");
			T.setName_surname("-");
			T.setNumber_of_person(number_of_person);
			T.setTable_number(table_number);
			T.setEmpty_or_not(empty);
		}
		else {
			T.setLocation("balcony");
			T.setName_surname("-");
			T.setNumber_of_person(number_of_person);
			T.setTable_number(table_number);
			T.setEmpty_or_not(empty);
		}
		return T;
	}
}
