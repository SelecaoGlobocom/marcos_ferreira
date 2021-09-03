package com.globo.usecases;

import com.globo.interfaces.ValidationFileFormatUseCaseProtocol;

public class ValidationFileFormatUseCase implements ValidationFileFormatUseCaseProtocol {

	private String validLineFormatPattern = "^[A-zÀ-ú ]{2,}\\|[A-zÀ-ú ]{2,}(,[A-zÀ-ú ]{2,})*$";
	
	@Override
	public boolean execute(String line) {
		return line.matches(validLineFormatPattern);
	}
	
}
