package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();

	Contrat addContrat(Contrat u);

	Contrat updateContrat(Contrat c);

	String deleteContrat(int id);

	List<Contrat> retrieveAllContrats();

	Contrat retrieveContratById(int id);


	
	
	

	
}
