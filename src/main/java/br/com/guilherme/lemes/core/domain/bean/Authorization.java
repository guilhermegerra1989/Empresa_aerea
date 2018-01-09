package br.com.guilherme.lemes.core.domain.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.guilherme.lemes.core.utils.Prefix;

@Entity
@Prefix(column = "aut")
public class Authorization implements Serializable {

	private static final long serialVersionUID = -3209864230738448243L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;

	public Authorization(String name) {
		this.name = name;
	}

	public Authorization() {}
	
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
	
}
