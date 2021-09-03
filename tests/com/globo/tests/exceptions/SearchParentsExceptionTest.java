package com.globo.tests.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.exceptions.SearchParentsException;

public class SearchParentsExceptionTest {

	@Test
	public void testSearchParentsException_create_ShouldBeReturnAnExceptionCreated() {
		SearchParentsException sut = new SearchParentsException("Search parents exception");
		String expected = "Search parents exception";
		
		assertEquals(expected, sut.getMessage());
	}

}
