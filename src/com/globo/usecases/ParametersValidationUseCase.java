package com.globo.usecases;

import java.util.Arrays;

import com.globo.exceptions.ParametersValidationException;
import com.globo.interfaces.*;

public class ParametersValidationUseCase implements ParametersValidationUseCaseProtocol {

	@Override
	public boolean execute(String[] args) throws ParametersValidationException {
		boolean argumentsLenghtValid = args.length == 2;
		boolean parameterInputFilePresent = Arrays.asList(args).contains("--input-file");
		boolean parameterFileNamePresent = Arrays.asList(args).contains("input.txt");
		
		if (!argumentsLenghtValid) {
			throw new ParametersValidationException("Parameters lenght is invalid. You should send 2 parameters.");
		} else if (!parameterInputFilePresent) {
			throw new ParametersValidationException("Parameter `--input-file` not present.");
		} else if (!parameterFileNamePresent) {
			throw new ParametersValidationException("Parameter `input.txt` is not present.");
		}
		
		return true;
	}
	
}
