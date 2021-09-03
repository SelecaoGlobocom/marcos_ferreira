package com.globo.interfaces;

import java.util.List;

import com.globo.exceptions.SearchParentsException;
import com.globo.models.Family;

public interface SearchParentsUseCaseProtocol {

	public String execute(String person, List<Family> families) throws SearchParentsException;
	
}
