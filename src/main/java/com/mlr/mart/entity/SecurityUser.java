package com.mlr.mart.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
