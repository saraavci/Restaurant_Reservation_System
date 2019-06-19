/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyon;


public abstract class Person {
	private String name_surname;
	private String tc;
	private String address;
	private String phone_number;
	private int age;
	public Person(String name_surname, String tc, String address, String phone_number, int age) {
		this.name_surname = name_surname;
		this.tc = tc;
		this.address = address;
		this.phone_number = phone_number;
		this.age = age;
	}
	public String getName_surname() {
		return name_surname;
	}
	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

