package co.grandcircus.lab24.dao;

import co.grandcircus.lab24.entity.Party;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * JpaRepository is a fully functionality CRUD Repository
 * 
 * that takes <Type, ID> arguments
 *  
 *  (here as a reminder)
 */

public interface PartyRepository extends JpaRepository<Party, Long> {


	
}
