import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BowlingGameTest1 {
	BowlingGame G0 = new BowlingGame();
	BowlingGame G1 = new BowlingGame();
	BowlingGame G2 = new BowlingGame();
	BowlingGame G3 = new BowlingGame();
	BowlingGame G4 = new BowlingGame();
	

	@Test
	void test1() {
		assertEquals(0,G0.getScore());
		G0.roll(5);
		assertEquals(5,G0.getScore());
		G0.roll(5);
		G0.roll(6);
		assertEquals(22,G0.getScore());
	}
	
	@Test
	void test2()throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Testing to see that we can only roll and hit 10 pins at a time 
			G1.roll(1000);
		  });
	}
	
	@Test
	void test3()throws Exception  {
		// Testing to see if we have a max of 20 attempts a game excluding the fact that we do not get a
		// bonus rolls from a strike.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			G2.roll(5);
			G2.roll(4);
			G2.roll(3);
			G2.roll(0);
			G2.roll(3);
			G2.roll(5);
			G2.roll(2);
			G2.roll(1);
			G2.roll(9);
			G2.roll(0);
			G2.roll(5);
			G2.roll(2);
			G2.roll(4);
			G2.roll(5);
			G2.roll(0);
			G2.roll(1);
			G2.roll(1);
			G2.roll(2);
			G2.roll(8);
			G2.roll(0);
			G2.roll(1);
					
		  });
	}
	@Test
	void test4() {
	// Check if method returns the correct score
		G3.roll(6);
		G3.roll(2);
		assertEquals(8,G3.getScore());
		
	}
	@Test
	void test5() {
	// Check if method returns the correct score for spare
		G3.roll(6);
		G3.roll(2);
		G3.roll(5);
		assertEquals(13,G3.getScore());
		G3.roll(5);
		assertEquals(18,G3.getScore());
		G3.roll(5);
		assertEquals(28,G3.getScore());
	}
	
	@Test 
	void test6() {
		// Checking if the code breaks if we only get strikes for the 22 rounds
		G4.roll(10);
		G4.roll(10);
		assertEquals(20,G4.getScore());
		G4.roll(10);//2nd round
		assertEquals(40,G4.getScore());
		G4.roll(10);
		assertEquals(50,G4.getScore());
		G4.roll(10);//3rd round
		assertEquals(70,G4.getScore());
		G4.roll(10);
		assertEquals(80,G4.getScore());
		G4.roll(10);//4th round
		assertEquals(100,G4.getScore());
		G4.roll(10);
		assertEquals(110,G4.getScore());
		G4.roll(10);//5th
		G4.roll(10);
		assertEquals(140,G4.getScore());
		G4.roll(10);//6th
		G4.roll(10);
		G4.roll(10);//7th
		G4.roll(10);
		G4.roll(10);//8th
		G4.roll(10);
		G4.roll(10);//9th
		G4.roll(10);
		G4.roll(10);//10th
		assertEquals(280,G4.getScore());
		G4.roll(10);
		G4.roll(10);
		assertEquals(300,G4.getScore());
	}
	
	@Test 
	void test7() throws Exception  {
		// Checking if the code throw exception if we only get strikes for the 23 rounds
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		G4.roll(10);
		G4.roll(10);
		assertEquals(20,G4.getScore());
		G4.roll(10);//2nd round
		assertEquals(40,G4.getScore());
		G4.roll(10);
		assertEquals(50,G4.getScore());
		G4.roll(10);//3rd round
		assertEquals(70,G4.getScore());
		G4.roll(10);
		assertEquals(80,G4.getScore());
		G4.roll(10);//4th round
		assertEquals(100,G4.getScore());
		G4.roll(10);
		assertEquals(110,G4.getScore());
		G4.roll(10);//5th
		G4.roll(10);
		assertEquals(140,G4.getScore());
		G4.roll(10);//6th
		G4.roll(10);
		G4.roll(10);//7th
		G4.roll(10);
		G4.roll(10);//8th
		G4.roll(10);
		G4.roll(10);//9th
		G4.roll(10);
		G4.roll(10);//10th
		assertEquals(280,G4.getScore());
		G4.roll(10);
		G4.roll(10);
		assertEquals(300,G4.getScore());
		G4.roll(5);
		});
		
	}
	
	
	
	
}
