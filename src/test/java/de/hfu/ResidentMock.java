package de.hfu;
import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentMock {
	
	@Test
	public void mocktest() {
		BaseResidentService service = new BaseResidentService();
		ResidentRepository mock = createMock(ResidentRepository.class);
		Date dd = new Date(2323223232L);
		Date dd2 = new Date(4444444L);
		Date dd3 = new Date(44444440000L);
		List<Resident> reslist = new ArrayList<Resident>();
		Resident per1 = new Resident("Max", "Brombach", "Straße 5", "MyCity", dd);
		Resident per2 = new Resident("Max", "Mustermann", "Musterstraße", "Musterstadt", dd2);
		Resident per3 = new Resident("Bruce", "Wayne", "Batcavestraße 3", "Gotham", dd3);		
		reslist.add(per1);
		reslist.add(per2);
		reslist.add(per3);
		expect(mock.getResidents()).andReturn(reslist);
		replay(mock);
		service.setResidentRepository(mock);
		
		Resident perout1 = new Resident("Max", "Brombach", "Straße 5", "MyCity", null);
		Resident perin1 = new Resident("Ma*", "Bro*", "Stra*", "My*", null);				
		
		List<Resident> testlist = service.getFilteredResidentsList(perin1);
		assertEquals(testlist.get(0).getFamilyName(), perout1.getFamilyName());
		
		
	}
	
	
}
