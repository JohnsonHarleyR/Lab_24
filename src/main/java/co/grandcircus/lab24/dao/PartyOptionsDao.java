package co.grandcircus.lab24.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.grandcircus.lab24.entity.SortByVotes;
import co.grandcircus.lab24.entity.Party;
import co.grandcircus.lab24.entity.PartyOption;

@Repository
@Transactional
public class PartyOptionsDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PartyOptionRepository repository;
	
	public PartyOption save(PartyOption partyOption) {
		
		if (partyOption.getId() == null) {
			
			//Create new
			em.persist(partyOption);
			return partyOption;
			
		} else {
			
			//Update
			return em.merge(partyOption);
		}
		
	}
	
	public List<PartyOption> findAll() {
		
		//JPQL
		return em.createQuery("SELECT p FROM PartyOption p",
				PartyOption.class).getResultList();
	}
	
public List<PartyOption> findById(Long id) {
		
		//JPQL - query uses named parameter
		return em.createQuery("SELECT p FROM PartyOption p WHERE p.id = :id",
				PartyOption.class).setParameter("id", id).getResultList();
	}
	
	public List<PartyOption> findByPartyId(Long partyId) {
		
		//JPQL - query uses named parameter
		return em.createQuery("SELECT p FROM PartyOption p WHERE p.party.id = :partyId",
				PartyOption.class).setParameter("partyId", partyId).getResultList();
		//Omg I did it
	}
	
	
	
	public List<PartyOption> findByCategory(String category) {
		
		//JPQL - query uses named parameter
		return em.createQuery("SELECT p FROM PartyOption WHERE p.category = :category",
				PartyOption.class).setParameter("category", category).getResultList();
		
	}
	

}
