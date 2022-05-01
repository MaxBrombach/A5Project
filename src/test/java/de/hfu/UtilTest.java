package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	
	@Test
	public void TestistErstesHalbjahr() {
		assertTrue(Util.istErstesHalbjahr(3));
	}
	
	@Test
	public void TestistnichtErstesHalbjahr() {
		assertFalse(Util.istErstesHalbjahr(8));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestExceptionistErstesHalbjahr() {		
		Util.istErstesHalbjahr(14);
		
	}
}
