package com.csj.demo.controller;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {  
    @NotNull(message = "{user.id.null}")  
    private Long id;  
  
    @NotEmpty(message = "{user.name.null}")  
    @Length(min = 5, max = 20, message = "{user.name.length.illegal}")  
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}")  
    private String name;  
  
    @NotNull(message = "{user.password.null}")  
    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
    
    
    
}  
