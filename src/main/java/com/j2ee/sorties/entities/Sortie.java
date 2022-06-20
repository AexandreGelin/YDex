package com.j2ee.sorties.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sorties")
public class Sortie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column @NotEmpty
	private String name;

	@Column @NotNull
	private Date dateSortie;

	@Column @Min(1) @Max(12)
	private Integer duration;

	@ManyToMany
	@JoinTable(name = "sortie_users", 
		joinColumns = @JoinColumn(name = "sortie_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	@ManyToOne @NotNull
	@JoinColumn(name="manager_id")
	private User manager;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Integer getDuration() { return duration;	}

	public void setDuration(Integer duration) { this.duration = duration; }

	public Date getDateSortie() { return dateSortie; }

	public void setDateSortie(Date dateSortie) { this.dateSortie = dateSortie; }
}
