package com.globo.tests.usescases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.globo.interfaces.ParametersValidationUseCaseProtocol;
import com.globo.usecases.ParametersValidationUseCase;

public class ParametersValidationUseCaseTests {
	
	private ParametersValidationUseCaseProtocol sut = new ParametersValidationUseCase();
	
	@Test
	public void testParametersValidationUseCase_execute_ShouldReturnSucess() {
		try {
			String[] args = { "--input-file", "../resources/input.txt" };
			boolean result = sut.execute(args);
			
			assertEquals(true, result);
		} catch (Exception ex) {
		}
	}
	
	@Test
	public void testParametersValidationUseCase_execute_ShouldTrhowEmptyParametersException() {
		try {
			String[] args = {};
			sut.execute(args);
		} catch (Exception ex) {
			String errorMessage = ex.getMessage();
			assertEquals("Parameters lenght is invalid. You should send 2 parameters.", errorMessage);
		}
	}
	
	@Test
	public void testParametersValidationUseCase_execute_ShouldTrhowInputFileParameterException() {
		try {
			String[] args = { "input-file", "input.txt" };
			sut.execute(args);
		} catch (Exception ex) {
			String errorMessage = ex.getMessage();
			assertEquals("Parameter `--input-file` not present.", errorMessage);
		}
	}
	
	@Test
	public void testParametersValidationUseCase_execute_ShouldTrhowFileNameParameterException() {
		try {
			String[] args = { "--input-file", "persons.txt" };
			sut.execute(args);
		} catch (Exception ex) {
			String errorMessage = ex.getMessage();
			assertEquals("Parameter `input.txt` is not present.", errorMessage);
		}
	}

}