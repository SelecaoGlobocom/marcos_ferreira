package com.globo.tests.usescases;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.globo.exceptions.SearchParentsException;
import com.globo.interfaces.LoadFamilyFileUseCaseProtocol;
import com.globo.interfaces.SearchParentsUseCaseProtocol;
import com.globo.models.Family;
import com.globo.usecases.LoadFamilyFileUseCase;
import com.globo.usecases.SearchParentsUseCase;

public class SearchParentsUseCaseTests {
	
	private SearchParentsUseCaseProtocol sut = new SearchParentsUseCase();
	
	@Test
	public void testSearchParentsUseCase_execute_ShouldReturnCorrectParentNames() {
		try {
			String parents = sut.execute("João Silva Almeida", buildFamiliesList());
			String expected = "Os pais dessa pessoa são:\nIgor Almeida e Joana Silva";
			
			assertEquals(expected, parents);
		} catch (Exception exception) {
		}
	}
	
	@Test
	public void testSearchParentsUseCase_executeWithoutSearchPersonName_ShouldThrowSearchParentsException() {
		try {
			sut.execute("", buildFamiliesList());
		} catch (SearchParentsException exception) {
			String errorMessage = exception.getMessage();
			
			assertEquals("O nome da pessoa deve ser fornecido para continuar.", errorMessage);
		}
	}
	
	@Test
	public void testSearchParentsUseCase_executeWithNonExistentPersonName_ShouldThrowSearchParentsException() {
		try {
			sut.execute("Napoleão Bonaparte", buildFamiliesList());
		} catch (SearchParentsException exception) {
			String errorMessage = exception.getMessage();
			
			assertEquals("Pessoa não existente.", errorMessage);
		}
	}
	
	private List<Family> buildFamiliesList() {
		LoadFamilyFileUseCaseProtocol useCase = new LoadFamilyFileUseCase();
		Path resourceDirectory = Paths.get("resources", "valid", "input.txt");
		String path = resourceDirectory.toString();
		
		try {
			return useCase.execute(path);
		} catch (Exception exception) {
			return new ArrayList<Family>();
		}
	}
	
}
