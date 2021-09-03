package com.globo.tests.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.exceptions.ParametersValidationException;

public class ParametersValidationExceptionsTests {

	@Test
	public void testParametersValidationException_create_ShouldBeReturnAnExceptionCreated() {
		ParametersValidationException sut = new ParametersValidationException("Exception of Parameters");
		String expected = "Exception of Parameters";
		
		assertEquals(expected, sut.getMessage());
	}

}
