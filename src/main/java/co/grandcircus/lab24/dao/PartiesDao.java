package co.grandcircus.lab24.dao;

import co.grandcircus.lab24.entity.Party;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PartiesDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PartyRepository repository;
	
	public Party save(Party party) {
		
		if (party.getId() == null) {
			
			//create new
			em.persist(party);
			return party;
			
		} else {
			
			//update
			return em.merge(party);
			
		}
	}
	
	public List<Party> findAll() {
		
		//JPQL
		return em.createQuery("SELECT p FROM Party p", Party.class).getResultList();
		
	}
	
	public List<Party> findByCategory(String category) {
		
		//JPQL - query uses named parameter
		return em.createQuery("SELECT p FROM Party WHERE p.category = :category",
				Party.class).setParameter("category", category).getResultList();
		
	}

}
