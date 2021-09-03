package com.globo.usecases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.globo.exceptions.LoadFamilyFileInvalidFormatException;
import com.globo.interfaces.LoadFamilyFileUseCaseProtocol;
import com.globo.interfaces.ValidationFileFormatUseCaseProtocol;
import com.globo.models.Family;
import com.globo.models.Parent;
import com.globo.models.Son;

public class LoadFamilyFileUseCase implements LoadFamilyFileUseCaseProtocol {
	
	private ValidationFileFormatUseCaseProtocol validationFileFormatUseCase = new ValidationFileFormatUseCase();

	@Override
	public List<Family> execute(String filePath) throws FileNotFoundException, LoadFamilyFileInvalidFormatException {
		File file = new File(filePath);
		
		if (!file.exists()) {
			throw new FileNotFoundException("O arquivo especificado no path: " + filePath + " não existe.");
		}
		
		Scanner fileReader = new Scanner(file);
		
		return processFile(fileReader);
	}
	
	private List<Family> processFile(Scanner fileReader) throws LoadFamilyFileInvalidFormatException {
		List<Family> families = new ArrayList<Family>();
		
		while (fileReader.hasNext()) {
			String lineReaded = fileReader.nextLine();
			boolean isValidLineFormat = validationFileFormatUseCase.execute(lineReaded);
			
			// Check if line is Valid
			if (!isValidLineFormat) {
				throw new LoadFamilyFileInvalidFormatException("Arquivo não esta no formato esperado.");
			}
			
			// Parse members of family
			Parent parent = parseParentWith(lineReaded);
			List<Son> sons = parseSonsWith(lineReaded);
			
			// Create family and add in families list
			Family family = new Family(parent, sons);
			families.add(family);
		}
		
		return families;
	}
	
	private Parent parseParentWith(String lineReaded) {
		// Split the line of file using the separator |
		String[] members = lineReaded.split("\\|");
		
		// According with the file format, parent member name, already in first position of line
		String parentName = members[0];
		
		return new Parent(parentName);
	}
	
	private List<Son> parseSonsWith(String lineReaded) {
		List<Son> sons = new ArrayList<Son>();
		
		// Split the line of file using the separator |
		String[] members = lineReaded.split("\\|");
		
		// According with the file format, sons members name, after | separated by ,
		String[] sonsName = members[1].split("\\,");
		
		for (String name : sonsName) {
			Son son = new Son(name);
			
			sons.add(son);
		}
		
		return sons;
	}
	
}
