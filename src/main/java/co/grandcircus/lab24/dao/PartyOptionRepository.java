package co.grandcircus.lab24.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.lab24.entity.PartyOption;

public interface PartyOptionRepository extends JpaRepository<PartyOption, Long> {
	
	//search by party.id
	List<PartyOption> findByPartyId(Long partyId);

}
