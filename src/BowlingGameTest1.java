import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BowlingGameTest1 {
	BowlingGame g1 = new BowlingGame();

	@Test
	void test1() {
		assertEquals(0,g1.getScore());
		g1.roll(5);
		assertEquals(5,g1.getScore());
		g1.roll(5);
		g1.roll(6);
		assertEquals(22,g1.getScore());

	}
	@Test
	void test2() {
		assertEquals(1,0);
		assertEquals(1,0);
		assertEquals(1,0);
	}

}
