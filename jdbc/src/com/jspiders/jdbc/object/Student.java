package com.jspiders.jdbc.object;

public class Student {
	
	private int Id;
	private String Name;
	private String Email;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@Override
	public String toString() {
		
		return "student[sid="+Id+", Name="+Name+", Email="+Email+"]";
	}


}
