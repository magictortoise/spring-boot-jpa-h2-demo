package com.tinroof.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "calendar")
public class Calendar implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "userid")
    private String userid;
	
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Calendar() {
    }

    public Calendar(int id, String name, String userid) {
        super();
        this.id = id;
        this.name = name;
        this.userid = userid;
    }





}
