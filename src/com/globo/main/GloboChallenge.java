package com.globo.main;

import com.globo.exceptions.ParametersValidationException;
import com.globo.interfaces.ParametersValidationUseCaseProtocol;
import com.globo.usecases.ParametersValidationUseCase;

public class GloboChallenge {
	
	private static ParametersValidationUseCaseProtocol parametersValidationUseCase = new ParametersValidationUseCase();

	public static void main(String[] args) {
		try {
			// Check if needed parameters are present
			if (parametersValidationUseCase.execute(args)) {
				
			}
		} catch (ParametersValidationException exception) {
			System.err.println(exception.getMessage());
		}
	}

}
