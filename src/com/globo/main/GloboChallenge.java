package com.globo.main;

import java.util.List;
import java.util.Scanner;

import com.globo.interfaces.LoadFamilyFileUseCaseProtocol;
import com.globo.interfaces.ParametersValidationUseCaseProtocol;
import com.globo.interfaces.SearchParentsUseCaseProtocol;
import com.globo.models.Family;
import com.globo.usecases.LoadFamilyFileUseCase;
import com.globo.usecases.ParametersValidationUseCase;
import com.globo.usecases.SearchParentsUseCase;

public class GloboChallenge {

	private static ParametersValidationUseCaseProtocol parametersValidationUseCase = new ParametersValidationUseCase();
	private static LoadFamilyFileUseCaseProtocol loadFamilyFileUseCase = new LoadFamilyFileUseCase();
	private static SearchParentsUseCaseProtocol searchParentsUseCase = new SearchParentsUseCase();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		do {
			try {
				// Check if needed parameters are present
				if (parametersValidationUseCase.execute(args)) {
					String path = args[1];

					List<Family> families = loadFamilyFileUseCase.execute(path);

					String searchParameter = "";

					// Request user input the name of parent to serch
					System.out.print("Digite o nome de uma pessoa:\n");
					searchParameter = scanner.nextLine();

					// Perform search
					String parents = searchParentsUseCase.execute(searchParameter, families);

					System.out.print(parents + "\n\n");
				}
			} catch (Exception exception) {
				System.err.println(exception.getMessage() + "\n\n");
			}
		} while (true);
	}

}
