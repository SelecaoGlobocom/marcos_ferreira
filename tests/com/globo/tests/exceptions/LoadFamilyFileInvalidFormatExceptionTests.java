package com.globo.tests.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.exceptions.LoadFamilyFileInvalidFormatException;

public class LoadFamilyFileInvalidFormatExceptionTests {

	@Test
	public void testLoadFamilyFileInvalidFormatException_create_ShouldBeReturnAnExceptionCreated() {
		LoadFamilyFileInvalidFormatException sut = new LoadFamilyFileInvalidFormatException("Invalid format file Exception");
		String expected = "Invalid format file Exception";
		
		assertEquals(expected, sut.getMessage());
	}

}
