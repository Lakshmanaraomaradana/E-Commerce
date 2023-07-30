package com.mlr.mart.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="")
public class SecurityUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String userName;
    private String password;
    private List<String> roles;
    
   // @OneToMany(mappedBy="user")
   // private List<Product>products;
    
	public SecurityUser() {
		super();
	}
	public SecurityUser(int id, String userName, String password, List<String> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    
    
    
}
