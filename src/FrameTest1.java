import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FrameTest1 {
	Frame f1 = new Frame();
	Frame f2 = new Frame();
	Frame f3 = new Frame();

	@Test
	void test1()throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f1.getBall(4);
			f1.setBall(1, 11);
			f2.setBall(1, 10);
			//set for set more than 10 pins in 2nd ball
			f1.setBall(0, 5);
			f1.setBall(1, 6);
			f1.setBall(2, 11);
		  });
	}
	@Test
	void test2() {
		f2.setBall(0, 10);
		assertEquals(true, f2.isStrike());
		f2.setBall(1, 10);
		assertEquals(false, f2.isSpare());	
		assertEquals(20, f2.sumAll());	
		assertEquals(20, f2.sumFirstTwoBalls());	
	}
	@Test
	void test3() {
		f1.setBall(0, 5);
		f1.setBall(2, 10);
		assertEquals(5, f1.sumFirstTwoBalls());	
		assertEquals(15, f1.sumAll());	
		assertEquals(false, f1.isStrike());	
		assertEquals(false, f1.isSpare());	
	}
	@Test
	void test4() {
		f1.setBall(0, 10);
		f1.setBall(1, 10);
		assertEquals(true, f1.isStrike());	
		assertEquals(false, f1.isSpare());	
	}
	@Test
	void test5() {
		f1.setBall(0, 8);
		f1.setBall(1, 2);
		assertEquals(false, f1.isStrike());	
		assertEquals(true, f1.isSpare());	
	}
	@Test
	void test6() {
		f1.setBall(0, 8);
		f1.setBall(1, 2);
		f1.setBall(2, 2);
		assertEquals(false, f1.isStrike());	
		assertEquals(true, f1.isSpare());	
	}
	
	@Test
	void test7() {
		f1.setBall(0, 8);
		f1.setBall(1, 1);
		f1.setBall(2, 2);
		assertEquals(false, f1.isStrike());	
		assertEquals(false, f1.isSpare());	
	}
}
