package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


	@Transactional
	public void deleteContrat(int id) {
		try {
			l.info(" search for contract");
			Contrat c =contratRepository.findById(id).get();
			l.info(" found contract");
			l.info(" deleting  contract");
			contratRepository.deleteById(id);
		l.info(" operation finish  contract");
		} catch (Exception ex) {
			l.error("contract could not be found !!!!");	
		}
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
