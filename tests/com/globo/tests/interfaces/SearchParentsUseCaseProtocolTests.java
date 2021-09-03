package com.globo.tests.interfaces;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.globo.exceptions.SearchParentsException;
import com.globo.interfaces.SearchParentsUseCaseProtocol;
import com.globo.models.Family;

public class SearchParentsUseCaseProtocolTests {

	@Test
	public void testSearchParentsUseCaseProtocol_execute_ShouldBeCalled() {
		SearchParentsUseCaseSpy sut = new SearchParentsUseCaseSpy();
		
		try {
			sut.execute("Person", new ArrayList<Family>());

			assertEquals(true, sut.executeCalled);
		} catch (SearchParentsException e) {
		}
	}

}

class SearchParentsUseCaseSpy implements SearchParentsUseCaseProtocol {
	
	boolean executeCalled = false;

	@Override
	public String execute(String person, List<Family> families) throws SearchParentsException {
		executeCalled = true;
		return null;
	}
	
}