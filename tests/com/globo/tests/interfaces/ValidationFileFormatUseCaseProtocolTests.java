package com.globo.tests.interfaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.interfaces.ValidationFileFormatUseCaseProtocol;

public class ValidationFileFormatUseCaseProtocolTests {

	@Test
	public void testValidationFileFormatUseCaseProtocol_execute_ShouldBeCalled() {
		ValidationFileFormatUseCaseSpy sut = new ValidationFileFormatUseCaseSpy();
		
		sut.execute("");
			
		assertEquals(true, sut.executeCalled);
	}

}

class ValidationFileFormatUseCaseSpy implements ValidationFileFormatUseCaseProtocol {

	boolean executeCalled = false;
	
	@Override
	public boolean execute(String line) {
		executeCalled = true;
		return false;
	}
	
}