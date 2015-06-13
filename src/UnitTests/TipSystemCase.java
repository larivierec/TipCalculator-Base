package UnitTests;

import model.Tip;
import model.TipSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TipSystemCase {
	Tip testTip;
	@Before
	 public void setUp() throws Exception {
		testTip = new Tip();
	}
	@Test
	public void legitCalculation() {
		assertEquals(21,TipSystem.getInstance().calculateTip(testTip),0.05);
	}
	@Test
	public void lowerBoundCalculation() {
		assertFalse(19>TipSystem.getInstance().calculateTip(testTip));
	}
	@Test
	public void upperBoundCalculation() {
		assertFalse(22<TipSystem.getInstance().calculateTip(testTip));
	}

}
