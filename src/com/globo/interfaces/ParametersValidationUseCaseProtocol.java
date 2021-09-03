package com.globo.interfaces;

import com.globo.exceptions.ParametersValidationException;

public interface ParametersValidationUseCaseProtocol {

	public boolean execute(String[] args) throws ParametersValidationException;
	
}
