package de.hfu;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import junit.framework.TestCase;

public class ResidentTest extends TestCase {
	
	@Test
	public void testgetFilteredResidentsList() {
		BaseResidentService service = new BaseResidentService();
		ResidentRepositoryStub stubrepo = new ResidentRepositoryStub();
		service.setResidentRepository(stubrepo);
		Date dd = new Date(2323223232L);
		Date dd2 = new Date(4444444L);
		Date dd3 = new Date(44444440000L);
		Resident perout1 = new Resident("Max", "Brombach", "Straße 5", "MyCity", dd);
		Resident perout3 = new Resident("Bruce", "Wayne", "Batcavestraße 3", "Gotham", dd3);
		Resident perin1 = new Resident("Ma*", "Bro*", "Stra*", "My*", dd);		
		Resident perin2 = new Resident("Ma*", null, null, null, null);
		Resident perin3 = new Resident("B*", "W*", "B*", "G*", dd3);
		
		List<Resident> testlist = service.getFilteredResidentsList(perin1);
		List<Resident> testlist2 = service.getFilteredResidentsList(perin3);
		List<Resident> testlist3 = service.getFilteredResidentsList(perin2);
		assertEquals(perout1.getFamilyName(), testlist.get(0).getFamilyName());
		assertEquals(perout3.getFamilyName(), testlist2.get(0).getFamilyName());
		assertEquals(2, testlist3.size());
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testgetUniqueResidentEx1() {
		BaseResidentService service = new BaseResidentService();
		ResidentRepositoryStub stubrepo = new ResidentRepositoryStub();
		service.setResidentRepository(stubrepo);
		Date dd = new Date(2323223232L);		
		Resident perin1 = new Resident("M*", null, null, null, null);
		try {
			service.getUniqueResident(perin1);
			fail("Wildcards (*) sind nicht erlaubt!");
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testgetUniqueResidentEx2() {
		BaseResidentService service = new BaseResidentService();
		ResidentRepositoryStub stubrepo = new ResidentRepositoryStub();
		service.setResidentRepository(stubrepo);
		Date dd = new Date(2323223232L);		
		Resident perin1 = new Resident("Hans", "Brombach", "Straße 5", "MyCity", dd);
		try {
			service.getUniqueResident(perin1);
			fail("Suchanfrage lieferte kein eindeutiges Ergebnis!");
		} catch (ResidentServiceException e) {
			
			
		}
	}
	
	public void testgetUniqueResident() throws ResidentServiceException {
		BaseResidentService service = new BaseResidentService();
		ResidentRepositoryStub stubrepo = new ResidentRepositoryStub();
		service.setResidentRepository(stubrepo);
		Date dd = new Date(2323223232L);		
		Resident perin1 = new Resident("Max", "Brombach", "Straße 5", "MyCity", dd);
		Resident er = service.getUniqueResident(perin1);
		assertEquals(perin1.getFamilyName(), er.getFamilyName());
	}
	
	
	
	

}
