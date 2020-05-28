package co.grandcircus.lab24.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="party_options")
public class PartyOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private int votes;
	
	//link Party class
	@ManyToOne //Tbh I don't think I understand the relationship stuff completely,
	private Party party; //just like real life

	public PartyOption() {
		super();
	}
	
	public PartyOption(String name, String description, Party party) {
		super();
		this.name = name;
		this.description = description;
		this.party = party;
		votes = 0;
		
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}


	@Override
	public String toString() {
		return "PartyOption [id=" + id + ", name=" + name + 
				", description=" + description + ", votes=" + votes +
				", party=" + party.getName() + "]";
	}
	
}
