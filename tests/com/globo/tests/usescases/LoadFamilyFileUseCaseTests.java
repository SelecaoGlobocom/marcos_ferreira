package com.globo.tests.usescases;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.globo.exceptions.LoadFamilyFileInvalidFormatException;
import com.globo.interfaces.LoadFamilyFileUseCaseProtocol;
import com.globo.models.Family;
import com.globo.usecases.LoadFamilyFileUseCase;

public class LoadFamilyFileUseCaseTests {

	private LoadFamilyFileUseCaseProtocol sut = new LoadFamilyFileUseCase();
	
	@Test
	public void testLoadFamilyFileUseCase_execute_ShouldBeReturnAValidFamiliesList() {
		Path resourceDirectory = Paths.get("resources", "valid", "input.txt");
		String path = resourceDirectory.toString();
		
		try {
			List<Family> families = sut.execute(path);
			
			assertEquals(false, families == null);
			assertEquals(false, families.isEmpty());
			assertEquals(true, families.get(0).getParent().getName().equals("Silvana Nunes"));
		} catch (Exception exception) {
		}
	}
	
	@Test
	public void testLoadFamilyFileUseCase_execute_ShouldBeThrowFileNotFoundException() {
		Path resourceDirectory = Paths.get("resources", "valid", "input-valid.txt");
		String path = resourceDirectory.toString();
		
		try {
			sut.execute(path);
		} catch (Exception exception) {
			String errorMessage = exception.getMessage();
			
			assertEquals(FileNotFoundException.class, exception.getClass());
			assertEquals(errorMessage, "O arquivo especificado no path: " + path + " não existe.");
		}
	}
	
	@Test
	public void testLoadFamilyFileUseCase_execute_ShouldBeThrowLoadFamilyFileInvalidFormatException() {
		Path resourceDirectory = Paths.get("resources", "invalid", "input.txt");
		String path = resourceDirectory.toString();
		
		try {
			sut.execute(path);
		} catch (Exception exception) {
			String errorMessage = exception.getMessage();
			
			assertEquals(LoadFamilyFileInvalidFormatException.class, exception.getClass());
			assertEquals(errorMessage, "Arquivo não esta no formato esperado.");
		}
	}

}
