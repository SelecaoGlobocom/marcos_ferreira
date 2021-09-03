package com.globo.tests.interfaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.exceptions.ParametersValidationException;
import com.globo.interfaces.ParametersValidationUseCaseProtocol;

import junit.framework.AssertionFailedError;

public class ParametersValidationUseCaseProtocolTests {

	@Test
	public void testParametersValidationUseCaseProtocol_execute_ShouldBeCalled() {
		ParametersValidationUseCaseSpy sut = new ParametersValidationUseCaseSpy();
		String[] args = {};
		
		try {
			sut.execute(args);
			
			assertEquals(true, sut.executeCalled);
		} catch (ParametersValidationException ex) {
			new AssertionFailedError(ex.getMessage());
		}
	}

}

class ParametersValidationUseCaseSpy implements ParametersValidationUseCaseProtocol {
	
	boolean executeCalled = false;
	
	@Override
	public boolean execute(String[] args) throws ParametersValidationException {
		executeCalled = true;
		return false;
	}
	
}
