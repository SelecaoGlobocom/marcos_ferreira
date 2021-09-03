package com.globo.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.globo.exceptions.SearchParentsException;
import com.globo.interfaces.SearchParentsUseCaseProtocol;
import com.globo.models.Family;

public class SearchParentsUseCase implements SearchParentsUseCaseProtocol {

	@Override
	public String execute(String person, List<Family> families) throws SearchParentsException {
		if (person.isEmpty()) {
			throw new SearchParentsException("O nome da pessoa deve ser fornecido para continuar.");
		}
		
		List<Family> parents = families.stream()
				.filter(family -> family.getSons().stream()
						.anyMatch(son -> son.getName().equals(person)))
				.collect(Collectors.toList());

		if (parents.isEmpty()) {
			throw new SearchParentsException("Pessoa não existente.");
		}
		
		String parentsName = parents.stream().map(family -> family.getParent().getName())
				.sorted()
				.collect(Collectors.joining(" e "));
		
		return "Os pais dessa pessoa são:\n" + parentsName;
	}
	
}
