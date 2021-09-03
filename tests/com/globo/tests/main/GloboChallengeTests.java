package com.globo.tests.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.main.GloboChallenge;

public class GloboChallengeTests {

	@Test
	public void test() {
		GloboChallengeSpy.main(null);
		assertEquals(true, GloboChallengeSpy.mainCalled);
	}

}

class GloboChallengeSpy extends GloboChallenge {
	
	static boolean mainCalled = false;
	
	public static void main(String[] args) {
		mainCalled = true;
	}
	
}