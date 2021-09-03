package com.globo.tests.interfaces;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.globo.exceptions.LoadFamilyFileInvalidFormatException;
import com.globo.interfaces.LoadFamilyFileUseCaseProtocol;
import com.globo.models.Family;

public class LoadFamilyFileUseCaseProtocolTests {

	@Test
	public void testLoadFamilyFileUseCaseProtocol_loadFamily_ShouldBeCalled() {
		LoadFamilyFileUseCaseSpy sut = new LoadFamilyFileUseCaseSpy();
		
		try {
			sut.execute("input.txt");
			
			assertEquals(true, sut.executeCalled);
		} catch (Exception exception) {
		}
	}

}

class LoadFamilyFileUseCaseSpy implements LoadFamilyFileUseCaseProtocol {
	
	boolean executeCalled = false;
	
	@Override
	public List<Family> execute(String filePath) throws FileNotFoundException, LoadFamilyFileInvalidFormatException {
		executeCalled = true;
		return new ArrayList<Family>();
	}
	
}