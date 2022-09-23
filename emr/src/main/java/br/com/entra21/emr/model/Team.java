package br.com.entra21.emr.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="team_emr")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Team extends MaturidadeNivel3Richardson {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String github;
	private String college;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(ArrayList<ItemNivel3> links) {
		super(links);
		// TODO Auto-generated constructor stub
	}
	public Team(Integer id, String name, String github, String college) {
		super();
		this.id = id;
		this.name = name;
		this.github = github;
		this.college = college;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	
}