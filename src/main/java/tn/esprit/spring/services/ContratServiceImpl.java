package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}


	@Override
	public Contrat addContrat(Contrat u) {
		l.info("In  addUser : " + u); 
		Contrat userSaved = contratRepository.save(u);
		l.info("Out of  addUser. "); 
		return userSaved; 
	}


	@Override
	public Contrat updateContrat(Contrat c) {
		l.info("in  updateContrat c = " + c);
		return contratRepository.save(c);
		
	}


	@Override
	public String deleteContrat(int id) {
		l.info("In  deleteContrat: "); 
		Contrat c =contratRepository.findById(id).get();
		String msg="No such contract with this id";
		if(c!=null){
			contratRepository.deleteById(id);
			msg="The contract has been deleted";
		}
		l.info("Out of  deleteContrat. "); 
		return msg;
	}


	@Override
	public List<Contrat> retrieveAllContrats() {
		l.info("In  retrieveAllContrats: "); 
		List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();  
		for (Contrat contrat : contrats) {
			l.debug("contrat +++ : " + contrat);
		}
		l.info("Out of retrieveAllContrats."); 
		return contrats;
	}


	@Override
	public Contrat retrieveContratById(int id) {
		l.info("in  retrievContrat id = " + id);
	
		Contrat c=  contratRepository.findById(id).orElse(null);
	
		l.info("contrat returned : " + c);
		return c;
	}


	


	

}
