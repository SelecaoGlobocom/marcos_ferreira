package com.globo.usecases;

import java.util.Arrays;

import com.globo.exceptions.ParametersValidationException;
import com.globo.interfaces.*;

public class ParametersValidationUseCase implements ParametersValidationUseCaseProtocol {

	@Override
	public boolean execute(String[] args) throws ParametersValidationException {
		boolean argumentsLenghtValid = args.length == 2;
		boolean parameterInputFilePresent = Arrays.asList(args).contains("--input-file");
		
		if (!argumentsLenghtValid) { // check if arguments passed leght equals 2
			throw new ParametersValidationException("Parameters lenght is invalid. You should send 2 parameters.");
		} else if (!parameterInputFilePresent) { // check if --input-file parameter as present
			throw new ParametersValidationException("Parameter `--input-file` not present.");
		} 
		
		int lastParameterIndex = args.length - 1 > 0 ? args.length - 1 : 0;
		boolean parameterFileNamePresent = Arrays.asList(args).get(lastParameterIndex).contains("input.txt");
		
		if (!parameterFileNamePresent) { // check if the last parameters passed contains the input.txt file name
			throw new ParametersValidationException("Parameter `input.txt` is not present.");
		}
		
		return true;
	}
	
}
