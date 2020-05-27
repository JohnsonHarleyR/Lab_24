package co.grandcircus.lab24.entity;

import java.util.Comparator;

public class SortByVotes implements Comparator<PartyOption> {

	
	@Override
	public int compare(PartyOption a, PartyOption b) {
		
		if (a.getVotes() > b.getVotes()) {
			return -1;
		} else if (a.getVotes() < b.getVotes()) {
			return 1;
		} else {
			return 0;
		}
		
	}
}
