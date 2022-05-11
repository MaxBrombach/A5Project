package de.hfu.residents.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
	Date dd = new Date(2323223232L);
	Date dd2 = new Date(4444444L);
	Date dd3 = new Date(44444440000L);
	Resident per1 = new Resident("Max", "Brombach", "Straße 5", "MyCity", dd);
	Resident per2 = new Resident("Max", "Mustermann", "Musterstraße", "Musterstadt", dd2);
	Resident per3 = new Resident("Bruce", "Wayne", "Batcavestraße 3", "Gotham", dd3);
	
	@Override
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		List<Resident> reslist = new ArrayList<Resident>();
		reslist.add(per1);
		reslist.add(per2);
		reslist.add(per3);
		return reslist;
		
	}
	
	

}
