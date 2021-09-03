package com.globo.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

import com.globo.exceptions.LoadFamilyFileInvalidFormatException;
import com.globo.models.Family;

public interface LoadFamilyFileUseCaseProtocol {
	
	public List<Family> execute(String filePath) throws FileNotFoundException, LoadFamilyFileInvalidFormatException;
	
}
