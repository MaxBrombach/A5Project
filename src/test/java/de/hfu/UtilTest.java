package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	
	@Test
	public void TestistErstesHalbjahr() {
		assertTrue(Util.istErstesHalbjahr(1));
	}
	
	@Test
	public void TestistnichtErstesHalbjahr() {
		assertFalse(Util.istErstesHalbjahr(12));
	}
	
	@Test
	public void TestistnichtErstesHalbjahrmid() {
		assertFalse(Util.istErstesHalbjahr(7));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestExceptionistErstesHalbjahr() {		
		Util.istErstesHalbjahr(14);
		
	}
}
