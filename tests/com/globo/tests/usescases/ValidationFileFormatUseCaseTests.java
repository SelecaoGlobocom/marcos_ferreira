package com.globo.tests.usescases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.interfaces.ValidationFileFormatUseCaseProtocol;
import com.globo.usecases.ValidationFileFormatUseCase;

public class ValidationFileFormatUseCaseTests {

	private ValidationFileFormatUseCaseProtocol sut = new ValidationFileFormatUseCase();
	
	@Test
	public void testValidationFileFormatUseCase_execute_ShouldBeReturnSuccess() {
		boolean result = sut.execute("Silvana Nunes|Pedrinho Nunes Augusto,Júlia Nunes Augusto,Clara Nunes Augusto");
			
		assertEquals(true, result);
	}
	
	@Test
	public void testValidationFileFormatUseCase_execute_ShouldBeReturnFailure() {
		boolean result = sut.execute("Silvana Nunes-Pedrinho Nunes Augusto:Júlia Nunes Augusto,Clara Nunes Augusto");
		
		assertEquals(false, result);
	}

}
