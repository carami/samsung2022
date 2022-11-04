package com.exam.todojpa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)  //password가 null 일경우 동작하지 않아요... 반드시!!  
	private String password;
	@Column(nullable = false, unique = true) //반드시 uniqu 해야함. 
	private String email;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="user_role",
			joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")}
			)
	private List<Role> roles;
	
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
