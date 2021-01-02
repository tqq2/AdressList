package entity;

import java.io.Serializable;

public class Address implements Serializable{
	private int id;
	private String name;
	private String phone1;
	private String phone2;
	public Address() {
	}
	public Address(int id, String name, String phone1, String phone2) {
		super();
		this.id=id;
		this.name=name;
		this.phone1=phone1;
		this.phone2=phone2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phone1=" + phone1 + ", phone2=" + phone2 + "]";
	}
     
}
