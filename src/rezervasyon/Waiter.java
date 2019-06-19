/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;


import java.util.ArrayList;
import java.util.List;

public class Waiter extends Person {
	public List liste = new ArrayList();
	public int index;
	public Waiter(String name_surname, String tc, String address, String phone_number, int age) {
		super(name_surname, tc, address, phone_number, age);
	}
	public void setOrder(int soup, int main_course, int dessert, List<Table> list1, int table_number) {
		liste.add(soup);
		liste.add(main_course);
		liste.add(dessert);
		for(int i=0;i<list1.size();i++){
			if(list1.get(i).getTable_number() == table_number) {
				list1.get(i).setList(liste);
			}
		}
	}
}
